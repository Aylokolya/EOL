package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ItemMapper;
import com.demo.dao.MajorMapper;
import com.demo.dao.QuestionMapper;
import com.demo.dao.TypeMapper;
import com.demo.entity.FullQuestion;
import com.demo.entity.Item;
import com.demo.entity.ItemExample;
import com.demo.entity.Question;
import com.demo.entity.QuestionExample;
import com.demo.entity.Type;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired 
	private TypeMapper typeMapper;
	@Autowired
	private MajorMapper majorMapper;
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Question> findAll() {
		
		return questionMapper.selectByExample(null);
	}

	@Override
	public boolean deleteQuestion(int id) {
		Question question = questionMapper.selectByPrimaryKey(id);
		Type type = typeMapper.selectByPrimaryKey(question.getTid());
		if(type.getName().contentEquals("单选")||type.getName().contentEquals("多选")) {
			ItemExample itemExample = new ItemExample();
			itemExample.createCriteria().andQidEqualTo(id);
			if(itemMapper.deleteByExample(itemExample)==1) {
				if(questionMapper.deleteByPrimaryKey(id)==1) {
					return true;
				}
			} else {
				if(questionMapper.deleteByPrimaryKey(id)==1) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateQuestion(FullQuestion fullQuestion) {
		Question question = fullQuestion.getQuestion();
		Type type = fullQuestion.getType();
		Item item = fullQuestion.getItem();
		if(type.getName().contentEquals("单选")||type.getName().contentEquals("多选")) {
			if(itemMapper.updateByPrimaryKeySelective(item)==1) {
				if(questionMapper.updateByPrimaryKeySelective(question)==1) {
					return true;
				}
			}
		} else {
			if(questionMapper.updateByPrimaryKeySelective(question)==1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public FullQuestion createNewQuestion(FullQuestion fullQuestion) {
		Question question = fullQuestion.getQuestion();
		Type type = fullQuestion.getType();
		Item item = fullQuestion.getItem();
		if(type.getName().contentEquals("单选")||type.getName().contentEquals("多选")) {
			questionMapper.insert(question);
			item.setQid(question.getId());
			itemMapper.insert(item);
		}
		fullQuestion.setQuestion(question);
		fullQuestion.setItem(item);
		return fullQuestion;
	}

	@Override
	public FullQuestion getFullQuestion(int id) {
		FullQuestion fullQuestion = new FullQuestion();
		Question question = questionMapper.selectByPrimaryKey(id);
		fullQuestion.setQuestion(question);
		Type type = typeMapper.selectByPrimaryKey(question.getTid());
		fullQuestion.setType(type);
		if(type.getName().contentEquals("单选")||type.getName().contentEquals("多选")) {
			ItemExample itemExample = new ItemExample();
			itemExample.createCriteria().andQidEqualTo(id);
			List<Item> list = itemMapper.selectByExample(itemExample);
			if(list!=null) {
				fullQuestion.setItem(list.get(0));
			}
		}
		return fullQuestion;
	}

	@Override
	public List<FullQuestion> exam(int id1, int id2) {
		Random random = new Random();
		QuestionExample questionExample1 = new QuestionExample();
		questionExample1.createCriteria().andMidEqualTo(id1);
		List<Question> list1 = questionMapper.selectByExample(questionExample1);
		QuestionExample questionExample2 = new QuestionExample();
		questionExample2.createCriteria().andMidEqualTo(id2);
		List<Question> list2 = questionMapper.selectByExample(questionExample2);
		List<FullQuestion> finalList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			int t = random.nextInt(list1.size());
			FullQuestion fullQuestion = new FullQuestion();
			fullQuestion.setQuestion(list1.get(t));
			finalList.add(fullQuestion);
			list1.remove(t);
		}
		for(int i=0;i<10;i++) {
			int t = random.nextInt(list2.size());
			FullQuestion fullQuestion = new FullQuestion();
			fullQuestion.setQuestion(list2.get(t));
			finalList.add(fullQuestion);
			list2.remove(t);
		}
		for (FullQuestion fullQuestion : finalList) {
			fullQuestion.setType(typeMapper.selectByPrimaryKey((fullQuestion.getQuestion().getTid())));
			if(fullQuestion.getType().getName().contentEquals("单选")||fullQuestion.getType().getName().contentEquals("多选")) {
				ItemExample itemExample = new ItemExample();
				itemExample.createCriteria().andQidEqualTo(fullQuestion.getQuestion().getId());
				List<Item> list = itemMapper.selectByExample(itemExample);
				if(list!=null) {
					fullQuestion.setItem(list.get(0));
				}
			}
		}
		return finalList;
	}
	
	
	
	
	
	
	
	
	

}
