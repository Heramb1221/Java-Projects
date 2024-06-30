package info;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welpg {
	
	JFrame frame = new JFrame();
	
	JLabel wel = new JLabel();
	
	Welpg(String userid){
		
		wel.setBounds(0,0,200,35);
		wel.setFont(new Font(null,Font.PLAIN,25));
		wel.setText("Hello! "+userid);
		
		frame.add(wel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

}
