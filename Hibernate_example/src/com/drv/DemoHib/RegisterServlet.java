package com.drv.DemoHib;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("Name");
		double i=Double.parseDouble(request.getParameter("Id"));
		int s= Integer.parseInt(request.getParameter("Sem"));
		float c =Float.parseFloat(request.getParameter("CPI"));
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		PrintWriter pout = response.getWriter();
	    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
       // ServiceRegistry serviceRegistry = new  StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();  
         Transaction t = session.beginTransaction();
         response.setContentType("text/html");
		try{
		  
    Student s1=new Student();    
    s1.setId(i);    
    s1.setName(n);    
    s1.setusername(un); 
     s1.setpassword(pw);
    s1.setCPI(c);
    s1.setSem(s);  
        
    session.save(s1);  
    t.commit();  
    pout.println("successfully saved");    
    factory.close();  
    session.close();
		}
		catch(Exception e)
		{
			
			pout.print(e);
		}
	}
}


