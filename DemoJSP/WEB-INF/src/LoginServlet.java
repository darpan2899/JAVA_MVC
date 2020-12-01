
import java.sql.*;
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
		
		ServletConfig config = getServletConfig();
		String dn =getInitParameter("DriverName");
		String cl = getInitParameter("ConnectionLink");
		String U =getInitParameter("Username");
		String P = getInitParameter("Password");
		PrintWriter out = res.getWriter();
		
		try
		{
			Class.forName(dn);
			
			Connection con = DriverManager.getConnection(cl,U,P);
			
			if(!con.isClosed())
			{
				System.out.println("connected");
				
			}
			
			PreparedStatement pst = con.prepareStatement("Select * from Student where Username=? and Password=?");
			 
			
			
		
			
			pst.setString(1,un);
			pst.setString(2,pw);
			
			
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next())
			{
				RequestDispatcher rd = req.getRequestDispatcher("/servlet3");
	            rd.forward(req,res);
				
			}
			else
			{
				out.println("<html><body>");
	            out.println("<h1>");
				out.println("username or password incorrect");
				out.println("</h1>");
	            out.println("</body></html>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
	            rd.include(req,res);
			}
			con.close();
		}
		
		catch(Exception e)
		{
			    out.println("<html><body>");
	            out.println("<h1>");
				out.println(e);
				out.println("</h1>");
	            out.println("</body></html>");
		}
	
		
	  
       
		out.close();
	}
	

}
