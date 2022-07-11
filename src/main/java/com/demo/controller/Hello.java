package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aylok
 *临时替代用全合一接口
 */
@Controller
@RequestMapping("/temp")
public class Hello {
	
	
	/**测试接口
	 * @return 空白主页
	 */
	@GetMapping("/hello")
	public String hello() {
		System.out.println("test hello");
		return "index";
	}


}