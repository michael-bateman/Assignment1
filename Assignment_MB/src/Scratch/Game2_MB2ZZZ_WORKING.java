package Scratch;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Question;

/**
 * This is a build on my Assignment1 adding GUI support for my game
 * 
 * @author michael.bateman
 *
 */
public class Game2_MB2ZZZ_WORKING {
	
	private JFrame frame = new JFrame("Michael's Chemistry Game");
	
	/*
	private JPanel panelMain = new JPanel() {
		
		public void paint(Graphics g) {
			
			g.fillRect(0,0,500,500);
		}

	};
	*/
	
	

	private JButton b1 = new JButton("A");
	private JButton b2 = new JButton("B");
	private static boolean active = true;
	private static String type = "";
	private static boolean ask = true;
	private static int noquestion = 0;
	private static boolean submit;
	private static String strinput2 = "";
	private static boolean go = true;

	private JButton b3 = new JButton("C");
	private JButton b4 = new JButton("Submit");
	private JButton b5 = new JButton("D");
	private JButton b6 = new JButton("Continue");
	
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea2 = new JTextArea();
	private JTextArea textArea3 = new JTextArea();
	private JTextArea textArea4 = new JTextArea();
	private JTextField textField = new JTextField();
	
	// Action Listener
	
	
	/*
	private JTextField textField = new JTextField();
	private JButton submit = new JButton ("submit");
	private JLabel textLabel = new JLabel();
	*/
	
	
	//Listeners************************************
	//NONE ADDED YET
	
	//Game Variable********************************
	//NO GAME TO SPEAK OF YET
	
	
	//Construtors:
	public Game2_MB2ZZZ_WORKING() {

		//assignment();
		//Action Listeners
		//sets frame location
		
		frame.setLocation(100, 100);
		
		//SetLayoutManager
		frame.setLayout(new GridBagLayout());
		
		/*
		//CODE TO ADD PANEL
		//special object that gives the GUI manager
		//instructions on how to add an object
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 4;
		
		//panelMain.setPreferredSize(new Dimension(500,500));
		
		//frame.add(panelMain,c1);
		 *
		 */
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 1;
		c12.gridy = 3;
		c12.insets = new Insets(10,10,10,10);
		textArea4.setText("Remaining: 0");
		textArea4.setEditable(false);
		textArea4.setBackground(UIManager.getColor ( "frame.background" ));
		frame.add(textArea4, c12);
		
		//Code to add continue button
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 4;
		c11.gridy = 3;
		c11.insets = new Insets(10,10,10,10);
		c11.anchor = GridBagConstraints.CENTER;
		c11.weightx = 1.0;
		b6.setEnabled(false);
		frame.add(b6, c11);
		
		
		
		//Code to add selection item 4
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 4;
		c10.gridy = 2;
		c10.anchor = GridBagConstraints.CENTER;
		c10.weightx = 1.0;
		b5.setEnabled(false);
		frame.add(b5, c10);
		
		 
		//Code to add notice field for selecting the question amount
		
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 0;
		c9.gridy = 4;
		textArea3.setText("Questions:");
		textArea3.setVisible(false);
		textArea3.setEditable(false);
		textArea3.setBackground(UIManager.getColor ( "frame.background" ));
		frame.add(textArea3, c9);
		
		
		/* Code to add input for how many questions */
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 0;
		c8.gridy = 5;
		//c8.gridwidth = 2;
		//c8.anchor = GridBagConstraints.WEST;
		textField.setText("0");
		textField.setVisible(false);
		frame.add(textField, c8);
		
		
		//CODE TO ADD TEXT -WHICH IS QUESTION
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 1;
		c6.gridwidth = 5;
		c6.anchor = GridBagConstraints.WEST;
		//c6.ipady = 50;
		c6.insets = new Insets(10,10,10,10);
		//textLabel.setBounds(50, 50, 100, 100)
		
		//textLabel.setText("Test");
		textArea.setText("Test2");
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor ( "frame.background" ));
		frame.add(textArea, c6);
		
