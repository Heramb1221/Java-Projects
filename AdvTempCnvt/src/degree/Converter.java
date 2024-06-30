package degree;

import javax.swing.JTextField;

public class Converter {

	public Converter(String x, String y, JTextField t1, JTextField t2) {
		
		//if both are same
		if(x == y) {
			t2.setText(""+t1.getText());
		}
		
		
		//Celsius to others 
		else if(x == "Celsius" && y == "Fahrenheit") {
			float a = Float.parseFloat(t1.getText());
			float b = (float)((a*9/5)+32);
			t2.setText(""+b);
		}
		else if (x == "Celsius" && y == "Kelvin") {
            String s = t1.getText();
            float a = Float.parseFloat(s);
            float b = (float) (a + 273.15);
            t2.setText("" + b);
        } 
		else if (x == "Celsius" && y == "Rankine") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 9 / 5 + 32 + 459.67);
            t2.setText("" + b);
        } 
		else if (x == "Celsius" && y == "Reaumur") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 0.8);
            t2.setText("" + b);
        }
		
		//Farenheit to others
		else if (x == "Fahrenheit" && y == "Celsius") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 32) * 5 / 9);
            t2.setText("" + b);
        } 
		else if (x == "Fahrenheit" && y == "Kelvin") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 32) * 5 / 9 + 273.15);
            t2.setText("" + b);
        } 
		else if (x == "Fahrenheit" && y == "Rankine") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a + 459.67);
            t2.setText("" + b);
        } 
		else if (x == "Fahrenheit" && y == "Reaumur") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 32) / 2.25);
            t2.setText("" + b);
        }

        // Kelvin to others.........................
        else if (x == "Kelvin" && y == "Celsius") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a - 273.15);
            t2.setText("" + b);
        } 
        else if (x == "Kelvin" && y == "Fahrenheit") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 273.15) * 9 / 5 + 32);
            t2.setText("" + b);
        } 
        else if (x == "Kelvin" && y == "Rankine") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 9 / 5);
            t2.setText("" + b);
        } 
        else if (x == "Kelvin" && y == "Reaumur") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 273.15) * 0.8);
            t2.setText("" + b);
        }

        // Rankine to others............................
        else if (x == "Rankine" && y == "Celsius") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 32 - 459.67) / 1.8);
            t2.setText("" + b);
        } 
        else if (x == "Rankine" && y == "Fahrenheit") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a - 459.67);
            t2.setText("" + b);
        } 
        else if (x == "Rankine" && y == "Kelvin") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a / 1.8);
            t2.setText("" + b);
        } 
        else if (x == "Rankine" && y == "Reaumur") {
            float a = Float.parseFloat(t1.getText());
            float b = (float) ((a - 32 - 459.67) / 2.25);
            t2.setText("" + b);
        }

        // Reaumur to others........................
        else if (x == "Reaumur" && y == "Celsius") {	          
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 1.25);
            t2.setText("" + b);
        } 
        else if (x == "Reaumur" && y == "Fahrenheit") {	                    
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 2.25 + 32);
            t2.setText("" + b);
        } 
        else if (x == "Reaumur" && y == "Kelvin") {	                    
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 1.25 + 273.15);
            t2.setText("" + b);
        } 
        else if (x == "Reaumur" && y == "Rankine") {	                   
            float a = Float.parseFloat(t1.getText());
            float b = (float) (a * 2.25 + 32 + 459.67);
            t2.setText("" + b);
		
	}
		
	}
}
