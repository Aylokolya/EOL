package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public User createUser(User user) {
		return  userService.insertNewUser(user);
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	

}
