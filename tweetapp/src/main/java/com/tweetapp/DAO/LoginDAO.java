package com.tweetapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tweetapp.entity.Registartion;
import com.tweetapp.service.DatabaseConnectionService;

public class LoginDAO {
	DatabaseConnectionService database=new DatabaseConnectionService();
	public void saveTweet(String username,String tweet){
		
		Connection con=database.getConnection();
		PreparedStatement stmt;
		boolean result = false;
		try {
			
			stmt = con.prepareStatement("select * from user where email = ?");
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery(); 
			
			rs.absolute(1);
			String name=rs.getString(1);
			
	           stmt = con.prepareStatement("insert into tweetmessage values(?, ?,?)");
				stmt.setString(1, name);
	            stmt.setString(2, tweet);
	            stmt.setString(3, username);
	            stmt.execute();
			
				
				
			
				con.close(); 
		} catch (SQLException e) {
			System.out.println("Exception occurred due to"+e);
		} 
		
	}
public void getMyTweet(String username){
		
		Connection con=database.getConnection();
		PreparedStatement stmt;
		ResultSet rs = null;
		try {
			
			stmt = con.prepareStatement("select * from tweetmessage where email = ?");
			stmt.setString(1, username);
			 rs=stmt.executeQuery(); 
			 if(rs.next()){
			 while(rs.next()){
					System.out.println(rs.getString(2));
				}
			 }
			 else{
				 System.out.println("No tweet was posted");
			 }
			con.close(); 
		} catch (SQLException e) {
			System.out.println("Exception occurred due to"+e);
		} 
		
	}
public boolean resetPassword(String username,String oldPassword,String newPassword){
	
	Connection con=database.getConnection();
	PreparedStatement stmt;
	ResultSet rs = null;
	boolean result=false;
	try {
		
		stmt = con.prepareStatement("select * from user where email = ? and password=?");
		stmt.setString(1, username);
		stmt.setString(2, oldPassword);
		 rs=stmt.executeQuery(); 
		 if(rs.next()){
			 
			 stmt = con.prepareStatement("update user set password=? where email=?");
				stmt.setString(1, newPassword);
				stmt.setString(2, username);
				 stmt.executeUpdate(); 
				 result=true;
		 }
		
		con.close(); 
	} catch (SQLException e) {
		System.out.println("Exception occurred due to"+e);
	} 
	return result;
	
}
public void updateLogoutStatus(String username){
	Connection con=database.getConnection();
	PreparedStatement stmt;
	ResultSet rs = null;
	boolean result=false;
	try {
		stmt = con.prepareStatement("update userlogindetails set loginstatus=? where email=? and loginstatus=?");
				stmt.setString(1, "No");
				stmt.setString(2, username);
				stmt.setString(3, "Yes");
				 stmt.executeUpdate(); 
		
		
		con.close(); 
	} catch (SQLException e) {
		System.out.println("Exception occurred due to"+e);
	} 
}
public void getAllTweet(){
	
	Connection con=database.getConnection();
	PreparedStatement stmt;
	ResultSet rs = null;
	try {
		
		stmt = con.prepareStatement("select * from tweetmessage");
		rs=stmt.executeQuery(); 
		while(rs.next()){
			System.out.println(rs.getString(1)+":"+rs.getString(2));
		}
		con.close(); 
	} catch (SQLException e) {
		System.out.println("Exception occurred due to"+e);
	} 
	
}
public void getAllUser(){
	
	Connection con=database.getConnection();
	PreparedStatement stmt;
	ResultSet rs = null;
	try {
		
		stmt = con.prepareStatement("select * from user");
		rs=stmt.executeQuery(); 
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		con.close(); 
	} catch (SQLException e) {
		System.out.println("Exception occurred due to"+e);
	} 
	
}
	public boolean getUser(String username,String password){
	Connection con=database.getConnection();
	PreparedStatement stmt;
	boolean result = false;
	try {
		
		stmt = con.prepareStatement("select * from user where email = ? and password=?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs=stmt.executeQuery(); 
		
		if(rs.next()){
           stmt = con.prepareStatement("insert into userlogindetails values(?, ?)");
			stmt.setString(1, username);
            stmt.setString(2, "Yes");
            stmt.execute();
		
			result=true;
			}
		
			con.close(); 
	} catch (SQLException e) {
		System.out.println("Exception occurred due to"+e);
	} 
	return result;
	}

}
