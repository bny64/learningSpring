package com.bny.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.bny.util.Security;

@Controller
@RequestMapping(value="/auth")
public class AuthController {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private UserService userService;
	private Security security;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mnv, HttpServletRequest req){		
		
		mnv.setViewName("auth/login");
		return mnv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody JSONObject loginUser(@RequestBody Map<String, String> req, HttpSession session) throws Exception{
		
		Map<String, String> user = new HashMap<String, String>();
		Map<String, String> userInfo = new HashMap<String, String>();
		JSONObject returnObj = new JSONObject();
		
		security = new Security();		
		
		String id = req.get("id");
		String password = req.get("password");
		
		
		
		boolean result = false;
		
		result = userService.selectUserById(id) == 1 ? true : false;
		
		if(!result) {
			returnObj.put("message", "아이디가 맞지 않습니다.");
			returnObj.put("result", false);
			return returnObj;
		}
		
		user.put("id", id);
		user.put("password", security.hashSHA256(password));
		
		userInfo = userService.selectUserByIdPass(user);
		
		if(userInfo==null) {
			returnObj.put("message", "비밀번호가 맞지 않습니다.");
			returnObj.put("result", false);			
			return returnObj;
		}else {
			returnObj.put("result", true);
			returnObj.put("message", "로그인 되었습니다.");
			session.setAttribute("userInfo", userInfo);			
		}
		
		return returnObj;
	}	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutUser(HttpSession session) throws Exception{
		if(session.getAttribute("userInfo")!=null) {
			session.removeAttribute("userInfo");
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public @ResponseBody JSONObject insertUser(@RequestBody Map<String, String> req) throws Exception{
		
		JSONObject returnObj = new JSONObject();
		User user = new User();
		security = new Security();
		
		String id = req.get("id");
		String name = req.get("name");
		String email = req.get("email");
		String password = req.get("password");
		String address = req.get("address"); 
		
		user.setUserKey(security.saltSHA1(id));		
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(security.hashSHA256(password));		
		user.setAddress(address);
		user.setJoinType("spring[xml]");
		user.setUserType("G".charAt(0));
		user.setUserClass("B".charAt(0));
		
		boolean result = false;
		
		result = userService.selectUserById(user.getId()) == 1 ? true : false;
						
		if(result) {
			returnObj.put("message", "아이디가 중복됩니다.");
			returnObj.put("result", false);
			return returnObj;
		}
		
		result = userService.selectUserByEmail(user.getEmail()) == 1 ? true : false;
		
		if(result) {
			returnObj.put("message", "이메일이 중복됩니다.");
			returnObj.put("result", false);
			return returnObj;
		}
		
		result = userService.insertUser(user) == 1 ? true : false;
		
		if(result) {
			returnObj.put("message", "가입에 성공했습니다.");
			returnObj.put("result", true);
		}else {
			returnObj.put("message", "가입에 실패했습니다.");
			returnObj.put("result", false);
		}
		
		return returnObj;
	}
}
