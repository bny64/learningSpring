package com.bny.dao;

import java.util.List;
import java.util.Map;

import com.bny.dto.Board;

public interface BoardDao {
	public List<Board> selectBoardList(Map<String, Integer> paging) throws Exception;	
}
