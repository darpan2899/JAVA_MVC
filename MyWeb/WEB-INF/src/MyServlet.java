

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class MyServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
	  
       out.println("<html><body>");
	  out.println("<h1>hello i am servlet</h1>");
	  out.println("</body></html>");
		out.close();
	}

}
