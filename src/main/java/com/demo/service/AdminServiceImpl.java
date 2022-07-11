package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.AdminMapper;
import com.demo.entity.Admin;
import com.demo.entity.AdminExample;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;

	
	@Override
	public Admin auth(String tno, String pwd) {
		AdminExample adminExample = new AdminExample();
		adminExample.createCriteria().andTnoEqualTo(tno).andPwdEqualTo(pwd);
		List<Admin> list = adminMapper.selectByExample(adminExample);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	

}
