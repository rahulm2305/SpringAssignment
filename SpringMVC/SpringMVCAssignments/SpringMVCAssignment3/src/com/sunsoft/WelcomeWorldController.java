package com.sunsoft;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeWorldController {
	
	@RequestMapping("/welcome")
	public String helloWorld( @RequestParam ("name") String name, @RequestParam ("basic") int basic, @RequestParam ("hra") int hra, 
			@RequestParam ("da") int da, @RequestParam ("it") int it, @RequestParam ("deductions") int deductions,
			@RequestParam("id") String id, Model m) {
		
		if(id.contentEquals("Rahul")) 
		{
		int gross_sal=basic+hra+da;
		int net_sal=gross_sal-it-deductions;
		String message="id: "+id+" Gross sal: "+gross_sal+" Name: "+name+" Net Sal :"+net_sal;
		m.addAttribute("message",message);
		
		return "hellopage";
		}
		else {
			String message="You are not a valid employee";
			m.addAttribute("message",message);
			return "errorpage";
		}
	}

}