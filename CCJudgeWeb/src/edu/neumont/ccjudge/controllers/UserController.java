package edu.neumont.ccjudge.controllers;

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
import edu.neumont.ccjudge.model.TeamMember;

public class UserController extends BaseController {
	static final long serialVersionUID = 1L;

	private TeamManagerLocal manager;
	private ContestManagerLocal contestManager;
	private TeamMemberManagerLocal memberManager;

	public UserController() {
		super();
		this.defaultAction = "list";
		
		try {
			Context ctx = new InitialContext();
			contestManager = (ContestManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal");
			manager = (TeamManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamManager!edu.neumont.ccjudge.managers.TeamManagerLocal");
			memberManager = (TeamMemberManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamMemberManager!edu.neumont.ccjudge.managers.TeamMemberManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public String list(HttpServletRequest request) throws ValidationException {
		List<TeamMember> list = null;
		Contest contest = null;
		HttpSession session = request.getSession();

		String idstr = request.getParameter("contest");
		if (idstr != null && !idstr.isEmpty()) {
			int contestId = validator.validateInt(idstr);
			contest = contestManager.findById(contestId);
			session.setAttribute("contest", contest);
		} else {
			contest = (Contest) session.getAttribute("contest");
			if (contest!=null) contest = contestManager.findById(contest.getId());
		}
		
		list = memberManager.getList();
		request.setAttribute("list", list);
		return "/views/user/list.jsp";
	}

	public String view(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember user = memberManager.findById(id);
		request.setAttribute("user", user);
		return "/views/user/view.jsp";
	}

	public String edit(HttpServletRequest request) throws ValidationException {
		String idStr = request.getParameter("id");
		TeamMember user = null;
		if (idStr != null) {
			int id = validator.validateInt(idStr);
			user = memberManager.findById(id);
		}
		if(user == null) {
			return list(request);
		}
		request.setAttribute("user", user);
		return "/views/user/edit.jsp";
	}

	public String delete(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember user = memberManager.findById(id);
		if (user != null)
		{
//			for(TeamMemberRole role : user.getTeams())
//				memberManager.deleteMemberRole(role);
			memberManager.delete(user);
		}
		return this.list(request);
	}

	public String update(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember user = memberManager.findById(id);

		user.setUsername(validator.validateString(request.getParameter("username")));
		user.setName(validator.validateString(request.getParameter("name")));
		user.setEmail(validator.validateString(request.getParameter(("email"))));
		if (request.getParameter("admin")!=null) user.setRole("admin");
		else user.setRole("participant");
		memberManager.update(user);

		request.setAttribute("user", user);
		return "/views/user/view.jsp";
	}
}
