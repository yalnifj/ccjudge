package edu.neumont.ccjudge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contest implements Serializable {
	private static final long serialVersionUID = -4894833236963173782L;

	@Id
	@GeneratedValue
	protected int id;
	
	protected String name;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String description;
	
	@ManyToMany(mappedBy="contests", fetch=FetchType.LAZY)
	@OrderBy(value="id")
	protected List<Team> teams = new ArrayList<Team>(0);
	
	@ManyToMany(mappedBy="contests", fetch=FetchType.LAZY)
	protected List<Problem> problems = new ArrayList<Problem>(0);

	@Temporal(value=TemporalType.TIMESTAMP)
	protected Date startTime;

	@Temporal(value=TemporalType.TIMESTAMP)
	protected Date endTime;
	
	protected int membersPerTeam = 3;
	
	protected JudgeType judgeType;
	
	protected boolean canRegister = true;
	
	public int getMembersPerTeam() {
		return membersPerTeam;
	}

	public void setMembersPerTeam(int membersPerTeam) {
		this.membersPerTeam = membersPerTeam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
	
	public boolean equals(Object t) {
		if (t instanceof Contest) {
			Contest team = (Contest) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public JudgeType getJudgeType() {
		return judgeType;
	}

	public void setJudgeType(JudgeType judgeType) {
		this.judgeType = judgeType;
	}

	public boolean isCanRegister() {
		return canRegister;
	}

	public void setCanRegister(boolean canRegister) {
		this.canRegister = canRegister;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
