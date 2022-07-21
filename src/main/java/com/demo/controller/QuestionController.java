package com.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.FullQuestion;
import com.demo.entity.Question;
import com.demo.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questions")
	public List<Question> getAllQuestions(){
		List<Question> list = questionService.findAll();
		Collections.reverse(list);
		return list;
		
	}
	
	@DeleteMapping("/questions/{id}")
	public boolean deleteQuestionById(@PathVariable int id) {
		return questionService.deleteQuestion(id);
	}
	
	@PutMapping("/questions")
	public boolean updateQuestion(@RequestBody FullQuestion fullQuestion) {
		
		return questionService.updateQuestion(fullQuestion);
	}
	
	@PostMapping("/questions")
	public FullQuestion createNewQuestion(@RequestBody FullQuestion fullQuestion) {
		return questionService.createNewQuestion(fullQuestion);
	}
	
	@GetMapping("/questions/{id}")
	public FullQuestion getFullQuestionById(@PathVariable int id) {
		return questionService.getFullQuestion(id);
	}
	
	@GetMapping("/exam")
	public List<FullQuestion> createExamQuestions(@RequestParam int id1,@RequestParam int id2){
		return questionService.exam(id1, id2);
	}

}
