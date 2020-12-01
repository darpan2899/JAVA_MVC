import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class RegisterServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		
		String n=req.getParameter("Name");
		double i=Double.parseDouble(req.getParameter("Id"));
		int s= Integer.parseInt(req.getParameter("Sem"));
		float c =Float.parseFloat(req.getParameter("CPI"));
		PrintWriter out = res.getWriter();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AJT559","root","ROOT");
			
			if(!con.isClosed())
			{
				System.out.println("connected");
				
			}
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO STUDENT(Id,Name,Sem,CPI) VALUES (?,?,?,?)");
			 int r;
			
			
		
			
			pst.setDouble(1,i);
			pst.setString(2,n);
			pst.setInt(3,s);
			pst.setFloat(4,c);
			
			r = pst.executeUpdate();
			
			
			if(r>0)
			{
				out.println("<html><body>");
	            out.println("<h1>");
				out.println("record inserted");
				out.println("</h1>");
	            out.println("</body></html>");
				
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
