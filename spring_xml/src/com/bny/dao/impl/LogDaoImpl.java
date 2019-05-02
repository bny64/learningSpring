package com.bny.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bny.dao.CommonDao;
import com.bny.dao.LogDao;
import com.bny.dto.LoginLog;

@Repository
public class LogDaoImpl extends CommonDao implements LogDao {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	public SqlSessionTemplate sqlSessionTemplate;
	
	public LogDaoImpl() {
		setNameSpace("com.bny.dao.LogDao");
	}
	
	@Override
	public int insertLoginLog(LoginLog loginLog) throws Exception {
		int result = sqlSessionTemplate.insert(getNameSpace()+".insertLoginLog", loginLog);
		return result;
	}

}
