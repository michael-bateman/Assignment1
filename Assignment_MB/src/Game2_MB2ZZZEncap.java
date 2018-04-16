import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * This is a build on my Assignment1 adding GUI support for my game
 * Errors:
 * 1. The screen has a weird screen animation when loading a new image
 * 2. The following elements pictures do not show up and will show up as a triangle:
 * 		a. Ununhexium
 * 		b. Wolfram
 * 		c. Ununquadium
 * 
 * @author michael.bateman
 *
 */
public class Game2_MB2ZZZEncap {
	
	/*
	 * Our JFrame - this is the main frame of the game
	 * Everything else is essentially "added" on to the frame
	 */
	
	private JFrame frame = new JFrame("Michael's Chemistry Game");
	
	/*
	 * Buttons - these are used for various uses outlined below:
	 * 
	 * Multiple choice buttons:
	 * b1 - submit "A"
	 * b2 - submit "B"
	 * b3 - submit "C"
	 * b5 - submit "D"
	 * 
	 * Other:
	 * b4 - used for input to get the amount of questions
	 * b6 - used in the program to "continue" to the next question
	 */
	
	private JButton b1 = new JButton("A");
	private JButton b2 = new JButton("B");
	private JButton b3 = new JButton("C");
	private JButton b4 = new JButton("Submit");
	private JButton b5 = new JButton("D");
	private JButton b6 = new JButton("Continue");
	
	/*
	 * Global variables that are used throughout the program
	 * Many of them are simply just to wait for a user to respond to an input
	 */
	
	private static boolean active = true;
	private static String type = "";
	private static boolean ask = true;
	private static int noquestion = 0;
	private static boolean submit;
	private static String strinput2 = "";
	private static boolean go = true;

	/*
	 * The following are JText things
	 * textArea - where the questions and their multiple choice answers are displayed
	 * textArea2 - score
	 * textArea3 - title to ask for how many questions are desired
	 * textArea4 - questions remaining
	 */
	
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea2 = new JTextArea();
	private JTextArea textArea3 = new JTextArea();
	private JTextArea textArea4 = new JTextArea();
	private JTextField textField = new JTextField();
	
	/*
	 * The following is used to get my images to display
	 * Note: Should something fail, an error image is displayed
	 */
	private JLabel imgarea = new JLabel();
	private ImageIcon imgicon = new ImageIcon("images/error.png");
	private GridBagConstraints c13 = new GridBagConstraints();
	
	/* SOME WORK THAT I DID AT THE START
	private JTextField textField = new JTextField();
	private JButton submit = new JButton ("submit");
	private JLabel textLabel = new JLabel();
	*/
	
	private Game2_MB2ZZZEncap() {
		

		// Set's the location of the frame on the screen
		frame.setLocation(100, 100);
		
		//Set's the Layout Manager which is GridBag Layout
		frame.setLayout(new GridBagLayout());
		
		//Button "A"
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.anchor = GridBagConstraints.CENTER;
		c2.weightx = 1.0;
	
		frame.add(b1,c2);
		
		//Button "B"
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 2;
		c3.anchor = GridBagConstraints.CENTER;
		c3.weightx = 1.0;
		
		frame.add(b2,c3);
		
		//Button "C"
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 2;
		c4.gridy = 2;
		c4.anchor = GridBagConstraints.CENTER;
		c4.weightx = 1.0;
		
		frame.add(b3,c4);
		
		//Button "D"
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 4;
		c10.gridy = 2;
		c10.anchor = GridBagConstraints.CENTER;
		c10.weightx = 1.0;
		
		b5.setEnabled(false);
		
		frame.add(b5, c10);
		
		// The button to "continue"
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 4;
		c11.gridy = 3;
		c11.insets = new Insets(10,10,10,10);
		c11.anchor = GridBagConstraints.CENTER;
		c11.weightx = 1.0;
		
		b6.setEnabled(false);
		
		frame.add(b6, c11);
		
		// Shows the questions that remain
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 1;
		c12.gridy = 3;
		c12.insets = new Insets(10,10,10,10);
		
		textArea4.setText("Remaining: 0");
		textArea4.setEditable(false);
		textArea4.setBackground(UIManager.getColor ( "frame.background" ));
		
		frame.add(textArea4, c12);
		
		// Title for asking for questions
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 0;
		c9.gridy = 4;
		
		textArea3.setText("Questions:");
		textArea3.setVisible(false);
		textArea3.setEditable(false);
		textArea3.setBackground(UIManager.getColor ( "frame.background" ));
		
		frame.add(textArea3, c9);
		
		
		// Text box when asking for number of questions
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 0;
		c8.gridy = 5;
		//c8.gridwidth = 2;
		//textField.setPreferredSize(10);
		textField.setColumns(5);
		
		textField.setText("0");
		textField.setVisible(false);
		
		frame.add(textField, c8);
		
		
		// Main text/Question field
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 1;
		c6.gridwidth = 5;
		c6.anchor = GridBagConstraints.WEST;
		c6.insets = new Insets(10,10,10,10);
		
		textArea.setText("Test2");
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor ( "frame.background" ));
		
