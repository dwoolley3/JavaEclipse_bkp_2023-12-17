/***********************************************************************
Program Name:        Tab5JPanelPools.java
Programmer's Name:   Doug Woolley
Program Description: This program will compute a pool's volume given
 	three values for the pool's length, width, and depth. When the user
 	presses the "Calculate Volume" button, if the three text boxes are
 	missing data or have invalid data then an error message is displayed. 	
 ***********************************************************************/

package week7;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.text.DecimalFormat;

public class Tab5JPanelPools extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JButton btnCalculate;
	private JButton btnExit;
	private JTextField jtxtfLength;
	private JTextField jtxtfWidth;
	private JTextField jtxtfDepth;
	private JTextField jtxtfVolume;
	private JLabel jlblLength;
	private JLabel jlblWidth;
	private JLabel jlblDepth;
	private JLabel jlblVolume;
	private JLabel jlblMessageArea;
	private JPanel jpnl1;
	
	//Class constructor method
	public Tab5JPanelPools()
	{
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 190));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		btnExit = new JButton("Exit");
		jlblLength = new JLabel("Enter the pool's length (ft): ");
		jlblWidth = new JLabel("Enter the pool's width (ft): ");
		jlblDepth = new JLabel("Enter the pool's depth (ft): ");
		jlblVolume = new JLabel("The pool's volume is (ft^3): ");
		jtxtfLength = new JTextField(7);
		jtxtfWidth = new JTextField(7);
		jtxtfDepth = new JTextField(7);
		jtxtfVolume = new JTextField(7);
		jtxtfVolume.setEditable(false);
		btnCalculate = new JButton("Calculate Volume");
		jlblMessageArea = new JLabel("");
		jlblMessageArea.setFont(new Font("Serif", Font.PLAIN, 11));
		
		//Set the layout of the container
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblLength);
		jpnl1.add(jtxtfLength);
		jpnl1.add(jlblWidth);
		jpnl1.add(jtxtfWidth);
		jpnl1.add(jlblDepth);
		jpnl1.add(jtxtfDepth);
		jpnl1.add(btnCalculate);
		jpnl1.add(btnExit);
		jpnl1.add(jlblVolume);
		jpnl1.add(jtxtfVolume);
		jpnl1.add(jlblMessageArea);
		
		//Set Tab/Panel color
		//jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnCalculate.setMnemonic('C');
		btnExit.setMnemonic('X');
		
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
		jtxtfVolume.addFocusListener(fhandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Calculate button. The required method actionPerformed
	 * is created to read the input values of the 3 input fields
	 * and calculate the volume of a pool given 3 values.
	 */

	class btnCalculateHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DecimalFormat num = new DecimalFormat(",###.##");
			double length = 0, width = 0, depth = 0, volume;
			Boolean incomplete = false, invalid = false; 
			
			jtxtfLength.setBackground(Color.white);
			jtxtfWidth.setBackground(Color.white);
			jtxtfDepth.setBackground(Color.white);
			
			if (jtxtfLength.getText().equals(""))
			{
				jtxtfLength.setBackground(Color.orange);
				incomplete = true;
			}
			else
			{
				try { 
					length = Double.parseDouble(jtxtfLength.getText()); 
				}
				catch (NumberFormatException ex) { 
					jtxtfLength.setBackground(Color.orange);
					invalid = true;
				}
			}
			
			if (jtxtfWidth.getText().equals(""))
			{
				jtxtfWidth.setBackground(Color.orange);
				incomplete = true;
			}
			else
			{
				try { 
					width = Double.parseDouble(jtxtfWidth.getText()); 
				}
				catch (NumberFormatException ex) { 
					jtxtfWidth.setBackground(Color.orange);
					invalid = true;
				}
			}
			
			if (jtxtfDepth.getText().equals(""))
			{
				jtxtfDepth.setBackground(Color.orange);
				incomplete = true;
			}
			else
			{
				try { 
					depth = Double.parseDouble(jtxtfDepth.getText()); 
				}
				catch (NumberFormatException ex) { 
					jtxtfDepth.setBackground(Color.orange);
					invalid = true;
				}
			}
						
			if (incomplete && invalid)
				jlblMessageArea.setText("Please fill out all fields! "
						+ "Please enter valid numbers!");
			else if (incomplete)
				jlblMessageArea.setText("Please fill out all fields!");
			else if (invalid)
				jlblMessageArea.setText("Please enter valid numbers!");
			else
			{
				volume = length * width * depth;
				jtxtfVolume.setText(num.format(volume));
				jlblMessageArea.setText("");
			}
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
				jtxtfVolume.setText("");
			}
			else if (e.getSource() == jtxtfVolume)
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