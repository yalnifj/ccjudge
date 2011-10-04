package edu.neumont.ccjudge.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Submission implements Serializable {
	private static final long serialVersionUID = 5407173399095903362L;

	@Id
	@GeneratedValue
	protected int id;
	@ManyToOne
	protected Team team;
	@ManyToOne
	protected Problem problem;
	@Temporal(value=TemporalType.TIMESTAMP)
	protected Date submissionTime;
	@Temporal(value=TemporalType.TIMESTAMP)
	protected Date judgeTime;
	protected boolean passed;
	protected String fileName;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String results;
	protected String status;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String fileContents;
	
	@ManyToOne
	protected Contest contest;
	protected double score;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String output;
	
	
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
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public Date getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}
	public Date getJudgeTime() {
		return judgeTime;
	}
	public void setJudgeTime(Date judgeTime) {
		this.judgeTime = judgeTime;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getFileContents() {
		return fileContents;
	}
	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
	
	public boolean equals(Object t) {
		if (t instanceof Submission) {
			Submission team = (Submission) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public double getScore() {
		return score;
	}
	
	public int getScoreHour() {
		return (int) (score/60);
	}
	
	public int getScoreMin() {
		return (int) (score%60);
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
