package snake;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	GameFrame(){
		
		ImageIcon logo = new ImageIcon("Snake.png");
		this.setIconImage(logo.getImage());
		
		this.add(new GPanel());
		this.setTitle("Heramb's Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
