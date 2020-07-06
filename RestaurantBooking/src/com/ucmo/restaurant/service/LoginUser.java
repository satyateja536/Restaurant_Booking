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
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
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
			handleRequestForLoginUser(request, response);
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
	
	private void handleRequestForLoginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String result = "";		
		
		UserDTO user = userDAO.getUser(request.getParameter("username"));
		//System.out.println("Inside Login USer: "+user.getUserName()+"--"+user.getPassword()+"--"+request.getParameter("password"));
		RequestDispatcher dispatcher;
		
		if(user.getUserName() != null) {
			if(user.getPassword().equals(request.getParameter("password"))) {
				result = "User Authenticated";
				request.setAttribute("userID", user.getUserID());
				request.setAttribute("username", request.getParameter("username"));
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-home.jsp");
			}
			else {
				result = "Username or Password is incorrect";
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			}
		}
		else {
			result = "User Does not exist";
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		}
		
		request.setAttribute("result", result);	
			
		
		dispatcher.forward(request, response);
	}

}
