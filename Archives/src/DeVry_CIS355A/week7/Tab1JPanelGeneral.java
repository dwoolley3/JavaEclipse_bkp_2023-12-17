/***********************************************************************
Program Name:        Tab1JPanelGeneral.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for General, 
     whereby the program displays a label containing a phrase
     "Today's Date: " followed by today's actual date in the
     format mm/dd/yyyy.
     An exit button is also displayed with x set as a mnemonic.
     We can place this JPanel into an individual tab on the JFrame.
 ***********************************************************************/

package week7;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class Tab1JPanelGeneral extends JPanel 
{ // start class	
	static final long serialVersionUID = 54321; // assign any number

	// Global objects to be used in inner classes, if necessary.
	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;
	private JLabel jlblTodaysDate;
	private JButton btnExit;
	
	//Class constructor method
	public Tab1JPanelGeneral()
	{
		//Define objects in constructor	
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 170));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		//Retrieve today's date and format it with MM/dd/yyyy
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String tDate = dateFormat.format(date);

		jlblTodaysDate = new JLabel("Today's Date: " + tDate);
		btnExit = new JButton("Exit");
		//btnExit.setBackground(Color.red);
		
		//Set the layout of the panel
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblTodaysDate);	
		jpnl1.add(btnExit);
		
		//Set Tab/Panel color
		//jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnExit.setMnemonic('X');
		
		//btnExitHandler is a class that is defined below
		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
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

