package com.tweetapp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tweetapp.entity.Registartion;
import com.tweetapp.service.DatabaseConnectionService;
import com.tweetapp.service.RegistrationService;

public class RegistartionDAO {
	DatabaseConnectionService database=new DatabaseConnectionService();
	public String saveUser(Registartion registration){
	Connection con=database.getConnection();
	PreparedStatement stmt;
	String message = null;
	try {
		
		stmt = con.prepareStatement("select * from user where email = ?");
		stmt.setString(1, registration.email);
		ResultSet rs=stmt.executeQuery(); 
		
		if(rs.next()){
			message="User Already Exist";
			
		}
		else{
			stmt = con.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?)");
			
			stmt.setString(1, registration.first_name);
            stmt.setString(2, registration.last_name);
            stmt.setString(3, registration.gender);
            stmt.setDate(4,  new java.sql.Date(registration.dob.getTime()));
            stmt.setString(5, registration.email);
            stmt.setString(6, registration.password);
			stmt.execute(); 
			message= "Registered successfully";
		}
			con.close(); 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return message;
	 
	
	
}}
