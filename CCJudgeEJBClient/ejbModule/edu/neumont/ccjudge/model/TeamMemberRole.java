package edu.neumont.ccjudge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@EntityListeners(LifeCycleListener.class)
public class TeamMemberRole implements Serializable {
	private static final long serialVersionUID = -2851391939679682697L;
	
	@Id
	@GeneratedValue
	protected int id;
	
	@ManyToOne
	protected Team team;
	
	@ManyToOne
	protected TeamMember member;
	protected String role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public TeamMember getMember() {
		return member;
	}
	public void setMember(TeamMember member) {
		this.member = member;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean equals(Object t) {
		if (t instanceof TeamMemberRole) {
			TeamMemberRole team = (TeamMemberRole) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}
}
