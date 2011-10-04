package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Local;

import edu.neumont.ccjudge.model.Team;

@Local
public interface TeamManagerLocal {

	public Team create(Team team);

	public void update(Team team);

	public void delete(Team team);

	public Team findById(int id);

	@SuppressWarnings("unchecked")
	public List<Team> getList();

}