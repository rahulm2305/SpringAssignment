package com.sunsoft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest req, HttpServletResponse res,Model m) {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		if(password.contentEquals("admin")) {
			//String message="You are valid user, Welcome "+name;
			m.addAttribute("id",102);
			m.addAttribute("name",name);
			m.addAttribute("dept","IBGT");
			m.addAttribute("designation","Senior officer");
			return "hellopage";
		}
		else {
		m.addAttribute("message","Sorry, username or password error");
		return "errorpage";
	}
	}
}
