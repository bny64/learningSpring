package com.bny.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bny.dao.LogDao;
import com.bny.dto.LoginLog;
import com.bny.service.LogService;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogDao logDao;
	
	@Override
	public int insertLoginLog(LoginLog loginLog) throws Exception {
		return logDao.insertLoginLog(loginLog);
	}

}
