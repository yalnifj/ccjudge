package edu.neumont.ccjudge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@EntityListeners(LifeCycleListener.class)
public class TeamMember implements Serializable {
	private static final long serialVersionUID = 8019178754764428886L;
	public static final String DEFAULT_ROLE = "participant";
	
	@Id
	@GeneratedValue
	protected int id;
	
	@OneToMany(mappedBy="member", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	protected List<TeamMemberRole> teams = new ArrayList<TeamMemberRole>(0);
	protected String name;
	@Column(nullable=false, unique=true)
	protected String username;
	protected String password;
	protected String email;
	
	protected String role;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	protected List<Property> properties = new ArrayList<Property>(0);
	
	public TeamMember() {
		role = DEFAULT_ROLE;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TeamMemberRole> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamMemberRole> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object t) {
		if (t instanceof TeamMember) {
			TeamMember team = (TeamMember) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
