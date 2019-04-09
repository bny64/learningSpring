package com.bny.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bny.dto.User;

@Repository
public class UserDaoImpl extends CommonDao implements UserDao{

	
	public SqlSessionTemplate sqlSessionTemplate;
	
	public UserDaoImpl() {
		setNameSpace("com.bny.dao.user");
	}

	@Override
	public User getUser(String email) throws Exception{
		System.out.println("email~~~~~~~~~~");
		return sqlSessionTemplate.selectOne(getNameSpace() + ".getUser");
	}
	
}
