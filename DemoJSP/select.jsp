<%@page import="java.sql.*"%>
<html>
<head>
<title>LoginServlet</title>
</head>
<body>
<%

try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajt559_2","root","ROOT");
			
			if(!con.isClosed())
			{
				System.out.println("connected");
				
			}
			
			Statement st = con.createStatement();
			
			
			ResultSet rs=st.executeQuery("select * from EMPLOYEE");
			%>
			<table>
			<tr>
			<th>NAME</th>
			<th>ID</th>
			<th>CONTACT</th>
			</tr>
			
<%
            while(rs.next())
			{%>
		      <tr>
               <td><%=rs.getString(1)%></td>
			   <td><%=rs.getInt(2)%> </td>
			   <td><%=rs.getInt(3)%></td>
			   </tr>
			   <%
			}	%>
   </table>
<%   
			
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
%>
</body>
</html>