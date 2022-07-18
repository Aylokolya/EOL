package com.demo.service;

import java.util.List;

import com.demo.entity.FullQuestion;
import com.demo.entity.Question;

public interface QuestionService {
	
	public List<Question> findAll();
	
	public boolean deleteQuestion(int id);
	
	public boolean updateQuestion(FullQuestion fullQuestion);
	
	public FullQuestion createNewQuestion(FullQuestion fullQuestion);
	
	public FullQuestion getFullQuestion(int id);
	
	public List<FullQuestion> exam(int id1,int id2);

}
