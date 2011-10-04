package edu.neumont.ccjudge.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;

public class SubmissionStatusTag extends SimpleTagSupport {

	private Team team;
	private Problem problem;
	private Contest contest;

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setProblem(Problem p) {
		this.problem = p;
	}
	
	public void setContest(Contest c) {
		this.contest = c;
	}

	public void doTag() throws IOException, JspException {
		Submission found = null;
		int count = 0;
		if (team != null) {
			List<Submission> problemSubs = team.getProblemSubmissions(problem);
			count = problemSubs.size();
			for (Submission s : problemSubs) {
				if (found == null) {
					found = s;
				} else {
					if (!found.isPassed() && s.isPassed())
						found = s;
					else {
						if (found.getSubmissionTime().after(s.getSubmissionTime()) && s.getSubmissionTime().before(contest.getEndTime()))
							found = s;
					}
				}
			}
		}
		getJspContext().setAttribute("submission", found);
		getJspContext().setAttribute("count", count);
		getJspBody().invoke(null);
	}
}
