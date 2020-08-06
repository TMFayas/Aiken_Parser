package Aiken;

import java.util.List;

public class QuestionShortResponse extends Question {
	
	private List<String> answers;

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	public String toString() {
		return getDescription()+"\n"+getAnswers().toString();
	}
	
	public void accept(QuestionVisitor v) {
		v.visitQuestionShortResponse(this);
	}

	public List<String> getAnswersShort(){
		return getAnswers();
	}

}
