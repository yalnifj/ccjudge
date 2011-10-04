package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import edu.neumont.ccjudge.model.Team;

@Stateless
public class TeamManager implements TeamManagerLocal {
	@PersistenceUnit(unitName = "CCJudge")
	EntityManagerFactory emf;

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamManagerLocal#create(edu.neumont.ccjudge.model.Team)
	 */
	public Team create(Team team) {
		EntityManager em = emf.createEntityManager();
		em.persist(team);
		return team;
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamManagerLocal#update(edu.neumont.ccjudge.model.Team)
	 */
	public void update(Team team) {
		EntityManager em = emf.createEntityManager();
		em.merge(team);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamManagerLocal#delete(edu.neumont.ccjudge.model.Team)
	 */
	public void delete(Team team) {
		EntityManager em = emf.createEntityManager();
		team = em.find(Team.class, team.getId());
		em.remove(team);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamManagerLocal#findById(int)
	 */
	public Team findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Team.class, id);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.TeamManagerLocal#getList()
	 */
	@SuppressWarnings("unchecked")
	public List<Team> getList() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select o from Team o").getResultList();
	}
}
