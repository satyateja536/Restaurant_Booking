package com.ucmo.restaurant.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewBooking
 */
@WebServlet("/NewBookingPage")
public class NewBookingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBookingPage() {
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
			handleRequestForNewBookingPage(request, response);
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
	
	
	private void handleRequestForNewBookingPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		request.setAttribute("userID", request.getParameter("userID"));
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("restaurantID", request.getParameter("restaurantID"));
		request.setAttribute("restaurantName", request.getParameter("restaurantName"));
		request.setAttribute("selectedNo", 2);
		//request.setAttribute("selectedDate", "05-15-2019");
		request.setAttribute("selectedType", "Lunch");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/book-restaurant.jsp");
		dispatcher.forward(request, response);
	}

}
