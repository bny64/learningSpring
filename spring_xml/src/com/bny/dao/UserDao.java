package com.bny.dao;

import java.util.Map;

import com.bny.dto.User;


public interface UserDao {	
	public int selectUserById(String id) throws Exception;
	public int selectUserByEmail(String email) throws Exception;
	public int insertUser(User user) throws Exception;
	public Map<String, String> selectUserByIdPass(Map<String, String> userInfo) throws Exception;
}
