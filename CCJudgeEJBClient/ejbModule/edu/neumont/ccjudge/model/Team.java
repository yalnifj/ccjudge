package edu.neumont.ccjudge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

@Entity
@EntityListeners(LifeCycleListener.class)
public class Team implements Serializable {
	private static final long serialVersionUID = 8890886922405569376L;
	
	@Id
	@GeneratedValue
	protected int id;
	
	@OneToMany(mappedBy="team", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	protected List<TeamMemberRole> members = new ArrayList<TeamMemberRole>(0);
	protected String name;
	protected boolean loggedIn;
	
	@OneToMany(mappedBy="team", fetch=FetchType.LAZY)
	@OrderBy("submissionTime")
	protected List<Submission> submissions = new ArrayList<Submission>(0);
	
	@ManyToMany
	protected List<Contest> contests = new ArrayList<Contest>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TeamMemberRole> getMembers() {
		return members;
	}

	public void setMembers(List<TeamMemberRole> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public List<Contest> getContests() {
		return contests;
	}
	
	@Transient
	public List<Contest> getActiveContests() {
		ArrayList<Contest> list = new ArrayList<Contest>();
		Date now = new Date();
		for(Contest c: this.getContests()) {
			if (c.getStartTime().before(now)) list.add(c);
		}
		return list;
	}
	
	@Transient
	public List<Contest> getInActiveContests() {
		ArrayList<Contest> list = new ArrayList<Contest>();
		Date now = new Date();
		for(Contest c: this.getContests()) {
			if (c.getStartTime().after(now)) list.add(c);
		}
		return list;
	}

	public void setContests(List<Contest> contests) {
		this.contests = contests;
	}
	
	public boolean equals(Object t) {
		if (t instanceof Team) {
			Team team = (Team) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}
	
	@Transient
	public List<Submission> getProblemSubmissions(Problem problem) {
		ArrayList<Submission> list = new ArrayList<Submission>();
		for(Submission s : getSubmissions()) {
			if (s.getProblem().getId()==problem.getId()) {
				list.add(s);
			}
		}
		return list;
	}
}
