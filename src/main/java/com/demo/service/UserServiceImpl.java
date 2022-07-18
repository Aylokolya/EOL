package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapper;
import com.demo.entity.Admin;
import com.demo.entity.AdminExample;
import com.demo.entity.User;
import com.demo.entity.UserExample;

/**
 * @author Aylok
 *用户Service实现
 */
@Service
public class UserServiceImpl implements UserService {
	
	//自动注入
	@Autowired
	private UserMapper userMapper;

	@Override
	public User insertNewUser(User user) {
		//因为不插入id，所以用selective只插入有的数据
		//但我测试了一下发现直接用insert也行
		userMapper.insertSelective(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		
		return userMapper.selectByExample(null);
	}

	@Override
	public User auth(String sno, String pwd) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andSnoEqualTo(sno).andPwdEqualTo(pwd);
		List<User> list = userMapper.selectByExample(userExample);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateUser(User user) {
		if(userMapper.updateByPrimaryKeySelective(user)==1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		if(userMapper.deleteByPrimaryKey(id)==1) {
			return true;
		}
		return false;
	}
	
	
	
	

}
