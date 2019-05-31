package com.bny.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/auth")
public class AuthController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mnv, HttpServletRequest req){
		
		System.out.println("hello");
		
		//System.out.println(req.getSession().getAttribute("userInfo"));
		mnv.setViewName("auth/login");
		return mnv;
	}
}
