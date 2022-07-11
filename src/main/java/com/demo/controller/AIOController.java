package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.util.GenerateData;

@RestController
@RequestMapping("/temp")
public class AIOController {
	
	/**查看所有用户
	 * @return 8条数据
	 */
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> t = new ArrayList<>();
		for(int i=0;i<8;i++)
		{
			t.add(GenerateData.generateUser());
		}
		return t;
	}
	
	@GetMapping("/users/{id}")
	public User getUserByID(@PathVariable int id) {
		return null;
	}

}
