package mathview;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mathmodel.MathProblem;
public class MathViewer extends JFrame{

	 private MathProblem problem = new MathProblem();
	 private JTextField questionTextField = new JTextField();
	 private JTextField userAnswerTextField = new JTextField();
	 private JTextField feedbackTextField = new JTextField();
	 
	 
	 public MathViewer(){
		 super("Math Practice"); // set title
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 JPanel MathPractice = new JPanel(new GridLayout(7,1)); 
		 
		 MathPractice.add(new JLabel("Question"));		 
		 questionTextField.setEditable(false);
		 MathPractice.add(questionTextField);
		 
		 MathPractice.add(new JLabel("Your Answer"));
		 MathPractice.add(userAnswerTextField);
		 
		 MathPractice.add(new JLabel("Feedback"));
		 feedbackTextField.setEditable(false);
		 MathPractice.add(feedbackTextField);
		 
		 JButton checkAnswerButton = new JButton("Check Answer");
		 checkAnswerButton.addActionListener(new ActionListener(){
			
			 @Override
			public void actionPerformed(ActionEvent e) {
				checkAnswer();				
			}			 
		 });
		 
		 JButton AnotherQuestionButton = new JButton("Another Question");
		 AnotherQuestionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				anotherQuestion();
			}
		});
		 
		 JPanel buttons = new JPanel();
		 buttons.add(checkAnswerButton);
		 buttons.add(AnotherQuestionButton);
		 
		 MathPractice.add(buttons);
		 
		 this.getContentPane().add(MathPractice);
		 this.pack();
		 this.setVisible(true);
		 
		 anotherQuestion();
	 }
	 
	 
	 public void checkAnswer(){
		try{
		 problem.setUserAnswer(
				 Integer.parseInt(userAnswerTextField.getText()));
		 feedbackTextField.setText(problem.getQuestionTextWithFeedback());
		}catch (NumberFormatException e){
			String message = "Please enter an integer number";
			String title = "incorrect format for entry";
			JOptionPane.showMessageDialog(this, 
					message, title, JOptionPane.ERROR_MESSAGE);
			userAnswerTextField.requestFocusInWindow();
			userAnswerTextField.selectAll();
		}
	 }

	 
	 public void anotherQuestion(){
		 problem = new MathProblem();
		 questionTextField.setText(problem.getQuestionText());
		 userAnswerTextField.setText(new String());
		 feedbackTextField.setText(new String());
	 }
	 
	 
}
