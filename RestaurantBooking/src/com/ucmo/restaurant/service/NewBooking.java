package com.ucmo.restaurant.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucmo.restaurant.dao.BookingDAO;
import com.ucmo.restaurant.dao.UserDAO;
import com.ucmo.restaurant.dto.BookingDTO;
import com.ucmo.restaurant.dto.UserDTO;

/**
 * Servlet implementation class NewBooking
 */
@WebServlet("/NewBooking")
public class NewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDAO bookingDAO = new BookingDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			handleRequestForNewBooking(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void handleRequestForNewBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
		
		System.out.println("Userid: "+request.getParameter("userID")+" Rest ID: "+request.getParameter("restaurantID")+" NoPers: "+request.getParameter("numberOfPersons"));
		String userID = request.getParameter("userID");
		String restaurantID = request.getParameter("restaurantID");
		String noOfPersons = request.getParameter("numberOfPersons");
		int id = Integer.parseInt(userID);
		System.out.println("ID: "+id);
		
		BookingDTO booking = new BookingDTO();
		booking.setUserID(Integer.parseInt(userID));
		booking.setRestaurantID(Integer.parseInt(restaurantID));		
		booking.setNumberOfPersons(Integer.parseInt(noOfPersons));
		booking.setBookingType(request.getParameter("bookingType"));
		booking.setRestaurantName(request.getParameter("restaurantName"));
		
		String bookingDate =  request.getParameter("bookingDate");
				
		booking.setBookingDate(bookingDate);
		String status = bookingDAO.insertBooking(booking);
		RequestDispatcher dispatcher;
		request.setAttribute("userID", userID);
		request.setAttribute("username", request.getParameter("username"));
		
		if(status == "success") {
			request.setAttribute("result", "User Booking Successful for the Restaurant: "+ request.getParameter("restaurantName") );			
		}
		else {
			request.setAttribute("result", "User Booking Failed for the restaurant "+request.getParameter("restaurantName")+", Please try Again!");			
		}
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-home.jsp"); 
		dispatcher.forward(request, response);
	}
}
