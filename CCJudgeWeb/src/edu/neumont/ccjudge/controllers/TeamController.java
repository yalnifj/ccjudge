package edu.neumont.ccjudge.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.neumont.ccjudge.managers.ContestManagerLocal;
import edu.neumont.ccjudge.managers.SubmissionManagerLocal;
import edu.neumont.ccjudge.managers.TeamManagerLocal;
import edu.neumont.ccjudge.managers.TeamMemberManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;
import edu.neumont.ccjudge.model.TeamMember;
import edu.neumont.ccjudge.model.TeamMemberRole;

public class TeamController extends BaseController {
	static final long serialVersionUID = 1L;

	private TeamManagerLocal manager;
	private ContestManagerLocal contestManager;
	private TeamMemberManagerLocal memberManager;
	private SubmissionManagerLocal submissionManager;

	public TeamController() {
		super();
		this.defaultAction = "list";

		try {
			Context ctx = new InitialContext();
			contestManager = (ContestManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal");
			manager = (TeamManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamManager!edu.neumont.ccjudge.managers.TeamManagerLocal");
			memberManager = (TeamMemberManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamMemberManager!edu.neumont.ccjudge.managers.TeamMemberManagerLocal");
			submissionManager = (SubmissionManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/SubmissionManager!edu.neumont.ccjudge.managers.SubmissionManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public String list(HttpServletRequest request) throws ValidationException {
		List<Team> list = null;
		Contest contest = null;

		String idstr = request.getParameter("contest");
		if (idstr != null && !idstr.isEmpty()) {
			int contestId = validator.validateInt(idstr);
			contest = contestManager.findById(contestId);
			request.setAttribute("contest", contest);
		} else {
			contest = (Contest) request.getAttribute("contest");
			if (contest != null) contest = contestManager.findById(contest.getId());
		}
		if (contest != null) {
			list = contest.getTeams();
		} else {
			list = manager.getList();
		}
		request.setAttribute("list", list);
		return "/views/team/list.jsp";
	}

	public String view(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Team team = manager.findById(id);
		List<TeamMemberRole> teams = team.getMembers();
		teams.size();
		request.setAttribute("team", team);
		return "/views/team/view.jsp";
	}

	public String edit(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Team team = null;
		if (idStr != null) {
			int id = validator.validateInt(idStr);
			team = manager.findById(id);
		}
		if (team == null) {
			team = new Team();
			Contest contest = (Contest) session.getAttribute("contest");
			if (request.getParameter("contest") != null) {
				int contestId = validator.validateInt(request.getParameter("contest"));
				contest = contestManager.findById(contestId);
			}
			if (contest != null) team.getContests().add(contest);
		}
		List<Contest> allcontests = contestManager.getList();
		request.setAttribute("contests", allcontests);
		request.setAttribute("team", team);
		return "/views/team/edit.jsp";
	}

	public String delete(HttpServletRequest request) throws ValidationException {
		// Get the team and contest parameters
		int teamId = validator.validateInt(request.getParameter("team"));
		int contestId = 0;
		if (request.getParameter("contest") != null)
			contestId = validator.validateInt(request.getParameter("contest"));

		// Set the request attributes
		request.setAttribute("team", manager.findById(teamId));
		request.setAttribute("contest", contestManager.findById(contestId));
		return "/views/team/delete.jsp";
	}

	public String deleteProcess(HttpServletRequest request) throws ValidationException {
		// Get the information [Option 1: Remove team from contest, 2: Remove
		// team only, 3: Remove team and team members]
		int id = validator.validateInt(request.getParameter("id"));
		int option = validator.validateInt(request.getParameter("option"));
		Contest contest = contestManager.findById(validator.validateInt(request.getParameter("contest")));
		Team team = manager.findById(id);

		if (team != null) {
			// Remove the team's submissions or the contest's submissions
			ArrayList<Submission> contestSubmissions = new ArrayList<Submission>();
			for (Submission submission : team.getSubmissions()) {
				if (contest == null || submission.getContest().getId() == contest.getId()) {
					submissionManager.delete(submission);
					contestSubmissions.add(submission);
				}
			}
			// -- remove any deleted submissions from the teams collection
			team.getSubmissions().removeAll(contestSubmissions);

			// Remove the team from the contest or all contests
			if (contest == null) team.getContests().clear();
			else team.getContests().remove(contest);

			// Remove the team members
			if (option == 3) {
				ArrayList<TeamMember> members = new ArrayList<TeamMember>();
				for (TeamMemberRole teamRole : team.getMembers()) {
					members.add(teamRole.getMember());
				}
				for(TeamMember member : members) {
					memberManager.delete(member);
				}
			}

			// Remove the team
			if (option != 1) manager.delete(team);
			else manager.update(team);
		}
		return this.list(request);
	}

	public String update(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Team team = manager.findById(id);

		if (team == null) team = new Team();
		team.setName(validator.validateString(request.getParameter("name"), Validator.STRIP_TAGS, -1));
		String[] cids = request.getParameterValues("contest");
		if (cids != null) {
			team.getContests().clear();
			for (String cid : cids) {
				if (cid != null && !cid.isEmpty()) {
					Contest c = contestManager.findById(validator.validateInt(cid));
					if (c != null) {
						team.getContests().add(c);
						if (!c.getTeams().contains(team)) c.getTeams().add(team);
					}
				}
			}
		}

		if (team.getId() == 0) team = (Team) manager.create(team);
		else manager.update(team);

		request.setAttribute("team", team);
		return "/views/team/view.jsp";
	}

	public String removeMember(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Team team = manager.findById(id);
		int memberid = validator.validateInt(request.getParameter("member"));
		TeamMemberRole memberRole = null;
		for (TeamMemberRole role : team.getMembers()) {
			if (role.getId() == memberid) {
				memberRole = role;
				break;
			}
		}
		if (memberRole != null) {
//			team.getMembers().remove(memberRole);
//			manager.update(team);
			memberRole.setMember(null);
			memberRole.setTeam(null);
			memberManager.deleteMemberRole(memberRole);
		}
		return this.view(request);
	}
}
