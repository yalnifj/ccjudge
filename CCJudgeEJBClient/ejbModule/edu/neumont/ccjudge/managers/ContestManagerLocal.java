package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Local;

import edu.neumont.ccjudge.model.Contest;

@Local
public interface ContestManagerLocal {

	public Contest create(Contest contest);

	public void update(Contest contest);

	public void delete(Contest contest);

	public Contest findById(int id);

	@SuppressWarnings("unchecked")
	public List<Contest> getList();

}