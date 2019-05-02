package com.bny.dao;

import com.bny.dto.LoginLog;

public interface LogDao{
	public int insertLoginLog(LoginLog loginLog) throws Exception;
}
