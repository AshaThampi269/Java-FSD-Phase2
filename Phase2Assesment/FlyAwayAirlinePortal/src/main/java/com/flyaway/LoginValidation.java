package com.flyaway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.User;
import com.flyaway.DBConnection;

@WebServlet("/loginUser")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		HttpSession session = request.getSession();
		
		// User userFromSession = (User) request.getSession().getAttribute("user");

		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM login WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				if(username.equals("admin@gmail.com"))
				{
					response.sendRedirect("adminPage.jsp");
				}
				else
				{
					response.sendRedirect("home.jsp");
				}
				session.setAttribute("user", user);
			} else {
				request.getSession().setAttribute("result", "Invalid User !!");
				//request.getRequestDispatcher("index.jsp").forward(request, response);
				response.sendRedirect("index.jsp");
			}

		}	
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			db.closeConnection();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}