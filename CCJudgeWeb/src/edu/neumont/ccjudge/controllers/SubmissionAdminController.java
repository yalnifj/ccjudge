package edu.neumont.ccjudge.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.neumont.ccjudge.managers.ProblemManagerLocal;
import edu.neumont.ccjudge.managers.SubmissionManagerLocal;
import edu.neumont.ccjudge.managers.TeamManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;

public class SubmissionAdminController extends BaseController {
	private static final long serialVersionUID = -7068812980240512521L;
	private TeamManagerLocal teamManager;
	private ProblemManagerLocal problemManager;
	private SubmissionManagerLocal submissionManager;

	public SubmissionAdminController() {
		super();
		this.defaultAction = "list";
		try {
			Context ctx = new InitialContext();
			problemManager = (ProblemManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/ProblemManager!edu.neumont.ccjudge.managers.ProblemManagerLocal");
			submissionManager = (SubmissionManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/SubmissionManager!edu.neumont.ccjudge.managers.SubmissionManagerLocal");
			teamManager = (TeamManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamManager!edu.neumont.ccjudge.managers.TeamManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public String list(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		
		Contest contest = (Contest) session.getAttribute("contest");
		if (contest==null) return "/contest";
		
		String teamId = request.getParameter("team");
		String problemId = request.getParameter("problem");
		Team team = (Team)session.getAttribute("team");
		//-- make sure we have the most up to date version
		if (team!=null) {
			team = teamManager.findById(team.getId());
		}
		Problem problem = (Problem)session.getAttribute("problem");;
		//-- make sure we have the most up to date problem
		if (problem!=null) {
			problem = problemManager.findById(problem.getId());
		}
		if (teamId!=null && !teamId.isEmpty()) {
			team = teamManager.findById(validator.validateInt(teamId));
			session.setAttribute("team", team);
		}
		if (problemId!=null  && !problemId.isEmpty()) {
			problem = problemManager.findById(validator.validateInt(problemId));
			session.setAttribute("problem", problem);
		}
		
		List<Submission> submissions = new ArrayList<Submission>();
		List<Submission> subs = null;
		if (team!=null) {
			if (problem!=null) subs = team.getProblemSubmissions(problem);
			else subs = team.getSubmissions();
		}
		else if (problem!=null) {
			subs = problem.getSubmissions();
		}
		
		//-- only show the submissions for this contest
		for(Submission sub : subs) {
			if (sub.getContest().equals(contest)) submissions.add(sub);
		}
		//TODO sort by problem or team
		
		request.setAttribute("submissions", submissions);
		
		return "/views/submission/list.jsp";
	}
	
	public String delete(HttpServletRequest request) throws ValidationException {
		String idstr = request.getParameter("id");
		if (idstr!=null) {
			int id = validator.validateInt(idstr);
			Submission sub = submissionManager.findById(id);
			submissionManager.delete(sub);
		}
		return list(request);
	}
	
	public String edit(HttpServletRequest request) throws ValidationException {
		String idstr = request.getParameter("id");
		if (idstr!=null) {
			int id = validator.validateInt(idstr);
			Submission sub = submissionManager.findById(id);
			if(sub!=null) {
				request.setAttribute("submission", sub);
				return "/views/submission/edit.jsp";
			}
		}
		return list(request);
	}
	
	public String update(HttpServletRequest request) throws ValidationException {
		String idstr = request.getParameter("id");
		if (idstr!=null) {
			int id = validator.validateInt(idstr);
			Submission sub = submissionManager.findById(id);
			if (sub!=null) {
				try {
					//submissionTime
					String day = validator.validateString(request.getParameter("submissionTime.day"));
					String month = validator.validateString(request.getParameter("submissionTime.month"));
					String year = validator.validateString(request.getParameter("submissionTime.year"));
					String hour = validator.validateString(request.getParameter("submissionTime.hour"));
					String minute = validator.validateString(request.getParameter("submissionTime.minute"));
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String submissionTime = String.format("%s-%s-%s %s:%s", year, month, day, hour, minute);
					Date subDate = df.parse(submissionTime);
					sub.setSubmissionTime(subDate);
					
					//judgeTime
					day = validator.validateString(request.getParameter("judgeTime.day"));
					month = validator.validateString(request.getParameter("judgeTime.month"));
					year = validator.validateString(request.getParameter("judgeTime.year"));
					hour = validator.validateString(request.getParameter("judgeTime.hour"));
					minute = validator.validateString(request.getParameter("judgeTime.minute"));
					
					String judgeTime = String.format("%s-%s-%s %s:%s", year, month, day, hour, minute);
					Date jTime = df.parse(judgeTime);
					sub.setJudgeTime(jTime);
					
					String pass = request.getParameter("passed");
					if (pass!=null) sub.setPassed(true);
					else sub.setPassed(false);
					
					String filename = validator.validateString(request.getParameter("fileName"));
					sub.setFileName(filename);
					
					String score = request.getParameter("score");
					if (score!=null) {
						sub.setScore(validator.validateDouble(score));
					}
					
					sub.setFileContents(request.getParameter("fileContents"));
					sub.setOutput(request.getParameter("output"));
					sub.setStatus(request.getParameter("status"));
					sub.setResults(request.getParameter("results"));
					
					submissionManager.update(sub);
					
				} catch (ParseException e) {
					throw new ValidationException(e);
				}
			}
		}
		return list(request);
	}
	
	public String regrade(HttpServletRequest request) throws ValidationException {
		String idstr = request.getParameter("id");
		if (idstr!=null) {
			int id = validator.validateInt(idstr);
			Submission sub = submissionManager.findById(id);
			sub = submissionManager.judgeSubmission(sub);
		}
		return list(request);
	}
	
	public String regradeAll(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		String teamId = request.getParameter("team");
		String problemId = request.getParameter("problemId");
		Team team = (Team)session.getAttribute("team");
		Problem problem = (Problem)session.getAttribute("problem");;
		if (teamId!=null) {
			team = teamManager.findById(validator.validateInt(teamId));
			session.setAttribute("team", team);
		}
		if (problemId!=null) {
			problem = problemManager.findById(validator.validateInt(problemId));
			session.setAttribute("problem", problem);
		}
		
		List<Submission> subs = null;
		if (team!=null) {
			if (problem!=null) subs = team.getProblemSubmissions(problem);
			else subs = team.getSubmissions();
		}
		else if (problem!=null) {
			subs = problem.getSubmissions();
		}
		
		for(Submission sub : subs) {
			sub = submissionManager.judgeSubmission(sub);
		}
		
		request.setAttribute("submissions", subs);
		
		return "/views/submission/list.jsp";
	}
}
