package com.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@WebServlet("/productDetails")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		int id = Integer.parseInt(request.getParameter("pid"));

		try {
		
			PreparedStatement ps = conn.prepareStatement(
					" SELECT * FROM product WHERE Id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			List<Product> products = new ArrayList<>();
			while (rs.next()) {
				Product product = new Product();
				//System.out.println(rs.getString(1));
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				
				products.add(product);
			}
			request.getSession().setAttribute("productList", products);
			//request.getRequestDispatcher("/WEB-INF/flightDetails.jsp").forward(request, response);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

	}
}