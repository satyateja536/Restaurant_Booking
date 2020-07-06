package com.ucmo.restaurant.service.user;

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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
			handleRequestForUpdateUser(request, response);
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
	
	private void handleRequestForUpdateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		UserDTO user = new UserDTO();
		user.setUserName(request.getParameter("username"));		
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setMobileNumber(request.getParameter("mobileNumber"));
		user.setAddress(request.getParameter("address"));
		user.setCity(request.getParameter("city"));
		
		RequestDispatcher dispatcher;
		request.setAttribute("user", user);
		String status = userDAO.updateUser(user);
		if(status == "success") {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-home.jsp");			
		}
		else {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fail.jsp");
		}
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("userID", request.getParameter("userID"));
		dispatcher.forward(request, response);
	}

}
