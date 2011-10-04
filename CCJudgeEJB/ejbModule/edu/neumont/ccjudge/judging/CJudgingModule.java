package edu.neumont.ccjudge.judging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Property;
import edu.neumont.ccjudge.model.Submission;
import edu.neumont.ccjudge.model.Team;

public class CJudgingModule extends JudgingModule {

	public String getExtensionFilter() {
		return ".c";
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

			String results = "";
			// -- check for valid includes
			String code = submission.getFileContents();
			/*
			Property allowed = this.module.getProperty(JudgingModule.ALLOWED_INCLUDES_PROPERTY);
			if (allowed != null) {
				String[] includes = allowed.getValue().split("[, ]");
				Pattern p = Pattern.compile("#include\\s*[\"<]([\\w\\._]+)[\">]");
				Matcher m = p.matcher(code);
				while (m.find()) {
					String include = m.group(1);
					boolean found = false;
					for (String i : includes) {
						if (i.equals(include)) {
							found = true;
							break;
						}
					}
					if (!found) {
						results += ERROR_INCLUDE + " " + include;
					}
				}
			}
*/
			if (!results.isEmpty()) {
				submission.setStatus(ERROR_COMPILE);
				submission.setResults(results);
				submission.setPassed(false);
				return 20;
			}

			// -- write the .c file
			File javafile = new File(teamDirectory, problem.getShortName() + ".c");
			FileWriter outwriter = new FileWriter(javafile);
			outwriter.write(submission.getFileContents());
			outwriter.close();

			// -- compile the java file
			ArrayList<String> commands = new ArrayList<String>();
			commands.add("gcc");
			commands.add("-o");
			commands.add(problem.getShortName());
			commands.add(javafile.getAbsolutePath());
			String[] result = this.runCommand(commands, teamDirectory, null);
			if (!result[0].isEmpty() || !result[1].isEmpty()) {
				submission.setStatus(ERROR_COMPILE);
				submission.setResults(result[0]+result[1]);
				submission.setPassed(false);
				return 20;
			}

			// -- change ownership of files to nobody for security
			if (USE_CHOWN) {
				commands = new ArrayList<String>();
				commands.add("chown");
				commands.add("nobody");
				commands.add("*");
				result = this.runCommand(commands, teamDirectory, null);
			}
			// -- run the c command
			commands = new ArrayList<String>();
			if (USE_SUDO) {
				commands.add("sudo");
				commands.add("-u");
				commands.add("nobody");
			}
			commands.add("./" + problem.getShortName());
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
