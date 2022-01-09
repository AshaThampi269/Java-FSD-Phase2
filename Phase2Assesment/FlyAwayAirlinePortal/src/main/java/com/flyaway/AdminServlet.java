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

@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldPassword = request.getParameter("oldPass");
		String newPassword = request.getParameter("newPass");
		String confirmPassword = request.getParameter("confirmPass");
		
		if(newPassword.equals(confirmPassword))
		{
			Admin admin = new Admin();
			admin.setOldPassword(oldPassword);
			admin.setNewPassword(newPassword);
			
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			try {
				
					PreparedStatement ps = conn.prepareStatement(" Update login set password = ? where username = ?");
					User user = (User) request.getSession().getAttribute("user");
					ps.setString(2, user.getUsername());
					ps.setString(1, newPassword);
					ps.executeUpdate();
					
					response.sendRedirect("index.jsp");
				
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				db.closeConnection();
			}
		}
		else
		{
			
		}
	}

}
