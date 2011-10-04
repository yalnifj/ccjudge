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

public class JavaJudgeModule extends JudgingModule {

	public String getExtensionFilter() {
		return ".java";
	}

	public double judgeSubmission(Submission submission) {
		try {
			Problem problem = submission.getProblem();
			Team team = submission.getTeam();
			Contest contest = submission.getContest();
			Date now = new Date();
			//-- filter the output during the contest
			if (now.after(contest.getStartTime()) && now.before(contest.getEndTime())) this.incontest = true;
			
			File teamDirectory = new File(WORK_DIRECTORY + "/ccjudge");
			if (!teamDirectory.exists()) {
				teamDirectory.mkdir();
				System.out.println("creating directory "+teamDirectory.getAbsolutePath());
			}
			teamDirectory = new File(WORK_DIRECTORY + "/ccjudge/team" + team.getId());
			if (!teamDirectory.exists()) {
				teamDirectory.mkdir();
				System.out.println("creating directory "+teamDirectory.getAbsolutePath());
			}
			this.writeInputFile(teamDirectory, submission);

			//-- write the policy file
			File policyFile = new File(teamDirectory, "policy.txt");
			if (!policyFile.exists()) {
				FileWriter pwriter = new FileWriter(policyFile);
				pwriter.write("grant {\n" +
							"\tpermission java.io.FilePermission \"./*.in\", \"read\";\n" +
							"\tpermission java.io.FilePermission \"./*\", \"write\";\n" +
							"};\n");
				pwriter.close();
			}
			
			if (submission.getFileContents().trim().startsWith("package")) {
				submission.setStatus(ERROR_COMPILE);
				submission.setResults("You may not use packages in the coding contest.");
				submission.setPassed(false);
				return 20;
			}
			else {
				
			//-- write the java file
			File javafile = new File(teamDirectory, problem.getShortName() + ".java");
			FileWriter outwriter = new FileWriter(javafile);
			outwriter.write(submission.getFileContents());
			outwriter.close();

			submission.setJudgeTime(new Date());

			//-- compile the java file
			ArrayList<String> commands = new ArrayList<String>();
			commands.add("javac");
			commands.add(javafile.getAbsolutePath());
			String[] results = this.runCommand(commands, teamDirectory, null);
			if (!results[0].isEmpty()) {
				submission.setStatus(ERROR_COMPILE);
				submission.setResults(results[0]+results[1]);
				submission.setPassed(false);
				return 20;
			}
			
			//-- change ownership of files to nobody for security
			commands = new ArrayList<String>();
			if (USE_CHOWN) {
				commands.add("chown");
				commands.add("nobody");
				commands.add("*");
				results = this.runCommand(commands, teamDirectory, null);
			}
			
			//-- run the java command
			String filepath = javafile.getAbsolutePath();
			String classfile = filepath.substring(filepath.lastIndexOf("/")+1,filepath.lastIndexOf("."));
			commands = new ArrayList<String>();
			if (USE_SUDO) {
				commands.add("sudo");
				commands.add("-u");
				commands.add("nobody");
			}
			commands.add("java");
			commands.add("-Djava.security.manager");
			commands.add("-Djava.security.policy==policy.txt");
			commands.add(classfile);
			
			return this.runAndJudge(commands, teamDirectory, submission);
			}

		} catch (IOException e) {
			e.printStackTrace();
			submission.setResults("An internal error occurred while attempting to judge the submission.\n"+e.getMessage());
			return 0;
		} catch (TimeoutException e) {
			submission.setStatus(ERROR_TIMEOUT);
			submission.setPassed(false);
		}
		return 20;
	}

}
