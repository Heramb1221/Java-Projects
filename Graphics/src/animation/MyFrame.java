package animation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

MyPanel panel;
	
	MyFrame(){
		
		panel = new MyPanel();
		
		ImageIcon logo = new ImageIcon("Graphics.png");
		this.setIconImage(logo.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}  
	
}
