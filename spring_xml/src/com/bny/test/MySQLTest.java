package com.bny.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/spring/root/root-context.xml", "classpath:/spring/application/database-context.xml"})
public class MySQLTest {
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		System.out.println("hello");
		try(Connection con = ds.getConnection()){
			System.out.println("출력 : " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
