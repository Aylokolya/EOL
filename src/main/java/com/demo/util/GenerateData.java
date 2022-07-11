package com.demo.util;

import java.util.Random;

import org.springframework.util.DigestUtils;

import com.demo.entity.User;

public class GenerateData {
	private static Random random = new Random();

	/**生成User数据
	 * @return 无id的User
	 */
	public static User generateUser() {
		
		User user = new User();
		String sno = String.valueOf(random.nextInt(10000, 99999));
		user.setSno(sno);
		user.setName("姓名"+random.nextInt(100));
		user.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
//		System.out.println(user.getPwd());
		return user;
		
	}
	
}
