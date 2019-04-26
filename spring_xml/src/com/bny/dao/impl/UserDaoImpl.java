package com.bny.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bny.dao.CommonDao;
import com.bny.dao.UserDao;
import com.bny.dto.User;

@Repository
public class UserDaoImpl extends CommonDao implements UserDao{
	
	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	public SqlSessionTemplate sqlSessionTemplate;
		
	public UserDaoImpl() {
		setNameSpace("com.bny.dao.UserDao");
	}	

	@Override
	public int selectUserById(String id) throws Exception {		
		int result = sqlSessionTemplate.selectOne(getNameSpace()+".selectUserById", id);		
		return result;
	}

	@Override
	public int selectUserByEmail(String email) throws Exception {		
		return sqlSessionTemplate.selectOne(getNameSpace()+".selectUserByEmail", email);
	}
	
	@Override
	public int insertUser(User user) throws Exception {		
		return sqlSessionTemplate.insert(getNameSpace()+".insertUser", user);		
	}

	
}
