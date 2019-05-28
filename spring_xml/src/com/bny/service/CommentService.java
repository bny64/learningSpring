package com.bny.service;

import java.util.List;
import java.util.Map;

import com.bny.dto.Comment;

public interface CommentService {
	public List<Comment> selectCommentList (Map<String, Integer> paging) throws Exception;
	public int selectCommentCount(int listNo) throws Exception;
	public int addComment(Comment comment) throws Exception;
}
