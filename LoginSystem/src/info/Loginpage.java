package info;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginpage implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JButton login = new JButton("Login");
	JButton reset = new JButton("Reset");
	
	JTextField uid = new JTextField();
	JPasswordField upass = new JPasswordField();
	
	JLabel user = new JLabel("userID: ");
	JLabel pass = new JLabel("password: ");
	JLabel mess = new JLabel();
	
	
	HashMap<String,String> loginInfo = new HashMap<String,String>();

	Loginpage(HashMap<String,String> logininfo) {
		
		ImageIcon logo = new ImageIcon("loginsystem.png");
		frame.setIconImage(logo.getImage());
		
		loginInfo = logininfo;
		
		user.setBounds(50, 100, 75, 25);
		pass.setBounds(50, 150, 75, 25);
		mess.setBounds(125,250,250,35);
		mess.setFont(new Font(null,Font.ITALIC,25));
		
		uid.setBounds(125,100,200,25);
		upass.setBounds(125,150,200,25);
		
		login.setBounds(125,200,100,25);
		login.addActionListener(this);
		login.setFocusable(false);
		
		reset.setBounds(125,200,100,25);
		reset.addActionListener(this);
		reset.setFocusable(false);
		
		frame.add(user);
		frame.add(pass);
		frame.add(mess);
		frame.add(uid);
		frame.add(upass);
		frame.add(login);
		frame.add(reset);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == reset) {
			
			uid.setText("");
			upass.setText("");
			
		}
		
		if(e.getSource() == login) {
			
			String userid = uid.getText();
			String password = String.valueOf(upass.getPassword());
			
			
			if(loginInfo.containsKey(userid)) {
				
				if(loginInfo.get(userid).equals(password)) {
					mess.setForeground(Color.green);
					mess.setText("Login successful");
					frame.dispose();
					Welpg w = new Welpg(userid);
				}
				else {
					mess.setForeground(Color.red);
					mess.setText("Wrong password");
				}
				
				
			}
			else {
				mess.setForeground(Color.red);
				mess.setText("username not found");
			}
			
		}
		
	}

}
