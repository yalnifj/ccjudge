package edu.neumont.ccjudge.judging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;

public class CSharpJudgingModule extends JudgingModule {

	public String getExtensionFilter() {
		return ".cs";
	}

	public double judgeSubmission(Submission submission) {
		try {
			Problem problem = submission.getProblem();
			Team team = submission.getTeam();
			Contest contest = submission.getContest();
			Date now = new Date();
			if (now.after(contest.getStartTime()) && now.before(contest.getEndTime())) this.incontest = true;

			File teamDirectory = new File(WORK_DIRECTORY + "/ccjudge");
			if (!teamDirectory.exists()) {
				teamDirectory.mkdir();
				System.out.println("creating directory " + teamDirectory.getAbsolutePath());
			}
			teamDirectory = new File(WORK_DIRECTORY + "/ccjudge/team" + team.getId());
			if (!teamDirectory.exists()) {
				teamDirectory.mkdir();
				System.out.println("creating directory " + teamDirectory.getAbsolutePath());
			}
			this.writeInputFile(teamDirectory, submission);

			submission.setJudgeTime(new Date());

			// -- write the cs file
			File javafile = new File(teamDirectory, problem.getShortName() + ".cs");
			FileWriter outwriter = new FileWriter(javafile);
			outwriter.write(submission.getFileContents());
			outwriter.close();
			
			File exeFile = new File(teamDirectory, problem.getShortName() + ".exe");
			if (exeFile.exists()) exeFile.delete();

			// -- compile the cs file
			ArrayList<String> commands = new ArrayList<String>();
			commands.add("gmcs");
			commands.add("-warn:0");
			commands.add(javafile.getAbsolutePath());
			String[] results = this.runCommand(commands, teamDirectory, null);
			if (!results[0].isEmpty() || !results[1].isEmpty()) {
				submission.setStatus(ERROR_COMPILE);
				submission.setResults(results[0]+results[1]);
				// -- check if the exe exists to ignore compiler warnings
				exeFile = new File(teamDirectory, problem.getShortName() + ".exe");
				if (!exeFile.exists()) {
					submission.setPassed(false);
					return 20;
				}
			}

			// -- change ownership of files to nobody for security
			if (USE_CHOWN) {
				commands = new ArrayList<String>();
				commands.add("chown");
				commands.add("nobody");
				commands.add("*");
				results = this.runCommand(commands, teamDirectory, null);
			}
			// -- run the mono command
			String classfile = problem.getShortName();
			commands = new ArrayList<String>();
			if (USE_SUDO) {
				commands.add("sudo");
				commands.add("-u");
				commands.add("nobody");
			}
			commands.add("mono");
			commands.add(classfile + ".exe");
			return this.runAndJudge(commands, teamDirectory, submission);
		} catch (IOException e) {
			e.printStackTrace();
			submission.setResults("An internal error occurred while attempting to judge the submission.\n"
					+ e.getMessage());
			return 0;
		} catch (TimeoutException e) {
			submission.setStatus(ERROR_TIMEOUT);
			submission.setPassed(false);
		}
		return 20;
	}

}
