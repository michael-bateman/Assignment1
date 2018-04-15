package Scratch;
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

public class Game2_MB2 {

	//Fields
	//GUI******************************************
	private JFrame frame = new JFrame("Michael's Chemistry Game");
	
	/*
	private JPanel panelMain = new JPanel() {
		
		public void paint(Graphics g) {
			
			g.fillRect(0,0,500,500);
		}

	};
	*/

	private JButton b1 = new JButton("Button 1");
	private JButton b2 = new JButton("Button 2");

	private JButton b3 = new JButton("Button 3");
	private JButton b4 = new JButton("Button 4");
	
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea2 = new JTextArea();
	
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
	public Game2_MB2() {
		
		//assignment();
		//Action Listeners
		b1.addActionListener(new ActionListener(){
			 
			 public void actionPerformed(ActionEvent e){  
				 b1.setText("TesTING!!!");
				 textArea.setText("What is the Capital of Canada?\nA) Toronto\nB) Ottawa\nC) NewYork");
			 }  
		 });
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
		
		//CODE TO ADD TEXT -WHICH IS QUESTION
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 1;
		c6.gridwidth = 4;
		c6.anchor = GridBagConstraints.WEST;
		//c6.ipady = 50;
		c6.insets = new Insets(10,10,10,10);
		//textLabel.setBounds(50, 50, 100, 100)
		
		//textLabel.setText("Test");
		textArea.setText("Test2");
		textArea.setEditable(false);
		frame.add(textArea, c6);
		
		//CODE TO ADD SCORE
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0;
		c7.gridy = 3;
		c7.gridwidth = 4;
		c7.anchor = GridBagConstraints.EAST;
		c7.insets = new Insets(10,10,10,10);
		textArea2.setText("Score: ");
		textArea2.setEditable(false);
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
		
		//CODE TO ADD BUTTON 4
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 3;
		c5.gridy = 2;
		c5.anchor = GridBagConstraints.CENTER;
		c5.weightx = 1.0;
		
		frame.add(b4,c5);
		
	
		//FINALIZE FRAME SETUP
		frame.setResizable(true);
		frame.pack(); //packs all the elements so it sets the size of the screen automatically
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Game2_MB2 game = new Game2_MB2();
		System.out.println(game.b1.getAction());
		
		
	}
	
}