package com.demo.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Admin;
import com.demo.entity.User;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import com.demo.util.ResultJson;
import com.demo.util.TokenUtil;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	
	/**用户和管理员登录
	 * @param account 用户名
	 * @param password 前端经md5加密后密码
	 * @param 
	 * @param id 0为管理员/1为用户 必须
	 * @return 失败返回500，成功返回200，msg返回token
	 */
	@PostMapping("/login")
	public ResultJson auth(String account,String password, @RequestParam int id) {
		ResultJson resultJson = new ResultJson();
		if(id == 0) {
			//管理员验证:10000,123456
			Admin admin = adminService.auth(account, password);
			if(admin != null) {
				resultJson.setCode(200);
				resultJson.setMsg(TokenUtil.sign(0, admin.getTno()));
				resultJson.setData(admin);
				return resultJson;
			}
		} else if(id == 1) {
			//用户验证，10000,123456
			User user = userService.auth(account, password);
			if(user != null) {
				resultJson.setCode(200);
				resultJson.setMsg(TokenUtil.sign(1, user.getSno()));
				resultJson.setData(user);
				return resultJson;
			}
		}
		resultJson.setCode(500);
		resultJson.setData("");
		resultJson.setMsg("用户名或密码错误");
		return resultJson;
	}

}
