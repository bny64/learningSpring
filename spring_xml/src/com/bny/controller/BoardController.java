package com.bny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mnv) throws Exception{
		logger.debug("BoardController : get - /boardList");
		mnv.setViewName("board/boardList");
		return mnv;
	}
	
}
