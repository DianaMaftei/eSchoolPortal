package service;

import java.util.Scanner;

import entities.User;

public class Login {
	Scanner userInput = new Scanner(System.in);
	String name;
	String password;
	static User currentUser;

	private void displayLoginMenu() {
		System.out.println("Welcome! Type your userID and password to login.");
		name = userInput.next();
		password = userInput.next();
	}

	public void doLogin() {
		displayLoginMenu();
		for (User user : ePortalMain.currentDatabase.getUseri()) {
			if (name.equalsIgnoreCase(user.getUserID())) {
				if (password.equalsIgnoreCase(user.getPassword())) {
					System.out.println("You've successfully logged in!");
					currentUser = user;
					return;
				}
				System.out.println("Invalid password. Please retry!");
				return;
			}
		}
		System.out.println("The userID is invalid.");
	}

}
