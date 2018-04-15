import java.util.Scanner;

/**
 * 
 * @author michael.bateman
 *
 */
public class Assignment {

	public static void loaDing() {
		final int p = 1;
		try {
			Thread.sleep(p * 1000);
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	
	public static void welcome() {
		System.out.println("Welcome to Michael's Chemistry Game!");
	}
	
	public static void instructions() {
		final int amount = 10; // amount of starts
		System.out.print("Do not forget: Type the multiple choice answer letter NOT the actual answer\nExample: A) H, you would type A NOT H\nLoading:");
		for (int f = 0; f < amount; f++) {
			System.out.print("* ");
			loaDing();
			
		}
		System.out.println();
		
	}
	
	public static String selectType() {
		
		String selectType = "B";
		
		Scanner sb = new Scanner(System.in);
		System.out.println("What would you like to quiz yourself on? ");
		do {
			if (!selectType.equals("A") && !selectType.equals("B") && !selectType.equals("C")) {
				System.out.println("Invalid Answer... Please try again");
			}
			System.out.println("A) Element Symbols from their Element Names (Easy) \nB) Element Names from their Atomic Numbers (Hard)\nC) Atomic Mass from Element Names (Very Hard)");
			selectType = sb.next().toUpperCase();
		} while (!selectType.equals("A") && !selectType.equals("B") && !selectType.equals("C"));
		
		return selectType;

	}
	
	
	public static String[] setArray() {
		
		String type = selectType(); // gets the type (selection of what to play) from the selectType() method
		
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
	
	public static void game() {
		
		welcome();
		String[] inputdata = setArray();
		instructions();
		
		Question q = new Question(inputdata[0]);
		
		String[] question = q.getQuestion(); // gets the questions from the Question class
		String[] answer = q.getAnswer(); // gets the answers from the Answer class
		final String[] answerselect = {"A","B","C","D"}; // used for randomizing the multiple choice answers and selections, we put the variable as final so they cannot 
		
		Scanner s = new Scanner(System.in);
		
		int intinput = 1; // used for asking how many questions a user will want to answer. NOTE- set to 1 because we don't want the conditional to activate.
		String strinput = "A"; // sets the input to "A" so the invalid answer conditional statement does not work
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
		do {
			if (intinput <= 0 || intinput > question.length) { // if statement to check to see if the input is invalid
				System.out.println("Invalid Answer... Please try again");
			}
			System.out.print("How many questions would you like to answer? (1 - " + question.length + "): ");
			intinput = s.nextInt(); // takes an int input
		} while (intinput <= 0 || intinput > question.length); // if the statement is invalid
		
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
		 * This question loop will go as many times as pre-selected for the questions. Each time this loop runs, it will move on to a new question
		 */
		for (int i = 0; i < intinput; i++) {
			
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
			System.out.println("Question #" + questioncount + ":");
			System.out.println(inputdata[1] + " " + question[grandom] + "?");
			
			
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
			 * This do while loop will do the following:
			 * 1. check to make sure the input is valid A-D
			 * 2. Will write out the multiple choice possible answers
			 * inputdata[2] - this is if there is a "unit" associated
			 */
			do {
				if (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.println("A) " + answersolutionsfinal[0] + inputdata[2] + "\nB) " + answersolutionsfinal[1] + inputdata[2] + "\nC) " + answersolutionsfinal[2] + inputdata[2] + "\nD) " + answersolutionsfinal[3] + inputdata[2]);
				System.out.print("Answer: ");
				strinput = s.next().toUpperCase(); // NOTE: we use .toUpperCase() to automatically set all input takes to uppercase
			} while (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D"));
			
			/*
			 * The following statements will check to see if the input from the user is correct
			 */
			
			if (strinput.equals(letteranswer)) { // if the answer correct
				score++; // will increase the score by 1
				System.out.print("Correct!");
			} else { // if the answer is incorrect 
				System.out.print("Incorrect! The correct answer was " + letteranswer + "!"); // will tell the user what the correct answer is
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
			
			// the following if statement will run if it is not the last time through the game
			if (i != intinput-1) {
				System.out.println(" Your score is " + score);
			}
			question[grandom] = null; // we need to set null to the question so it can no longer be asked
			
		} //end question/game loop
		
		scorepercent = Math.round(((double)(score)/intinput) * 10000.0)/100.0; // calculates the percent and rounds the percent to 2 decimals
		System.out.println("\nYou got " + scorepercent + "% of the questions correct"); // will tell you your percentage of correct questions
		
		/*
		 * The questions that were answered incorrectly can be reviewed here
		 * NOTE: This option will not show if all answers are answered correctly, we can verify this by using a conditional statement
		 */
		if (score != intinput) {
			
			strinput = "Y"; // we set the input to "Y" so it does not go through the invalid answer conditional
			
			/*
			 * Do while loop to ask if the user would like to review their questions
			 */
			do {
				if (!strinput.equals("Y") && !strinput.equals("N")) { // invalid answer conditional
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.print("Would you like to review your incorrect questions? (Y/N) ");
				strinput = s.next().toUpperCase();
			} while (!strinput.equals("Y") && !strinput.equals("N"));
			
			if (strinput.equals("Y")) { // checks the input to see what the person chose
				
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
						System.out.println("Review #" + reviewcount + ": " + inputdata[1] + " " +  reviewquestion[e] + "?");
						System.out.println("Answer: " + reviewanswer[e] + inputdata[2]);
						System.out.println("You chose: " + reviewyourchoice[e] + inputdata[2]);
						System.out.print("Press any key to continue: ");
						strinput = s.next(); // just acts as a wait
					} else {
						reviewcount = reviewcount - 1;
					}
				} // end for
			}
		} // end answer review
	}
	
	public static void main(String[] args) {
		String inputagain = "Y"; // we set this to "Y" so when getting input it does not go through invalid answer conditional
		Scanner sa = new Scanner(System.in); // scanner to take inputs
		
		/*
		 * Do while loop #1:
		 * Will repeat the game as many times as wanted
		 */
		do {
			game();
			
			/*
			 * Do while loop #2:
			 * Will ask the user for an input if the user wants to play again
			 */
			do {
				if (inputagain.length() >= 2 || !inputagain.equals("Y") && !inputagain.equals("N")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.println("\nWould you like to play again? (Y/N)");
				inputagain = sa.next().toUpperCase();
			} while(inputagain.length() >= 2 || !inputagain.equals("Y") && !inputagain.equals("N")); // this checks to make sure the input is valid, and if not valid will keep asking the user for the input
		} while (inputagain.equals("Y")); // this actually will re run the game if wanted
		
		System.out.println("Thanks for playing! Have a great day!"); // this will print when the user ends the game
	} // end main

} // end class