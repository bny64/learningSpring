package com.bny.dao;

import java.util.List;
import java.util.Map;

import com.bny.dto.Comment;

public interface CommentDao {
	public List<Comment> selectCommentList(Map<String, Integer> paging) throws Exception;
	public int selectCommentCount(int listNo) throws Exception;
}
