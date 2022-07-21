package com.demo.entity;



/**完整题目类，非选择题的Item项为空
 * @author Aylok
 *
 */
public class FullQuestion {
	
	private Question question;
	private Type type;
	private Item item;
	
	@Override
	public String toString() {
		return "FullQuestion [question=" + question + ", type=" + type + ", item=" + item + "]";
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
