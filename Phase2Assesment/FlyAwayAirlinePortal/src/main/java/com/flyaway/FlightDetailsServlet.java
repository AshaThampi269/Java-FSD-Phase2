package com.flyaway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/flightDetails")
public class FlightDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = request.getParameter("travelDate");
		//System.out.println(parameter);
		LocalDate bookDate;

		try {
			//bookDate = in.parse(parameter);
			bookDate = LocalDate.parse(request.getParameter("travelDate"),
					DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
			String sourceCity = request.getParameter("source");
			String destinationCity = request.getParameter("destination");

			SeatBooked book = new SeatBooked();
			Date dateBookDate = Date.from(bookDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


			book.setDate(dateBookDate);

			PreparedStatement ps = conn.prepareStatement(
					" SELECT * FROM flightDetails WHERE travelDate = ? AND sourceCity = ? AND destinationCity = ?");
			ps.setDate(1, java.sql.Date.valueOf(request.getParameter("travelDate")));
			ps.setString(2, sourceCity);
			ps.setString(3, destinationCity);
			ResultSet rs = ps.executeQuery();
			
			List<Flight> flights = new ArrayList<>();
			while (rs.next()) {
				Flight flight = new Flight();
				//System.out.println(rs.getString(1));
				flight.setName(rs.getString(1));
				flight.setPrice(rs.getInt(2));
				flight.setNumber(rs.getInt(3));
				flight.setSource(rs.getString(4));
				flight.setDestination(rs.getString(5));
				flight.setSourceTime(rs.getTime(6));
				flight.setDestinationTime(rs.getTime(7));
				flight.setTotalSeats(rs.getInt(8));
				flight.setBookedSeats(rs.getInt(9));
				flight.setSeatAvailable(rs.getInt(10));
				flight.setDate(rs.getDate(11));
				flight.setClassType(rs.getString(12));
				
				flights.add(flight);
			}
			request.getSession().setAttribute("flightList", flights);
			request.getRequestDispatcher("/WEB-INF/flightDetails.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

	}

}