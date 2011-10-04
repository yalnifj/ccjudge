package edu.neumont.ccjudge.scoring;

import java.util.Comparator;
import java.util.Map;

import edu.neumont.ccjudge.model.Team;

public class TeamRankComparator implements Comparator<Team> {

	Map<Integer, Double> teamScores;
	Map<Integer, Integer> teamPassed;
	
	public TeamRankComparator(Map<Integer, Double> teamScores, Map<Integer, Integer> teamPassed) {
		this.teamPassed = teamPassed;
		this.teamScores = teamScores;
	}
	
	public int compare(Team a, Team b) {
		Integer apassed = teamPassed.get(a.getId());
		Integer bpassed = teamPassed.get(b.getId());
		
		if (apassed==bpassed) {
			Double ascore = teamScores.get(a.getId());
			Double bscore = teamScores.get(b.getId());
			return (int)Math.round(ascore-bscore);
		}
		return bpassed-apassed;
		
	}

}
