package edu.neumont.ccjudge.managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import edu.neumont.ccjudge.model.Problem;

@Stateless
public class ProblemManager implements ProblemManagerLocal {
	@PersistenceUnit(unitName = "CCJudge")
	EntityManagerFactory emf;

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ProblemManagerLocal#create(edu.neumont.ccjudge.model.Problem)
	 */
	public Problem create(Problem problem) {
		EntityManager em = emf.createEntityManager();
		em.persist(problem);
		return problem;
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ProblemManagerLocal#update(edu.neumont.ccjudge.model.Problem)
	 */
	public void update(Problem problem) {
		EntityManager em = emf.createEntityManager();
		em.merge(problem);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ProblemManagerLocal#delete(edu.neumont.ccjudge.model.Problem)
	 */
	public void delete(Problem problem) {
		EntityManager em = emf.createEntityManager();
		problem = em.find(Problem.class, problem.getId());
		em.remove(problem);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ProblemManagerLocal#findById(int)
	 */
	public Problem findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Problem.class, id);
	}

	/* (non-Javadoc)
	 * @see edu.neumont.ccjudge.managers.ProblemManagerLocal#getList()
	 */
	@SuppressWarnings("unchecked")
	public List<Problem> getList() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select o from Problem o").getResultList();
	}
}
