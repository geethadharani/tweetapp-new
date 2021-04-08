package com.tweetapp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.tweetapp.App;
import com.tweetapp.DAO.LoginDAO;

public class LoginService {
	String username;
	String password;
	LoginDAO loginDAO=new LoginDAO();
	App app=new App();
	public void getUser() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter username:");
		username=scanner.next();
		System.out.println("Enter password:");
		password=scanner.next();
		boolean result=loginDAO.getUser(username, password);
		if(result){
			System.out.println("LoggedIn successfully");
			loginChoice(username);
		}
		else{
			System.out.println("Invalid username and password");
			app.tweet();
		}
	}
	public void postTweet(String username) {
		String tweet;
		System.out.println("Enter Tweet");
		Scanner scanner=new Scanner(System.in);
		tweet=scanner.next();
		loginDAO.saveTweet(username, tweet);
		System.out.println("Tweet posted successfully");
		loginChoice(username);
		
	}
public void viewMyTweet(String username)  {
	System.out.println("Tweet posted:");
	loginDAO.getMyTweet(username);
	loginChoice(username);
	}
public void viewAllTweet(String username) {
	System.out.println("All Tweet posted:");
	loginDAO.getAllTweet();
	loginChoice(username);
}
public void viewAllUser(String username){
	System.out.println("Users:");
	loginDAO.getAllUser();
	loginChoice(username);
	
}
public void resetPassword(String username){
	String oldPassword;
	String newPassword;
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter old password:");
	oldPassword=scanner.next();
	System.out.println("Enter New password:");
	newPassword=scanner.next();
	boolean result=loginDAO.resetPassword(username, oldPassword, newPassword);
	if(result){
		System.out.println("Reset Password Successfully");
		}
	else{
		System.out.println("Please Enter correct old password");
		resetPassword(username);
	}
	loginChoice(username);
	
	
}
public void logout(String username){
	loginDAO.updateLogoutStatus(username);
	System.out.println("Logout successfully");
	app.tweet();
	
}
	public void loginChoice(String username) {
		int choice;
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.Post Tweet");
		System.out.println("2.View My Tweet");
		System.out.println("3.View All User Tweets");
		System.out.println("4.View All User");
		System.out.println("5.Reset Password");
		System.out.println("6.Logout");
		System.out.println("Enter your choice:");
		choice=scanner.nextInt();
		switch(choice){
		
		case 1:
			postTweet(username);
			break;
		case 2:
			viewMyTweet(username);
			break;
		case 3:
			viewAllTweet(username);
			break;
		case 4:
			viewAllUser(username);
			break;
		case 5:
			resetPassword(username);
			break;
		case 6:
			logout(username);
			break;
			default:
				System.out.println("Invalid Choice");
				loginChoice(username);
				break;
		}
		
		
	}

}
