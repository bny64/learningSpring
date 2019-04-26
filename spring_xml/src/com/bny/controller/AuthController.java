package com.bny.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.bny.dto.User;
import com.bny.service.UserService;
import com.bny.util.Security;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
		
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;
	
	private Security security;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView joinView(ModelAndView mnv) {
		logger.debug("AuthController : get - /join");
		mnv.setViewName("auth/join");
		return mnv;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView joinMember(ModelAndView mnv, HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.debug("AuthController : post - /join");
				
		User user = new User();	
		security = new Security();
		
		String userId = request.getParameter("id");
		user.setId(userId);
		user.setUserKey(security.saltSHA1(userId));		
		user.setPassword(security.hashSHA256(request.getParameter("pass")));
		user.setEmail(request.getParameter("email"));		
		user.setProfilePath("");
		user.setBirth(request.getParameter("birthday"));
		user.setEmailYn(request.getParameter("emailYn").charAt(0));
		user.setIntMySelf(request.getParameter("introduction"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setUserName(request.getParameter("name"));
		user.setUsedType("spring_xml");
						
		boolean result = false;		
		
		result = userService.selectUserById(user.getId()) == 0 ? false : true;
		if(result) {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<script language='javascript'>alert('아이디가 중복됩니다.'); history.back();</script>");
			return null;
		}
		
		
		result = userService.selectUserByEmail(user.getEmail()) == 0 ? false : true;
		
		if(result) {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<script language='javascript'>alert('이메일이 중복됩니다.'); history.back();</script>");
			return null;
		}
		
		result = userService.insertUser(user) == 0 ? false : true;
		
		if(result) {
			mnv.addObject("message", "가입되었습니다. 로그인을 해주세요.");
		}
		
		mnv.setViewName("index");
		
		return mnv;
	}
}
