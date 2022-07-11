package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.AdminMapper;
import com.demo.entity.Admin;

public interface AdminService {
	
	
	/**管理员登录验证
	 * @param tno 管理员账号
	 * @param pwd 管理员密码md5密文
	 * @return 管理员记录
	 */
	public Admin auth(String tno, String pwd) ;

}
