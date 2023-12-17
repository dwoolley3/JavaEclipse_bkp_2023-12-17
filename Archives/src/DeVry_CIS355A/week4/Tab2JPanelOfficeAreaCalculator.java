/***********************************************************************
Program Name:        Tab2JPanelOfficeAreaCalculator.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for an Office Area 
 					 Calculator. The GUI accepts as input length and width.
 					 After clicking a button, the actionPerformed method
					 will retrieve the entered length and width, and
					 then display the area by multiplying length and width.
	 This program was changed from extending JFrame to extending JPanel.
     Thus, we can place this JPanel into an individual tab on the JFrame.
 ***********************************************************************/
package week4;

import java.awt.*;
import java.awt.event.*;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;

public class Tab2JPanelOfficeAreaCalculator extends JPanel { // start class

	// Global objects to be used in inner classes, if necessary.
	// Declare variables for controls needed to create GUI

	//private JFrame mainFrame;
	private JButton btnCalculate;
	private JButton btnExit;
	private JTextField jtxtfLength;
	private JTextField jtxtfWidth;
	private JTextField jtxtfArea;
	private JLabel jlblLength;
	private JLabel jlblWidth;
	private JLabel jlblArea;
	private JPanel jpnl1;
	
	//Class constructor method
	public Tab2JPanelOfficeAreaCalculator()
	{
		//Define objects in constructor
		//mainFrame = new JFrame("Office Area Calculator");
		
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 150));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		btnExit = new JButton("Exit");
		jlblLength = new JLabel("Enter the length of the office:");
		jlblWidth = new JLabel("Enter the width of the office:");
		jlblArea = new JLabel("Office area:");
		jtxtfLength = new JTextField(5);
		jtxtfWidth = new JTextField(5);
		jtxtfArea = new JTextField(5);
		jtxtfArea.setEditable(false);
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBackground(Color.green);
		btnExit.setBackground(Color.red);
		
		//Get a container for the frame
		//Container c = mainFrame.getContentPane();			
		//Set the layout of the container
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblLength);
		jpnl1.add(jtxtfLength);
		jpnl1.add(jlblWidth);
		jpnl1.add(jtxtfWidth);
		jpnl1.add(jlblArea);
		jpnl1.add(jtxtfArea);
		jpnl1.add(btnCalculate);
		jpnl1.add(btnExit);
		
		//Set Tab/Panel color
		jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnCalculate.setMnemonic('C');
		btnExit.setMnemonic('X');
		
		//Set the size of the GUI frame
		//mainFrame.setSize(260, 150);
		
		//Make sure you terminate the program when the application is closed
		//mainFrame.addWindowListener(new WindowAdapter() {
		//	public void windowClosing(WindowEvent e) {
		//		System.exit(0);
		//	}
		//} );
		
		//Add action listener to each button
		//btnCalculatehandler is a class that is defined below
		btnCalculateHandler chandler = new btnCalculateHandler();
		btnCalculate.addActionListener(chandler);
		
		//btnExitHandler is a class that is defined below
		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
		
		//FocusHandler is a class that is defined below
		FocusHandler fhandler = new FocusHandler();
		jtxtfLength.addFocusListener(fhandler);
		jtxtfWidth.addFocusListener(fhandler);
		jtxtfArea.addFocusListener(fhandler);
		
		//Set the GUI frame visible
		//mainFrame.setVisible(true);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Calculate button. The required method actionPerformed
	 * is created to read the input values of the input fields
	 * and calculate the area of an office given the dimensions.
	 */

	class btnCalculateHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DecimalFormat num = new DecimalFormat(",###.##");
			double width, length, area;
			String instring;
			
			instring = jtxtfLength.getText();
			if (instring.equals(""))
			{
				instring = ("0");
				jtxtfLength.setText("0");				
			}
			length = Double.parseDouble(instring);
		
			instring = jtxtfWidth.getText();
			if (instring.equals(""))
			{
				instring = ("0");
				jtxtfWidth.setText("0");				
			}
			width = Double.parseDouble(instring);
			
			area = length * width;
			jtxtfArea.setText(num.format(area));
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
			
	/**
	 * This class implements the FocusListener interface
	 * and handles the focus of the components.
	 */	
	class FocusHandler implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			if (e.getSource() == jtxtfLength || e.getSource() == jtxtfWidth)
			{
				jtxtfArea.setText("");
			}
			else if (e.getSource() == jtxtfArea)
			{
				btnCalculate.requestFocus();
			}
		}
		
		public void focusLost(FocusEvent e)
		{
			if (e.getSource() == jtxtfWidth)
			{
				btnCalculate.requestFocus();
			}
		}
	}
}

