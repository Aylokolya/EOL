package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**新建用户
	 * @param user 用户实体
	 * @return 包含表中插入id的用户实体
	 */
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		return  userService.insertNewUser(user);
	}
	
	/**查看所有用户
	 * @return 用户信息列表（密码为空）
	 */
	@GetMapping("/users")
	public List<User> findAllUsers(){
		List<User> list = userService.findAll();
		for (User user : list) {
			user.setPwd("");
		}
		return list;
	}
	
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable int id) {
		User user = userService.findUserById(id);
		user.setPwd("");
		return user;
	}
	
	@PutMapping("/users")
	public boolean changeUserInfo(@RequestBody  User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
	@PutMapping("/users/{id}")
	public boolean changeUserPwd(@PathVariable int id,String sno,String oldPwd,String newPwd) {
		User user = userService.auth(sno, oldPwd);
		if(user!=null) {
			user.setPwd(newPwd);
			if(userService.updateUser(user)) {
				return true;
			}
		}
		return false;
	}

}
