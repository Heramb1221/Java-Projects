package stop;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Stopwatch implements ActionListener{

	JFrame frame = new JFrame();
	JButton start = new JButton("START");
	JButton reset = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	
	int eTime = 0;
	int sec = 0;
	int min = 0;
	int hr = 0;
	
	boolean started = true;
	
	String s_string = String.format("%02d", sec);
	String m_string = String.format("%02d", min);
	String h_string = String.format("%02d", hr);
	
	Timer timer = new Timer(1000,new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			eTime += 1000;
			hr = (eTime/3600000);
			min = (eTime/60000)%60;
			sec = (eTime/1000)%60;
			
			s_string = String.format("%02d", sec);
			m_string = String.format("%02d", min);
			h_string = String.format("%02d", hr);
			
			timeLabel.setText(h_string+":"+m_string+":"+s_string);
			
		}
		
	});
	
	Stopwatch(){
		
		ImageIcon logo = new ImageIcon("Stopwatch.png");
		frame.setIconImage(logo.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		
		timeLabel.setText(h_string+":"+m_string+":"+s_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		start.setBounds(100,200,100,50);
		start.setFont(new Font("Ink Free",Font.PLAIN,20));
		start.setFocusable(false);
		start.addActionListener(this);
		
		reset.setBounds(200,200,100,50);
		reset.setFont(new Font("Ink Free",Font.PLAIN,20));
		reset.setFocusable(false);
		reset.addActionListener(this);
		
		frame.add(timeLabel);
		frame.add(start);
		frame.add(reset);
		
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== start) {
			if(started == false) {
				started = true;
				start.setText("STOP");
				start();
			}
			else {
				started = false;
				start.setText("START");
				stop();
			}
		}
		
		if(e.getSource() == reset) {
			started = false;
			start.setText("START");
			reset();		}
		
	}
	
	void start() {
		
		timer.start();
		
	}
	
	void stop() {
		
		timer.stop();
		
	}
	
	void reset() {
		
		timer.stop();
		eTime = 0;
		sec = 0;
		min = 0;
		hr = 0;
		
		s_string = String.format("%02d", sec);
		m_string = String.format("%02d", min);
		h_string = String.format("%02d", hr);
		
		timeLabel.setText(h_string+":"+m_string+":"+s_string);
		
		
	}

}
