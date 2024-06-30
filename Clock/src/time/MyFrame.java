package time;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{

	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	
	MyFrame(){

		ImageIcon logo = new ImageIcon("Clock.png");
		this.setIconImage(logo.getImage());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Heramb's Digital Clock");
		this.setLayout(new FlowLayout());
		this.setSize(350,220);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		
		timeFormat = new SimpleDateFormat("HH:mm:ss a");
		
		dayFormat = new SimpleDateFormat("EEEE");
		
		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Open Snas",Font.PLAIN,50));
		timeLabel.setForeground(Color.CYAN);
		
		dayLabel = new JLabel();
		dayLabel.setForeground(Color.magenta);
		dayLabel.setFont(new Font("Galgo",Font.PLAIN,35));
		
		
		dateLabel = new JLabel();
		dateLabel.setForeground(Color.orange);
		dateLabel.setFont(new Font("Saint Regus",Font.PLAIN,40));
		
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
		
	}
	
	public void setTime() {
		
		while(true) {
			
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}