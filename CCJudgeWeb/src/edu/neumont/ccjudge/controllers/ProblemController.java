package edu.neumont.ccjudge.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.neumont.ccjudge.managers.ContestManagerLocal;
import edu.neumont.ccjudge.managers.ProblemManagerLocal;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Problem;

public class ProblemController extends BaseController {
	static final long serialVersionUID = 1L;

	private ProblemManagerLocal manager;
	private ContestManagerLocal contestManager;

	public ProblemController() {
		super();
		this.defaultAction = "list";
		try {
			Context ctx = new InitialContext();
			contestManager = (ContestManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal");
			manager = (ProblemManagerLocal) ctx.lookup("java:global/CCJudge/CCJudgeEJB/ProblemManager!edu.neumont.ccjudge.managers.ProblemManagerLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String list(HttpServletRequest request) throws ValidationException {
		List<Problem> list = null;
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
		if (contest != null) {
			list = contest.getProblems();
		} else {
			list = manager.getList();
		}
		request.setAttribute("list", list);
		return "/views/problem/list.jsp";
	}

	public String view(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Problem problem = manager.findById(id);
		request.setAttribute("problem", problem);
		return "/views/problem/view.jsp";
	}

	public String edit(HttpServletRequest request) throws ValidationException {
		String idStr = request.getParameter("id");
		Problem problem = null;
		if (idStr != null) {
			int id = validator.validateInt(idStr);
			problem = manager.findById(id);
		}
		if (problem == null) {
			problem = new Problem();
			String templateFile = getServletContext().getRealPath(getServletContext().getInitParameter("problem_template"));
			String template = "";
			try {
				File tfile = new File(templateFile);
				BufferedReader in = new BufferedReader(new FileReader(tfile));
				String line = null;
				while((line = in.readLine())!=null) {
					template += line+"\r\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			problem.setDescription(template);
			Contest contest = (Contest) request.getSession().getAttribute("contest");
			if (contest != null)
				problem.getContests().add(contest);
		}
		List<Contest> allcontests = contestManager.getList();
		request.setAttribute("contests", allcontests);
		request.setAttribute("problem", problem);
		return "/views/problem/edit.jsp";
	}

	public String delete(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Problem problem = manager.findById(id);
		if (problem != null)
			manager.delete(problem);
		return this.list(request);
	}

	public String update(HttpServletRequest request) throws ValidationException {
		int id = validator.validateInt(request.getParameter("id"));
		Problem problem = manager.findById(id);

		if (problem == null)
			problem = new Problem();
		problem.setName(validator.validateString(request.getParameter("name"),
				Validator.STRIP_TAGS, -1));
		problem.setShortName(validator.validateString(request.getParameter("shortName"),
				Validator.STRIP_TAGS, -1));
		problem.setDescription(request.getParameter("description"));
		problem.setInput(request.getParameter("input"));
		problem.setOutput(request.getParameter("output"));
		String[] cids = request.getParameterValues("contest");
		if (cids != null) {
			problem.getContests().clear();
			for (String cid : cids) {
				if (cid != null && !cid.isEmpty()) {
					Contest c = contestManager.findById(validator.validateInt(cid));
					if (c != null) {
						if (!problem.getContests().contains(c)) {
							problem.getContests().add(c);
						}
						if (!c.getProblems().contains(problem)) {
							c.getProblems().add(problem);
						}
					}
				}
			}
		}

		if (problem.getId() == 0)
			problem = (Problem) manager.create(problem);
		else
			manager.update(problem);

		request.setAttribute("problem", problem);
		return "/views/problem/view.jsp";
	}
}
