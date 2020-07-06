package com.ucmo.restaurant.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucmo.restaurant.dao.UserDAO;
import com.ucmo.restaurant.dto.UserDTO;

/**
 * Servlet implementation class InsertUser
 */
@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
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
			handleRequestForInsertUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

	private void handleRequestForInsertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		UserDTO user = new UserDTO();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setMobileNumber(request.getParameter("mobileNumber"));
		user.setAddress(request.getParameter("address"));
		user.setCity(request.getParameter("city"));
		
		
		
		RequestDispatcher dispatcher;
		String result;
		String status = userDAO.insertUser(user);
		if(status == "success") {
			result = "User Created Successfully. Please Log in";
		}
		else {
			result = "User Creation Failed. Please Sign up again!";
		}
		
		request.setAttribute("result", result);
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	
}
