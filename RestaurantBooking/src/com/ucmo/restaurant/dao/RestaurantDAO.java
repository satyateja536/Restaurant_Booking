package com.ucmo.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ucmo.restaurant.dto.RestaurantDTO;

public class RestaurantDAO {
	
	Connection connection;	
	
	public Connection getDBConnection() {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");		
			}catch(Exception e){ 
				System.out.println(e);
			 }		
		return connection;
	}
	
	public List<RestaurantDTO> getRestaurants() throws SQLException{
		List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from restaurants");  
		while(rs.next()) {
			RestaurantDTO restaurant = new RestaurantDTO();
			restaurant.setRestaurantID(rs.getInt(1));
			restaurant.setRestaurantName(rs.getString(2));
			restaurant.setCity(rs.getString(3));
			restaurant.setAddress(rs.getString(4));
			restaurant.setCostPerTwo(rs.getInt(5));
			restaurant.setRating(rs.getFloat(6));
			restaurants.add(restaurant);
		}
				
		return restaurants;
	}
	
	public List<RestaurantDTO> getRestaurantsByCity(String city) throws SQLException{
		List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from restaurants where City=\'"+city+"\'");  
		while(rs.next()) {
			RestaurantDTO restaurant = new RestaurantDTO();
			restaurant.setRestaurantID(rs.getInt(1));
			restaurant.setRestaurantName(rs.getString(2));
			restaurant.setCity(rs.getString(3));
			restaurant.setAddress(rs.getString(4));
			restaurant.setCostPerTwo(rs.getInt(5));
			restaurant.setRating(rs.getFloat(6));
			restaurants.add(restaurant);
		}
				
		return restaurants;
	}
	
	public RestaurantDTO getRestaurant(int id) throws SQLException {
		
		RestaurantDTO restaurant = new RestaurantDTO();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from restaurants where RestaurantID="+id);  
		while(rs.next()) {			
			restaurant.setRestaurantID(rs.getInt(1));
			restaurant.setRestaurantName(rs.getString(2));
			restaurant.setCity(rs.getString(3));
			restaurant.setAddress(rs.getString(4));
			restaurant.setCostPerTwo(rs.getInt(5));
			restaurant.setRating(rs.getFloat(6));			
		}
				
		return restaurant;
	 	
	}
	
	public List<String> getCities() throws SQLException{
		
		List<String> cities = new ArrayList<String>();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select distinct city from restaurants");  
		while(rs.next()) {
			cities.add(rs.getString(1));
		}
		return cities;
	}

}
