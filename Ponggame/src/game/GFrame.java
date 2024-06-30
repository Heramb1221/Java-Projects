package game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GFrame extends JFrame{
	
	GPanel gp;
	

	GFrame(){
		
		gp = new GPanel();
		
		ImageIcon logo = new ImageIcon("pong.png");
		this.setIconImage(logo.getImage());
		
		this.add(gp);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
}
