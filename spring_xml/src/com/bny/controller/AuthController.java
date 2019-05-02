package com.bny.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bny.dto.LoginLog;
import com.bny.dto.User;
import com.bny.service.LogService;
import com.bny.service.UserService;
import com.bny.util.Security;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
		
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	
	private Security security;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView joinMember(ModelAndView mnv) throws Exception{
		logger.debug("AuthController : get - /login");
		mnv.setViewName("auth/login");
		return mnv;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView joinView(ModelAndView mnv) throws Exception{
		logger.debug("AuthController : get - /join");
		mnv.setViewName("auth/join");
		return mnv;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinMember(HttpServletRequest request, 
			HttpServletResponse response, final RedirectAttributes message) throws Exception{
		logger.debug("AuthController : post - /join");
				
		User user = new User();	
		security = new Security();
		
		String userId = request.getParameter("id");
		user.setId(userId);
		user.setUserKey(security.saltSHA1(userId));		
		user.setPassword(security.hashSHA256(request.getParameter("pass")));
		user.setEmail(request.getParameter("email"));		
		user.setBirth(request.getParameter("birthday"));
		user.setEmailYn(request.getParameter("emailYn").charAt(0));
		user.setIntMySelf(request.getParameter("introduction"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setUserName(request.getParameter("name"));
		user.setJoinedType("spring_xml");
						
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
		
		if(!result) {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<script language='javascript'>alert('가입에 실패했습니다.'); history.back();</script>");
			return null;
		}else {
			message.addFlashAttribute("message", "가입되었습니다. 로그인을 해주세요.");
			return "redirect:/index";	
		}		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginMember(HttpServletRequest request, 
			HttpServletResponse response, RedirectAttributes message) throws Exception{
		logger.debug("AuthController : post - /login");
		Map<String, String> userInfo = new HashMap<String, String>();
		security = new Security();		
		
		Map<String, String> user = new HashMap<String, String>();
		user.put("id", request.getParameter("id"));
		user.put("password", security.hashSHA256(request.getParameter("password")));
		
		userInfo = userService.selectUserByIdPass(user);
		
		if(userInfo==null) {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<script language='javascript'>alert('ID혹은 비밀번호가 맞지 않습니다.'); history.back();</script>");
			return null;
		}else {
			/**
			 * JSP 기본 객체 내장 영역
			 * 찾는 순서 context - request - session - application
			 * 범위 큰 순서 application - session - request - context
			  */
			LoginLog loginLog = new LoginLog();
			loginLog.setId(request.getParameter("id"));
			loginLog.setUsedType("spring_xml");
			loginLog.setUserName(userInfo.get("userName"));
			logService.insertLoginLog(loginLog);
			
			message.addFlashAttribute("message", "로그인 되었습니다.");
			request.getSession().setAttribute("userKey", userInfo.get("userKey"));			
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutMember(HttpServletRequest request, 
			HttpServletResponse response, RedirectAttributes message) throws Exception{
		if(request.getSession().getAttribute("userKey")!=null) {
			
			message.addFlashAttribute("message", "로그아웃 되었습니다.");
			request.getSession().removeAttribute("userKey");
		}
		
		return "redirect:/index";
		
	}
}
