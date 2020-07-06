

package com.ucmo.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ucmo.restaurant.dto.BookingDTO;
import com.ucmo.restaurant.dto.UserDTO;

public class BookingDAO {
	
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
	
	public List<BookingDTO> getUserBookings(int userID) throws SQLException {
		List<BookingDTO> userBookings = new ArrayList<BookingDTO>();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bookings where UserID="+userID);  
		while(rs.next()) {
			BookingDTO booking = new BookingDTO();
			booking.setBookingID(rs.getInt(1));
			booking.setUserID(rs.getInt(2));
			booking.setRestaurantID(rs.getInt(3));
			booking.setNumberOfPersons(rs.getInt(4));
			booking.setBookingDate(rs.getDate(5).toString());
			booking.setBookingType(rs.getString(6));
			booking.setRestaurantName(rs.getString(7));
			
			userBookings.add(booking);
		}
		connection.close();
		return userBookings;
	}
	
	public BookingDTO getBookingById(int id) throws SQLException {
		BookingDTO booking = new BookingDTO();
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bookings where BookingID="+id);  
		while(rs.next()) {			
			booking.setBookingID(rs.getInt(1));
			booking.setUserID(rs.getInt(2));
			booking.setRestaurantID(rs.getInt(3));
			booking.setNumberOfPersons(rs.getInt(4));
			booking.setBookingDate(rs.getDate(5).toString());
			booking.setBookingType(rs.getString(6));
			booking.setRestaurantName(rs.getString(7));
		}
		connection.close();
		return booking;
	}
	
	public String insertBooking(BookingDTO booking) throws SQLException {
		
		
		String status = "";		
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "INSERT INTO BOOKINGS (UserID,RestaurantID,NumberOfPersons,BookingDate,BookingType,RestaurantName) VALUES("+booking.getUserID()+","+booking.getRestaurantID()+","+booking.getNumberOfPersons()+",\'"+booking.getBookingDate()+"\',\'"+booking.getBookingType()+"\',\'"+booking.getRestaurantName()+"\')";
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	
	
	public String updateBooking(BookingDTO booking) throws SQLException {
		String status;
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "UPDATE BOOKINGS SET NumberOfPersons="+booking.getNumberOfPersons()+", BookingDate="+booking.getBookingDate()+", BookingType=\'"+booking.getBookingType()+"\'";
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	
	public String deleteBooking(int bookingID) throws SQLException {
		String status;
		connection = getDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "DELETE FROM BOOKINGS where BookingID="+bookingID;
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
