package com.bny.dao;

import com.bny.dto.User;


public interface UserDao {
	
	public User getUser(String email) throws Exception;
	
}
