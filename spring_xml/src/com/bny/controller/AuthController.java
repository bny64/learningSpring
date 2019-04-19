package com.bny.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.bny.dto.User;
import com.bny.service.UserService;


@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	//오류 부분	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView joinView(ModelAndView mnv) {
		System.out.println("join:get");
		mnv.setViewName("auth/join");
		return mnv;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView joinMember(ModelAndView mnv, HttpServletRequest request) {
		
		System.out.println("join:post");
		
		User user = new User();
		
		user.setUserKey(request.getAttribute("email").toString());
		user.setId(request.getAttribute("id").toString());
		user.setEmail(request.getAttribute("email").toString());
		user.setPassword(request.getAttribute("pass").toString());
		user.setProfilePath("");
		user.setBirth(request.getAttribute("birthday").toString());
		user.setEmailYn((Character)request.getAttribute("emailYn"));
		user.setIntMySelf(request.getAttribute("introduction").toString());
		user.setPhoneNumber(request.getAttribute("phoneNumber").toString());
		user.setUserName(request.getAttribute("name").toString());
		user.setUsedType("spring_xml");
		
		try {
			int result = userService.insertUser(user);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		mnv.setViewName("index");
		return mnv;
	}
}