		//CODE TO ADD SCORE
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 2;
		c7.gridy = 3;
		
		//c7.gridwidth = 1;
		//c7.anchor = GridBagConstraints.EAST;
	
		c7.insets = new Insets(10,10,10,10);
		textArea2.setText("Score: 0");
		textArea2.setEditable(false);
		textArea2.setBackground(UIManager.getColor ( "frame.background" ));
		frame.add(textArea2, c7);
		
		//CODE TO ADD BUTTON 1
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.anchor = GridBagConstraints.CENTER;
		c2.weightx = 1.0;
		/*
		 * We set the text by using the following
		 */
		//b1.setText("PoopyPants");
	
		frame.add(b1,c2);
		
		//CODE TO ADD BUTTON 2
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 2;
		c3.anchor = GridBagConstraints.CENTER;
		c3.weightx = 1.0;
		
		frame.add(b2,c3);

		//CODE TO ADD BUTTON 3
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 2;
		c4.gridy = 2;
		c4.anchor = GridBagConstraints.CENTER;
		c4.weightx = 1.0;
		
		frame.add(b3,c4);
		
		
		//CODE TO ADD SUBMIT BUTTON
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 5;
		c5.anchor = GridBagConstraints.WEST;
		c5.weightx = 1.0;
		b4.setText("Continue");
		b4.setVisible(false);
		
		frame.add(b4,c5);
		
		
	
