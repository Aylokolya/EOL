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

public class UserTest {
	
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
	
	@Test
	public void testGenerator() {
		User user = GenerateData.generateUser();
		
		System.out.println(user.getSno());
	}
	
	@Test
	public void testInsert() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = GenerateData.generateUser();
		int i = userMapper.insert(user);
		sqlSession.commit();
		System.out.println(user.getId());
		System.out.println(i);
	}
	
	@Test
	public void testInsertSelective() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		int id = 11;
		String sno = "78910";
		//String name = "test";
		String pwd = "123456";
		user.setId(id); 
		//user.setName(name); 
		user.setPwd(pwd); 
		user.setSno(sno);
		
		int i = userMapper.insertSelective(user);
		sqlSession.commit();
		System.out.println(user.getId());
		System.out.println(i);
	}
	
	@Test
	public void testDeleteByPrimaryKey() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int id = 6;
		int ret =  userMapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		System.out.println(ret);
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int id = 3;
		User user = userMapper.selectByPrimaryKey(id);
		sqlSession.commit();
		System.out.println(user);
	}	
	
	@Test
	public void testUpdateByPrimaryKey() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		int id = 10;
		System.out.println(userMapper.selectByPrimaryKey(id));
		
		String sno = "22222";
		String name = "newtest";
		String pwd = "999999";
		user.setId(id); 
		user.setName(name); 
		user.setPwd(pwd); 
		user.setSno(sno);
		
		int ret = userMapper.updateByPrimaryKey(user);
		sqlSession.commit();
		System.out.println(userMapper.selectByPrimaryKey(id));
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		int id = 11;
		System.out.println(userMapper.selectByPrimaryKey(id));
		
		String sno = "11111";
		String name = "test222";
		String pwd = "666666";
		user.setId(id); 
		//user.setName(name); 
		user.setPwd(pwd); 
		//user.setSno(sno);
		
		int ret = userMapper.updateByPrimaryKeySelective(user);
		sqlSession.commit();
		System.out.println(userMapper.selectByPrimaryKey(id));
	}
}
