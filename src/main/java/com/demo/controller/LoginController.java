package com.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Admin;
import com.demo.entity.User;
import com.demo.service.AdminService;
import com.demo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	
	/**用户和管理员登录
	 * @param account 用户名
	 * @param password 前端经md5加密后密码
	 * @param response 用于设置cookie
	 * @param id 0为管理员/1为用户 必须
	 * @return 失败返回提示信息msg，成功跳转对应主页
	 */
	@PostMapping("/login")
	public ModelAndView auth(String account,String password, HttpServletResponse response, @RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		if(id == 0) {
			//管理员验证
			Admin admin = adminService.auth(account, password);
			if(admin == null) {
				modelAndView.setViewName("LoginFail");		//展示登录失败信息的jsp
				modelAndView.addObject("msg", "登录失败，用户名或密码错误");
			} else {
				Cookie accountType = new Cookie("accountType","Admin");
				response.addCookie(accountType);
				modelAndView.setViewName("AdminMain");		//管理员主页
			}
		} else if(id == 1) {
			//用户验证
			User user = userService.auth(account, password);
			if(user == null) {
				modelAndView.setViewName("LoginFail");		//展示登录失败信息的jsp
				modelAndView.addObject("msg", "登录失败，账号或密码错误");
			} else {
				Cookie accountType = new Cookie("accountType","User");
				response.addCookie(accountType);
				modelAndView.setViewName("UserMain");		//用户主页
			}
		}
		return modelAndView;
	}

}
