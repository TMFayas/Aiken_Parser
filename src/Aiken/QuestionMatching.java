package Aiken;

import java.util.HashMap;
import java.util.Map;

public class QuestionMatching extends Question {

	private Map<Character, String> responsesLeft = new HashMap<Character, String>();
	private Map<Character, String> responsesRight = new HashMap<Character, String>();
	private Map<Character, Character> answers = new HashMap<Character, Character>();
	
	public Map<Character, String> getResponsesLeft() {
		return responsesLeft;
	}
	public void setResponsesLeft(Map<Character, String> responsesLeft) {
		this.responsesLeft = responsesLeft;
	}
	public Map<Character, String> getResponsesRight() {
		return responsesRight;
	}
	public void setResponsesRight(Map<Character, String> responsesRight) {
		this.responsesRight = responsesRight;
	}
	public Map<Character, Character> getAnswers() {
		return answers;
	}
	public void setAnswers(Map<Character, Character> answers) {
		this.answers = answers;
	}
	public String toString() {
		return getDescription()+"\n"+responsesLeft.toString()+"\n"+responsesRight.toString()+"\n"+answers.toString();
	}
	
	public Map<Character, String> getMatchingResponsesRight(){
		return getResponsesRight();
	}
	public Map<Character, String> getMatchingResponsesLeft(){
		return getResponsesLeft();
	}
	public Map<Character,Character> getAnswersMatching(){
		return getAnswers();
	}
	public void accept(QuestionVisitor v) {
		v.visitQuestionMatching(this);
	}
	
	
	
}
