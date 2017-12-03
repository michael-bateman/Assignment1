import java.util.Scanner;

public class Assignment_MB2 {
	
	public static void welcome() {
		System.out.println("Welcome to Michael's Chemistry Game!");
	}
	
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
	
	public static void game() {
		
		welcome();
		String type = selectType();
		
		final String[] inputdata = new String[3];
		
		if (type.equals("A")) {
			inputdata[0] = "data";
			inputdata[1] = "What is the element with atomic number";
		} else if (type.equals("B")) {
			inputdata[0] = "data2";
			inputdata[1] = "What is the element symbol with the name";
		} else if (type.equals("C")) {
			inputdata[0] = "data3";
			inputdata[1] = "What is the atomic mass of the element";
			inputdata[2] = "g";
		} else {
			System.out.println("ERROR");
		}
		
		Question q = new Question(inputdata[0]);
		
		String[] question = q.getQuestion();
		String[] answer = q.getAnswer();
		String[] answerselect = {"A","B","C","D"};
		
		Scanner s = new Scanner(System.in);
		int intinput = 1;
		String strinput = "A";
		int score = 0;
		int grandom = 0;
		int arandom = 0; // for choosing shuffle order of responses
		double scorepercent = 0.0;
			
		do {
			if (intinput <= 0 || intinput > question.length) {
				System.out.println("Invalid Answer... Please try again");
			}
			System.out.print("How many questions would you like to answer? (1 - " + question.length + "): ");
			intinput = s.nextInt();
		} while (intinput <= 0 || intinput > question.length);
		
		int questioncount = 0;
		for (int i = 0; i < intinput; i++) { //main questions loop
			do {
				grandom = (int)(Math.random() * question.length); // selects a random question
			} while (question[grandom] == null);
			String[] answersolutions = new String[4]; //4 is the amount of MC responses
			answersolutions[0] = answer[grandom];
			int random = 0;
			boolean add = true;
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
			question[grandom] = null;
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
				strinput = s.next().toUpperCase();
			} while (strinput.length() >= 2 || !strinput.equals("A") && !strinput.equals("B") && !strinput.equals("C") && !strinput.equals("D"));
			if (strinput.equals(letteranswer)) {
				score++;
				System.out.println("Correct! Your score is " + score);
			} else {
				System.out.println("Whoops! The correct answer was " + letteranswer + "!");
				System.out.println("Your score is " + score);
			}
			
		}
		System.out.println(intinput);
		scorepercent = ((double)(score)/intinput) * 100;
		System.out.println("You got " + scorepercent + "% of the questions correct");
		
	}
	public static void main(String[] args) {
		String inputagain = "Y";
		Scanner sa = new Scanner(System.in);
		do {
			do {
				game();
				if (inputagain.length() >= 2 || !inputagain.equals("Y") && !inputagain.equals("N")) {
					System.out.println("Invalid Answer... Please try again");
				}
				System.out.println("Would you like to play again? (Y/N) ");
				inputagain = sa.next().toUpperCase();
			} while(inputagain.length() >= 2 || !inputagain.equals("Y") && !inputagain.equals("N"));
		} while (inputagain.equals("Y"));
		System.out.println("Thanks for playing! Have a great day!");
	}

}