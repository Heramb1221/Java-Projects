package degree;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements Parameters{

	MyFrame(){
		
		ImageIcon logo = new ImageIcon("logo.png");
		this.setIconImage(logo.getImage());
		
		this.setTitle("Temperature Converter");

        setLayout(null);
        
        cb1.setBounds(75, 50, 100, 20);
        
        t1.setBounds(200, 50, 100, 20);
        
        l1.setBounds(100, 75, 50, 20);
        l2.setBounds(90, 25, 50, 20);
        l4.setBounds(200, 35, 100, 20);
        l3.setBounds(200, 85, 100, 20);
        
        cb2.setBounds(75, 100, 100, 20);
        
        t2.setBounds(200, 100, 100, 20);
        
        conv.setBounds(138, 150, 100, 20);
        ac.setBounds(238, 200, 50, 100);
        pm.setBounds(238, 350, 50, 50);
        bs.setBounds(238, 300, 50, 50);
        dot.setBounds(188, 350, 50, 50);
        
        n0.setBounds(88, 350, 100, 50);
        n1.setBounds(88, 200, 50, 50);
        n2.setBounds(138, 200, 50, 50);
        n3.setBounds(188, 200, 50, 50);
        n4.setBounds(88, 250, 50, 50);
        n5.setBounds(138, 250, 50, 50);
        n6.setBounds(188, 250, 50, 50);
        n7.setBounds(88, 300, 50, 50);
        n8.setBounds(138, 300, 50, 50);
        n9.setBounds(188, 300, 50, 50);
        
        conv.addActionListener(new Handler());
        ac.addActionListener(new Handler());
        pm.addActionListener(new Handler());
        bs.addActionListener(new Handler());
        dot.addActionListener(new Handler());
        n0.addActionListener(new Handler());
        n1.addActionListener(new Handler());
        n2.addActionListener(new Handler());
        n3.addActionListener(new Handler());
        n4.addActionListener(new Handler());
        n5.addActionListener(new Handler());
        n6.addActionListener(new Handler());
        n7.addActionListener(new Handler());
        n8.addActionListener(new Handler());
        n9.addActionListener(new Handler());
        
        add(cb1);
        add(cb2);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(conv);
        add(ac);
        add(dot);
        add(pm);
        add(bs);
        add(n0);
        add(n1);
        add(n2);
        add(n3);
        add(n4);
        add(n5);
        add(n6);
        add(n7);
        add(n8);
        add(n9);
        
        Handler h = new Handler();
        
        t2.setEditable(false);
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,500);
		this.setVisible(true);
	}
}