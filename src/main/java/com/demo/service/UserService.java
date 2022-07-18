package com.demo.service;

import java.util.List;

import com.demo.entity.User;

/**
 * @author Aylok
 *用户Service接口，隔离实现和Controller
 */
public interface UserService {
	
	
	/**新增用户
	 * @param user 无ID的用户信息
	 * @return 插入表后获得ID的用户信息
	 */
	public User insertNewUser(User user);
	
	/**查看所有用户
	 * @return 用户列表
	 */
	public List<User> findAll();
	
	/**用户登录验证
	 * @param sno 用户账号
	 * @param pwd 用户密码，md5密文
	 * @return 用户记录
	 */
	public User auth(String sno,String pwd);
	
	/**查找用户
	 * @param id
	 * @return用户信息
	 */
	public User findUserById(int id);
	
	public boolean updateUser(User user);

	public boolean deleteUser(int id);
}
