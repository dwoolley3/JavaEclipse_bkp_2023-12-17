
/***********************************************************************
Program Name:        Tab8JPanelLengthCalc.java
Programmer's Name:   Doug Woolley
Program Description: This program will convert lengths from a given 
	unit to 4 other units of length. The program provides the user with
	5 unit lengths and text fields for which to enter a single value.
	The program will read the first entered value among the measurements:
	Millimeters, Meters, Yards, Feet, and Inches. 
	The program then converts the value to all the other units of 
	measurement and displays the results in the JTextField boxes. 
	
	 * 1 Meter = 1000 Millimeters
	 * 1 Yard = 3 Feet              1 Yard = 0.9144 meters
	 * 1 Foot = 12 Inches           1 Foot = 0.3048 meters

	If the first populated entry contains invalid data,
	a zero value will be used for that field instead.
 ***********************************************************************/

package week7;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.text.DecimalFormat;

public class Tab8JPanelLengthCalc extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JButton btnConvert;
	private JButton btnExit;
	private JButton btnClear;
	private JTextField jtxtfMillimetersHeading;
	private JTextField jtxtfMetersHeading;
	private JTextField jtxtfYardsHeading;
	private JTextField jtxtfFeetHeading;
	private JTextField jtxtfInchesHeading;
	private JTextField jtxtfMillimeters;
	private JTextField jtxtfMeters;
	private JTextField jtxtfYards;
	private JTextField jtxtfFeet;
	private JTextField jtxtfInches;
	private JLabel jlblMessageArea;
	private JPanel jpnl1;
	
	//Class constructor method
	public Tab8JPanelLengthCalc()
	{
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(320, 190));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		jtxtfMillimetersHeading = new JTextField(6);
		jtxtfMillimetersHeading.setText("Millimeters");
		jtxtfMillimeters = new JTextField(6);
		jtxtfMillimetersHeading.setEditable(false);
		
		jtxtfMetersHeading = new JTextField(5);
		jtxtfMetersHeading.setText("Meters");
		jtxtfMeters = new JTextField(5);
		jtxtfMetersHeading.setEditable(false);
		
		jtxtfYardsHeading = new JTextField(5);
		jtxtfYardsHeading.setText("Yards");
		jtxtfYards = new JTextField(5);
		jtxtfYardsHeading.setEditable(false);
		
		jtxtfFeetHeading = new JTextField(4);
		jtxtfFeetHeading.setText("Feet");
		jtxtfFeet = new JTextField(4);
		jtxtfFeetHeading.setEditable(false);
		
		jtxtfInchesHeading = new JTextField(5);
		jtxtfInchesHeading.setText("Inches");
		jtxtfInches = new JTextField(5);
		jtxtfInchesHeading.setEditable(false);
		
		btnConvert = new JButton("Convert");	
		btnExit = new JButton("Exit");
		btnClear = new JButton("Clear");
		jlblMessageArea = new JLabel("");
		jlblMessageArea.setFont(new Font("Serif", Font.PLAIN, 11));
		
		//Set the layout of the container
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jtxtfMillimetersHeading);
		jpnl1.add(jtxtfMetersHeading);
		jpnl1.add(jtxtfYardsHeading);
		jpnl1.add(jtxtfFeetHeading);
		jpnl1.add(jtxtfInchesHeading);
		jpnl1.add(jtxtfMillimeters);
		jpnl1.add(jtxtfMeters);
		jpnl1.add(jtxtfYards);
		jpnl1.add(jtxtfFeet);
		jpnl1.add(jtxtfInches);
		jpnl1.add(btnConvert);
		jpnl1.add(btnExit);
		jpnl1.add(btnClear);
		jpnl1.add(jlblMessageArea);
		
		//Set Tab/Panel color
		//jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnConvert.setMnemonic('C');
		btnExit.setMnemonic('X');
		btnClear.setMnemonic('L');
		
		//Add action listener to each button
		btnConvertHandler chandler = new btnConvertHandler();
		btnConvert.addActionListener(chandler);
		
		btnClearHandler lhandler = new btnClearHandler();
		btnClear.addActionListener(lhandler);
		
		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
		
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Convert button. The required method actionPerformed
	 * is created to read the first entered value among the measurements:
	 * Millimeters, Meters, Yards, Feet, and Inches. The program
	 * then converts the value to all the other units of measurement and
	 * displays the results in the JTextField boxes. 
	 * 1 Meter = 1000 Millimeters
	 * 1 Yard = 3 Feet              1 Yard = 0.9144 meters
	 * 1 Foot = 12 Inches           1 Foot = 0.3048 meters
	 * 
	 * If the first populated entry contains invalid data,
	 * a zero value will be used for that field instead.
	 */

	class btnConvertHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DecimalFormat num = new DecimalFormat(",###.###");
			double millimeters = 0, meters = 0;
			double yards = 0, feet = 0, inches = 0;			
			jlblMessageArea.setText("");
			
			if (!jtxtfMillimeters.getText().equals(""))
			{
				try { 
					millimeters = Double.parseDouble(jtxtfMillimeters.getText()); 
				}
				catch (NumberFormatException ex) { 
				}
				meters = millimeters / 1000;
				yards = meters / 0.9144;
				feet = yards * 3;
				inches = feet * 12;
			}	
			else if (!jtxtfMeters.getText().equals(""))
			{
				try { 
					meters = Double.parseDouble(jtxtfMeters.getText()); 
				}
				catch (NumberFormatException ex) { 
				}
				millimeters = meters * 1000;
				yards = meters / 0.9144;
				feet = yards * 3;
				inches = feet * 12;
			}
			else if (!jtxtfYards.getText().equals(""))
			{
				try { 
					yards = Double.parseDouble(jtxtfYards.getText()); 
				}
				catch (NumberFormatException ex) { 
				}
				feet = yards * 3;
				inches = feet * 12;
				meters = yards * 0.9144;
				millimeters = meters * 1000;				
			}
			else if (!jtxtfFeet.getText().equals(""))
			{
				try { 
					feet = Double.parseDouble(jtxtfFeet.getText()); 
				}
				catch (NumberFormatException ex) { 
				}
				yards = feet / 3;
				inches = feet * 12;
				meters = yards * 0.9144;
				millimeters = meters * 1000;			
			}
			else if (!jtxtfInches.getText().equals(""))
			{
				try { 
					inches = Double.parseDouble(jtxtfInches.getText()); 
				}
				catch (NumberFormatException ex) { 
				}
				feet = inches / 12;
				yards = feet / 3;
				meters = yards * 0.9144;
				millimeters = meters * 1000;			
			}
		
			//Display results to the screen for all 5 units
			jtxtfMillimeters.setText(num.format(millimeters));
			jtxtfMeters.setText(num.format(meters));
			jtxtfYards.setText(num.format(yards));
			jtxtfFeet.setText(num.format(feet));
			jtxtfInches.setText(num.format(inches));
		}
	}
	
	/**
	 * This class implements the ActionListner interface
	 * and handles the action of the Clear button,
	 * which clears all 5 JTextFields
	 */	
	class btnClearHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Display results to the screen for all 5 units
			jtxtfMillimeters.setText("");
			jtxtfMeters.setText("");
			jtxtfYards.setText("");
			jtxtfFeet.setText("");
			jtxtfInches.setText("");
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