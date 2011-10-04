package edu.neumont.ccjudge.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.neumont.ccjudge.managers.ContestManagerLocal;
import edu.neumont.ccjudge.managers.TeamManagerLocal;
import edu.neumont.ccjudge.managers.TeamMemberManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Team;
import edu.neumont.ccjudge.model.TeamMember;
import edu.neumont.ccjudge.model.TeamMemberRole;
import edu.neumont.lms.User;
import edu.neumont.lms.authentication.AuthenticationException;
import edu.neumont.lms.authentication.MoodleAuthentication;

public class RegisterController extends BaseController {
	static final long serialVersionUID = 1L;

	private TeamManagerLocal teamManager;
	private ContestManagerLocal contestManager;
	private TeamMemberManagerLocal teamMemberManager;

	public RegisterController() {
		super();
		this.defaultAction = "view";
		this.errorPage = "/views/home/error.jsp";
		try {
			Context ctx = new InitialContext();
			contestManager = (ContestManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal");
			teamManager = (TeamManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/TeamManager!edu.neumont.ccjudge.managers.TeamManagerLocal");
			teamMemberManager = (TeamMemberManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/TeamMemberManager!edu.neumont.ccjudge.managers.TeamMemberManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String view(HttpServletRequest request) throws ValidationException {
		return "/views/register/register.jsp";
	}

	public String team(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		if (member == null)
			return view(request);

		int contestId = validator.validateInt(request
				.getParameter("contest_id"));
		Contest contest = contestManager.findById(contestId);
		// Contest contest = (Contest) session.getAttribute("contest"); //--
		// don't store contest in session when registering
		if (contest == null)
			contest(request);
		request.setAttribute("contest", contest);

		Team team = null;
		String teamStr = request.getParameter("team_id");
		// -- registering an existing team for the contest
		if (teamStr != null && !teamStr.isEmpty()) {
			team = teamManager.findById(validator.validateInt(teamStr));
			if (team != null) {
				if (!team.getContests().contains(contest))
					team.getContests().add(contest);
				teamManager.update(team);
				contest.getTeams().add(team);
				contestManager.update(contest);
				member = teamMemberManager.findById(member.getId());
				// -- refresh the member on the session
				session.setAttribute("member", member);
				return "/views/home/home.jsp";
			}
		} else {
			String nameParam = request.getParameter("name");
			if (nameParam != null && !nameParam.isEmpty()) {
				String name = validator.validateString(nameParam);
				team = new Team();
				team.setName(name);
			} else
				team = (Team) session.getAttribute("team");
		}

		String[] usernames = request.getParameterValues("username");
		for (String u : usernames) {
			if (u != null && !u.isEmpty()) {
				TeamMember tm = teamMemberManager.findByUsername(u);
				if (tm != null) {
					for (TeamMemberRole r : tm.getTeams()) {
						if (!r.getTeam().equals(team)
								&& r.getTeam().getContests().contains(contest)) {
							request
									.setAttribute(
											"error",
											"The username "
													+ u
													+ " is already registered for this contest.");
							return "/views/register/team.jsp";
						}
					}
				}
			}
		}

		try {
			MoodleAuthentication mauth = (MoodleAuthentication) session
					.getAttribute("mauth");
			if (mauth==null) {
				return view(request);
			}
			User[] users = mauth.getMoodleUsers(usernames);
			team.getContests().add(contest);
			TeamMemberRole role = new TeamMemberRole();
			role.setMember(member);
			role.setTeam(team);
			role.setRole("participant");
			team.getMembers().add(role);
			if (team.getId() == 0)
				teamManager.create(team);
			else
				teamManager.update(team);
			member.getTeams().add(role);
			teamMemberManager.update(member);
			contest.getTeams().add(team);
			contestManager.update(contest);
			for (User ur : users) {
				TeamMember mem = teamMemberManager.findByUsername(ur
						.getUsername().toLowerCase());
				if (mem == null) {
					mem = new TeamMember();
					mem.setEmail(ur.getEmail());
					mem.setName(ur.getFirstname() + " " + ur.getLastname());
					mem.setRole("participant");
				}
				mem.setUsername(ur.getUsername().toLowerCase());
				TeamMemberRole r1 = new TeamMemberRole();
				r1.setMember(mem);
				r1.setTeam(team);
				r1.setRole("participant");
				team.getMembers().add(r1);
				mem.getTeams().add(r1);
				if (mem.getId() == 0)
					teamMemberManager.create(mem);
				else
					teamMemberManager.update(mem);
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			return "/views/register/team.jsp";
		}

		return "/views/home/home.jsp";
	}

	public String contest(HttpServletRequest request)
			throws ValidationException {
		HttpSession session = request.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		if (member == null)
			return view(request);

		int contestId = validator.validateInt(request
				.getParameter("contest_id"));
		Contest contest = contestManager.findById(contestId);
		if (contest != null) {
			boolean incontest = false;
			Team team = null;
			for (TeamMemberRole r : member.getTeams()) {
				if (r.getTeam().getContests().contains(contest)) {
					incontest = true;
					team = r.getTeam();
					break;
				}
			}
			if (!incontest) {
				request.setAttribute("contest", contest);
				return "/views/register/team.jsp";
			} else {
				request.setAttribute("error",
						"You are already registered for that contest.");
				session.setAttribute("team", team);
			}
		}

		request.setAttribute("contests", getActiveContests());
		return "/views/register/contest.jsp";
	}

	public List<Contest> getActiveContests() {
		List<Contest> contests = new ArrayList<Contest>();
		Date now = new Date();
		for (Contest c : contestManager.getList()) {
			if (c.isCanRegister() && c.getEndTime().after(now))
				contests.add(c);
		}
		return contests;
	}

	public String register(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			TeamMember member = (TeamMember) session.getAttribute("member");
			if (username != null || member==null) {
				username = validator.validateString(request
						.getParameter("username"));
				String password = validator.validateString(request
						.getParameter("password"));

				MoodleAuthentication mauth = new MoodleAuthentication();
				mauth.authenticate(username, password);
				session.setAttribute("mauth", mauth);
				User user = mauth.getMoodleUser();
				String email = user.getEmail();
				String name = user.getFirstname() + " " + user.getLastname();

				member = teamMemberManager.findByUsername(username);
				if (member != null) {
					member.setEmail(email);
					member.setName(name);
					teamMemberManager.update(member);
					session.setAttribute("member", member);

					request.setAttribute("contests", getActiveContests());
					return "/views/register/contest.jsp";
				} else {
					member = new TeamMember();
					member.setUsername(username);
					member.setEmail(email);
					member.setName(name);
					member.setRole("participant");
					session.setAttribute("member", member);
					request.setAttribute("contests", getActiveContests());
					teamMemberManager.create(member);
					return "/views/register/contest.jsp";
				}
			} else {
				request.setAttribute("contests", getActiveContests());
				return "/views/register/contest.jsp";
			}
		} catch (ValidationException e) {
			request.setAttribute("error", e.getMessage());
			return "/views/register/register.jsp";
		} catch (AuthenticationException e) {
			request.setAttribute("error",
					"Unable to validate Neumont username and password");
			return "/views/register/register.jsp";
		}
	}
}
