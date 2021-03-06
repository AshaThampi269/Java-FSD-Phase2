

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "Pankaj";
	private final String password = "journaldev";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
				
				if(userID.equals(user) && password.equals(pwd)){
					Cookie loginCookie = new Cookie("user",user);
					//setting cookie to expiry in 30 mins
					loginCookie.setMaxAge(30*60);
					response.addCookie(loginCookie);
					response.sendRedirect("LoginSuccess.jsp");
				}else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
					PrintWriter out= response.getWriter();
					out.println("<font color=red>Either user name or password is wrong.</font>");
					rd.include(request, response);
				}

			}
	}
