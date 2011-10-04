package edu.neumont.ccjudge.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import edu.neumont.ccjudge.judging.JavaJudgeModule;
import edu.neumont.ccjudge.judging.JudgingModule;
import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Module;
import edu.neumont.ccjudge.model.Property;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;
import edu.neumont.ccjudge.scoring.ScoringModule;

@Stateless
public class SubmissionManager implements SubmissionManagerLocal {
	@PersistenceUnit(unitName = "CCJudge")
	EntityManagerFactory emf;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.neumont.ccjudge.managers.SubmissionManagerLocal#create(edu.neumont.ccjudge.model.Submission)
	 */
	public Submission create(Submission submission) {
		EntityManager em = emf.createEntityManager();
		em.persist(submission);
		return submission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.neumont.ccjudge.managers.SubmissionManagerLocal#update(edu.neumont.ccjudge.model.Submission)
	 */
	public void update(Submission submission) {
		EntityManager em = emf.createEntityManager();
		em.merge(submission);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.neumont.ccjudge.managers.SubmissionManagerLocal#delete(edu.neumont.ccjudge.model.Submission)
	 */
	public void delete(Submission submission) {
		EntityManager em = emf.createEntityManager();
		submission = em.find(Submission.class, submission.getId());
		em.remove(submission);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.neumont.ccjudge.managers.SubmissionManagerLocal#findById(int)
	 */
	public Submission findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Submission.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.neumont.ccjudge.managers.SubmissionManagerLocal#getList()
	 */
	@SuppressWarnings("unchecked")
	public List<Submission> getList() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("select o from Submission o").getResultList();
	}

	/**
	 * setup the default modules
	 * 
	 * @return
	 */
	@Override
	public List<Module> createDefaultModules() {
		EntityManager em = emf.createEntityManager();
		ArrayList<Module> list = new ArrayList<Module>();

		Query q = em.createQuery("delete from Module m");
		int r = q.executeUpdate();
		System.out.println("Deleted " + r + " modules");

		Module java = new Module();
		java.setClassName("edu.neumont.ccjudge.judging.JavaJudgeModule");
		java.setEnabled(true);
		java.setExtension(".java");
		java.setLanguage("Java");
		java.setType("judge");
		em.persist(java);
		list.add(java);
		
		Module csharp = new Module();
		csharp.setClassName("edu.neumont.ccjudge.judging.CSharpJudgingModule");
		csharp.setEnabled(true);
		csharp.setExtension(".cs");
		csharp.setLanguage("C#");
		csharp.setType("judge");
		em.persist(csharp);
		list.add(csharp);
		
		Module c = new Module();
		c.setClassName("edu.neumont.ccjudge.judging.CJudgingModule");
		c.setEnabled(true);
		c.setExtension(".c");
		c.setLanguage("C");
		c.setType("judge");
//		Property prop = new Property();
//		prop.setName(JudgingModule.ALLOWED_INCLUDES_PROPERTY);
//		prop.setValue("iostream,fstream,string,math,stdio,stdlib");
//		prop.setParent(c);
//		c.getProperties().put(prop.getName(), prop);
		em.persist(c);
		list.add(c);
		
		Module cpp = new Module();
		cpp.setClassName("edu.neumont.ccjudge.judging.CPPJudgingModule");
		cpp.setEnabled(true);
		cpp.setExtension(".cpp");
		cpp.setLanguage("C++");
		cpp.setType("judge");
//		prop = new Property();
//		prop.setName(JudgingModule.ALLOWED_INCLUDES_PROPERTY);
//		prop.setValue("iostream,fstream,string,math,stdio,stdlib");
//		prop.setParent(cpp);
//		cpp.getProperties().put(prop.getName(), prop);
		em.persist(cpp);
		list.add(cpp);

		Module defaultscore = new Module();
		defaultscore.setClassName("edu.neumont.ccjudge.scoring.DefaultScoringModule");
		defaultscore.setEnabled(true);
		defaultscore.setExtension("score");
		defaultscore.setLanguage("score");
		defaultscore.setType("score");
		em.persist(defaultscore);
		list.add(defaultscore);

		return list;
	}

	@Override
	public Submission judgeSubmission(Submission sub) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select m from Module m where m.type='judge' and m.enabled=true");
		List<Module> modules = (List<Module>) q.getResultList();

		if (modules.size() == 0)
			modules = createDefaultModules();

		ScoringModule scorer = null;

		try {
			q = em.createQuery("select m from Module m where m.type='score' and m.enabled=true");
			List<Module> smodules = (List<Module>)q.getResultList();
			if (smodules.size() > 0) {
				Module sm = smodules.get(0);
				scorer = (ScoringModule) Class.forName(sm.getClassName()).newInstance();
			}

			Module judger = null;
			if (sub.getFileName().startsWith(sub.getProblem().getShortName()+".")) {
				for (Module m : modules) {
					System.out.println(sub.getFileName()+".endwith("+m.getExtension()+")");
					if (sub.getFileName().endsWith(m.getExtension()))
						judger = m;
				}
			}
			if (judger != null) {
				JudgingModule judge = (JudgingModule) Class.forName(judger.getClassName()).newInstance();
				judge.setModule(judger);
				//JudgingModule judge = new JavaJudgeModule(judger.getClassName());
				judge.judgeSubmission(sub);

				sub.setJudgeTime(new Date());
				scorer.scoreSubmission(sub);

			} else {
				sub.setPassed(false);
				sub.setStatus(JudgingModule.ERROR_INVALID);
				sub.setJudgeTime(new Date());
				scorer.scoreSubmission(sub);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		em.merge(sub);

		return sub;
	}
	
	@Override
	public Map<Integer, Double> getTeamScores(int contestId, boolean limitDates) {
		EntityManager em = emf.createEntityManager();
		ScoringModule scorer = null;
		try {
			Query q = em.createQuery("select m from Module m where m.type='score' and m.enabled=true");
			List<Module> smodules = q.getResultList();
			if (smodules.size() == 0) {
				smodules = createDefaultModules();
				em.createQuery("select m from Module m where m.type='score' and m.enabled=true");
				smodules = q.getResultList();
			}
			if (smodules.size() > 0) {
				Module sm = smodules.get(0);
				scorer = (ScoringModule) Class.forName(sm.getClassName()).newInstance();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		scorer.setLimitDates(limitDates);
		Contest contest = em.find(Contest.class, contestId);
		HashMap<Integer, Double> teamScores = new HashMap<Integer, Double>();
		for(Team team : contest.getTeams()) {
			Double score = scorer.score(contest, team);
			teamScores.put(team.getId(), score);
		}
		return teamScores;
	}
	
	@Override
	public Map<Integer, Integer> getTeamPassCount(int contestId, boolean limitDates) {
		EntityManager em = emf.createEntityManager();
		
		Contest contest = em.find(Contest.class, contestId);
		HashMap<Integer, Integer> teamScores = new HashMap<Integer, Integer>();
		for(Team team : contest.getTeams()) {
			List<Submission> subs = team.getSubmissions();
			HashMap<Integer, Boolean> problemPass = new HashMap<Integer, Boolean>();
			int count = 0;
			for(Submission sub : subs) {
				if ((!limitDates || sub.getSubmissionTime().before(contest.getEndTime())) && sub.isPassed() && sub.getContest().equals(contest) 
						&& problemPass.get(sub.getProblem().getId())==null) {
					problemPass.put(sub.getProblem().getId(), true);
					count++;
				}
			}
			teamScores.put(team.getId(), count);
		}
		return teamScores;
	}
	
	public List<Submission> getRecentPasses(int contestId, Date date) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select s from Submission s where s.contest.id=?1 and s.passed=true and s.submissionTime>?2");
		q.setParameter(1, contestId);
		q.setParameter(2, date);
		return q.getResultList();
	}
}