		//FINALIZE FRAME SETUP
		frame.setResizable(true);
		//frame.pack(); //packs all the elements so it sets the size of the screen automatically
		frame.setSize(550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public static void waiTing(int mseconds) {
		try {
			Thread.sleep(mseconds);
		} catch(Exception h) {
			System.out.println("ERROR");
		}
	}
	
	public static String[] setQuestionBank(String type) {
		
		
		final String[] inputdata = new String[3];
		
		/*
		 * We use the inputdata array to store important information about each file as follows:
		 * [0] - the name of plain text file with the questions
		 * [1] - the question that is asked
		 * [2] - if there is a "unit" such as kg or cm, if there is no unit, do not declare it at all.
		 */
		
		if (type.equals("A")) {
			inputdata[0] = "data2";
			inputdata[1] = "What is the element symbol with the name";
		} else if (type.equals("B")) {
			inputdata[0] = "data";
			inputdata[1] = "What is the element with atomic number";
		} else if (type.equals("C")) {
			inputdata[0] = "data3";
			inputdata[1] = "What is the molar mass of the element";
			inputdata[2] = "g";
		} else {
			System.out.println("ERROR");
		}
		
		/*
		 * We do not want the program to leave the empty elements as null so we change them to blank ("")
		 */
		if (inputdata[2] == null) {
			inputdata[2] = "";
		}
		
		return inputdata;
	}
	/*
	 * Not working - was going to be a method that could set the buttons to active or false
	private static void setButtonsEnabled(boolean set) {
		Game2_MB2ZZZ game2 = new Game2_MB2ZZZ();
		Game2_MB2().game2.b1.setEnabled(set);
		game2.b2.setEnabled(set);
		game2.b3.setEnabled(set);
	}
	*/
	public static void Game2_MB2() {
		Game2_MB2ZZZ_WORKING game2 = new Game2_MB2ZZZ_WORKING();
		
		game2.textArea.setText("Welcome to Michael's Chemistry Game\n\nWhat would you like to quiz yourself on?\nA) Element Symbols from their Element Names (Easy)\nB) Element Names from their Atomic Numbers (Hard)\nC) Atomic Mass from Element Names (Very Hard)");
		/*
		game2.b1.setText("A");
		game2.b2.setText("B");
		game2.b3.setText("C");
		*/
		
		
		
		game2.b1.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){  
				 
				 if(active) {
					 type = "A";
				 }
				 active = false;
			 }  
		 });
		game2.b2.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){ 
				 if (active) {
					 type = "B";
				 }
				 active = false;
			 }  
		 });
		game2.b3.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){
				 if (active) {
					 type = "C";
				 }
				 active = false;
				 
			 }  
		 });
		while (active) {
			System.out.println("WAITING FOR USER");
		}
		//game2.textArea.setText("TESTING...");
		//System.out.println(game2.b1.getAction());
		
		System.out.println(type);
		
		/*
		final int amount = 10; // amount of starts
		System.out.print("Do not forget: Type the multiple choice answer letter NOT the actual answer\nExample: A) H, you would type A NOT H\nLoading:");
		for (int f = 0; f < amount; f++) {
			System.out.print("* ");
			loaDing();
		*/
		
		final String[] inputdata = setQuestionBank(type);
		
		game2.b1.setEnabled(false);
		game2.b2.setEnabled(false);
		game2.b3.setEnabled(false);
		
		game2.textArea.setText("Welcome!\nWhen a question appears, click the button corresponding to the correct answer\nExample: A) Hydrogen, you would click button 'A'\nLoading ");
		for (int x = 0; x < 15; x++) {
			game2.textArea.append("* ");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("WAITING ERROR");
			}
		}
		
		//System.out.println("TEST");
		game2.textField.setVisible(true);
		game2.textArea3.setVisible(true);
		game2.b4.setVisible(true);
		//game2.textField.setColumns(50);
		
		/*
		 * The following two lines of code make repaint the frame so it will show my textField
		 * Source - https://stackoverflow.com/questions/20922442/hide-show-jtextfield
		 */
		game2.frame.revalidate();
		game2.frame.repaint();
		
		// ADDED FOR TESTING 
		
		Question q = new Question(inputdata[0]);
		
		
		String[] question = q.getQuestion(); // gets the questions from the Question class
		String[] answer = q.getAnswer(); // gets the answers from the Answer class
		final String[] answerselect = {"A","B","C","D"}; // used for randomizing the multiple choice answers and selections, we put the variable as final so they cannot 
		
		/* Used for testing purposes to see if the questions were being summoned correctly
		for (int testing = 0; testing < question.length; testing++) {
			System.out.println(question[testing]);
		}
		*/
		
		/*
		 * This scanner should be removed in the future
		 */
		//Scanner s = new Scanner(System.in);
		
		//String strinput = "A"; // sets the input to "A" so the invalid answer conditional statement does not work
		int score = 0; // sets your score to 0
		int grandom = 0; // used for selecting a random question
		int arandom = 0; // for choosing shuffle order of responses
		double scorepercent = 0.0; // sets your score to 0 - note, it's a double
		int questioncount = 0; // this is the question number to be used as a question header
		int reviewcount = 0;
		int random = 0;
		boolean add = true;
		
		/*
		 * This do while loop selects how many questions you would like to answer
		 */
		
		game2.textArea.setText("Please enter below how many questions you would like\nYou may enter a number from 1 - " + question.length);
		
		game2.b4.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){  
				 
				 if (ask) {
					 try {
						 if(Integer.valueOf(game2.textField.getText()) > 0 && Integer.valueOf(game2.textField.getText()) <= question.length) {
							 noquestion = Integer.valueOf(game2.textField.getText());
							 System.out.println(noquestion);
							 ask = false;
						 } else {
							 game2.textArea.append("\nINVALID ENTRY");
							 game2.b4.setBackground(Color.RED);
							 game2.b4.setOpaque(true);
						 }
					 } catch(Exception f) {
						 game2.textArea.append("\nINVALID ENTRY");
						 game2.b4.setBackground(Color.RED);
						 game2.b4.setOpaque(true);
					 }
				 }
				 //active = false;
			 }  
		 });
		
		while (ask) {
			System.out.println("WAITING FOR USER");
		}
		
		/*
		 * This resets the color of the frame when you've inputted a wrong answer
		 * Source - https://stackoverflow.com/questions/9991204/get-default-background-color-of-swing-component
		 */
		
		//game2.frame.getContentPane().setBackground(UIManager.getColor ( "game2.frame.background" ));
		game2.b4.setBackground(UIManager.getColor ( "game2.b4.background" ));
		
		final int intinput = noquestion;
		System.out.println(intinput);
		
		/* No longer needed as we don't take inputs from the command line
		do {
			if (intinput <= 0 || intinput > question.length) { // if statement to check to see if the input is invalid
				System.out.println("Invalid Answer... Please try again");
			}
			System.out.print("How many questions would you like to answer? (1 - " + question.length + "): ");
			intinput = s.nextInt(); // takes an int input
		} while (intinput <= 0 || intinput > question.length); // if the statement is invalid
		*/
		
		/*
		 * reviewquestion[] - used for adding the questions that were incorrectly answered
		 * reviewanswer[] - used for adding the answers that were incorrectly answered
		 * reviewyourchoice[] - used for adding the answers that were incorrectly answered
		 */
		
		/*
		 * The following arrays are used to for purposes at the end of the game for going over the wrong answers
		 */
		
		String[] reviewquestion = new String[intinput];
		String[] reviewanswer = new String[intinput];
		String[] reviewyourchoice = new String[intinput];
		
		/*
		 * Hides the select amount of questions fields
		 */
		game2.textField.setVisible(false);
		game2.textArea3.setVisible(false);
		game2.b4.setVisible(false);
		
		/*
		 * This question loop will go as many times as pre-selected for the questions. Each time this loop runs, it will move on to a new question
		 */
		for (int i = 0; i < intinput; i++) {
			
			game2.textArea4.setText("Remaining: " + (intinput-i));
			
			/*
			 * This do while loop will select a random question and will check to make sure that the question has not been used yet, using a null check
			 */
			do {
				grandom = (int)(Math.random() * question.length); // selects a random int to choose from the array
			} while (question[grandom] == null); // this will check to see if the question has already been used
			
			String[] answersolutions = new String[4]; //4 is the amount of MC responses
			answersolutions[0] = answer[grandom]; // will automatically put the corresponding question answer into the multiple choice array for checking
			
			/*
			 * This will get random answers for the multiple choice answers
			 * NOTE: we start at index 1 because we have already added the real answer above
			 */
			for (int a = 1; a < answersolutions.length; a++) {
				
				add = true; // we always assume that we will add the answer unless if we find otherwise, it resets every time we go through this loop
				random = (int)(Math.random() * answer.length); // this will get a random answer
				
				/*
				 * This loop checks to see if the answer is already in the multiple choice answer array  
				 */
				for (int b = 0; b < answersolutions.length; b++) {
					if (answer[random].equals(answersolutions[b])) {
						add = false;
						a = a-1;
					}
				}
				
				/*
				 * If the above does not turn to false - i.e. it finds that the answer is not already in the array, it will add it into the array below
				 */
				if (add == true) {
					answersolutions[a] = answer[random];
				}
			}
			
			questioncount++; // this variable is used for the question numbering below
			
			/*
			 * Below, we print out the question number and the actual question.
			 * RECALL:
			 * inputdata[1] - this is the question, for example, "What is the capital of..."
			 * question[grandom] - this is the actual data for the question "Canada"
			 * 
			 * So, this would make the output "What is the capital of Canada?"
			 */
			game2.textArea.setText("Question #" + questioncount + ":");
			game2.textArea.append("\n" + inputdata[1] + " " + question[grandom] + "?");
			
			
			String[] answersolutionsfinal = new String[4]; // this is the final array where we will randomize the answers that we just picked...
			String letteranswer = ""; // this is the variable for the answer letter, so A,B,C or D
			
			/*
			 * This loop randomly randomizes the array for the multiple choice answers
			 * We can choose the random numbers because by getting random numbers
			 */
			for (int c = 0; c < answersolutions.length; c++) {
				
				/*
				 * This do while loop will check to see if the answer has already been randomized using a null check
				 */
				do {
					arandom = (int)(Math.random() * answersolutions.length);
				} while (answersolutions[arandom] == null);
				
				/*
				 * This if statement check to see if the random answer is the real answer
				 * If it is the real answer, it will set the letter answer to either A,B,C, or D
				 */
				if (arandom == 0) {
					letteranswer = answerselect[c];
				}
				
				answersolutionsfinal[c] = answersolutions[arandom]; //this will add a random solution into the array
				answersolutions[arandom] = null; // will now set the old element to null so it can no longer be selected
			}
			//Adds the answers to the screen
			game2.textArea.append("\nA) " + answersolutionsfinal[0] + inputdata[2] + "\nB) " + answersolutionsfinal[1] + inputdata[2] + "\nC) " + answersolutionsfinal[2] + inputdata[2] + "\nD) " + answersolutionsfinal[3] + inputdata[2]);
			
			/*
			 * Reinables the buttons so they are clickable
			 */
			game2.b1.setEnabled(true);
			game2.b2.setEnabled(true);
			game2.b3.setEnabled(true);
			game2.b5.setEnabled(true);
			
			submit = true;
			
			game2.b1.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "A";
					 }
					 submit = false;
					 
				 }  
			});
			
			game2.b2.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "B";
					 }
					 submit = false;
				 }  
			});
			
			game2.b3.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "C";
					 }
					 submit = false;
					 
				 }  
			});
			
			game2.b5.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "D";
					 }
					 submit = false;
					 
				 }  
			});
			while (submit) {
				System.out.println("WAITING FOR USER");
			}
			
			final String strinput = strinput2;

			/*
			 * This do while loop will do the following:
			 * 1. check to make sure the input is valid A-D
			 * 2. Will write out the multiple choice possible answers
			 * inputdata[2] - this is if there is a "unit" associated
			 */
			/*
			do {
				if (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.println("A) " + answersolutionsfinal[0] + inputdata[2] + "\nB) " + answersolutionsfinal[1] + inputdata[2] + "\nC) " + answersolutionsfinal[2] + inputdata[2] + "\nD) " + answersolutionsfinal[3] + inputdata[2]);
				System.out.print("Answer: ");
				strinput = s.next().toUpperCase(); // NOTE: we use .toUpperCase() to automatically set all input takes to uppercase
			} while (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D"));
			*/
			
			/*
			 * The following statements will check to see if the input from the user is correct
			 */
			
			/*
			 * The following will make the correct answer highlight green
			 */
			
			if (letteranswer.equals("A")) {
				game2.b1.setBackground(Color.GREEN);
				
			} else if (letteranswer.equals("B")) {
				game2.b2.setBackground(Color.GREEN);
				
			} else if (letteranswer.equals("C")) {
				game2.b3.setBackground(Color.GREEN);
				
			} else {
				game2.b5.setBackground(Color.GREEN);
				
			}
			game2.b1.setOpaque(true);
			game2.b2.setOpaque(true);
			game2.b3.setOpaque(true);
			game2.b5.setOpaque(true);
			
			/*
			 * This conditional checks to do the following:
			 * 1. Correct Answer
			 * 2. If incorrect, will add the question and answer to be reviewable at a later time
			 */
			if (strinput.equals(letteranswer)) { // if the answer correct
				score++; // will increase the score by 1
				game2.textArea2.setText("Score: " + score);
			} else { // if the answer is incorrect 
				if (strinput.equals("A")) {
					game2.b1.setBackground(Color.RED);
					
				} else if (strinput.equals("B")) {
					game2.b2.setBackground(Color.RED);
					
				} else if (strinput.equals("C")) {
					game2.b3.setBackground(Color.RED);
					
				} else {
					game2.b5.setBackground(Color.RED);
					
				}
				//System.out.print("Incorrect! The correct answer was " + letteranswer + "!"); // will tell the user what the correct answer is
				/*
				 * Will set the following elements to be able to be reviewed at the end of the game
				 */
				reviewquestion[i] = question[grandom];
				reviewanswer[i] = answer[grandom];
				/*
				 * This loop will check what the user entered and will add their wrong answer to be reviewed later
				 */
				for (int d = 0; d < answersolutions.length; d++) {
					if (strinput.equals(answerselect[d])) {
						reviewyourchoice[i] = answersolutionsfinal[d];
						d = answersolutions.length; // this will end the loop without using break
					}
				} 
			}
			
			game2.b1.setEnabled(false);
			game2.b2.setEnabled(false);
			game2.b3.setEnabled(false);
			game2.b5.setEnabled(false);
			
			if (i == intinput-1 && score < intinput) {
				game2.b6.setText("Review Answers");
			}
			
			go = true;
			game2.b6.setEnabled(true);
			game2.b6.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (go) {
						 game2.b6.setEnabled(false);
						 game2.b1.setBackground(UIManager.getColor ( "game2.b1.background" ));
						 game2.b2.setBackground(UIManager.getColor ( "game2.b1.background" ));
						 game2.b3.setBackground(UIManager.getColor ( "game2.b1.background" ));
						 game2.b5.setBackground(UIManager.getColor ( "game2.b1.background" ));
					 }
					 go = false;
					 
				 }  
			});
			
			while (go) {
				System.out.println("WAITING FOR USER");
			}
			
			
			
			
			// the following if statement will run if it is not the last time through the game
			/*
			if (i != intinput-1) {
				System.out.println(" Your score is " + score);
			}
			*/
			question[grandom] = null; // we need to set null to the question so it can no longer be asked
			
			
			
		} //end question/game loop
		
		scorepercent = Math.round(((double)(score)/intinput) * 10000.0)/100.0; // calculates the percent and rounds the percent to 2 decimals
		System.out.println("\nYou got " + scorepercent + "% of the questions correct"); // will tell you your percentage of correct questions
		
		/*
		 * The questions that were answered incorrectly can be reviewed here
		 * NOTE: This option will not show if all answers are answered correctly, we can verify this by using a conditional statement
		 */
		
		if (score != intinput) {
			game2.b6.setText("Continue");
			
			////strinput = "Y"; // we set the input to "Y" so it does not go through the invalid answer conditional
			
			/*
			 * Do while loop to ask if the user would like to review their questions
			 */
			/*
			do {
				if (!strinput.equals("Y") && !strinput.equals("N")) { // invalid answer conditional
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.print("Would you like to review your incorrect questions? (Y/N) ");
				strinput = s.next().toUpperCase();
			} while (!strinput.equals("Y") && !strinput.equals("N"));
			*/
			
			//if (strinput.equals("Y")) { // checks the input to see what the person chose
			
			/*
			 * This for loop does the following
			 * 1. Prints out the question that was incorrect
			 * 2. Prints out the correct answer
			 * 3. Prints out the incorrect answer that they chose
			 * 
			 * The user can press any key to continue.
			 */
			
			for (int e = 0; e < reviewquestion.length; e++) {
				reviewcount++;
				if (reviewquestion[e] != null) {
					game2.textArea.setText("Review #" + reviewcount + ": " + inputdata[1] + " " +  reviewquestion[e] + "?\nAnswer: " + reviewanswer[e] + inputdata[2] + "\nYou chose: " + reviewyourchoice[e] + inputdata[2]);
					go = true;
					game2.b6.setEnabled(true);
					game2.b6.addActionListener(new ActionListener(){
						 
						 public void actionPerformed(ActionEvent e){
							 if (go) {
								 game2.b6.setEnabled(false);
							 }
							 go = false;
							 
						 }  
					});
					
					while (go) {
						System.out.println("WAITING FOR USER");
					}
					/*
					System.out.print("Press any key to continue: ");
					strinput = s.next(); // just acts as a wait
					*/
				} else {
					reviewcount = reviewcount - 1;
				}
			} // end for
		}
		
		game2.textArea.setText("THANKS FOR PLAYING! HAVE A GOOD DAY\n\nPlease re-run the game to play again!");
		try {
			Thread.sleep(5000);
		} catch(Exception f ) {
			System.out.println("ERROR");
		}
		game2.frame.dispose();
		
	} // end answer review
	

	public static void main(String[] args) {
		Game2_MB2();
		System.out.println("END OF GAME");
		
	} // end main
	
}