		frame.add(textArea, c6);
		
		// Score text
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 2;
		c7.gridy = 3;
		c7.insets = new Insets(10,10,10,10);
		
		textArea2.setText("Score: 0");
		textArea2.setEditable(false);
		textArea2.setBackground(UIManager.getColor ( "frame.background" ));
		
		frame.add(textArea2, c7);
		
		// Submit button for the amoutn of questions
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 5;
		c5.anchor = GridBagConstraints.WEST;
		c5.weightx = 1.0;
		b4.setText("Continue");
		b4.setVisible(false);
		
		frame.add(b4,c5);
		
		// Image
		c13.gridx = 0;
		c13.gridy = 0;
		c13.gridwidth = 5;
		c13.anchor = GridBagConstraints.CENTER;
		imgarea.setSize(300, 300);

		imgarea = new JLabel(imgicon);
		frame.add(imgarea, c13);
		
		// Finalizing frame setup
		frame.setResizable(true);
		
		//frame.pack(); //packs all the elements so it sets the size of the screen automatically
		
		frame.setSize(550, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/**
	 * Takes the input and finds the question bank from which we are using
	 * @param type
	 * @return
	 */
	private static String[] setQuestionBank(String type) {
		
		
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
	
	/**
	 * This takes two parameters and finds the corresponding image for the element
	 * @param element
	 * @param inputdata
	 * @return
	 */
	
	private static String getImage(String element, String inputdata) {
		String[] nums = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118"};
		String[] names = {"Hydrogen","Helium","Lithium","Beryllium","Boron","Carbon","Nitrogen","Oxygen","Fluorine","Neon","Sodium","Magnesium","Aluminum","Silicon","Phosphorus","Sulfur","Chlorine","Argon","Potassium","Calcium","Scandium","Titanium","Vanadium","Chromium","Manganese","Iron","Cobalt","Nickel","Copper","Zinc","Gallium","Germanium","Arsenic","Selenium","Bromine","Krypton","Rubidium","Strontium","Yttrium","Zirconium","Niobium","Molybdenum","Technetium","Ruthenium","Rhodium","Palladium","Silver","Cadmium","Indium","Tin","Antimony","Tellurium","Iodine","Xenon","Cesium","Barium","Lanthanum","Cerium","Praseodymium","Neodymium","Promethium","Samarium","Europium","Gadolinium","Terbium","Dysprosium","Holmium","Erbium","Thulium","Ytterbium","Lutetium","Hafnium","Tantalum","Tungsten","Rhenium","Osmium","Iridium","Platinum","Gold","Mercury","Thallium","Lead","Bismuth","Polonium","Astatine","Radon","Francium","Radium","Actinium","Thorium","Protactinium","Uranium","Neptunium","Plutonium","Americium","Curium","Berkelium","Californium","Einsteinium","Fermium","Mendelevium","Nobelium","Lawrencium","Rutherfordium","Dubnium","Seaborgium","Bohrium","Hassium","Meitnerium","Darmstadtium","Roentgenium","Copernicium","Ununtrium","Flerovium","Ununpentium","Ununhexium","Ununseptium","Ununoctium"};
		String[] replace1 = {"Ununpentium","Ununtrium","Ununseptium","Ununoctium","Livermorium","Flerovium","Tungsten"};
		String[] replace2 = {"Moscovium","Nihonium", "Tennessine","Oganesson","Ununhexium","Ununquadium","Wolfram"};
		String name = "";
		String element2 = element.replaceAll(" ", "");
		
		for (int d = 0; d < replace1.length; d++) {
			if (element2.contains(replace2[d])) {
				element2.replace(replace2[d], replace1[d]);
			}
		}
		
		
		if (inputdata.equals("data")) {
			for (int a = 0; a < names.length; a++) {
				if (element2.equals(nums[a])) {
					name = nums[a] + "-" + names[a] + "-Tile.png";
				}
			}
		} else if (inputdata.equals("data2") || inputdata.equals("data3")) {
			for (int a = 0; a < names.length; a++) {
				if (element2.equals(names[a])) {
					name = nums[a] + "-" + names[a] + "-Tile.png";
				}
			}
		} else {
			System.out.println("COULDNT FIND THE ITEM");
			name = "error.png";
		}
		
		
		if (name.equals("")) {
			name = "error.png";
		} else if (name.contains(" ")) {
			name.replace(" ", "");
		}
		
		return name;
	}
	
	/**
	 * Finds a random image for display
	 * @return
	 */
	private static String randomImage() {
		String[] nums = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118"};
		String[] names = {"Hydrogen","Helium","Lithium","Beryllium","Boron","Carbon","Nitrogen","Oxygen","Fluorine","Neon","Sodium","Magnesium","Aluminum","Silicon","Phosphorus","Sulfur","Chlorine","Argon","Potassium","Calcium","Scandium","Titanium","Vanadium","Chromium","Manganese","Iron","Cobalt","Nickel","Copper","Zinc","Gallium","Germanium","Arsenic","Selenium","Bromine","Krypton","Rubidium","Strontium","Yttrium","Zirconium","Niobium","Molybdenum","Technetium","Ruthenium","Rhodium","Palladium","Silver","Cadmium","Indium","Tin","Antimony","Tellurium","Iodine","Xenon","Cesium","Barium","Lanthanum","Cerium","Praseodymium","Neodymium","Promethium","Samarium","Europium","Gadolinium","Terbium","Dysprosium","Holmium","Erbium","Thulium","Ytterbium","Lutetium","Hafnium","Tantalum","Tungsten","Rhenium","Osmium","Iridium","Platinum","Gold","Mercury","Thallium","Lead","Bismuth","Polonium","Astatine","Radon","Francium","Radium","Actinium","Thorium","Protactinium","Uranium","Neptunium","Plutonium","Americium","Curium","Berkelium","Californium","Einsteinium","Fermium","Mendelevium","Nobelium","Lawrencium","Rutherfordium","Dubnium","Seaborgium","Bohrium","Hassium","Meitnerium","Darmstadtium","Roentgenium","Copernicium","Nihonium","Flerovium","Moscovium","Livermorium","Tennessine","Oganesson"};
		int num;
		do {
			num = (int)(Math.round(Math.random()*100));
		} while (num > 117);
		return nums[num] + "-" + names[num] + "-Tile.png";
	}
	
	public static void Game2_MB2() {
		Game2_MB2ZZZEncap game2 = new Game2_MB2ZZZEncap();
		
		/*
		 * The following piece of code will add the image desired
		 */
		game2.frame.remove(game2.imgarea);
		
		game2.imgicon = new ImageIcon("images/" + randomImage());
		game2.imgarea = new JLabel(game2.imgicon);
		game2.frame.add(game2.imgarea, game2.c13);
		
		game2.frame.revalidate();
		game2.frame.repaint();
		
		game2.textArea.setText("Welcome to Michael's Chemistry Game\n\nWhat would you like to quiz yourself on?\nA) Element Symbols from their Element Names (Easy)\nB) Element Names from their Atomic Numbers (Hard)\nC) Atomic Mass from Element Names (Very Hard)");
		
		/*
		 * Below, we add the action listeners for buttons "A","B" and "C"
		 * They let the user choose which type of game they would like to play
		 */
		
		// Button "A"
		game2.b1.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){  
				 
				 if(active) {
					 type = "A";
				 }
				 active = false;
			 }  
		 });
		
