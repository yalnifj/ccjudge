package edu.neumont.ccjudge.model;

import javax.persistence.PostPersist;
import javax.persistence.PreRemove;


public class LifeCycleListener {

	@PreRemove
	public void onRemove(Object e){
		int id = 0;
		if (e instanceof TeamMember) id = ((TeamMember)e).getId();
		if (e instanceof TeamMemberRole) id = ((TeamMemberRole)e).getId();
		if (e instanceof Team) id = ((Team)e).getId();
		System.out.println("Deleting entity "+e.getClass().getName()+" "+id);
	}
	@PostPersist
	public void onCreate(Object e) {
		int id = 0;
		if (e instanceof TeamMember) id = ((TeamMember)e).getId();
		if (e instanceof TeamMemberRole) id = ((TeamMemberRole)e).getId();
		if (e instanceof Team) id = ((Team)e).getId();
		System.out.println("Creating entity "+e.getClass().getName()+" "+id);
	}
}
