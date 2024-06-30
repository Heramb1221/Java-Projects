package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		GameComponents g = new GameComponents();
		
		ImageIcon logo = new ImageIcon("brickbreaker.png");
		f.setIconImage(logo.getImage());
		
		f.setBounds(10,10,800,600);
		f.setTitle("Simple Brick Breaker");
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(g);
		
	}
}
