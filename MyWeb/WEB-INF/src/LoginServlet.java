

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class LoginServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		
		String un=req.getParameter("username");
		String pw=req.getParameter("password");
		PrintWriter out = res.getWriter();
		
	  
       out.println("<html><body>");
	  out.println("<h1>");
	  out.println("username:" + un);
	  out.println("password:" + pw);
	  out.println("</h1>");
	  out.println("</body></html>");
		out.close();
	}

}
