package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Model - POJO
//View - response - jsp / html

//MVC pattern

@Controller
  
public class HomeController {
 public String val;
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/demo")
	public String getDemo() {
		return port;
	}
	
	@GetMapping("/demo/next")
	public String getSecPage() {
		return "second page";
	}

	
	@RequestMapping("home")
	public String home(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String name=req.getParameter("name");
		System.out.println(name);
		session.setAttribute("name", name);
		return "home";	
	}
	
	
	@RequestMapping("aboutUS")
	public String aboutUS(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String city=req.getParameter("city");
		System.out.println(city);
		session.setAttribute("city", city);
		return "city";	
	}
	
	@RequestMapping("mvc")
	public ModelAndView mvc(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String city=req.getParameter("city").toUpperCase();
		ModelAndView mv=new ModelAndView();
		//session.setAttribute("city", city);
		mv.addObject("city", city);
		mv.setViewName("city");
		return mv;	
	}
	
	

	
	
	
	
	
	

}


//localhost:9092/myapp/demo/next
