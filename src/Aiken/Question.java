package Aiken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Question {
	private String description;
	private int point;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String toString() {
		return description;
	}
	
	public List<Character> getAnswersQCM(){
		return new ArrayList<Character>();
	}  
	
	public List<String> getAnswersShort(){
		return new ArrayList<String>();
	}
	public Map<Character,Character> getAnswersMatching(){
		return new HashMap<Character,Character>();
	}
	public Map<Character, String> getMatchingResponsesRight(){
		return new HashMap<Character,String>();
	}
	public Map<Character, String> getMatchingResponsesLeft(){
		return new HashMap<Character,String>();
	}
	public Map<Character, String> getResponses(){
		return new HashMap<Character, String>();
	}
	
	public void accept(QuestionVisitor v) {
		
	}

}
