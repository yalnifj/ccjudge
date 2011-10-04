package edu.neumont.ccjudge.tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Submission;

public class Diff extends SimpleTagSupport {

	Submission submission = null;

	public void setSubmission(Submission s) {
		submission = s;
	}

	public void doTag() throws IOException {
		Problem problem = submission.getProblem();
		String sout = submission.getOutput().trim();
		String pout = problem.getOutput().trim();

		String[] slines = sout.split("\r?\n");
		String[] plines = pout.split("\r?\n");

		StringBuilder diff = new StringBuilder();
		int j = 0;
		int i = 0;
		if (slines.length < 2000) {
			while (i < plines.length && j < slines.length) {
				if (plines[i].equals(slines[j])) {
					diff.append(slines[j]);
					diff.append("\n");
				} else {
					int x = 0;
					int y = 0;
					int state = 0;
					while (x < plines[i].length() && y < slines[j].length()) {
						if (plines[i].charAt(x) != slines[j].charAt(y)) {
							if (state == 0)
								diff.append("<span class=\"diff\">");
							state = 1;
						} else {
							if (state == 1)
								diff.append("</span>");
							state = 0;
						}
						diff.append(slines[j].charAt(y));
						x++;
						y++;
					}
					diff.append("\n" + plines[i] + "\n");
				}

				i++;
				j++;
			}
			getJspContext().getOut().print("<pre>");
			getJspContext().getOut().print(diff.toString());
			getJspContext().getOut().println("</pre>");
		}
		else {
			getJspContext().getOut().print("<pre>");
			getJspContext().getOut().print(sout);
			getJspContext().getOut().println("</pre>");	
		}

	}
}
