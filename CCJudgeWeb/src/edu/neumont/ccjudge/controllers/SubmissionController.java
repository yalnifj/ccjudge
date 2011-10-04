package edu.neumont.ccjudge.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.neumont.ccjudge.managers.ContestManagerLocal;
import edu.neumont.ccjudge.managers.ProblemManagerLocal;
import edu.neumont.ccjudge.managers.SubmissionManagerLocal;
import edu.neumont.ccjudge.managers.TeamManagerLocal;
import edu.neumont.ccjudge.managers.TeamMemberManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;
import edu.neumont.ccjudge.model.TeamMember;
import edu.neumont.ccjudge.model.TeamMemberRole;
import edu.neumont.lms.authentication.AuthenticationException;
import edu.neumont.lms.authentication.MoodleAuthentication;

public class SubmissionController extends BaseController {
	static final long serialVersionUID = 1L;

	private TeamManagerLocal teamManager;
	private ProblemManagerLocal problemManager;
	private ContestManagerLocal contestManager;
	private SubmissionManagerLocal submissionManager;
	private TeamMemberManagerLocal teamMemberManager;

	public SubmissionController() {
		super();
		this.defaultAction = "home";
		this.errorPage = "/views/home/error.jsp";
		try {
			Context ctx = new InitialContext();
			contestManager = (ContestManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal");
			problemManager = (ProblemManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/ProblemManager!edu.neumont.ccjudge.managers.ProblemManagerLocal");
			submissionManager = (SubmissionManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/SubmissionManager!edu.neumont.ccjudge.managers.SubmissionManagerLocal");
			teamManager = (TeamManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/TeamManager!edu.neumont.ccjudge.managers.TeamManagerLocal");
			teamMemberManager = (TeamMemberManagerLocal) ctx
					.lookup("java:global/CCJudge/CCJudgeEJB/TeamMemberManager!edu.neumont.ccjudge.managers.TeamMemberManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		if (member == null) {
			if (request.getUserPrincipal() != null) {
				String username = request.getUserPrincipal().getName();
				member = teamMemberManager.findByUsername(username);
				if (member == null && !request.isUserInRole("admin")) {
					request.setAttribute("error",
							"User is not registered with a team");
					return "/views/home/error.jsp";
				}
				System.out.println("User Login " + member.getUsername());
				session.setAttribute("member", member);
				if (request.isUserInRole("admin")) {
					session.setAttribute("adminuser", true);
				} else {
					session.setAttribute("adminuser", false);
				}
			} else {
				TeamMember m = new TeamMember();
				m.setName("Guest");
				List<Contest> contests = contestManager.getList();
				ArrayList<Contest> old = new ArrayList<Contest>();
				Date now = new Date();
				//-- only show the last 3 quarters of contests
				long yearmilli=(1000L*60L*60L*24L*274L);
				Date then = new Date(now.getTime()-yearmilli);
				for (Contest c : contests) {
					if (c.getEndTime().before(now) && c.getEndTime().after(then))
						old.add(c);
				}
				Team t = new Team();
				t.setContests(old);
				TeamMemberRole r = new TeamMemberRole();
				r.setMember(m);
				r.setTeam(t);
				r.setRole("participant");
				m.getTeams().add(r);
				t.getMembers().add(r);
				session.setAttribute("member", m);
				session.setAttribute("team", t);
			}
		}
		return "/views/home/home.jsp";
	}

	public String logout(HttpServletRequest request) {
		return "/logout";
	}

	public String login(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		String username = validator.validateString(request
				.getParameter("j_username"));
		String password = validator.validateString(request
				.getParameter("j_password"));
		TeamMember member = teamMemberManager.findByUsername(username);

		if (member == null) {
			return "/views/login_error.jsp";
		}
		if (member.getPassword() == null
				|| !member.getPassword().equals(password)) {
			try {
				MoodleAuthentication mauth = new MoodleAuthentication();
				session.setAttribute("mauth", mauth);
				String sessionkey = mauth.authenticate(username, password);
				System.out.println("Moodle authenticated successfully "
						+ sessionkey);
			} catch (AuthenticationException e) {
				e.printStackTrace();
				return "/views/login_error.jsp";
			}
		}
		System.out.println("User Login " + member.getUsername());
		session.setAttribute("member", member);
		if (member.getRole().equals("admin")) {
			session.setAttribute("adminuser", true);
		} else {
			session.setAttribute("adminuser", false);
		}
		String redir = request.getParameter("redir");
		if (redir!=null) return "redirect:"+redir;
		else return home(request);
	}

	public String problems(HttpServletRequest request)
			throws ValidationException {
		HttpSession session = request.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		if (member == null)
			return home(request);

		Contest contest = (Contest) session.getAttribute("contest");
		if (request.getParameter("contest") != null) {
			int contestId = validator.validateInt(request
					.getParameter("contest"));
			contest = contestManager.findById(contestId);
			// -- make sure the contest is active first
		} else {
			if (contest!=null) contest = contestManager.findById(contest.getId());
			else return home(request);
		}
		
		boolean adminuser = false;
		if (session.getAttribute("adminuser")!=null) adminuser = (Boolean)session.getAttribute("adminuser");
		Date now = new Date();
		if (!adminuser
				&& contest.getStartTime().after(now)) {
			request.setAttribute(
							"error",
							"This contest is not currently active.  You may not view the problems until the contest has started.");
			return "/views/home/error.jsp";
		}
		session.setAttribute("contest", contest);

		Team team = (Team) session.getAttribute("team");
		if (request.getParameter("team") != null) {
			int teamId = validator.validateInt(request.getParameter("team"));
			// -- guest team is 0
			if (teamId > 0)
				team = teamManager.findById(teamId);
			else
				team = member.getTeams().get(0).getTeam();
			session.setAttribute("team", team);
		}

		return "/views/home/problems.jsp";
	}

	public String problem(HttpServletRequest request)
			throws ValidationException {
		HttpSession session = request.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		if (member == null)
			return home(request);

		Team team = (Team) session.getAttribute("team");
		if (team == null)
			return home(request);

		Contest contest = (Contest) session.getAttribute("contest");
		if (contest == null)
			return home(request);
		
		boolean adminuser = false;
		if (session.getAttribute("adminuser")!=null) adminuser = (Boolean)session.getAttribute("adminuser");
		Date now = new Date();
		if (!adminuser
				&& contest.getStartTime().after(now)) {
			request.setAttribute(
							"error",
							"This contest is not currently active.  You may not view the problems until the contest has started.");
			return "/views/home/error.jsp";
		}

		int problemId = validator.validateInt(request.getParameter("id"));
		Problem problem = problemManager.findById(problemId);

		if (!contest.getProblems().contains(problem)) {
			request.setAttribute("error",
					"The problem you have chosen is not in the active contest");
			return "/views/home/error.jsp";
		}

		request.setAttribute("problem", problem);

		List<Submission> submissions = team.getProblemSubmissions(problem);
		request.setAttribute("submissions", submissions);

		return "/views/home/problem.jsp";
	}

	public String submit(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		TeamMember member = (TeamMember) session.getAttribute("member");
		if (member == null)
			return home(request);
		//-- refresh the member from the database
		member = teamMemberManager.findById(member.getId());

		Team team = (Team) session.getAttribute("team");
		if (team == null)
			return home(request);

		Contest contest = (Contest) session.getAttribute("contest");
		if (contest == null)
			return home(request);

		Date now = new Date();
		Date later = new Date(contest.getEndTime().getTime() + (1000 * 60 * 15));
		boolean adminuser = false;
		if (session.getAttribute("adminuser")!=null) adminuser = (Boolean)session.getAttribute("adminuser");
		if (!adminuser
				&& contest.getEndTime().before(new Date()) && !now.after(later)) {
			request.setAttribute("error",
					"Submission time for this contest has passed.");
			return "/views/home/error.jsp";
		}

		int problemId = 0;
		String buffer = null;
		String fileName = null;

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = (List<FileItem>) upload
					.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("problemId")) {
					problemId = validator.validateInt(item.getString());
				} else if (item.getFieldName().equals("sourceFile")
						&& item.getSize() > 0) {
					buffer = item.getString();
					int i = 0;
					for (i = 0; i < buffer.length(); i++) {
						char c = buffer.charAt(i);
						if (c >= ' ' && c <= '~')
							break;
					}
					if (i > 0)
						buffer = buffer.substring(i);
					fileName = new File(item.getName()).getName();
					if (fileName.contains("\\")) {
						fileName = fileName.substring(fileName
								.lastIndexOf("\\") + 1);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("error",
					"There was an error uploading the file");
			request.setAttribute("exception", e);
			return "/error.jsp";
		}

		Problem problem = problemManager.findById(problemId);
		if (problem == null) {
			request
					.setAttribute("error",
							"Invalid problem specified.  Please go back and try again.");
			return "/error.jsp";
		}

		if (buffer == null) {
			request
					.setAttribute(
							"error",
							"Unable to retrieve file data.  Please make sure you selected the correct file and try again.");
			return "/error.jsp";
		}

		Submission submission = new Submission();
		submission.setContest(contest);
		submission.setFileContents(buffer);
		submission.setFileName(fileName);
		submission.setProblem(problem);
		submission.setSubmissionTime(new Date());
		submission.setTeam(team);
		problem.getSubmissions().add(submission);
		team.getSubmissions().add(submission);
		submissionManager.create(submission);
		teamManager.update(team);
		problemManager.update(problem);

		submission = submissionManager.judgeSubmission(submission);

		request.setAttribute("problem", problem);

		List<Submission> submissions = team.getProblemSubmissions(problem);
		request.setAttribute("submissions", submissions);

		return "/views/home/problem.jsp";
	}

	public String help(HttpServletRequest request) {
		return "/views/home/help.jsp";
	}
}
