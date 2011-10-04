package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Local;

import edu.neumont.ccjudge.model.Problem;

@Local
public interface ProblemManagerLocal {

	public Problem create(Problem problem);

	public void update(Problem problem);

	public void delete(Problem problem);

	public Problem findById(int id);

	@SuppressWarnings("unchecked")
	public List<Problem> getList();

}