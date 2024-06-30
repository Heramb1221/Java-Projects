package degree;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public interface Parameters {
	String arr1[] = { "Celsius", "Fahrenheit", "Kelvin", "Rankine", "Reaumur" };
    String arr2[] = { "Celsius", "Fahrenheit", "Kelvin", "Rankine", "Reaumur" };
	
	public static final JTextField t1 = new JTextField();
	public static final JTextField t2 = new JTextField();
	
	public static final JLabel l1 = new JLabel("To :");
	public static final JLabel l2 = new JLabel("From :");
	public static final JLabel l3 = new JLabel("Enter the Value :");
	public static final JLabel l4 = new JLabel("Converted Value :");
	
	public static final JComboBox cb1 = new JComboBox(arr1);
	public static final JComboBox cb2 = new JComboBox(arr2);
	
	public static final JButton n0 = new JButton("0");
	public static final JButton n1 = new JButton("1");
	public static final JButton n2 = new JButton("2");
	public static final JButton n3 = new JButton("3");
	public static final JButton n4 = new JButton("4");
	public static final JButton n5 = new JButton("5");
	public static final JButton n6 = new JButton("6");
	public static final JButton n7 = new JButton("7");
	public static final JButton n8 = new JButton("8");
	public static final JButton n9 = new JButton("9");
	
	public static final JButton ac = new JButton("AC");
	public static final JButton dot = new JButton(".");
	public static final JButton conv = new JButton("Convert");
	public static final JButton pm = new JButton("±");
	public static final JButton bs = new JButton("<--");
	

	
}
