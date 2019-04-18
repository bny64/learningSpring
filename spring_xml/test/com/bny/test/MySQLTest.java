package com.bny.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bny.dao.UserDao;
import com.bny.dto.User;

public class MySQLTest extends CommonTest{
	
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionFactory sqlFactory;
	@Autowired
	UserDao userDao;	
	
	//@Test
	public void testConnection(){
		System.out.println("hello");
		try(Connection con = ds.getConnection()){
			System.out.println("출력 : " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
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
			User user = userDao.getUser("bny64@naver.com");
			System.out.println(user.getAge());
			System.out.println(user.getCreatedAt());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
