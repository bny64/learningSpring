package com.bny.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bny.dao.BoardDao;
import com.bny.dto.Board;
import com.bny.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> selectBoardList(Map<String, Integer> paging) throws Exception {
		return boardDao.selectBoardList(paging);
	}

	@Override
	public int registBoard(Board board) throws Exception {		
		return boardDao.registBoard(board);
	}

	@Override
	public Board selectBoard(int listNo) throws Exception {
		return boardDao.selectBoard(listNo);
	}

}
