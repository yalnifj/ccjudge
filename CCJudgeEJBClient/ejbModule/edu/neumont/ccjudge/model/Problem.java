package edu.neumont.ccjudge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Problem implements Serializable {
	private static final long serialVersionUID = 5248412300852779050L;

	@Id
	@GeneratedValue
	protected int id;
	protected String shortName;
	protected String name;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String description;
	
	@ManyToMany(fetch=FetchType.LAZY)
	protected List<Contest> contests = new ArrayList<Contest>(0);
	
	@OneToMany(mappedBy="problem", fetch=FetchType.LAZY)
	protected List<Submission> submissions = new ArrayList<Submission>(0);
	
	@OneToMany(mappedBy="problem", fetch=FetchType.LAZY)
	protected List<Comment> comments = new ArrayList<Comment>(0);
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String input;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected String output;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Contest> getContests() {
		return contests;
	}

	public void setContests(List<Contest> contests) {
		this.contests = contests;
	}

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public boolean equals(Object t) {
		if (t instanceof Problem) {
			Problem team = (Problem) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
