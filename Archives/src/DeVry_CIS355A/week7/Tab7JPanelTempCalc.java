
/***********************************************************************
Program Name:        Tab7JPanelTempCalc.java
Programmer's Name:   Doug Woolley
Program Description: This program will convert a temperature from
 	Celsius to Fahrenheit or from Fahrenheit to Celsius, depending upon
 	the combo box option selected by the user. The user also enters a
 	temperature in the textbox, and 1 of 2 formulas are used depending
 	upon the kind of conversion, and the results are displayed to the 
 	screen. If no value is entered for temperature or an invalid number
 	is entered, then zero is used instead.
 ***********************************************************************/

package week7;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.text.DecimalFormat;

public class Tab7JPanelTempCalc extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JButton btnConvert;
	private JButton btnExit;
	private JTextField jtxtfTemperature;
	private JTextField jtxtfResult;
	private JLabel jlblTemperature;
	private JLabel jlblResult;
	private JLabel jlblScale;
	private JTextField jtxtfMessageArea;
	private JComboBox<String> jcbScale;
	private JPanel jpnl1;
	
	//Class constructor method
	public Tab7JPanelTempCalc()
	{
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 190));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		btnExit = new JButton("Exit");
		jlblTemperature = new JLabel("Enter temperature: ");
		
		//Create the combo box, with Celsius and Fahrenheit
		jcbScale = new JComboBox<String>();
		jcbScale.addItem("C");   //Celsius
		jcbScale.addItem("F");   //Fahrenheit
		jcbScale.setSelectedIndex(0);  //Initially set to "C"

		
		jlblResult = new JLabel("Result: ");
		jtxtfTemperature = new JTextField(7);
		jtxtfResult = new JTextField(15);
		jtxtfResult.setEditable(false);
		jlblScale = new JLabel("F");
		btnConvert = new JButton("Convert");
		jtxtfMessageArea =  new JTextField(20);
		jtxtfMessageArea.setFont(new Font("Serif", Font.PLAIN, 11));
		jtxtfMessageArea.setEditable(false);		
		
		//Set the layout of the container
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblTemperature);
		jpnl1.add(jtxtfTemperature);
		jpnl1.add(jcbScale);
		jpnl1.add(jlblResult);
		jpnl1.add(jtxtfResult);
		jpnl1.add(jlblScale);
		jpnl1.add(btnConvert);
		jpnl1.add(btnExit);
		jpnl1.add(jtxtfMessageArea);
		
		//Set Tab/Panel color
		//jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnConvert.setMnemonic('C');
		btnExit.setMnemonic('X');
		
		//Add action listener to combo box
		//btnConverthandler is a class that is defined below
		jcbScaleHandler cbhandler = new jcbScaleHandler();
		jcbScale.addActionListener(cbhandler);
		
		//Add action listener to each button
		//btnConverthandler is a class that is defined below
		btnConvertHandler chandler = new btnConvertHandler();
		btnConvert.addActionListener(chandler);
		
		//btnExitHandler is a class that is defined below
		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Combo Box. The required method actionPerformed
	 * is created to switch the resulting temperature scale
	 * to the scale not chosen.
	 */

	class jcbScaleHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox cb = (JComboBox)e.getSource();
	        String scale = (String)cb.getSelectedItem();

			//Make the Resulting temperature label the opposite of selection
			if (scale == "C")     //C - Celsius
				jlblScale.setText("F");
			else  // scale == "F" //F - Fahrenheit
				jlblScale.setText("C");
		}
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Convert button. The required method actionPerformed
	 * is created to read the input values for temperature and the
	 * scale of the given temperature and then calculate and display
	 * the temperature in the other scale (C vs. F, or F vs. C).
	 * Temperature in Fahrenheit = (( Temperature in Celsius) * 9 / 5) + 32
	 * Temperature in Celsius = (( Temperature in Fahrenheit) - 32) * 5 / 9
	 */

	class btnConvertHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DecimalFormat num = new DecimalFormat(",###.##");
			Boolean incomplete = false, invalid = false; 
			double temp = 0, result = 0;
			
			jtxtfTemperature.setBackground(Color.white);
			jtxtfMessageArea.setText("");
			
			if (jtxtfTemperature.getText().equals(""))
			{
				jtxtfTemperature.setBackground(Color.orange);
				incomplete = true;
			}
			else
			{
				try { 
					temp = Double.parseDouble(jtxtfTemperature.getText()); 
				}
				catch (NumberFormatException ex) { 
					jtxtfTemperature.setBackground(Color.orange);
					invalid = true;
				}
			}			
		
			//if no input or invalid input, set temperature to zero
			if (incomplete || invalid)
			{
				jtxtfTemperature.setText("0");
				jtxtfMessageArea.setText("Value set to zero ");
			}
			
			//Based on temperature scale, use 1 of 2 formulas for conversion.
			String scaleForResults = jlblScale.getText();
			//Current temp is the opposite of the scaleForResults
			if (scaleForResults == "F")
				result = (( temp) * 9 / 5) + 32;
			else   //scaleForResults == "C"
				result =(( temp) - 32) * 5 / 9;
			
			jtxtfResult.setText(num.format(result));
		}
	}
	
	/**
	 * This class implements the ActionListner interface
	 * and handles the action of the Exit button
	 */	
	class btnExitHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	} 
}