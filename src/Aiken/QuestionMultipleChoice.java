package Aiken;

import java.util.List;
import java.util.Map;

public class QuestionMultipleChoice extends Question {

	private Map<Character, String> responses;
	private List<Character> answers;
	
	public Map<Character, String> getResponses() {
		return responses;
	}
	public void setResponses(Map<Character, String> responses) {
		this.responses = responses;
	}
	public List<Character> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Character> answer) {
		this.answers = answer;
	}
	public String toString() {
		return getDescription()+"\n"+responses.toString()+"\n"+answers.toString();
	}
	
	public List<Character> getAnswersQCM(){
		return this.getAnswers();
	}
	
	public void accept(QuestionVisitor v) {
		v.visitQuestionMultipleChoice(this);
	}
	
}
