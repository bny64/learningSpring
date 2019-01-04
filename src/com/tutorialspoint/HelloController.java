package com.tutorialspoint;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

@Controller
public class HelloController{
 	
	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;

	
	
   @RequestMapping(value="/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "hello";
   }
   
   @RequestMapping(value="/sftp", method = RequestMethod.GET)
   public @ResponseBody String sftpTTS(@RequestParam Map<String, String> req) {
	   
	   String host = "write your sftp ip";
	   String userName = "write your id";
	   String password = "write your password";
	   String path = "write your file path";
	   int port = 22;
	   
	   
	   String fileName = req.get("fileName") + ".mp3";
	   String publicDate = req.get("publicDate");
	   ttsInit(host, userName, password, port);
	   
	   String url = checkFileExist(path, publicDate, fileName);
	   disconnection();
	   
	   return url;
   }
   
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
	   channelSftp = (ChannelSftp) channel;
   }
   
   public String checkFileExist(String dir, String publicDate, String fileName) {
	   
	   SftpATTRS attrs = null;
	   
	   String fileYear = publicDate.substring(0, 4);
	   String fileMonth = publicDate.substring(4,6);
	   String fileDay = publicDate.substring(6,8);
	   String[] fileDate = {fileYear, fileMonth, fileDay};
	   
	   InputStream in = null;
	   boolean result = false;
	   
	   for(int i=0; i<fileDate.length; i++) {
		   attrs = null;
		   dir += "/" + fileDate[i];
		   
		   try {
			   attrs = channelSftp.stat(dir);
		   }catch(SftpException e) {
			   System.out.println("cannot find directory!");
			   return "";
		   }
	   }
	   
	   try {
		   channelSftp.cd(dir);
		   in = channelSftp.get(fileName);
		   
	   }catch(SftpException e) {
		   System.out.println("cannot find file~!");
		   return "";
	   }
	   
	   try {
		   int i;
		   
		   while((i = in.read()) != -1) {
			   result = true;
		   }
	   }catch(IOException e) {
		   e.printStackTrace();
	   }finally {
		   try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   if(result) {
		   return fileName;
	   }else {
		   return "";
	   }
   }
   
   public void disconnection() {
	   channelSftp.quit();
   }
}