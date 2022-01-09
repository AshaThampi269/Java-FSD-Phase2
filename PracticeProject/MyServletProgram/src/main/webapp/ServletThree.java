package advanced;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletThree extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		ServletContext sc = getServletContext();
		
		int a = Integer.parseInt(sc.getInitParameter("a"));
		int b = Integer.parseInt(sc.getInitParameter("b"));
		int c = Integer.parseInt(sc.getInitParameter("c"));
		
		ServletConfig sConfig = getServletConfig();
		
		int d = Integer.parseInt(sConfig.getInitParameter("d"));
		
		out.println("(1) " + (a + b + d) + "<br>");
		out.println(Arrays.stream(new int[] {a,b,c,d}).max().getAsInt());
	}

}