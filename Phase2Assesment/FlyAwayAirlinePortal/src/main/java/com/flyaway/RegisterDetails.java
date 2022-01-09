package com.flyaway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.DBConnection;
import com.flyaway.User;
 
@WebServlet("/registerUser")
public class RegisterDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Fullname = request.getParameter("fullName");
		String Address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		String contact = request.getParameter("mobile");
		String idType = request.getParameter("ID type");
		String idNo = request.getParameter("idNo");
		String country = request.getParameter("country");
		int passNo = Integer.parseInt(request.getParameter("passNo"));
		
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		User user = new User();
		
		try {
			PreparedStatement ps = conn.prepareStatement(" insert into register (username, fullName, address, age, contact, idType, idNo, country, flightNo, travelDate, passengers) values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, ((User) request.getSession().getAttribute("user")).getUsername());
			ps.setString(2, Fullname);
			ps.setString(3, Address);
			ps.setInt(4, age);
			ps.setString(5, contact);
			ps.setString(6, idType);
			ps.setString(7, idNo);
			ps.setString(8, country);
			//System.out.println(request.getParameter("date"));
			ps.setString(9,request.getParameter("flightNumber"));
			ps.setString(10, request.getParameter("date"));
			ps.setInt(11, passNo);
			ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM register");
			ResultSet rs = ps1.executeQuery();
			
			List<Booking> seats = new ArrayList<>();
			while (rs.next()) {
				Booking seat = new Booking();
				//System.out.println(rs.getString(1));
				seat.setUsername(rs.getString(1));
				seat.setFullName(rs.getString(2));
				seat.setContact(rs.getString(5));
				seat.setFlightNo(rs.getString(9));
				seat.setTravelDate(rs.getString(10));
				seat.setPassenger(rs.getInt(11));
				seats.add(seat);	
		}
			request.getSession().setAttribute("seatList", seats);
			response.sendRedirect("paymentPortal.jsp");

		}	
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			db.closeConnection();
		}
	}

}