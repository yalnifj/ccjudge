package edu.neumont.ccjudge.controllers;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import edu.neumont.ccjudge.managers.TeamManagerLocal;
import edu.neumont.ccjudge.managers.TeamMemberManagerLocal;
import edu.neumont.ccjudge.model.Team;
import edu.neumont.ccjudge.model.TeamMember;
import edu.neumont.ccjudge.model.TeamMemberRole;


/**
 * Servlet implementation class for Servlet: ContestController
 *
 */
 public class TeamMemberController extends BaseController {
   static final long serialVersionUID = 1L;
   
   private TeamMemberManagerLocal manager;
   private TeamManagerLocal teamManager;
   
	public TeamMemberController() {
		super();
		this.defaultAction = "list";
		this.errorPage = "/views/member/error.jsp";
		try {
			Context ctx = new InitialContext();
			manager = (TeamMemberManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamMemberManager!edu.neumont.ccjudge.managers.TeamMemberManagerLocal");
			teamManager = (TeamManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/TeamManager!edu.neumont.ccjudge.managers.TeamManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}   	
	
	public String list(HttpServletRequest request) {
		List<TeamMember> list = manager.getList();
		request.setAttribute("list", list);
		return "/views/member/list.jsp";
	}
	
	public String view(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember member = manager.findById(id);
		request.setAttribute("member", member);
		return "/views/member/view.jsp";
	}
	
	public String edit(HttpServletRequest request) throws ValidationException {
		String idStr = request.getParameter("id");
		TeamMember member = null;
		if (idStr!=null) {
			int id = validator.validateInt(idStr);
			member = manager.findById(id);
		}
		if (member==null) {
			member = new TeamMember();
			//Property p = new Property();
			//p.setName("Email");
			//member.getProperties().put(p.getName(), p);
			String teamid = request.getParameter("team");
			if (teamid!=null && !teamid.isEmpty()) {
				int tid = validator.validateInt(teamid);
				Team team = teamManager.findById(tid);
				request.setAttribute("team", team);
				
				TeamMemberRole memberRole = new TeamMemberRole();
				memberRole.setMember(member);
				memberRole.setRole("Participant");
				memberRole.setTeam(team);
				member.getTeams().add(memberRole);
			}
		}
		
		request.setAttribute("member", member);
		return "/views/member/edit.jsp";
	}
	
	public String delete(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember member = manager.findById(id);
		if (member!=null) manager.delete(member);
		return this.list(request);
	}
	
	public String update(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember member = manager.findById(id);
		
		if (member==null) member = new TeamMember();
		
		String name = validator.validateString(request.getParameter("name"));
		String username = validator.validateString(request.getParameter("username"));
		String role = validator.validateString(request.getParameter("role"));
		
		member.setName(name);
		member.setUsername(username);
		
		String teamid = request.getParameter("team");
		if (teamid!=null) {
			int tid = validator.validateInt(teamid);
			Team team = teamManager.findById(tid);
			request.setAttribute("team", team);
			
			TeamMemberRole memberRole = new TeamMemberRole();
			memberRole.setMember(member);
			memberRole.setRole(role);
			memberRole.setTeam(team);
			
			if (!team.getMembers().contains(memberRole)) {
				team.getMembers().add(memberRole);
//				teamManager.update(team);
			}
			if (!member.getTeams().contains(memberRole)) member.getTeams().add(memberRole);
		}
		
		if(member.getId()==0) member = (TeamMember)manager.create(member);
		else manager.update(member);
		
		request.setAttribute("member", member);
		return "/views/member/view.jsp";
	}
	
	public String find(HttpServletRequest request) throws ValidationException {
		String username = validator.validateString(request.getParameter("username"));
		List<TeamMember> members = manager.findList(username);
		request.setAttribute("list", members);
//		System.out.println("Searching for "+username+" found "+members.size());
		return "/views/member/list.jsp";
	}
	
	public String add(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		TeamMember member = manager.findById(id);
		String teamid = request.getParameter("team");
		if (member!=null && teamid!=null) {
			int tid = validator.validateInt(teamid);
			Team team = teamManager.findById(tid);
			TeamMemberRole memberRole = new TeamMemberRole();
			memberRole.setMember(member);
			memberRole.setRole("Participant");
			memberRole.setTeam(team);
			if (!member.getTeams().contains(memberRole)) {
				member.getTeams().add(memberRole);
				manager.update(member);
			}
		}
		return members(request);
	}
	
	public String members(HttpServletRequest request) throws ValidationException {
		String teamid = request.getParameter("team");
		if (teamid!=null) {
			int tid = validator.validateInt(teamid);
			Team team = teamManager.findById(tid);
			
			request.setAttribute("team", team);
			request.setAttribute("edit", request.getParameter("edit"));
		}
		return "/views/member/teamMembers.jsp";
	}
}