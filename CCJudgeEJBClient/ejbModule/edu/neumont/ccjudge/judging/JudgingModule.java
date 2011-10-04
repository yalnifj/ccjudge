package edu.neumont.ccjudge.judging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.List;

import edu.neumont.ccjudge.model.Contest;
import edu.neumont.ccjudge.model.JudgeType;
import edu.neumont.ccjudge.model.Module;
import edu.neumont.ccjudge.model.Problem;
import edu.neumont.ccjudge.model.Submission;

public abstract class JudgingModule {

	public static final String WORK_DIRECTORY = System.getProperty("java.io.tmpdir");
	public static final String ERROR_COMPILE = "There was an error compiling your file.  The error was: ";
	public static final String ERROR_TIMEOUT = "Your program did not run in the allotted time limit.";
	public static final String ERROR_RUNTIME = "Your program did not complete. In other words your program crashed.  The output from your program was: ";
	public static final String ERROR_FORMAT = "Your program did not produce the correct output.";
	public static final String ERROR_OK = "Your program passed.";
	public static final String ERROR_INVALID = "You submitted an invalid file.";
	public static final String ERROR_INCLUDE = "You have attempted to include and invalid library or namespace: ";

	public static final boolean USE_SUDO = false;
	public static final boolean USE_CHOWN = false;

	public static final String ALLOWED_INCLUDES_PROPERTY = "allowedincludes";

	public abstract String getExtensionFilter();

	public abstract double judgeSubmission(Submission submission);

	protected boolean incontest = false;

	protected Module module;

	public void writeInputFile(File teamDirectory, Submission submission) throws IOException {
		Contest contest = submission.getContest();
		Problem problem = submission.getProblem();
		
		// -- delete any old output files
		File outfile = new File(teamDirectory, problem.getShortName()
				+ ".out");
		if (outfile.exists()) {
			outfile.delete();
		}
		
		// -- delete any old output files
		File infile = new File(teamDirectory, problem.getShortName()
				+ ".in");
		if (infile.exists()) {
			infile.delete();
		}

		if (contest.getJudgeType() == JudgeType.FILEIO) {
			// -- write the input file
			File inputFile = new File(teamDirectory, problem.getShortName() + ".in");
			FileWriter inwriter = new FileWriter(inputFile);
			inwriter.write(problem.getInput());
			inwriter.close();
		}
	}
	
	public int runAndJudge(List<String> commands, File teamDirectory, Submission submission) throws IOException, TimeoutException {
		Contest contest = submission.getContest();
		Problem problem = submission.getProblem();
		
		String input = null;
		boolean passed = false;
		if (contest.getJudgeType()==JudgeType.CONSOLEIO) input = problem.getInput();
		String[] results = this.runCommand(commands, teamDirectory, input);
		if (contest.getJudgeType()==JudgeType.FILEIO) {
			if (!results[0].isEmpty()||!results[1].isEmpty()) {
				submission.setStatus(ERROR_RUNTIME);
				submission.setResults(results[0]+results[1]);
				submission.setOutput(results[0]);
				submission.setPassed(false);
				return 20;
			}
			passed = this.compareOutput(teamDirectory, submission);
		}
		else {
			if (!results[1].isEmpty()) {
				submission.setStatus(ERROR_RUNTIME);
				submission.setResults(results[0]+results[1]);
				submission.setPassed(false);
				submission.setOutput(results[0]);
				return 20;
			}
			passed = this.compareOutput(results[0], submission);
		}
		
		if (passed) {
			submission.setStatus(ERROR_OK);
			submission.setPassed(true);
			return 0;
		}
		else {
			submission.setStatus(ERROR_FORMAT);
			submission.setPassed(false);
			return 20;
		}
	}

	public String[] runCommand(List<String> command, File directory, String input) throws IOException, TimeoutException {
		System.out.println("Running: " + command);
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.directory(directory);
		Process p = pb.start();

		if (input != null) {
			StringReader in = new StringReader(input);
			OutputStreamWriter out = new OutputStreamWriter(p.getOutputStream());
			
			int b = in.read();
			int count=0;
			while(b!=-1) {
				out.write(b);
				b = in.read();
				count++;
				if (count>1000) {
					count=0;
					out.flush();
				}
			}
			
			out.flush();
			out.close();
		}

		int waitcount = 0;
		boolean running = true;
		while (running) {
			try {
				System.out.println("Waiting for process "+waitcount);
				Thread.sleep(1000);
				waitcount++;
				if (waitcount > 30) {
					System.out.println("Killing process"+p);
					p.destroy();
					running = false;
					throw new TimeoutException();
				}
				if (p.exitValue() >= 0) running = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IllegalThreadStateException e) {
				//e.printStackTrace();
				//running = false;
				// -- catch the exception but don't do anything with it
			}
		}

		// read the output from the command
		String s;
		StringBuilder results = new StringBuilder();
		InputStream in = p.getInputStream();
		if (in.available() > 0) {
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(in));
			while ((s = stdInput.readLine()) != null) {
				results.append(s);
				results.append("\n");
				// if (!incontest) results += s;
				// else results += "[filtered output]";
			}
			stdInput.close();
		}

		// read any errors from the attempted command
		InputStream err = p.getErrorStream();
		StringBuilder error = new StringBuilder();
		if (err.available() > 0) {
			BufferedReader stdError = new BufferedReader(new InputStreamReader(err));
			while ((s = stdError.readLine()) != null) {
				error.append(s);
				error.append("\n");
				// if (!incontest) results += s;
				// else results += "[filtered output]";
			}
			stdError.close();
		}
		String[] ret = {results.toString(), error.toString()}; 
		return ret;
	}

	public boolean compareOutput(File teamDirectory, Submission submission) throws IOException {
		Problem problem = submission.getProblem();
		// -- read the output
		File outfile = new File(teamDirectory, problem.getShortName() + ".out");
		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(outfile));
		System.out.println("reading output file " + outfile.getAbsolutePath());
		String line = reader.readLine();
		boolean passed = true;
		while (line != null) {
			output.append(line);
			output.append("\n");
		}
		reader.close();
		passed = compareOutput(output.toString(), submission);
		submission.setOutput(output.toString());
		//System.out.println("output=" + output.toString() + "=" + problem.getOutput().trim());
		return passed;
	}

	public boolean compareOutput(String output, Submission submission) throws IOException {
		Problem problem = submission.getProblem();
		// -- read the output
		String[] expected = problem.getOutput().replaceAll("\\s+$", "").split("\r?\n");
		String[] lines = output.replaceAll("\\s+$", "").split("\r?\n");
		boolean passed = true;
		int l = 0;
		for(String line : lines) {
			// -- check output with desired output line by line
			if (l >= expected.length || expected[l] == null
					|| !expected[l].replaceAll("\\s+$", "").equals(line.replaceAll("\\s+$", ""))) {
				if (l < expected.length || !line.isEmpty()) {
					passed = false;
					break;
				}
			}
			l++;
		}
		if (l<expected.length && expected[l]!=null && !expected[l].isEmpty()) passed=false;
		output = output.trim();
		submission.setOutput(output);
		//System.out.println("output=" + output + "=" + problem.getOutput().trim());
		return passed;
	}
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
