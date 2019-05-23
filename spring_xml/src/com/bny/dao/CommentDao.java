package com.bny.dao;

import java.util.List;

import com.bny.dto.Comment;

public interface CommentDao {
	public List<Comment> selectCommentList(int listNo) throws Exception;
}
