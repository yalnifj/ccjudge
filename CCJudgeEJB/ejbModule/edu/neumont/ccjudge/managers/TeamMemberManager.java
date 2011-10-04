package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import edu.neumont.ccjudge.model.TeamMember;
import edu.neumont.ccjudge.model.TeamMemberRole;

@Stateless
public class TeamMemberManager implements TeamMemberManagerLocal {
	@PersistenceUnit(unitName = "CCJudge")
	EntityManagerFactory emf;

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamMemberManagerLocal#create(edu.neumont.ccjudge.model.TeamMember)
	 */
	public TeamMember create(TeamMember member) {
		EntityManager em = emf.createEntityManager();
		em.persist(member);
		return member;
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamMemberManagerLocal#update(edu.neumont.ccjudge.model.TeamMember)
	 */
	public void update(TeamMember member) {
		EntityManager em = emf.createEntityManager();
		em.merge(member);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamMemberManagerLocal#delete(edu.neumont.ccjudge.model.TeamMember)
	 */
	public void delete(TeamMember member) {
		EntityManager em = emf.createEntityManager();
		em.flush();
		member = em.find(TeamMember.class, member.getId());
		if (member!=null) {
			for(TeamMemberRole role : member.getTeams()) {
				System.out.println("Deleting role "+role.getId());
				role.getTeam().getMembers().remove(role);
				em.merge(role.getTeam());
				em.remove(role);
			}
			em.remove(member);
		}
	}
	
	@Override
	public void deleteMemberRole(TeamMemberRole member) {
		EntityManager em = emf.createEntityManager();
		member = em.find(TeamMemberRole.class, member.getId());
		if (member!=null) {
			member.getTeam().getMembers().remove(member);
			member.getMember().getTeams().remove(member);
			member.setMember(null);
			member.setTeam(null);
			em.remove(member);
		}
		em.flush();
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamMemberManagerLocal#findById(int)
	 */
	public TeamMember findById(int id) {
		EntityManager em = emf.createEntityManager();
		em.flush();
		em.clear();
		return em.find(TeamMember.class, id);
	}
	
	@Override
	public TeamMember findByUsername(String username) {
		EntityManager em = emf.createEntityManager();
		TeamMember member = null;
		Query q = em.createQuery("select m from TeamMember m where m.username=?1");
		q.setParameter(1, username);
		try {
			member = (TeamMember) q.getSingleResult();
		}
		catch(EntityNotFoundException e) {
			//-- nothing found return null
		}
		catch(NoResultException e) {
			//-- nothing found return null
		}
		return member;
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamMemberManagerLocal#getList()
	 */
	@SuppressWarnings("unchecked")
	public List<TeamMember> getList() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select o from TeamMember o").getResultList();
	}
	
	@Override
	public List<TeamMember> findList(String username) {
		if (username==null || username.length()<1) return null;
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select o from TeamMember o where o.username like '"+username+"%' order by o.username").getResultList();
	}
}
