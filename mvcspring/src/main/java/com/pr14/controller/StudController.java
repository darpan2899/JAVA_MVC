package com.pr14.controller;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.pr14.beans.Stud;    
import com.pr14.dao.StudDao;    
 
@Controller
public class StudController {
	
	  @Autowired    
	    StudDao dao;//will inject dao from XML file    
	        
	    /*It displays a form to input data, here "command" is a reserved request attribute  
	     *which is used to display object data into form  
	     */    
	    @RequestMapping("/studentform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Stud());  
	        return "studentform";   
	    }    
	    
	    @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("stud") Stud stud){    
	        dao.save(stud);    
	        return "redirect:/viewstudent";    
	    }    
	       
	    @RequestMapping("/viewstudent")    
	    public String viewstudent(Model m){    
	        List<Stud> list = dao.getStudents();    
	        m.addAttribute("list",list);  
	        return "viewstudent";    
	    }    
	    /* It displays object data into form for the given id.   
	     * The @PathVariable puts URL data into variable.*/    
	    @RequestMapping(value="/editstud/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Stud stud=dao.getStudById(id);    
	        m.addAttribute("command",stud);  
	        return "studenteditform";    
	    }    
	      
	    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("stud") Stud stud){    
	        dao.update(stud);    
	        return "redirect:/viewstudent";    
	    }    
	       
	    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/viewstudent";    
	    }  
	

}
