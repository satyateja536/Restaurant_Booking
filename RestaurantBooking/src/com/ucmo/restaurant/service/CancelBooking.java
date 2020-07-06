package com.ucmo.restaurant.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucmo.restaurant.dao.BookingDAO;
import com.ucmo.restaurant.dto.BookingDTO;

/**
 * Servlet implementation class CancelBooking
 */
@WebServlet("/CancelBooking")
public class CancelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingDAO bookingDAO = new BookingDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBooking() {
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
			handleRequestForCancelBooking(request, response);
		} catch (SQLException e) {
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
	
	private void handleRequestForCancelBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String result;
		String bookingID = request.getParameter("bookingID");
		String restaurantName = request.getParameter("restaurantName");
		String userID = request.getParameter("userID");
		String username = request.getParameter("username");
		String status = bookingDAO.deleteBooking(Integer.parseInt(bookingID));
		
		if(status == "success") {
			
			result = "Booking for the restaurant: "+restaurantName+" with booking id: "+bookingID+" has been cancelled";
		}
		else {
			result = "Cancellation of Booking with id: "+bookingID+" is unsuccessful";
			}
		List<BookingDTO> bookings = bookingDAO.getUserBookings(Integer.parseInt(userID));
		request.setAttribute("bookings", bookings);
		request.setAttribute("userID", userID);
		request.setAttribute("username", username);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view-bookings.jsp");
		dispatcher.forward(request, response);		
		
		
	}

}
