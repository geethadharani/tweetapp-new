package com.tweetapp.service;

import java.text.ParseException;
import java.util.Scanner;

import com.tweetapp.App;
import com.tweetapp.DAO.ForgetPasswordDAO;
import com.tweetapp.DAO.LoginDAO;

public class ForgetPasswordService {
	
	ForgetPasswordDAO forget=new ForgetPasswordDAO();
	App app=new App();
	public void forgetPassword() {
		String username;
		String newPassword;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username:");
		username=scanner.next();
		System.out.println("Enter New password:");
		newPassword=scanner.next();
		boolean result=forget.resetPassword(username, newPassword);
		if(result){
			System.out.println("Reset Password Successfully");
			}
		else{
			System.out.println("Please Enter correct username");
			forgetPassword();
		}
		app.tweet();
		
		
	}

}
