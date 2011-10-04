package edu.neumont.ccjudge.scoring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;

public class DefaultScoringModule implements ScoringModule {

	boolean limitDates = true;
	public double score(Contest contest, Team team) {
		if (contest.getTeams().contains(team)) {
			HashMap<Integer, Submission> problemScores = new HashMap<Integer, Submission>();
			List<Submission> subs = team.getSubmissions();
			for (Submission sub : subs) {
				if (sub.isPassed() && sub.getContest().equals(contest) && (!limitDates || sub.getSubmissionTime().before(contest.getEndTime()))) {
					if (problemScores.containsKey(sub.getProblem().getId())) {
						if (problemScores.get(sub.getProblem().getId()).getSubmissionTime().after(sub.getSubmissionTime()))
							problemScores.put(sub.getProblem().getId(), sub);
					}
					else problemScores.put(sub.getProblem().getId(), sub);
				}
			}
			double score = 0;
			for(Submission sub : problemScores.values()) {
				score += sub.getScore();
			}
			return score;
		} else
			throw new IllegalArgumentException(
					"The given team is not associated with the given contest");
	}

	public double scoreSubmission(Submission submission) {
			if (submission.isPassed()) {
				List<Submission> subs = submission.getTeam().getSubmissions();
				double score = 0;
				for (Submission sub : subs) {
					// -- add all of the incorrect submissions
					if (!sub.isPassed() && sub.getProblem().equals(submission.getProblem())
							&& sub.getContest().equals(submission.getContest())) {
						if (sub.getScore()<0) score+=20;
						else score += sub.getScore();
					}
				}
				Date start = submission.getContest().getStartTime();
				Date subdate = submission.getSubmissionTime();
				long starttime = start.getTime();
				long subtime = subdate.getTime();
				long diff = subtime - starttime;
				score += diff / (1000 * 60);
				submission.setScore(score);
			} else {
				submission.setScore(-1);
			}
		return submission.getScore();
	}

	@Override
	public void setLimitDates(boolean l) {
		this.limitDates = l;
		
	}

}
