package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.FullQuestion;
import com.demo.entity.Question;
import com.demo.entity.User;
import com.demo.util.GenerateData;
import com.demo.util.ResultJson;

@RestController
@RequestMapping("/temp")
public class AIOController {
	
	/**2查看所有用户
	 * @return 8条用户数据
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
	
	/**4获取用户个人信息
	 * @param id 用户id
	 * @return 单条用户数据
	 */
	@GetMapping("/users/{id}")
	public User getUserByID(@PathVariable int id) {
		User user = GenerateData.generateUser();
		user.setPwd("");
		user.setId(id);
		return user;
	}
	
	/**3新建用户
	 * @param user 无id用户信息
	 * @return 有id用户数据
	 */
	@PostMapping("/users")
	public User createUser(User user) {
		User newUser = user;
		newUser.setId(10001);
		return newUser;
	}
	
	/**5修改用户信息
	 * @param user 修改的用户信息
	 * @param id 用户id
	 * @return 修改后用户信息
	 */
	@PutMapping("/users/{id}")
	public User changeUserInfo(@PathVariable int id,User user) {
		//修改用户信息
		return user;
	}
	
	/**6删除用户
	 * @param id 用户id
	 * @return 操作结果ResultJson
	 */
	@DeleteMapping("/users/{id}")
	public ResultJson deleteUser(@PathVariable int id) {
		ResultJson resultJson = new ResultJson();
		resultJson.setCode(ResultJson.SUCCESS);
		resultJson.setMsg("删除成功");
		return resultJson;
	}
	
	/**7删除题目
	 * @param id 题目id
	 * @return 操作结果
	 */
	@DeleteMapping("/questions/{id}")
	public ResultJson deleteQuestion(@PathVariable int id) {
		ResultJson resultJson = new ResultJson();
		resultJson.setCode(ResultJson.SUCCESS);
		resultJson.setMsg("删除成功");
		return resultJson;
	}
	
	/**8修改题目
	 * @param fullQuestion 修改的完整题目信息
	 * @param id 题目id
	 * @return 完整题目数据
	 */
	@PutMapping("/questions/{id}")
	public FullQuestion changeQuestionInfo(FullQuestion fullQuestion,@PathVariable int id) {
		//修改题目信息
		return fullQuestion;
	}
	
	/**9新建题目
	 * @param fullQuestion 完整题目信息（question不含id）
	 * @return 完整题目信息（question含id)
	 */
	@PostMapping("/questions")
	public FullQuestion createFullQuestion(FullQuestion fullQuestion) {
		Question q = fullQuestion.getQuestion();
		q.setId(10001);
		fullQuestion.setQuestion(q);
		return fullQuestion;
	}
	
	/**10获取完整题目详情
	 * @param id 题目id
	 * @return 完整题目信息
	 */
	@GetMapping("/questions/{id}")
	public FullQuestion getFullQuestion(@PathVariable int id) {
		FullQuestion f = GenerateData.generateFullQuestion();
		Question q = f.getQuestion();
		q.setId(id);
		f.setQuestion(q);
		return f;
	}
	
	/**11生成考试试卷
	 * @param id1 专业一id
	 * @param id2 专业二id
	 * @return 完整题目列表，每个专业8道题
	 */
	@GetMapping("/exam")
	public List<FullQuestion> getExamQuestions(@RequestParam int id1,@RequestParam int id2){
		List<FullQuestion> list = new ArrayList<>();
		for(int i=0;i<8;i++) {
			list.add(GenerateData.generateFullQuestion(id1));
			list.add(GenerateData.generateFullQuestion(id2));
		}
		return list;
	}
	
	/**1查看所有问题
	 * @return 问题列表，16道题
	 */
	@GetMapping("/questions")
	public List<Question> getAllQuestions(){
		List<Question> list = new ArrayList<>();
		for(int i=0;i<16;i++) {
			list.add(GenerateData.generateQuestion());
		}
		return list;
	}

}
