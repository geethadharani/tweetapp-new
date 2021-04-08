package com.tweetapp;

import java.text.ParseException;
import java.util.Scanner;

import com.tweetapp.DAO.RegistartionDAO;
import com.tweetapp.entity.TweetMessage;
import com.tweetapp.service.ForgetPasswordService;
import com.tweetapp.service.LoginService;
import com.tweetapp.service.RegistrationService;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void tweet() {
		int choice;
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("TweetApp");
    	System.out.println("1.Registration");
    	System.out.println("2.Login");
    	System.out.println("3.Forget Password");
    	System.out.println("Enter your choice:");
    	choice=scanner.nextInt();
    	switch(choice){
    	case 1:
    		RegistrationService registration=new RegistrationService();
    		registration.getUserDetails();
    		break;
    	case 2:
    		LoginService login=new LoginService();
    		login.getUser();
    		break;
    	case 3:
    		ForgetPasswordService forgetPassword=new ForgetPasswordService();
    		forgetPassword.forgetPassword();
    		break;
    	default:
    		System.out.println("Invalid Choice");
    		tweet();
    		break;
    	}
    	
       

	}
    public static void main( String[] args ) throws ParseException
    {
    	tweet();
    	    }
}
