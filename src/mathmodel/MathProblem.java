package mathmodel;
/* File: MathProblem.java
 * Course: CST8288
 * Lab Section: All
 * Author: Stanley Pieda
 * Date: Sept 2015
 */
import java.util.Scanner;
import java.util.Random;

/**
 * Represents an addition math problem
 * @author Stan Pieda
 */
public class MathProblem{
	
	/**
	 * Represents left hand operand of an equation
	 */
	private int operand1;
	
	/**
	 * Represents right hand operand of an equation
	 */
	private int operand2;
	
	/**
	 * Stores an attempted answer
	 */
	private int userAnswer;
	
	/**
	 * Initializes MathProblem by setting operand1 and 
	 * operand2 to a random integer number from 1 to 100
	 * Caution: Needs to be fixed if initializing an array
	 * of MathProblems with a loop.
	 */
	public MathProblem(){
		Random random = new Random();
		this.operand1 = random.nextInt(100) + 1; // 1 to 100
		this.operand2 = random.nextInt(100) + 1; // 1 to 100
	}
	
	/**
	 * Simple getter for operand1
	 * @return the int value stored inside operand1
	 */
	public int getOperand1(){
		return operand1;
	}
	
	/**
	 * Simple setter for operand1, ignores values outside
	 * of range 1 to 100 (inclusive)
	 * @param operand1 an int value
	 */
	public void setOperand1(int operand1){
		if(operand1 >= 1 && operand1 <= 100){
		    this.operand1 = operand1;
		}
	}
	
	/**
	 * Simple getter for operand2
	 * @return the int value stored inside operand2
	 */
	public int getOperand2(){
		return operand2;
	}
	
	/**
	 * Simple setter for operand2, ignores values outside
	 * of range 1 to 100 (inclusive)
	 * @param operand2 an int value
	 */
	public void setOperand2(int operand2){
		if(operand2 >= 1 && operand2 <= 100){
		    this.operand2 = operand2;
		}
	}
	
	/**
	 * Returns an answer based on adding the two operand values
	 * @return
	 */
	public int getAnswer(){
		return getOperand1() + getOperand2();
	}
	
	/**
	 * Simple getter for userAnswer
	 * @return int value within userAnswer
	 */
	public int getUserAnswer(){
		return userAnswer;
	}
	
	/**
	 * Simple setter for 
	 * @param userAnswer
	 */
	public void setUserAnswer(int userAnswer){
		this.userAnswer = userAnswer;
	}
	
	/**
	 * Generates and returns
	 * a user-readable math problem for
	 * addition.
	 * @return MathProblem question
	 */
	public String getQuestionText(){
		StringBuilder builder = new StringBuilder();
		builder.append(getOperand1())
		    .append(" + ")
		    .append(getOperand2())
		    .append(" is ?");
		return builder.toString();
	}
	
	/**
     * Generates and returns
     * a user-readable math problem for
     * addition, including answer and feedback.
     * @return MathProblem question with answer and feedback
     */
	public String getQuestionTextWithFeedback(){
		StringBuilder builder = new StringBuilder();
		builder.append(getOperand1())
		    .append(" + ")
		    .append(getOperand2())
		    .append(" is ? ")
		    .append(getAnswer())
		    .append(" Your answer: ").append(getUserAnswer());
		if(getUserAnswer() == getAnswer()){
			builder.append(" is correct");
		}
		else{
			builder.append(" is not correct");
		}
		return builder.toString(); 
	}
	
//	public static void main(String[] args){
//		MathProblem problem = new MathProblem();
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println(problem.getQuestionText());
//		problem.setUserAnswer(input.nextInt());
//		
//		System.out.println(problem.getQuestionTextWithFeedback());
//	}
}
