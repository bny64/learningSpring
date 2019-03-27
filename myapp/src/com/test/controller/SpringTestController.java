package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringTestController {
	@RequestMapping("/helloSpring")
	public ModelAndView TestController(){
		ModelAndView mv = new ModelAndView();
		System.out.println("logger");
		mv.addObject("helloWorld", "hello~ Spring World");
		mv.setViewName("helloSpring");
		return mv;
	}
}