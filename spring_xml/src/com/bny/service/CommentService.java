package com.bny.service;

import java.util.List;

import com.bny.dto.Comment;

public interface CommentService {
	public List<Comment> selectCommentList (int listNo) throws Exception;
}
