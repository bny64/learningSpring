package com.bny.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bny.dao.impl.UserDaoImpl;
import com.bny.dto.User;
import com.bny.service.UserService;

@Controller
@RequestMapping(value="/auth")
public class AuthController {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mnv, HttpServletRequest req){		
		
		mnv.setViewName("auth/login");
		return mnv;
	}
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public @ResponseBody JSONObject insertUser(@RequestBody Map<String, String> req) throws Exception{
		
		JSONObject returnObj = new JSONObject();
		User user = new User();
		
		String id = req.get("id");
		String name = req.get("name");
		String email = req.get("email");
		String password = req.get("password");
		String address = req.get("address"); 
				
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setAddress(address);
		user.setJoinType("spring[xml]");
		user.setUserType("G".charAt(0));
		user.setUserClass("B".charAt(0));
				
		boolean result = userService.insertUser(user) == 1 ? true : false; 
				
		returnObj.put("result", result);
		
		return returnObj;
	}
}
