package Aiken;

public interface QuestionVisitor {
	
	public void visitQuestionMultipleChoice(Question q);
	
	public void visitQuestionMatching(Question q);
	
	public void visitQuestionShortResponse(Question q);
	
	public void getFile();
}
