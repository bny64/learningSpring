package com.bny.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bny.service.UserService;

public class MySQLTest extends CommonTest{
	
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionFactory sqlFactory;	
	
	@Autowired
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(MySQLTest.class);
	
	@Test
	public void testConnection(){
		System.out.println("hello");
		try(Connection con = ds.getConnection()){
			System.out.println("출력 : " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
    public void testSession() throws Exception{
        
        try(SqlSession session = sqlFactory.openSession()){
            
            System.out.println(" >>>>>>>>>> session 출력 : "+session+"\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Test
	public void testQuery() {
		try {
			int result = userService.selectUserById("bny64");
			logger.debug("### {}", result);
			int result2 = userService.selectUserById("qoskaduf");
			logger.debug("### {}", result2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
