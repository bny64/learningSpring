package com.bny.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bny.dao.BoardDao;
import com.bny.dao.CommonDao;
import com.bny.dto.Board;

@Repository
public class BoardDaoImpl extends CommonDao implements BoardDao{

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	public SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoImpl() {
		setNameSpace("com.bny.dao.BoardDao");
	}
	
	@Override
	public List<Board> selectBoardList(Map<String, Integer> paging) throws Exception {
		return sqlSessionTemplate.selectList(getNameSpace()+".selectBoardList", paging);
	}
}
