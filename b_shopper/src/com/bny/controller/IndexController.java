package com.bny.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView TestController(ModelAndView mnv, HttpServletRequest req){
			
		
		mnv.setViewName("index");
		return mnv;
	}
}
