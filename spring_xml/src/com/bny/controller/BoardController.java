package com.bny.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bny.dto.Board;
import com.bny.dto.Comment;
import com.bny.service.BoardService;
import com.bny.service.CommentService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentService commentService;
	
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
		logger.debug("BoardController : POST - /getBoardList");
		
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
	
	@RequestMapping(value="/registBoard", method=RequestMethod.POST)
	public String registBoard(HttpServletRequest request, RedirectAttributes message) throws Exception {
		/**
		 * form 태그는 json 형태가 아니기 때문에 @RequestBody를 사용할 수 없고
		 * HttpServletRequest로 받아야 함.
		 * */
		JSONObject userInfo = (JSONObject) request.getSession().getAttribute("userInfo");
		Board board = new Board();
		
		String password = request.getParameter("password");		
		board.setContents(request.getParameter("contents"));		
		board.setTitle(request.getParameter("title"));
		if(!("".equals(password) || password==null)) {
			board.setPassword(password);
			board.setPassYn("Y".charAt(0));
		}else {
			board.setPassYn("N".charAt(0));
		}
		
		board.setName(userInfo.get("userName").toString());
		board.setId(userInfo.get("userId").toString());
		
		boardService.registBoard(board);
		
		message.addFlashAttribute("message", "등록되었습니다");
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/viewBoard", method=RequestMethod.GET)
	public ModelAndView viewBoard(ModelAndView mnv, @RequestParam Map<String, String> req) throws Exception{		
		logger.debug("BoardController : GET - /viewBoard");
		int listNo = Integer.parseInt(req.get("listNo"));
		
		Board board = boardService.selectBoard(listNo);
		
		mnv.addObject("content", board);
		mnv.setViewName("board/viewBoard");
		return mnv;
	}
}
