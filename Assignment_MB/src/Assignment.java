import java.util.Scanner;

/**
 * 
 * @author michael.bateman
 *
 */
public class Assignment {
	
	/**
	 * 
	 */
	public static void welcome() {
		System.out.println("Welcome to Michael's Chemistry Game!");
	}
	
	/**
	 * 
	 * @return
	 */
	public static String selectType() {
		
		String selectType = "B";
		
		Scanner sb = new Scanner(System.in);
		System.out.println("What would you like to quiz yourself on? ");
		do {
			if (!selectType.equals("A") && !selectType.equals("B") && !selectType.equals("C")) {
				System.out.println("Invalid Answer... Please try again");
			}
			System.out.println("A) Element Names from their Atomic Numbers\nB) Element Symbols from their Element Names\nC) Atomic Mass from Element Names");
			selectType = sb.next().toUpperCase();
		} while (!selectType.equals("A") && !selectType.equals("B") && !selectType.equals("C"));
		
		return selectType;

	}
	
	
	/**
	 * 
	 * @return
	 */
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
			inputdata[0] = "data";
			inputdata[1] = "What is the element with atomic number";
		} else if (type.equals("B")) {
			inputdata[0] = "data2";
			inputdata[1] = "What is the element symbol with the name";
		} else if (type.equals("C")) {
			inputdata[0] = "data3";
			inputdata[1] = "What is the molar mass of the element";
			inputdata[2] = "g";
		} else {
			System.out.println("ERROR");
		}
		
		if (inputdata[2] == null) {
			inputdata[2] = "";
		}
		
		return inputdata;
	}
	
	/**
	 * 
	 */
	public static void game() {
		
		welcome();
		String[] inputdata = setArray();
		
		Question q = new Question(inputdata[0]);
		
		String[] question = q.getQuestion(); // gets the questions from the Question class
		String[] answer = q.getAnswer(); // gets the answers from the Answer class
		String[] answerselect = {"A","B","C","D"}; // used for randomizing the multiple choice answers and selections
		
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
		
		String[] reviewquestion = new String[intinput];
		String[] reviewanswer = new String[intinput];
		String[] reviewyourchoice = new String[intinput];
		
		for (int i = 0; i < intinput; i++) { // this is the question loop
			
			do {
				grandom = (int)(Math.random() * question.length); // selects a random question
			} while (question[grandom] == null); // this will check to see if the question has already been used
			
			String[] answersolutions = new String[4]; //4 is the amount of MC responses
			answersolutions[0] = answer[grandom]; // selects the answer from the question randomizer above
			
			for (int a = 1; a < answersolutions.length; a++) {
				add = true;
				random = (int)(Math.random() * answer.length);
				if (random == grandom) {
					a = a - 1;
					add = false;
				} else {
					for (int b = 1; b < answersolutions.length; b++) {
						if (answer[random].equals(answersolutions[b])) {
							add = false;
							a = a-1;
						}
					}
				}
				if (add == true) {
					answersolutions[a] = answer[random];
				}
			}
			questioncount++;
			System.out.println("Question #" + questioncount + ":");
			System.out.println(inputdata[1] + " " + question[grandom] + "?");
			//question[grandom] = null;
			String[] answersolutionsfinal = new String[4];
			String letteranswer = "";
			for (int c = 0; c < answersolutions.length; c++) {
				do {
					arandom = (int)(Math.random() * answersolutions.length);
				} while (answersolutions[arandom] == null);
				if (arandom == 0) {
					letteranswer = answerselect[c];
				}
				answersolutionsfinal[c] = answersolutions[arandom];
				answersolutions[arandom] = null;
			}
			do {
				if (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.println("A) " + answersolutionsfinal[0] + inputdata[2] + "\nB) " + answersolutionsfinal[1] + inputdata[2] + "\nC) " + answersolutionsfinal[2] + inputdata[2] + "\nD) " + answersolutionsfinal[3] + inputdata[2]);
				System.out.print("Answer: ");
				strinput = s.next().toUpperCase();
			} while (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D"));
			if (strinput.equals(letteranswer)) { // correct
				score++;
				System.out.print("Correct!");
			} else { // incorrect 
				System.out.print("Incorrect! The correct answer was " + letteranswer + "!");
				reviewquestion[i] = question[grandom];
				reviewanswer[i] = answer[grandom];
				for (int d = 0; d < answersolutions.length; d++) {
					if (strinput.equals(answerselect[d])) {
						reviewyourchoice[i] = answersolutionsfinal[d] + inputdata[2];
						d = answersolutions.length; // this will end the loop without forcing break
					}
				} 
			}
			
			if (i != intinput-1) {
				System.out.println(" Your score is " + score);
			}
			question[grandom] = null; // we need to set null down here because we reaccess the array for review if wrong.
			
		} //end game loop
		scorepercent = Math.round(((double)(score)/intinput) * 10000.0)/100.0;
		System.out.println("\nYou got " + scorepercent + "% of the questions correct");
		// add an if statement to see if they got 100%
		if (score != intinput) {
			strinput = "Y";
			do {
				if (!strinput.equals("Y") && !strinput.equals("N")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.print("Would you like to review your incorrect questions? (Y/N) ");
				strinput = s.next().toUpperCase();
			} while (!strinput.equals("Y") && !strinput.equals("N"));
			
			if (strinput.equals("Y")) {
				for (int e = 0; e < reviewquestion.length; e++) {
					reviewcount++;
					if (reviewquestion[e] != null) {
						System.out.println("Review #" + reviewcount + ": " + inputdata[1] + " " +  reviewquestion[e] + "?");
						System.out.println("Answer: " + reviewanswer[e]);
						System.out.println("You chose: " + reviewyourchoice[e]);
						System.out.print("Press any key to continue: ");
						strinput = s.next(); // just acts as a wait
					} else {
						reviewcount = reviewcount - 1;
					}
				}
			}
		}// end answer review
	}
	public static void main(String[] args) {
		String inputagain = "Y";
		Scanner sa = new Scanner(System.in);
		do {
			game();
			do {
				if (inputagain.length() >= 2 || !inputagain.equals("Y") && !inputagain.equals("N")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.println("\nWould you like to play again? (Y/N)");
				inputagain = sa.next().toUpperCase();
			} while(inputagain.length() >= 2 || !inputagain.equals("Y") && !inputagain.equals("N"));
		} while (inputagain.equals("Y"));
		System.out.println("Thanks for playing! Have a great day!");
	} // end main

} // end class