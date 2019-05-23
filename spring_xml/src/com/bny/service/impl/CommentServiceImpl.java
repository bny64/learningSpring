package com.bny.service.impl;

import java.util.List;

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
	public List<Comment> selectCommentList(int listNo) throws Exception {
		return commentDao.selectCommentList(listNo);
	}

}
