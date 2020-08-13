package Aiken;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class VisitorLaTex implements QuestionVisitor {
	
	private String res = "";
	
	public VisitorLaTex() {
		res = "\\documentclass{article}\n\\usepackage[utf8]{inputenc}\n" + 
				"\\usepackage[french]{babel}\n\\newenvironment{qcm}{Question (QCM)}{}\r\n" + 
				"\\newenvironment{answer}{\\begin{enumerate}}{\\end{enumerate}}\r\n" + 
				"\\newenvironment{qmatch}{Question (Association)}{}\r\n" + 
				"\\newenvironment{qshort}{Question (Reponse courte)}{}\r\n" + 
				"\r\n" + 
				"\\begin{document}\r\n";
	}
	
	public void visitQuestionMultipleChoice(Question q) {
		res += "\\begin{qcm}\n" + q.getDescription()
				+ "\\begin{answer}\n";
		
		Map<Character,String> responses = q.getResponses();
		for(Character c : responses.keySet()) {
			res += "\\item "+responses.get(c)+"\\\\\n";
		}
		res += "\\end{answer}\n\\end{qcm}"+"\n";
	}

	
	public void visitQuestionMatching(Question q) {
		res += "\\begin{qmatch}\n" + q.getDescription()+"\\\\" +"\\begin{tabular}{ll}\n";
		
		Map<Character, String> left = q.getMatchingResponsesLeft();
		Map<Character, String> right = q.getMatchingResponsesRight();
		String[] leftResponses = {};
		leftResponses = left.values().toArray(leftResponses);
		String[] rightResponses = {};
		rightResponses = right.values().toArray(rightResponses);
		for(int i = 0; i<left.size();i++) {
			res += leftResponses[i] + "&" + rightResponses[i]+" \\\\ \n";
		}
		res += " \\end{tabular}\r\n" + 
				"\\end{qmatch}"+"\\\\\n";

	}

	
	public void visitQuestionShortResponse(Question q) {
		res += "\\begin{qshort}\n" + q.getDescription()
				+"\\\\"+ "............................................"
				+"\\end{qshort}"+"\\\\\n";

	}

	
	public void getFile(String name) {
		res += "\\end{document}";
		try {
			FileWriter file = new FileWriter(name);
			file.write(res);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
