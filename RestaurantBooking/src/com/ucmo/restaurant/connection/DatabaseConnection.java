package com.ucmo.restaurant.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	Connection connection;
	
	public Connection getDBConnection() {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","admin");		
			}catch(Exception e){ 
				System.out.println(e);
			 }		
		return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
