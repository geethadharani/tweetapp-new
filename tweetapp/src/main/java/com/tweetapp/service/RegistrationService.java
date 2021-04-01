package com.tweetapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.tweetapp.App;
import com.tweetapp.DAO.RegistartionDAO;
import com.tweetapp.entity.Registartion;

public class RegistrationService {
	
	public void getUserDetails() throws ParseException{
		Scanner scanner=new Scanner(System.in);
		Registartion registration=new Registartion();
		System.out.println("Enter FirstName*:");
		registration.first_name=scanner.next();
		System.out.println("Enter LastName:");
		registration.last_name=scanner.next();
		System.out.println("Enter Gender*:");
		registration.gender=scanner.next();
		System.out.println("Enter DOB(dd-MM-yyyy):");
		String date = scanner.next();
		registration.dob=new SimpleDateFormat("dd-MM-yyyy").parse(date);
		System.out.println("Enter Email-Id*");
		registration.email=scanner.next();
		System.out.println("Enter password*");
		registration.password=scanner.next();
		saveUser(registration);
	}
	
	public void saveUser(Registartion registration) throws ParseException{
		if(registration.first_name!=""&& registration.gender!=""&&registration.email!=""&&registration.password!=""){
			RegistartionDAO registrationDAO=new RegistartionDAO();
			String message=registrationDAO.saveUser(registration);
			System.out.println(message);
			App app=new App();
			app.tweet();
		}
		else{
			System.out.println("Enter All the required fields");
			getUserDetails();
		}
		
	}

}
