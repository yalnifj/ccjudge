package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import edu.neumont.ccjudge.model.Contest;

@Stateless(mappedName="java:global/CCJudge/CCJudgeEJB/ContestManager!edu.neumont.ccjudge.managers.ContestManagerLocal")
public class ContestManager implements ContestManagerLocal {
	@PersistenceUnit(unitName="CCJudge")
	EntityManagerFactory emf;
	
	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ContestManagerLocal#create(edu.neumont.ccjudge.model.Contest)
	 */
	public Contest create(Contest contest) {
		EntityManager em = emf.createEntityManager();
		em.persist(contest);
		return contest;
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ContestManagerLocal#update(edu.neumont.ccjudge.model.Contest)
	 */
	public void update(Contest contest) {
		EntityManager em = emf.createEntityManager();
		em.merge(contest);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ContestManagerLocal#delete(edu.neumont.ccjudge.model.Contest)
	 */
	public void delete(Contest contest) {
		EntityManager em = emf.createEntityManager();
		contest = em.find(Contest.class, contest.getId());
		if (contest!=null) em.remove(contest);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ContestManagerLocal#findById(int)
	 */
	public Contest findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Contest.class, id);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ContestManagerLocal#getList()
	 */
	@SuppressWarnings("unchecked")
	public List<Contest> getList() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select o from Contest o").getResultList();
	}
}
