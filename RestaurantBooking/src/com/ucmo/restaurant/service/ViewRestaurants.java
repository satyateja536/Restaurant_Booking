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

import com.ucmo.restaurant.dao.RestaurantDAO;
import com.ucmo.restaurant.dto.RestaurantDTO;

/**
 * Servlet implementation class ViewRestaurants
 */
@WebServlet("/ViewRestaurants")
public class ViewRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RestaurantDAO restaurantDAO = new RestaurantDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRestaurants() {
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
			handleRequestForViewRestaurants(request, response);
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
	
	private void handleRequestForViewRestaurants(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<RestaurantDTO> restaurants = restaurantDAO.getRestaurantsByCity(request.getParameter("city"));
		request.setAttribute("restaurants", restaurants);
		request.setAttribute("userID", request.getParameter("userID"));		
		request.setAttribute("username", request.getParameter("username"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view-restaurants.jsp");
		dispatcher.forward(request, response);
		
	}

}
