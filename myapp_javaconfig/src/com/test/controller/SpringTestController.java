package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringTestController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView TestController(){
		ModelAndView mv = new ModelAndView();		
		mv.addObject("helloWorld", "hello~ Spring World");
		mv.setViewName("index");
		return mv;
	}
}