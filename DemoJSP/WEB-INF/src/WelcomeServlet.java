import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class WelcomeServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		
		String un=req.getParameter("username");
		
		PrintWriter out = res.getWriter();
		
		
				out.println("<html><body>");
	            out.println("<h1>");
				out.println("Welcome  " + un);
				out.println("</h1>");
	            out.println("</body></html>");
		
	}
}
