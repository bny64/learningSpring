package com.bny.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bny.dto.Board;
import com.bny.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	//BOARDLIST 페이지	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mnv) throws Exception{
		logger.debug("BoardController : GET - /boardList");
		mnv.setViewName("board/boardList");
		return mnv;
	}
	
	@RequestMapping(value="/registBoard", method=RequestMethod.GET)
	public ModelAndView registBoard(ModelAndView mnv) throws Exception{
		logger.debug("BoardController : GET - /registBoard");
		mnv.setViewName("board/registBoard");
		return mnv;
	}
	
	@RequestMapping(value="/getBoardList", method=RequestMethod.POST)
	public @ResponseBody List<Board> getBoardList(@RequestBody Map<String, String> request, HttpServletResponse response) throws Exception {
		/**
		 * !중요
		 * @RequsetBody, @ResponseBody를 사용하려면 jackson library를 넣어야 됨.
		 * jackson-core, jackson-databind, jackson-annotation
		 * */
		
		Map<String, Integer> map = new HashMap<String, Integer>();		
		List<Board> boards = new ArrayList<Board>();
		
		String pageNo = request.get("pageNo");
		String pageSize = request.get("pageSize");
		int offset = (Integer.parseInt(pageNo)-1) * Integer.parseInt(pageSize);
		
		map.put("pageSize", Integer.parseInt(pageSize));
		map.put("offset", offset);
		
		boards = boardService.selectBoardList(map);
		return boards;
	}	
}
