package com.ucmo.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ucmo.restaurant.connection.DatabaseConnection;
import com.ucmo.restaurant.dto.UserDTO;

public class UserDAO {
	
	Connection connection;
	//DatabaseConnection dbConnection = new DatabaseConnection();
	
	public Connection getDBConnection() {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");		
			}catch(Exception e){ 
				System.out.println(e);
			 }		
		return connection;
	}
	
	public List<UserDTO> getUsers() throws SQLException {
		List<UserDTO> users = new ArrayList<UserDTO>();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from users");  
		while(rs.next()) {
			UserDTO user = new UserDTO();
			user.setUserID(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setFirstName(rs.getString(3));
			user.setLastName(rs.getString(4));
			user.setAge(rs.getInt(5));
			user.setMobileNumber(rs.getString(6));
			user.setAddress(rs.getString(7));
			user.setCity(rs.getString(8));
			users.add(user);
		}
		connection.close();
		return users;
	}
	
	public UserDTO getUser(String userName) throws SQLException {
		UserDTO user = new UserDTO();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from users where username = '"+userName+"'");
		while(rs.next()){
			user.setUserID(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setFirstName(rs.getString(3));
			user.setLastName(rs.getString(4));
			user.setAge(rs.getInt(5));
			user.setMobileNumber(rs.getString(6));
			user.setAddress(rs.getString(7));
			user.setCity(rs.getString(8));
			user.setPassword(rs.getString(9));
		}
		return user;
	}
	
	public String insertUser(UserDTO user) throws SQLException {
		String status = "";
		UserDTO userDB = getUser(user.getUserName());		
		if(userDB.getUserName()==null) {
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "INSERT INTO USERS (UserName,FirstName,LastName,Age,MobileNumber,Address,City,Password) VALUES(\'"+user.getUserName()+"\',\'"+user.getFirstName()+"\',\'"+user.getLastName()+"\',"+user.getAge()+",\'"+user.getMobileNumber()+"\',\'"+user.getAddress()+"\',\'"+user.getCity()+"\',\'"+user.getPassword()+"\')";
		stmt.executeUpdate(sql);
		status = "success";
		}
		else {
			status = "fail";
		}
		return status;
	}
	
	public void deleteUser() {
		
	}
	
	public String updateUser(UserDTO user) throws SQLException {
		String status;
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "UPDATE USERS SET FirstName=\'"+user.getFirstName()+"\', LastName=\'"+user.getLastName()+"\', Age=\'"+user.getAge()+"\', MobileNumber=\'"+user.getMobileNumber()+"\', Address=\'"+user.getAddress()+"\', City=\'"+user.getCity()+"\' where UserName=\'"+user.getUserName()+"\'";
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	

}
