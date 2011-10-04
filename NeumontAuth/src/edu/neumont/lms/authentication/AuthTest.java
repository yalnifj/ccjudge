package edu.neumont.lms.authentication;

import java.util.Scanner;

import edu.neumont.lms.User;


public class AuthTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.print("Username: ");
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			System.out.println("Password: ");
			String password = in.nextLine();
			MoodleAuthentication mauth = new MoodleAuthentication();
			String sessionkey = mauth.authenticate(username, password);
			System.out.println("Session key: ");
			System.out.println(sessionkey);
			User u = mauth.getMoodleUser();
			System.out.println(u.getEmail());
			String[] usernames = {"jfinlay", "apace", "areed", "jwalkenhorst", "alogan"};
			User[] users = mauth.getMoodleUsers(usernames);
			for(User user : users) {
				System.out.println(user.getEmail());
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}

	}

}
