package com.bny.service;

import java.util.List;
import java.util.Map;

import com.bny.dto.Board;

public interface BoardService {
	public List<Board> selectBoardList(Map<String, Integer> paging) throws Exception;
	public int registBoard(Board board) throws Exception;
	public Board selectBoard(int listNo) throws Exception;
}
