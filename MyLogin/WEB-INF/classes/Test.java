

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;



class Test
{
public static void main(String a[])
{
 String cl="jdbc:mysql://localhost:3306/AJT559";
 String U="root";
 String P="ROOT";
 String dn="com.mysql.cj.jdbc.Driver";
 String un="drv";
 String pw="drv559";
 
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
				
				System.out.println("Welcome" + un);
				
				
			}
			else
			{
				System.out.println("invalid");
			}
			con.close();
		}
		
		catch(Exception e)
		{
			 e.printStackTrace();  
		}
	}
}