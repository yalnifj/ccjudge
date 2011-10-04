package edu.neumont.ccjudge.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import edu.neumont.ccjudge.managers.ContestManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.JudgeType;
import edu.neumont.ccjudge.model.Team;


/**
 * Servlet implementation class for Servlet: ContestController
 *
 */
 public class ContestController extends BaseController {
   static final long serialVersionUID = 1L;
   
   @EJB 
   private ContestManagerLocal manager;
   
	public ContestController() {
		super();
		this.defaultAction = "list";
	}   	
	
	public String list(HttpServletRequest request) {
		List<Contest> list = manager.getList();
		request.setAttribute("list", list);
		return "/views/contest/list.jsp";
	}
	
	public String view(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Contest contest = manager.findById(id);
		List<Team> teams = contest.getTeams();
		teams.size();
		request.setAttribute("contest", contest);
		return "/views/contest/view.jsp";
	}
	
	public String edit(HttpServletRequest request) throws ValidationException {
		String idStr = request.getParameter("id");
		Contest contest = null;
		if (idStr!=null) {
			int id = validator.validateInt(idStr);
			contest = manager.findById(id);
		}
		if (contest==null) {
			contest = new Contest();
			contest.setEndTime(new Date());
			contest.setStartTime(new Date());
		}
		List<Team> teams = contest.getTeams();
		teams.size();
		request.setAttribute("contest", contest);
		return "/views/contest/edit.jsp";
	}
	
	public String delete(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Contest contest = manager.findById(id);
		if (contest!=null) manager.delete(contest);
		return this.list(request);
	}
	
	public String update(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Contest contest = manager.findById(id);
		
		if (contest==null) contest = new Contest();
		
		String name = validator.validateText(request.getParameter("name"));
		String descr = validator.validateString(request.getParameter("description"), Validator.NONE, -1);
		HashMap<String,String> dateParams = new HashMap<String, String>();
		dateParams.put("day", request.getParameter("startTime.day"));
		dateParams.put("month", request.getParameter("startTime.month"));
		dateParams.put("year", request.getParameter("startTime.year"));
		dateParams.put("hour", request.getParameter("startTime.hour"));
		dateParams.put("minute", request.getParameter("startTime.minute"));
		Date startTime = validator.validateDate(dateParams);
		dateParams = new HashMap<String, String>();
		dateParams.put("day", request.getParameter("endTime.day"));
		dateParams.put("month", request.getParameter("endTime.month"));
		dateParams.put("year", request.getParameter("endTime.year"));
		dateParams.put("hour", request.getParameter("endTime.hour"));
		dateParams.put("minute", request.getParameter("endTime.minute"));
		Date endTime = validator.validateDate(dateParams);
		
		contest.setDescription(descr);
		contest.setEndTime(endTime);
		contest.setName(name);
		contest.setStartTime(startTime);
		contest.setCanRegister(false);
		if (request.getParameter("canRegister")!=null) {
			String canRegister = validator.validateString(request.getParameter("canRegister"));
			if (canRegister.equals("true")) contest.setCanRegister(true);
		}
		
		int type = validator.validateInt(request.getParameter("judgeType"));
		if (type==0) contest.setJudgeType(JudgeType.FILEIO);
		else contest.setJudgeType(JudgeType.CONSOLEIO);
		
		if(contest.getId()==0) contest = (Contest)manager.create(contest);
		else manager.update(contest);
		
		List<Team> teams = contest.getTeams();
		teams.size();
		request.setAttribute("contest", contest);
		return "/views/contest/view.jsp";
	}
}