package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Local;

import edu.neumont.ccjudge.model.TeamMember;
import edu.neumont.ccjudge.model.TeamMemberRole;

@Local
public interface TeamMemberManagerLocal {

	public TeamMember create(TeamMember member);

	public void update(TeamMember member);

	public void delete(TeamMember member);

	public TeamMember findById(int id);

	@SuppressWarnings("unchecked")
	public List<TeamMember> getList();

	public abstract void deleteMemberRole(TeamMemberRole member);

	public abstract TeamMember findByUsername(String username);

	public abstract List<TeamMember> findList(String username);

}