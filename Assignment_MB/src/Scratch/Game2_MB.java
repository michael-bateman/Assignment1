package Scratch;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game2_MB {

	//Fields
		
	//GUI VARIABLES
	private JFrame frame = new JFrame();
	private JButton[] buttons = new JButton[9];
	
	private ActionListener action1 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			((JButton)e.getSource()).setEnabled(false);
		}
		
	};
	
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel() {
			
		public void paint(Graphics g) {
			
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			int width = frame.getWidth();
			int height = frame.getHeight();
			//g2.drawRect(10,10,width-20,height-20);
			g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD,25));
			
			g2.drawString("<question>", 20, 40);
			
			
			for (int i = 0; i < buttons.length; i++) {
				buttons[i] = new JButton();
				frame.add(buttons[i]);
				//buttons[i].setSize(50,50);
				//frame.setResizable(false);
			}
			
		}
	};
	
	
		//GAMES VARIABLES
	
	
	
	//Constructors
	
	
	public Game2_MB() {
		frame = new JFrame("Michael's Chemistry Game");
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(3,3,5,5));
		
		frame.add(panel2);
		
		
		//frame.pack();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		//panel.setLocation(100, 100);
		
		
	}
	
	//Attributes
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game2_MB newGame = new Game2_MB();
	}

}
