package com.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Admin;
import com.demo.entity.User;
import com.demo.util.GenerateData;

@Controller
@RequestMapping("/temp")
public class AIOController2 {
	
	@PostMapping("/login")
	public ModelAndView auth(String account,String password, HttpServletResponse response, @RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		if(id == 0) {
			//管理员验证:10000,123456
			if(account=="10000"&&password==DigestUtils.md5DigestAsHex("123456".getBytes())) {
				Cookie accountType = new Cookie("accountType","Admin");
				response.addCookie(accountType);
				Admin admin = new Admin();
				admin.setId(1);
				admin.setTno("10000");
				admin.setPwd("");
				modelAndView.addObject("admin",admin);		//存入无密码的admin信息
				modelAndView.setViewName("AdminMain");		//管理员主页，可替换
			} else {
				modelAndView.setViewName("LoginFail");		//展示登录失败信息的jsp,可替换
				modelAndView.addObject("msg", "登录失败，用户名或密码错误");
			}
		} else if(id == 1) {
			//用户验证，10000,123456
			if(account=="10000"&&password==DigestUtils.md5DigestAsHex("123456".getBytes())) {
				Cookie accountType = new Cookie("accountType","User");
				response.addCookie(accountType);
				User user = GenerateData.generateUser();
				user.setId(1);
				user.setSno("10000");
				user.setPwd("");
				modelAndView.addObject("user",user);		//存入无密码的admin信息
				modelAndView.setViewName("UserMain");		//用户主页，可替换
			} else {
				modelAndView.setViewName("LoginFail");		//展示登录失败信息的jsp,可替换
				modelAndView.addObject("msg", "登录失败，用户名或密码错误");
			}
		}
		return modelAndView;
	}
	

}
