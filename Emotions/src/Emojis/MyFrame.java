package Emojis;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements MouseListener{

	JLabel label;
	ImageIcon smile;
	ImageIcon nervous;
	ImageIcon pain;
	ImageIcon dizzy;
	
	MyFrame(){
		
		ImageIcon logo = new ImageIcon("Emotions.png");
		this.setIconImage(logo.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		
		label = new JLabel();
		label.addMouseListener(this);
		
		smile = new ImageIcon("smile.png");
		nervous = new ImageIcon("Nervous.png");
		pain = new ImageIcon("Pain.png");
		dizzy = new ImageIcon("Dizzy Face Emoji.png");
		
		label.setIcon(smile);
		
		this.add(label);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		label.setIcon(pain);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		label.setIcon(dizzy);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		label.setIcon(nervous);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		label.setIcon(smile);;
		
	}

}
