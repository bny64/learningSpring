package com.tutorialspoint;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

public class SftpController {

	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;
	
	public void ttsInit(String host, String userName, String password, int port) {
		JSch jsch = new JSch();
		
		try {
			session = jsch.getSession(userName, host, port);
			session.setPassword(password);
			
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			
			session.setConfig(config);
			session.setTimeout(5000);
			session.connect();
			
			channel = session.openChannel("sftp");
			channel.connect();
			
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFile(String fileDir) {
		SftpATTRS attrs = null;
		
		try {
			attrs = channelSftp.stat(fileDir);
			
			if(attrs!=null) {
				channelSftp.rm(fileDir);
			}
			
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnection() {
		channelSftp.quit();
	}
	
}
