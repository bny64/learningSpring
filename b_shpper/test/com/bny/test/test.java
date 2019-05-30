package com.bny.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class test {
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://49.247.211.93:3306/bny_sequelize?characterEncoding=UTF-8&serverTimezone=UTC";
    private final String USER ="bny";
    private final String PW = "Namuyoru64!";

	@Test
	public void test2() {
		/**
		 * org/hamcrest/SelfDescribing class not found 에러 발생.
		 * 해결 못함.
		 * */
		try {
            Class.forName(DRIVER);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(URL, USER, PW)){
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
