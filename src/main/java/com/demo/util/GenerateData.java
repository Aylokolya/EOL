package com.demo.util;

import java.util.Random;

import org.springframework.util.DigestUtils;

import com.demo.entity.Admin;
import com.demo.entity.FullQuestion;
import com.demo.entity.Item;
import com.demo.entity.Question;
import com.demo.entity.Type;
import com.demo.entity.User;

public class GenerateData {
	private static Random random = new Random();

	/**生成无idUser数据
	 * @return 无id的User
	 */
	public static User generateUser() {
		
		User user = new User();
		String sno = String.valueOf(random.nextInt(10000, 100000));
		user.setSno(sno);
		user.setName("姓名"+random.nextInt(100));
		user.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
//		System.out.println(user.getPwd());
		return user;
		
	}
	
	/**生成fullQuestion数据
	 * @return fullQuestion
	 */
	public static FullQuestion generateFullQuestion() {
		FullQuestion fullQuestion = new FullQuestion();
		Type t = new Type();
		t.setId(random.nextInt(1, 5));
		switch (t.getId()) {
		case 1: t.setName("单选");
			break;
		case 2: t.setName("多选");
			break;
		case 3: t.setName("判断");
			break;
		case 4: t.setName("简答");
			break;
		default:
			break;
		}
		fullQuestion.setType(t);
		if(t.getId()==1 || t.getId()==2) {
			Item i = new Item();
			i.setId(1);
			i.setItema("a选项的描述");
			i.setItemb("b选项的另一个描述");
			i.setItemc("这是c选项");
			i.setItemd("d选项的描述在此");
			fullQuestion.setItem(i);
		}
		Question q = new Question();
		
		q.setMid(random.nextInt(1,5));
		q.setTid(random.nextInt(10000,100000 ));
		q.setContent("题目的题干描述，如衬衫的价格是九磅十五便士");
		fullQuestion.setQuestion(q);
		return fullQuestion;
	}
	
	/**生成限制专业的完整题目数据
	 * @param mid 专业id
	 * @return 选定专业的完整题目
	 */
	public static FullQuestion generateFullQuestion(int mid) {
		FullQuestion fullQuestion = new FullQuestion();
		Type t = new Type();
		t.setId(random.nextInt(1, 5));
		switch (t.getId()) {
		case 1: t.setName("单选");
			break;
		case 2: t.setName("多选");
			break;
		case 3: t.setName("判断");
			break;
		case 4: t.setName("简答");
			break;
		default:
			break;
		}
		fullQuestion.setType(t);
		if(t.getId()==1 || t.getId()==2) {
			Item i = new Item();
			i.setId(1);
			i.setItema("a选项的描述");
			i.setItemb("b选项的另一个描述");
			i.setItemc("这是c选项");
			i.setItemd("d选项的描述在此");
			fullQuestion.setItem(i);
		}
		Question q = new Question();
		
		q.setMid(mid);
		q.setTid(random.nextInt(10000,100000 ));
		q.setContent("题目的题干描述，如衬衫的价格是九磅十五便士");
		fullQuestion.setQuestion(q);
		return fullQuestion;
	}
	
	/**生成有id的Question数据
	 * @return 有id的Question信息
	 */
	public static Question generateQuestion() {
		Question question = new Question();
		question.setId(random.nextInt(100));
		question.setTid(random.nextInt(10000, 100000));
		question.setMid(random.nextInt(1, 5));
		question.setContent("当你看到这个题目的时候你看到的是这个"+random.nextInt(999)+"题目吗");
		return question;
	}
	
	/**生成有id无密码的admin数据
	 * @return 有id无密码的admin数据
	 */
	public static Admin generateAdmin() {
		Admin admin = new Admin();
		admin.setId(random.nextInt(99));
		admin.setPwd("");
		String tno = String.valueOf(random.nextInt(10000, 100000));
		admin.setTno(tno);
		return admin;
	}
}
