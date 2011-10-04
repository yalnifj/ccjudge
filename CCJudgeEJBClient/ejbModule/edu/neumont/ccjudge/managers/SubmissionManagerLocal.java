package edu.neumont.ccjudge.managers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import edu.neumont.ccjudge.model.Module;
import edu.neumont.ccjudge.model.Submission;

@Local
public interface SubmissionManagerLocal {

	public Submission create(Submission submission);

	public void update(Submission submission);

	public void delete(Submission submission);

	public Submission findById(int id);

	@SuppressWarnings("unchecked")
	public List<Submission> getList();

	public abstract Submission judgeSubmission(Submission sub);

	public abstract Map<Integer, Double> getTeamScores(int contestId, boolean limitDates);

	public abstract Map<Integer, Integer> getTeamPassCount(int contestId, boolean limitDates);

	public abstract List<Module> createDefaultModules();
	
	public List<Submission> getRecentPasses(int contestId, Date date);

}