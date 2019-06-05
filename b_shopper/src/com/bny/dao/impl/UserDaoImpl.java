package com.bny.dao.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bny.dao.UserDao;
import com.bny.dto.User;

@Repository
public class UserDaoImpl extends CommonDaoImpl implements UserDao{

	public SqlSessionTemplate sqlSessionTemplate;
	
	public UserDaoImpl() {
		setNameSpace("com.bny.dao.UserDao");
	}
	
	@Override
	public int insertUser(User user) throws Exception {
		return sqlSessionTemplate.insert(getNameSpace()+".insertUser", user);		
	}

	@Override
	public int selectUserById(String id) throws Exception {
		return sqlSessionTemplate.selectOne(getNameSpace()+".selectUserById", id);
	}

	@Override
	public int selectUserByEmail(String email) throws Exception {
		return sqlSessionTemplate.selectOne(getNameSpace()+".selectUserByEmail", email);
	}

	@Override
	public Map<String, String> selectUserByIdPass(Map<String, String> userInfo) throws Exception {
		return sqlSessionTemplate.selectOne(getNameSpace()+".selectUserByIdPass", userInfo);
	}
	
	
}
