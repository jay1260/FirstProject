package com.hclass.project1;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectorTest extends MyTestCase{

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession.getConnection());
	}
	

}
