import java.io.File;
import java.util.Scanner;

public class Question {

	
	private String[] question = null;
	private String[] answer = null;
	
	public Question(String fileName) {
		
	
		try {
			
			
			Scanner s = new Scanner(new File(fileName));
			
			int numLines = Integer.valueOf(s.nextLine());
			
			question = new String[numLines];
			answer = new String[numLines];
			

			for (int i = 0; i < numLines; i++) {
				
				String line = s.nextLine();	
				question[i] = line.substring(0,line.indexOf("|"));
				answer[i] = line.substring(line.indexOf("|")+1);
			}
	
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
		}
	
	}
	
	public String[] getQuestion() {
		return question;
	}
	
	public String[] getAnswer() {
		return answer;
	}
		
	

}