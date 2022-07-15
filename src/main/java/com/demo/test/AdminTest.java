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
import com.demo.dao.AdminMapper;
import com.demo.dao.UserMapper;
import com.demo.entity.Admin;
import com.demo.entity.User;
import com.demo.util.GenerateData;

public class AdminTest {
	
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
	public void testInsert() {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin admin = new Admin();
		int id = 4;
		String tno = "0001";
		String pwd = "123456";
		admin.setId(id);
		admin.setPwd(pwd);
		admin.setTno(tno);
		
		int i = adminMapper.insert(admin);
		sqlSession.commit();
		System.out.println(i);
		System.out.println(adminMapper.selectByPrimaryKey(id));
	}
	
	/*
	 * 报错
	 * 管理员的tno pwd属性均为非空 故无法进行选择插入
	 * */
	@Test
	public void testInsertSelective() {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin admin = new Admin();
		int id = 5;
		String tno = "0001";
		String pwd = "123456";
		admin.setId(id);
		admin.setPwd(pwd);
		//admin.setTno(tno);
		
		int i = adminMapper.insertSelective(admin);
		sqlSession.commit();
		System.out.println(i);
		System.out.println(adminMapper.selectByPrimaryKey(id));
	}
	
	@Test
	public void testDeleteByPrimaryKey() {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		int id = 4;
		int ret =  adminMapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		System.out.println(ret);
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		int id = 3;
		Admin admin = adminMapper.selectByPrimaryKey(id);
		sqlSession.commit();
		System.out.println(admin);
	}	
	
	@Test
	public void testUpdateByPrimaryKey() {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin admin = new Admin();
		int id = 3;
		System.out.println(adminMapper.selectByPrimaryKey(id));
	
		String tno = "0002";
		String pwd = "123456";
		admin.setId(id);
		admin.setPwd(pwd);
		admin.setTno(tno);
		
		int ret = adminMapper.updateByPrimaryKey(admin);
		sqlSession.commit();
		System.out.println(adminMapper.selectByPrimaryKey(id));
		System.out.println(ret);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin admin = new Admin();
		int id = 3;
		System.out.println(adminMapper.selectByPrimaryKey(id));
	
		String tno = "0001";
		String pwd = "11111";
		admin.setId(id);
		admin.setPwd(pwd);
		//admin.setTno(tno);
		
		int ret = adminMapper.updateByPrimaryKeySelective(admin);
		sqlSession.commit();
		System.out.println(adminMapper.selectByPrimaryKey(id));
		System.out.println(ret);
	}
}
