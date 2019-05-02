package com.bny.service;

import com.bny.dto.LoginLog;

public interface LogService {
	public int insertLoginLog(LoginLog loginLog) throws Exception;
}
