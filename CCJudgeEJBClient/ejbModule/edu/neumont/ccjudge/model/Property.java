package edu.neumont.ccjudge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Property implements Serializable {
	private static final long serialVersionUID = -7609994443160014048L;

	@Id
	@GeneratedValue
	protected int id;
	protected String name;
	protected String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean equals(Object t) {
		if (t instanceof Property) {
			Property team = (Property) t;
			if (team==this) return true;
			if (team.getId()==this.getId()) return true;
		}
		return false;
	}
}
