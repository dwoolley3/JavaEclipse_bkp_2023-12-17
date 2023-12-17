/***********************************************************************
Program Name:        Tab2JPanelIndex2.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for Options, 
	whereby the program allows a user to enter text for a Company Name,
	which then gets placed in the title of the JFrame upon clicking the
	button "Set New Name".
    We can place this JPanel into an individual tab on the JFrame.
***********************************************************************/
package week7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab2JPanelOptions extends JPanel 
{ 
	static final long serialVersionUID = 54321; // assign any number

	// Global objects to be used in inner classes, if necessary.
	// Declare variables for controls needed to create GUI

	private JButton btnSetNewName;
	private JButton btnExit;
	private JTextField jtxtfCompanyName;
	private JLabel jlblInstructions;
	private JPanel jpnl1;
	
	//Class constructor method
	public Tab2JPanelOptions()
	{
		//Define objects in constructor
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 150));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		btnExit = new JButton("Exit");
		jlblInstructions = new JLabel("Change Company Name:");
		jtxtfCompanyName = new JTextField(20);
		btnSetNewName = new JButton("Set New name");
	
		//Set the layout of the container
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblInstructions);
		jpnl1.add(jtxtfCompanyName);
		jpnl1.add(btnSetNewName);
		jpnl1.add(btnExit);
		
		//Set Tab/Panel color
		//jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnSetNewName.setMnemonic('S');
		btnExit.setMnemonic('X');
		
		//Add action listener to each button
		btnSetNewNameHandler chandler = new btnSetNewNameHandler();
		btnSetNewName.addActionListener(chandler);

		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * "Set New name" button. The required method actionPerformed
	 * is created to read the input values of the new Company Name,
	 * and assign the JFrame's title to this new Company name.
	 */

	class btnSetNewNameHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			//Retrieve company name from the JTextField.
			String companyName = jtxtfCompanyName.getText();

			//Get reference to the top frame by repeatedly getting
			//the Parent component until there are no more parents.
			//Then, set the Title of the frame to the companyName.
		    Component c = getParent();   
	        while( c.getParent() != null )   
	        {   
	            c = c.getParent();   
	        }   
	     
	        Frame topFrame = ( Frame )c;   
	        topFrame.setTitle(companyName ); 
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