package com.bny.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bny.dao.CommentDao;
import com.bny.dao.CommonDao;
import com.bny.dto.Comment;

@Repository
public class CommentDaoImpl extends CommonDao implements CommentDao{

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	public SqlSessionTemplate sqlSessionTemplate;
	
	public CommentDaoImpl() {
		/**
		 * com.bny.dao 처럼 패키지 뿐만 아니라
		 * com.bny.dao.CommentDao 같이 인터페이스 명도 맞춰줘야함.
		 * com.bny.dao 이렇게 네임스페이스 지정해서 오류로 고생함.
		 * */
		setNameSpace("com.bny.dao.CommentDao");
	}
	
	@Override
	public List<Comment> selectCommentList(Map<String, Integer> paging) throws Exception {
		return sqlSessionTemplate.selectList(getNameSpace()+".selectCommentList", paging);
	}

	@Override
	public int selectCommentCount(int listNo) throws Exception {		
		return sqlSessionTemplate.selectOne(getNameSpace()+".selectCommentCount", listNo);
	}

}
