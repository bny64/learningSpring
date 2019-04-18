package com.bny.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bny.dao.CommonDao;
import com.bny.dao.UserDao;
import com.bny.dto.User;

@Repository
public class UserDaoImpl extends CommonDao implements UserDao{

	
	public SqlSessionTemplate sqlSessionTemplate;
		
	public UserDaoImpl() {
		setNameSpace("com.bny.dao.UserDao");
	}

	@Override
	public int insertUser(User user) throws Exception {
		return sqlSessionTemplate.insert(getNameSpace()+".insertUser", user);		
	}

	
}
