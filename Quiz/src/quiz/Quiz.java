package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Quiz implements ActionListener{
	
	String[] que = {
			
			"Which company created Java?",
			"Which year was Java created?",
			"What was Java originally called?",
			"Who is credited with creating Java?"
			
	};
	
	String[][] opt = {
			
			{"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
			{"1989","1996","1972","1492"},
			{"Apple","Latte","Oak","Koffing"},
			{"Avete Jobs","Bill Gates","James Gosling","Mark Zukerburg"}
			
	};
	
	char[] ans = {'A','B','C','C'};
	
	char guess;
	char answer;
	
	int index;
	int cguess = 0;
	int tque = que.length;
	int res;
	int sec = 10;
	
	JFrame frame = new JFrame();
	
	JTextField tfield = new JTextField();
	
	JTextArea tarea = new JTextArea();
	
	JButton bA = new JButton();
	JButton bB = new JButton();
	JButton bC = new JButton();
	JButton bD = new JButton();
	
	JLabel Aa = new JLabel();
	JLabel Ab = new JLabel();
	JLabel Ac = new JLabel();
	JLabel Ad = new JLabel();
	
	JLabel tLabel = new JLabel();
	
	JLabel sleft = new JLabel();
	
	JTextField nRight = new JTextField();
	
	JTextField per = new JTextField();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			sec--;
			sleft.setText(String.valueOf(sec));
			if(sec <=0) {
				disAns();
			}
			
		}
	});
	
	Quiz(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		tfield.setBounds(0,0,650,50);
		tfield.setBackground(new Color(25,25,25));
		tfield.setForeground(new Color(25,255,0));
		tfield.setFont(new Font("Ink Free",Font.BOLD,30));
		tfield.setBorder(BorderFactory.createBevelBorder(1));
		tfield.setHorizontalAlignment(JTextField.CENTER);
		tfield.setEditable(false);
		
		tarea.setBounds(0,50,650,50);
		tarea.setLineWrap(true);
		tarea.setWrapStyleWord(true);
		tarea.setBackground(new Color(25,25,25));
		tarea.setForeground(new Color(25,255,0));
		tarea.setFont(new Font("MV Boli",Font.BOLD,30));
		tarea.setBorder(BorderFactory.createBevelBorder(1));
		tarea.setEditable(false);
		
		bA.setBounds(0,100,100,100);
		bA.setFont(new Font("MV Boli",Font.BOLD,35));
		bA.setFocusable(false);
		bA.addActionListener(this);
		bA.setText("A");
		
		bB.setBounds(0,200,100,100);
		bB.setFont(new Font("MV Boli",Font.BOLD,35));
		bB.setFocusable(false);
		bB.addActionListener(this);
		bB.setText("B");
		
		bC.setBounds(0,300,100,100);
		bC.setFont(new Font("MV Boli",Font.BOLD,35));
		bC.setFocusable(false);
		bC.addActionListener(this);
		bC.setText("C");
		
		bD.setBounds(0,400,100,100);
		bD.setFont(new Font("MV Boli",Font.BOLD,35));
		bD.setFocusable(false);
		bD.addActionListener(this);
		bD.setText("D");
		
		Aa.setBounds(125,100,500,100);
		Aa.setBackground(new Color(50,50,50));
		Aa.setForeground(new Color(25,255,0));
		Aa.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		Ab.setBounds(125,200,500,100);
		Ab.setBackground(new Color(50,50,50));
		Ab.setForeground(new Color(25,255,0));
		Ab.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		Ac.setBounds(125,300,500,100);
		Ac.setBackground(new Color(50,50,50));
		Ac.setForeground(new Color(25,255,0));
		Ac.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		Ad.setBounds(125,400,500,100);
		Ad.setBackground(new Color(50,50,50));
		Ad.setForeground(new Color(25,255,0));
		Ad.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		sleft.setBounds(535,510,100,100);
		sleft.setBackground(new Color(25,25,25));
		sleft.setForeground(new Color(255,0,0));
		sleft.setFont(new Font("Ink Free",Font.BOLD,60));
		sleft.setBorder(BorderFactory.createBevelBorder(1));
		sleft.setOpaque(true);
		sleft.setHorizontalAlignment(JTextField.CENTER);
		sleft.setText(String.valueOf(sec));
		
		tLabel.setBounds(535,475,100,25);
		tLabel.setBackground(new Color(50,50,50));
		tLabel.setForeground(new Color(255,0,0));
		tLabel.setFont(new Font("MV boli",Font.PLAIN,20));
		tLabel.setHorizontalAlignment(JTextField.CENTER);
		tLabel.setText("Timer");
		
		nRight.setBounds(225,225,200,100);
		nRight.setBackground(new Color(25,25,25));
		nRight.setForeground(new Color(25,255,0));
		nRight.setFont(new Font("Ink Free",Font.BOLD,50));
		nRight.setBorder(BorderFactory.createBevelBorder(1));
		nRight.setHorizontalAlignment(JTextField.CENTER);
		nRight.setEditable(false);
		
		per.setBounds(255,325,200,100);
		per.setBackground(new Color(25,25,25));
		per.setForeground(new Color(25,255,0));
		per.setFont(new Font("Ink Free",Font.BOLD,50));
		per.setBorder(BorderFactory.createBevelBorder(1));
		per.setHorizontalAlignment(JTextField.CENTER);
		per.setEditable(false);
		
		frame.add(tLabel);
		
		frame.add(sleft);
		
		frame.add(Aa);
		frame.add(Ab);
		frame.add(Ac);
		frame.add(Ad);
		
		frame.add(bA);
		frame.add(bB);
		frame.add(bC);
		frame.add(bD);
		
		frame.add(tarea);
		frame.add(tfield);
		
		frame.setVisible(true);
		
		nQue();
		
	}
	
	public void nQue() {
		
		if(index>=tque) {
			results();
		}
		else {
			tfield.setText("Question "+index+1);
			
			tarea.setText(que[index]);
			
			Aa.setText(opt[index][0]);
			Ab.setText(opt[index][1]);
			Ac.setText(opt[index][2]);
			Ad.setText(opt[index][3]);
			
			timer.start();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		
		if(e.getSource() == bA) {
			answer = 'A';
			if(answer == ans[index]) {
				cguess++;
			}
		}
		
		if(e.getSource() == bB) {
			answer = 'B';
			if(answer == ans[index]) {
				cguess++;
			}
		}
		
		if(e.getSource() == bC) {
			answer = 'C';
			if(answer == ans[index]) {
				cguess++;
			}
		}
		
		if(e.getSource() == bD) {
			answer = 'D';
			if(answer == ans[index]) {
				cguess++;
			}
		}
		
		disAns();
		
	}
	
	public void disAns() {
		timer.stop();
		
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		
		if(ans[index] != 'A') {
			Aa.setForeground(new Color(255,0,0));
		}
		
		if(ans[index] != 'B') {
			Ab.setForeground(new Color(255,0,0));
		}
		
		if(ans[index] != 'C') {
			Ac.setForeground(new Color(255,0,0));
		}
		
		if(ans[index] != 'D') {
			Ad.setForeground(new Color(255,0,0));
		}
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aa.setForeground(new Color(25,255,0));
				Ab.setForeground(new Color(25,255,0));
				Ac.setForeground(new Color(25,255,0));
				Ad.setForeground(new Color(25,255,0));
				
				answer = ' ';
				sec = 10;
				sleft.setText(String.valueOf(sec));
				
				bA.setEnabled(true);
				bB.setEnabled(true);
				bC.setEnabled(true);
				bD.setEnabled(true);
				
				index++;
				nQue();
			}
		});
		pause.setRepeats(false);
		pause.start();
		
	}
	
	public void results() {
		
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		
		res = (int)(cguess/(double)tque)*100;
		
		tfield.setText("RESULTS!");
		tarea.setText("");
		
		Aa.setText("");
		Ab.setText("");
		Ac.setText("");
		Ad.setText("");
		
		nRight.setText("("+cguess+"/"+tque+")");
		
		per.setText(res+"%");
		
		frame.add(per);
		frame.add(nRight);
		
	}

}
