package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.util.TokenUtil;

public class TokenInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if(!url.contains("login")) {
			String token = request.getHeader("Authorization");
			if(TokenUtil.verify(token)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
