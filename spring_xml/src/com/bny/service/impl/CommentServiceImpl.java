package com.bny.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bny.dao.CommentDao;
import com.bny.dto.Comment;
import com.bny.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> selectCommentList(Map<String, Integer> paging) throws Exception {
		return commentDao.selectCommentList(paging);
	}

	@Override
	public int selectCommentCount(int listNo) throws Exception {
		return commentDao.selectCommentCount(listNo);		
	}

	@Override
	public int addComment(Comment comment) throws Exception {
		return commentDao.addComment(comment);
	}

}
