package edu.neumont.lms.authentication;

public class AuthenticationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthenticationException() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(Throwable cause) {
		super(cause);
	}

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
