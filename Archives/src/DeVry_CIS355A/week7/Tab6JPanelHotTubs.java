
/***********************************************************************
Program Name:        Tab6JPanelHotTubs.java
Programmer's Name:   Doug Woolley
Program Description: This program will compute a tub's volume given
 	three values for the tub's length, width, and depth. When the user
 	presses the "Calculate Volume" button, if the three text boxes are
 	missing data or have invalid data then an error message is displayed. 	
 	If a "Round Tub" is selected, then the text box for width is 
 	disabled since it will be automatically populated with the same
 	value as entered in the length text box (since shape is round).
 ***********************************************************************/

package week7;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.text.DecimalFormat;

public class Tab6JPanelHotTubs extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JRadioButton jrbRoundTub;
	private JRadioButton jrbOvalTub;
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
	public Tab6JPanelHotTubs()
	{
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 190));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		jrbRoundTub = new JRadioButton("Round Tub");
		jrbOvalTub = new JRadioButton("Oval Tub");
		//Group the radio buttons, to automatically unselect other option
	    ButtonGroup group = new ButtonGroup();
	    group.add(jrbRoundTub);
	    group.add(jrbOvalTub);	    
	    jrbRoundTub.setSelected(true);
	    
		jlblLength = new JLabel("Enter the tub's length (ft): ");
		jlblWidth = new JLabel("Enter the tub's width (ft): ");
		jlblDepth = new JLabel("Enter the tub's depth (ft): ");
		jlblVolume = new JLabel("The tub's volume is (ft^3): ");
		jtxtfLength = new JTextField(7);
		jtxtfWidth = new JTextField(7);
		jtxtfDepth = new JTextField(7);
		jtxtfVolume = new JTextField(7);
		jtxtfVolume.setEditable(false);
	    //For Round Tub, width will be automatically set to length
	    jtxtfWidth.setEditable(false);
		btnCalculate = new JButton("Calculate Volume");
		btnExit = new JButton("Exit");
		jlblMessageArea = new JLabel("");
		jlblMessageArea.setFont(new Font("Serif", Font.PLAIN, 11));
		
		//Set the layout of the container
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jrbRoundTub);
		jpnl1.add(jrbOvalTub);		
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

		//Register a listener for the radio buttons.
		jrbHandler rhandler = new jrbHandler();
		jrbRoundTub.addActionListener(rhandler);
		jrbOvalTub.addActionListener(rhandler);
		
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
	 * Radio buttons. The required method actionPerformed
	 * is created to read the select radio button and disable
	 * the text field for width if the "Round Tub" is selected.
	 */
	
	class jrbHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getActionCommand() == "Round Tub")
			{
				jtxtfWidth.setEditable(false);
				jlblMessageArea.setText("");
				
			}
			else if (e.getActionCommand() == "Oval Tub")
			{
				jtxtfWidth.setEditable(true);
				jlblMessageArea.setText("");
			}
		}
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Calculate button. The required method actionPerformed
	 * is created to read the input values of the 3 input fields
	 * and calculate the volume of a tub given 3 values.
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
			jlblMessageArea.setText("");
					
			if (jtxtfLength.getText().equals(""))
			{
				jtxtfLength.setBackground(Color.orange);
				incomplete = true;
			}
			else
			{
				try { 
					length = Double.parseDouble(jtxtfLength.getText()); 
					if (jrbRoundTub.isSelected())
					{
						//For Round Tub, width is set equal to the length
						jtxtfWidth.setText(jtxtfLength.getText());
						jlblMessageArea.setText("Tub's width set to length");
					}
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
				//For Round Tub, width is set equal to the length
				volume =  (Math.PI * (length/2) * (width/2) * depth);
				jtxtfVolume.setText(num.format(volume));
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