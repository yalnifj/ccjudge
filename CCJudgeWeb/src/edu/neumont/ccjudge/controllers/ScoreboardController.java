package edu.neumont.ccjudge.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.neumont.ccjudge.managers.ContestManagerLocal;
import edu.neumont.ccjudge.managers.SubmissionManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;
import edu.neumont.ccjudge.scoring.TeamRankComparator;

public class ScoreboardController extends BaseController {
	private static final long serialVersionUID = 7214818554771283793L;
	private ContestManagerLocal contestManager;
	private SubmissionManagerLocal submissionManager;
	
	public ScoreboardController() {
		super();
		this.defaultAction = "scoreboard";
		this.errorPage = "/views/home/error.jsp";
		
		try {
			Context ctx = new InitialContext();
			contestManager = (ContestManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal");
			submissionManager = (SubmissionManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/SubmissionManager!edu.neumont.ccjudge.managers.SubmissionManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public String scoreboard(HttpServletRequest request) throws ValidationException {
		HttpSession session = request.getSession();
		Date lastload = (Date) session.getAttribute("lastload");
		if (lastload==null) lastload = new Date();
		
		Contest contest = (Contest) session.getAttribute("contest");
		if (contest==null || request.getParameter("contestId")!=null || request.getParameter("contest")!=null) {
			int contestId = 1;
			if (request.getParameter("contestId")!=null) contestId = validator.validateInt(request.getParameter("contestId"));
			if (request.getParameter("contest")!=null) contestId = validator.validateInt(request.getParameter("contest"));
			contest = contestManager.findById(contestId);
		}
		else {
			//-- refresh
			if (contest!=null) contest = contestManager.findById(contest.getId());
		}
		Date now = new Date();
		//-- disable scoreboard the last 30 minutes
		//-- TODO time should be configurable as a property of the contest
		if (now.getTime()+(1000*60*15) > contest.getEndTime().getTime() 
				&& now.getTime() < contest.getEndTime().getTime()) {
			request.setAttribute("error", "Scoreboard is disabled 15 minutes before the end of the competition.");
			return "/views/home/error.jsp";
		}
		
		
		boolean limitDates = true;
		if (session.getAttribute("limitDates")!=null) limitDates = (Boolean) session.getAttribute("limitDates");
		String ld = request.getParameter("limitDates");
		if (ld!=null) limitDates = ld.equals("true");
		session.setAttribute("limitDates", limitDates);
		
		
		Map<Integer, Double> teamScores = submissionManager.getTeamScores(contest.getId(), limitDates);
		Map<Integer, Integer> teamPassed = submissionManager.getTeamPassCount(contest.getId(), limitDates);
		TeamRankComparator ranker = new TeamRankComparator(teamScores,teamPassed);
		List<Team> teams = contest.getTeams();
		Collections.sort(teams, ranker);
		
		List<Submission> recentPasses = submissionManager.getRecentPasses(contest.getId(), lastload);
		request.setAttribute("recentPasses", recentPasses);
		
		request.setAttribute("contest", contest);
		request.setAttribute("teamScores", teamScores);
		request.setAttribute("teamPassed", teamPassed);
		request.setAttribute("teams", teams);
		session.setAttribute("lastload", new Date());
		return "/views/scoreboard/scoreboard.jsp";
	}

}
