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

@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		
		try
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM register");
			ResultSet rs = ps.executeQuery();
			
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
			response.sendRedirect("confirm.jsp");
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
	}
}