package com.ucmo.restaurant.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucmo.restaurant.dao.BookingDAO;
import com.ucmo.restaurant.dao.RestaurantDAO;
import com.ucmo.restaurant.dto.BookingDTO;
import com.ucmo.restaurant.dto.RestaurantDTO;

/**
 * Servlet implementation class ShowBookingsPage
 */
@WebServlet("/ShowBookingsPage")
public class ShowBookingsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookingDAO bookingDAO = new BookingDAO();
	RestaurantDAO restaurantDAO = new RestaurantDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookingsPage() {
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
			handleRequestForShowBookingsPage(request, response);
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
	
	private void handleRequestForShowBookingsPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String userID = request.getParameter("userID");
		List<BookingDTO> bookings = bookingDAO.getUserBookings(Integer.parseInt(userID));
		
		request.setAttribute("userID", userID);
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("bookings", bookings);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view-bookings.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
