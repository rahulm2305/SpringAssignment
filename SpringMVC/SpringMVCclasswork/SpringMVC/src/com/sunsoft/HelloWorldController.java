package com.sunsoft;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld(Model m) {
		String message="This is my first MVC project..";
		m.addAttribute("message",message);
		
		return new ModelAndView("hellopage", "rahul", "Hello Rahul!");
	}
}
