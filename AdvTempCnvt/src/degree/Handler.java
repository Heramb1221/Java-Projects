package degree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Handler implements Parameters, ActionListener{
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String x,y;
		
		x = (String) cb1.getSelectedItem();
		y = (String) cb2.getSelectedItem();
		
		//Buttons
		if(e.getSource() == n0) {
			t1.setText(t1.getText() + "0");
		}
		
		if(e.getSource() == n1) {
			t1.setText(t1.getText() + "1");
		}
		
		if(e.getSource() == n2) {
			t1.setText(t1.getText() + "2");
		}
		
		if(e.getSource() == n3) {
			t1.setText(t1.getText() + "3");
		}
		
		if(e.getSource() == n4) {
			t1.setText(t1.getText() + "4");
		}
		
		if(e.getSource() == n5) {
			t1.setText(t1.getText() + "5");
		}
		
		if(e.getSource() == n6) {
			t1.setText(t1.getText() + "6");
		}
		
		if(e.getSource() == n7) {
			t1.setText(t1.getText() + "7");
		}
		
		if(e.getSource() == n8) {
			t1.setText(t1.getText() + "8");
		}
		
		if(e.getSource() == n9) {
			t1.setText(t1.getText() + "9");
		}
		
		if(e.getSource() == dot) {
			t1.setText(t1.getText() + ".");
		}
		
		if(e.getSource() == ac) {
			t1.setText("");
			t2.setText("");
		}
		
		if(e.getSource() == pm) {
			String spm = new String();
			spm = t1.getText();
			if(spm.length() == 0) {
				t1.setText("-");
			}
			else if(spm.charAt(0) != '-') {
				t1.setText("-"+t1.getText());
			}
			else {
				t1.setText(""+spm.substring(1));
			}
		}
		
		if(e.getSource() == bs) {
			int n;
			String bsp = new String();
			
			bsp = t1.getText();
			n = bsp.length();
			
			t1.setText(""+bsp.substring(0,n-1));
		}
		
		//both are same
		if(e.getSource() == conv){
			
			Converter c = new Converter(x,y,t1,t2);
			
		}	
	}
}
