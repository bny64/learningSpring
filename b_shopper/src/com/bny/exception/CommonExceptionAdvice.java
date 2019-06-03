package com.bny.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CommonExceptionAdvice {
	/**
	 * @ContorllerAdvice를 통해 객체가 컨트롤에서 발생하는 Exception을 전문적으로 처리하는 클래스라고 명시해줌.
	 * */
	private static Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public void commonException(Exception e) {
		logger.info("bny exception : {}", e);
	}
}
