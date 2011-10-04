package edu.neumont.ccjudge.judging;

public class TimeoutException extends Exception {

	private static final long serialVersionUID = 5973582962477634964L;

	public TimeoutException() {
		super();
	}

	public TimeoutException(String arg0) {
		super(arg0);
	}

	public TimeoutException(Throwable arg0) {
		super(arg0);
	}

	public TimeoutException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
