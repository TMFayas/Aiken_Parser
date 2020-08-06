package Aiken;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VisitorXML implements QuestionVisitor {
	private Document document;
	private Element racine;
	
	public VisitorXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			racine = document.createElement("quiz");
			document.appendChild(racine);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void visitQuestionMultipleChoice(Question q) {
			
		Element question = document.createElement("question");
		racine.appendChild(question);
		question.setAttribute("type", "multichoice");
		Element name = document.createElement("name");
		question.appendChild(name);
		Element text = document.createElement("text");
		text.appendChild(document.createTextNode("Question1"));
		name.appendChild(text);
		Element questionText = document.createElement("questiontext");
		question.appendChild(questionText);
		questionText.setAttribute("format", "html");
		Element description = document.createElement("text");
		description.appendChild(document.createCDATASection("<p>"+q.getDescription()+"</p>"));
		questionText.appendChild(description);
		Element single = document.createElement("single");
		single.appendChild(document.createTextNode("false"));
		question.appendChild(single);
		Map<Character,String> responses = q.getResponses();
		List<Character> answers = q.getAnswersQCM();
		int length = answers.size();
		double point = 100.0/length;
		for (Character c : responses.keySet()) {
			Element answer = document.createElement("answer");
			Element answerText = document.createElement("text");
			answerText.appendChild(document.createTextNode(responses.get(c)));
			if(answers.contains(c)) {
				answer.setAttribute("fraction", point+"");
			}
			else {
				answer.setAttribute("fraction", "0");
			}
			answer.setAttribute("format", "html");
			answer.appendChild(answerText);
			question.appendChild(answer);
		}	
		
	}

	@Override
	public void visitQuestionMatching(Question q) {

		Element question = document.createElement("question");
		racine.appendChild(question);
		question.setAttribute("type", "matching");
		Element name = document.createElement("name");
		question.appendChild(name);
		Element text = document.createElement("text");
		text.appendChild(document.createTextNode("Question1"));
		name.appendChild(text);
		Element questionText = document.createElement("questiontext");
		question.appendChild(questionText);
		questionText.setAttribute("format", "html");
		Element description = document.createElement("text");
		description.appendChild(document.createCDATASection("<p>"+q.getDescription()+"</p>"));
		questionText.appendChild(description);
		
		Map<Character, String> left = q.getMatchingResponsesLeft();
		Map<Character, String> right = q.getMatchingResponsesRight();
		Map<Character, Character> answers = q.getAnswersMatching();
		for(Character c : left.keySet()) {
			Element SubQuestion = document.createElement("subquestion");
			question.appendChild(SubQuestion);
			SubQuestion.setAttribute("format", "html");
			if(answers.containsKey(c)) {
				Element leftPart = document.createElement("text");
				leftPart.appendChild(document.createCDATASection("<p>"+left.get(c)+"</p>"));
				SubQuestion.appendChild(leftPart);
				
				Element rightPart = document.createElement("answer");
				Element rightPartText = document.createElement("text");
				rightPartText.appendChild(document.createCDATASection("<p>"+right.get(answers.get(c))+"</p>"));
				rightPart.appendChild(rightPartText);
				SubQuestion.appendChild(rightPart);
			}
		}

	}

	@Override
	public void visitQuestionShortResponse(Question q) {

		Element question = document.createElement("question");
		racine.appendChild(question);
		question.setAttribute("type", "shortanswer");
		Element name = document.createElement("name");
		question.appendChild(name);
		Element text = document.createElement("text");
		text.appendChild(document.createTextNode("Question1"));
		name.appendChild(text);
		Element questionText = document.createElement("questiontext");
		question.appendChild(questionText);
		questionText.setAttribute("format", "html");
		Element description = document.createElement("text");
		description.appendChild(document.createCDATASection("<p>"+q.getDescription()+"</p>"));
		questionText.appendChild(description);
		List<String> answers = q.getAnswersShort();
		System.out.println(answers.size());
		for (String s : answers) {
			Element answer = document.createElement("answer");
			answer.setAttribute("format", "moodle_auto_format");
			answer.setAttribute("fraction", "100");
			Element answerText = document.createElement("text");
			answerText.appendChild(document.createTextNode(s));
			answer.appendChild(answerText);
			question.appendChild(answer);
		}
			

	}
	
	public void getFile() {
		
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult sortie = new StreamResult(new File("file.xml"));
		  //final StreamResult result = new StreamResult(System.out);
				
		  //prologue
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");		
		  		
		  //formatage
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
		  //sortie
			transformer.transform(source, sortie);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		  
	}

}
