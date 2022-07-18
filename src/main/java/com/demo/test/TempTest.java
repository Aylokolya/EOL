package com.demo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demo.controller.UserController;
import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.util.GenerateData;

public class TempTest {
	
	private SqlSession sqlSession;
	
	@Before
	public void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@After
	public void close() {
		if(sqlSession!=null)
			sqlSession.close();
	}
	
//	@Test
//	public void testGenerator() {
//		User user = GenerateData.generateUser();
//		
//		System.out.println(user.getPwd());
//	}
	
	@Test
	public void testMapper() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(1);
		user.setSno("10001");
		System.out.println(userMapper.insert(user));
		sqlSession.commit();
		System.out.println(user.getId());
	}
	
	@Test
	public void testController() {
//		UserController userController = new UserController();
		//System.out.println(userController.findAllUsers());
		
	}

}
