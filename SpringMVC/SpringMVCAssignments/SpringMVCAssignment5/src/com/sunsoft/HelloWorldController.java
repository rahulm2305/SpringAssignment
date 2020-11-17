package com.sunsoft;
import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

@Controller  
public class HelloWorldController {
	 List<Student> stulist=new ArrayList<Student>();
	 
	 @RequestMapping("/add") 
	 public String showform(Model m){  
	        m.addAttribute("command",new Student());
	        return("add");  
	    }  
	    @RequestMapping(value="/save",method = RequestMethod.POST)  
	    public String save(@ModelAttribute("Ins") Student Ins,Model m){  
	        
	        System.out.println(Ins.getId()+" "+Ins.getName()+" "+Ins.getDept());
	       
	           stulist.add(Ins);
	           m.addAttribute("message","Details Added");
	           return "file";
	        
	    }  
	      
	    @RequestMapping("/view")  
	    public String view(Model m){  
	        
	       
	      
	        m.addAttribute("list",stulist);
	        
	        for(Student I:stulist)
	        System.out.println(I.id+" "+I.name+" "+I.dept);
	        return "view";  
	    }  	
	    
	    @RequestMapping(value="/delete")   
	    public String delete(HttpServletRequest request,HttpServletResponse res,Model m){  
	        
	        int id=Integer.parseInt(request.getParameter("id1"));
	        for(Student I:stulist)
	        {
	        	if(I.id==id)
	        		stulist.remove(id);
	        }
	        return "view";
	    }  	

    
}  