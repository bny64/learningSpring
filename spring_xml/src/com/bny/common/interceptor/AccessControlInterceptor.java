package com.bny.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessControlInterceptor extends HandlerInterceptorAdapter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object userInfo = session.getAttribute("userKey");
		if(null==userInfo) {
			logger.debug("세션정보 없음. 로그인 페이지로 이동");
			response.sendRedirect("/spring_xml/auth/login");
			return false;
		}
		
		return true;
	}
}
