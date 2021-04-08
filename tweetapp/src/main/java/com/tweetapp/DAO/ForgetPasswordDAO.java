package com.tweetapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tweetapp.service.DatabaseConnectionService;

public class ForgetPasswordDAO {
	DatabaseConnectionService database=new DatabaseConnectionService();
	public boolean resetPassword(String username,String newPassword){
		
		Connection con=database.getConnection();
		PreparedStatement stmt;
		ResultSet rs = null;
		boolean result=false;
		try {
			
			stmt = con.prepareStatement("select * from user where email = ?");
			stmt.setString(1, username);
			
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

}
