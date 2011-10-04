package edu.neumont.ccjudge.scoring;

import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;

public interface ScoringModule {

	public double score(Contest contest, Team team);
	public double scoreSubmission(Submission submission);
	public void setLimitDates(boolean l);
}
