/***********************************************************************
Program Name:        Tab2JPanelIndex2.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for Index2, 
                     whereby the program allows a user to enter text and
                     click a button to display the number of occurrences
                     of each letter in the alphabet in the text,
                     irrespective of case. The program
                     utilizes the indexOf command, thus titled "Index2".
     We can place this JPanel into an individual tab on the JFrame.
***********************************************************************/
package week6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab2JPanelIndex2 extends JPanel 
{ // start class	
	static final long serialVersionUID = 54321; // assign any number

	// Global objects to be used in inner classes, if necessary.
	// Declare variables for controls needed to create GUI

	//private JFrame mainFrame;
	private JPanel jpnl1;
	private JLabel jlblInstructions1;
	private JTextArea jtxtaText;
	private JButton btnCount;
	private JTextArea jtxtaResults;
	
	//Class constructor method
	public Tab2JPanelIndex2()
	{
		//Define objects in constructor	
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 580));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		jlblInstructions1 = new JLabel("Enter some text:");
		jtxtaText = new JTextArea(5,20);
		jtxtaText.setWrapStyleWord(true);
		jtxtaText.setLineWrap(true);
		btnCount = new JButton("Count Occurrences of Each Letter");
		jtxtaResults = new JTextArea(27, 10);
		jtxtaResults.setEditable(false);
		
		//Set the layout of the panel
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblInstructions1);	
		jpnl1.add(jtxtaText);
		jpnl1.add(btnCount);	
		jpnl1.add(jtxtaResults);
		
		//Set Tab/Panel color
		jpnl1.setBackground(Color.orange); 
		
		//Add action listener to button	
		ButtonsHandler bhandler = new ButtonsHandler();
		btnCount.addActionListener(bhandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the button Count.
	 * The required method actionPerformed
	 * is created to read the input text and determine the number
	 * of occurrences of each letter in the text.
	 */

	class ButtonsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Retrieve text and determine number of occurrences
			// of each letter in text (irrespective of case)
		
			//Retrieve text and make all letters lower case for comparison
			String text = jtxtaText.getText().toLowerCase();
			
			//Iterate through each lower case letter of alphabet for comparison
			jtxtaResults.setText("");
			char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			for (char letter: alphabet)
			{
				int startAt = 0, cnt = 0;
				int ind = text.indexOf(letter, startAt);
				while (ind > -1)
				{
					cnt++;             //Found an occurrence
					startAt = ind + 1; //Start checking after current char
					ind = text.indexOf(letter, startAt);
				}
				
				String s = String.format("%s:\t%d\n", letter, cnt);
				jtxtaResults.append(s);
			}
		}
	}
}

