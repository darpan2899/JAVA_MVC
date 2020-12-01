package com.drv.DemoHib;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.drv.DemoHib.Student;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
res.setContentType("text/html");
		try{
		String n=request.getParameter("Name");
		double i=Double.parseDouble(request.getParameter("Id"));
		int s= Integer.parseInt(request.getParameter("Sem"));
		float c =Float.parseFloat(request.getParameter("CPI"));
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		PrintWriter out = response.getWriter();
	     Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new  StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();  
         Transaction t = session.beginTransaction();

          
		Student s1=new Student();    
		s1.setId(i);    
		s1.setName(n);    
		s1.setusername(un); 
		s1.setpassword(p);
		s1.setCPI(c);
		s1.setSem(s);  
        
		session.save(s1);  
		t.commit();  
		out.println("successfully saved");    
		factory.close();  
		session.close();
		}catch(Exception e){
			
			out.println(e);
		}
		}
	}


