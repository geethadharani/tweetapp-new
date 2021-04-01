package com.tweetapp.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionService {
	
public Connection getConnection(){
	Connection con = null;
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tweetapp","root","root"); 
	}
	catch(Exception e){ 
		System.out.println(e);
		}
return con;
}

}
