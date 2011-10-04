package edu.neumont.lms.authentication;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import edu.neumont.lms.NeumontWS;
import edu.neumont.lms.NeumontWSService;
import edu.neumont.lms.NeumontWSServiceLocator;
import edu.neumont.lms.User;

/**
 * Main class that provides authentication support through the Moodle SOAP Web Service
 * The class represents a single user's interaction with the webservice
 * @author jfinlay
 *
 */
public class MoodleAuthentication {
	private NeumontWSService ws;
	private NeumontWS port;
	private User user; 

	public MoodleAuthentication() throws AuthenticationException {
		ws = new NeumontWSServiceLocator();
		try {
			port = ws.getNeumontWS();
		} catch (ServiceException e) {
			throw new AuthenticationException(e);
		}
	}
	
	/**
	 * Authenticate through moodle using the given username and password
	 * This method must be called first before any other method
	 * @param username
	 * @param password
	 * @return	the session key for communicating with the moodle web service
	 * @throws AuthenticationException
	 */
	public String authenticate(String username, String password) throws AuthenticationException {
		try {
			user = port.login(username, password);
			return user.getSesskey();
		} catch (Exception e) {
			throw new AuthenticationException(e);
		}
	}
	
	
	/**
	 * get the user record for the currently authenticated moodle user
	 * @return
	 * @throws AuthenticationException	thrown if the user is not authenticated
	 */
	public User getMoodleUser() throws AuthenticationException {
		if (user!=null) return user;
		else throw new AuthenticationException("You must authenticate first.");
	}
	
	/**
	 * gets an array of moodle user records for the given array of usernames
	 * @param usernames
	 * @return
	 * @throws AuthenticationException	thrown if the user is not authenticated
	 */
	public User[] getMoodleUsers(String[] usernames) throws AuthenticationException {
		if (user==null) throw new AuthenticationException("You must authenticate first.");
		try {
			User[] users = port.getUsersByUsername(user.getSesskey(), usernames);
			return users;
		} catch (RemoteException e) {
			throw new AuthenticationException(e);
		}
	}
}
