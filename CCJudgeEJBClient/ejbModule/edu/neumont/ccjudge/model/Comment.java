package edu.neumont.ccjudge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {
	private static final long serialVersionUID = -4254382854614167002L;

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Comment parent;
	@OneToMany(mappedBy="parent")
	private List<Comment> children = new ArrayList<Comment>();
	@ManyToOne
	private TeamMember commenter;
	@ManyToOne
	private Problem problem;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	@Lob
	private String text;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Comment getParent() {
		return parent;
	}
	public void setParent(Comment parent) {
		this.parent = parent;
	}
	public List<Comment> getChildren() {
		return children;
	}
	public void setChildren(List<Comment> children) {
		this.children = children;
	}
	public TeamMember getCommenter() {
		return commenter;
	}
	public void setCommenter(TeamMember commenter) {
		this.commenter = commenter;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