		// Button "B"
		game2.b2.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){ 
				 if (active) {
					 type = "B";
				 }
				 active = false;
			 }  
		 });
		
		// Button "C"
		game2.b3.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){
				 if (active) {
					 type = "C";
				 }
				 active = false;
				 
			 }  
		 });
		
		/*
		 * This while loop runs so the code waits until the user has selected a game selection
		 */
		while (active) {
			System.out.println("WAITING FOR USER");
		}
		
		/*
		 * We run setQuestionBank and send in the String type which is the game we choose
		 */
		final String[] inputdata = setQuestionBank(type);
		
		/*
		 * All the buttons are now disabled so they cannot be clicked while we get the input for the amount of questions
		 */
		game2.b1.setEnabled(false);
		game2.b2.setEnabled(false);
		game2.b3.setEnabled(false);
		
		/*
		 * Welcome text and instructions
		 * Welcome!
		 * 
		 * When a question appears, click the button corresponding to the correct answer
		 * Example: A) Hydrogen, you would click button 'A'
		 * Loading 
		 * 
		 * Note: there are nice loading stars
		 */
		game2.textArea.setText("Welcome!\n\nWhen a question appears, click the button corresponding to the correct answer\nExample: A) Hydrogen, you would click button 'A'\nLoading ");
		for (int x = 0; x < 15; x++) { //set to 15
			game2.textArea.append("* ");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("WAITING ERROR");
			}
		}
		
		/*
		 * The following is now visible for the user to input how many questions are desired
		 * Refer to the creation of the objects at the top to see what each one is
		 */
		game2.textField.setVisible(true);
		game2.textArea3.setVisible(true);
		game2.b4.setVisible(true);
		
		/*
		 * The following two lines of code make repaint the frame so it will show my textField
		 * Source - https://stackoverflow.com/questions/20922442/hide-show-jtextfield
		 */
		game2.frame.revalidate();
		game2.frame.repaint();
		
		
		// We create an instance of the Question class
		Question q = new Question(inputdata[0]);
		
		/*
		 * Here, we get out array of questions and answers
		 */
		String[] question = q.getQuestion(); // gets the questions from the Question class
		String[] answer = q.getAnswer(); // gets the answers from the Answer class
		final String[] answerselect = {"A","B","C","D"}; // used for randomizing the multiple choice answers and selections, we put the variable as final so they cannot 
		
		/*
		 * All of our variables that need to be defined
		 */
		int score = 0; // sets your score to 0
		int grandom = 0; // used for selecting a random question
		int arandom = 0; // for choosing shuffle order of responses
		double scorepercent = 0.0; // sets your score to 0 - note, it's a double
		int questioncount = 0; // this is the question number to be used as a question header
		int reviewcount = 0;
		int random = 0;
		boolean add = true;
		
		/*
		 * We ask how many questions the user would like to answer
		 */
		game2.textArea.setText("Please enter below how many questions you would like\nYou may enter a number from 1 - " + question.length);
		
		/*
		 * The following adds the action listener to wait until the user clicks the "submit" button indicating his/her desired amount of questions
		 * Then, the value is extracted from the JTextField
		 * Note: we use a try/catch so if the user inputs an invalid option such as a letter, the program will not crash
		 * Note: We also will make the button go red if the input is not permitted
		 */
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
			 }  
		 });
		
		/*
		 * This just waits and doesn't allow the program to keep running until the user puts in a valid answer
		 */
		while (ask) {
			System.out.println("WAITING FOR USER");
		}
		
		/*
		 * This resets the color of the frame when you've inputted a wrong answer
		 * 
		 * The code essentially sets something to another elements background colour
		 * Source - https://stackoverflow.com/questions/9991204/get-default-background-color-of-swing-component
		 */
		game2.b4.setBackground(UIManager.getColor ( "game2.b4.background" ));
		
		/*
		 * intinput - is the amount of questions the user would like
		 * Note: noquestion was taken from the value in the JTextField
		 */
		final int intinput = noquestion;
		
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
		 * This question loop will go as many times as pre-selected for the questions by the JTextField. 
		 * Each time this loop runs, it will move on to a new question
		 */
		for (int i = 0; i < intinput; i++) {
			
			/*
			 * The following line of code shows how many questions are remaining in the game
			 */
			game2.textArea4.setText("Remaining: " + (intinput-i-1));
			
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
			 * The following piece of code will add the image desired
			 */
			game2.frame.remove(game2.imgarea);
			
			game2.imgicon = new ImageIcon("images/question.png");
			game2.imgarea = new JLabel(game2.imgicon);
			game2.frame.add(game2.imgarea, game2.c13);
			
			game2.frame.revalidate();
			game2.frame.repaint();
			
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
			
			/*
			 * This "appends" or adds on the possible multiple choice answer solutions
			 */
			game2.textArea.append("\nA) " + answersolutionsfinal[0] + inputdata[2] + "\nB) " + answersolutionsfinal[1] + inputdata[2] + "\nC) " + answersolutionsfinal[2] + inputdata[2] + "\nD) " + answersolutionsfinal[3] + inputdata[2]);
			
			/*
			 * Enables the buttons for the multiple choice answers so they are clickable
			 */
			game2.b1.setEnabled(true);
			game2.b2.setEnabled(true);
			game2.b3.setEnabled(true);
			game2.b5.setEnabled(true);
			
			/*
			 * Set's submit to true
			 * Submit allows the action listeners to set the multiple choice answer
			 * After a user has clicked a button, the buttons are changed to false, so they can't take more inputs
			 */
			submit = true;
			
			/*
			 * The following adds the action listener to each button
			 */
			
			// Button "A"
			game2.b1.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "A";
					 }
					 submit = false;
					 
				 }  
			});
			
			// Button "B"
			game2.b2.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "B";
					 }
					 submit = false;
				 }  
			});
			
			// Button "C"
			game2.b3.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "C";
					 }
					 submit = false;
					 
				 }  
			});
			
			// Button "D"
			game2.b5.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e){
					 if (submit) {
						 strinput2 = "D";
					 }
					 submit = false;
					 
				 }  
			});
			
			/*
			 * Waits for the user to click a button
			 */
			while (submit) {
				System.out.println("WAITING FOR USER");
			}
			
			/*
			 * The following piece of code will add the image desired
			 */
			game2.frame.remove(game2.imgarea);
			
			game2.imgicon = new ImageIcon("images/" + getImage(question[grandom],inputdata[0]).replace(" ", ""));
			game2.imgarea = new JLabel(game2.imgicon);
			game2.frame.add(game2.imgarea, game2.c13);
			
			game2.frame.revalidate();
			game2.frame.repaint();
			
			final String strinput = strinput2;
			
			/*
			 * The following statements will check to see if the input from the user is correct and if it is, make the button go green
			 * If NOT, it will still make it green and highlight the button the user clicked in red
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
			
			/*
			 * I found this on stack overflow somewhere... I can't remember but it allows the buttons to be highlighted
			 */
			game2.b1.setOpaque(true);
			game2.b2.setOpaque(true);
			game2.b3.setOpaque(true);
			game2.b5.setOpaque(true);
			
			/*
			 * This conditional checks to do the following:
			 * 1. Correct Answer
			 * 2. If incorrect, will add the question and answer to be reviewable at a later time
			 * As well, if the answers are wrong will highlight red
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
			
			/*
			 * Now we turn off the buttons so they can no longer be clicked
			 */
			game2.b1.setEnabled(false);
			game2.b2.setEnabled(false);
			game2.b3.setEnabled(false);
			game2.b5.setEnabled(false);
			
			/*
			 * If the user is on the last question and got some answers wrong, the system will change the button to "review answers" to go over the solutions
			 * Otherwise the game will be over and the user will be done
			 */
			if (i == intinput-1 && score < intinput) {
				game2.b6.setText("Review Answers");
			}
			
			/*
			 * The following action listener just checks for input for the game to do one of the following:
			 * A) Review the questions
			 * B) End
			 */
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
			
			/*
			 * Waits for user input before procceeding
			 */
			while (go) {
				System.out.println("WAITING FOR USER");
			}
			
			/*
			 * Set's the question to null so it won't be asked again
			 */
			question[grandom] = null;
			
			
			
		} //end question/game loop
		
		/*
		 * The questions that were answered incorrectly can be reviewed now
		 * NOTE: This option will not show if all answers are answered correctly, we can verify this by using a conditional statement
		 */
		
		if (score != intinput) {
			game2.b6.setText("Continue");
			
			
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
					/*
					 * The following piece of code will add the image desired
					 */
					game2.frame.remove(game2.imgarea);
					
					game2.imgicon = new ImageIcon("images/" + getImage(reviewquestion[e],inputdata[0]));
					game2.imgarea = new JLabel(game2.imgicon);
					game2.frame.add(game2.imgarea, game2.c13);
					
					game2.frame.revalidate();
					game2.frame.repaint();
					
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
					
				} else {
					reviewcount = reviewcount - 1;
				}
			} // end for

		}
		
		/*
		 * The following piece of code will add the image desired
		 */
		game2.frame.remove(game2.imgarea);
		
		game2.imgicon = new ImageIcon("images/" + randomImage());
		game2.imgarea = new JLabel(game2.imgicon);
		game2.frame.add(game2.imgarea, game2.c13);
		
		game2.frame.revalidate();
		game2.frame.repaint();
		
		/*
		 * The following does two things:
		 * 1. finds your percentage
		 * 2. Puts your percentage on the board
		 */
		
		scorepercent = Math.round(((double)(score)/intinput) * 10000.0)/100.0; // calculates the percent and rounds the percent to 2 decimals
		game2.textArea.setText("\nYou got " + scorepercent + "% of the questions correct");
		
		/*
		 * Waits for the user to click continue
		 */
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