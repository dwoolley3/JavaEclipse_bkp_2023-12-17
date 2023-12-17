/***********************************************************************
Program Name:        Tab1JPanelIndex.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for Index, 
                     whereby the program allows a user to enter text and
                     a letter and displays the number of occurrences of the
                     letter in the text, irrespective of case. The program
                     utilizes the indexOf command, thus titled "Index".
     We can place this JPanel into an individual tab on the JFrame.
 ***********************************************************************/

package week6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab1JPanelIndex extends JPanel 
{ // start class	
	static final long serialVersionUID = 54321; // assign any number

	// Global objects to be used in inner classes, if necessary.
	// Declare variables for controls needed to create GUI

	//private JFrame mainFrame;
	private JPanel jpnl1;
	private JLabel jlblInstructions1;
	private JLabel jlblInstructions2;
	private JTextArea jtxtaText;
	private JTextField jtxtfCharacter;
	private JTextField jtxtfResults;
	
	//Class constructor method
	public Tab1JPanelIndex()
	{
		//Define objects in constructor	
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 170));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		jlblInstructions1 = new JLabel("Enter text to be searched");
		jlblInstructions2 = new JLabel("Enter a character:");
		jtxtaText = new JTextArea(5,20);
		jtxtaText.setWrapStyleWord(true);
		jtxtaText.setLineWrap(true);
		jtxtfCharacter = new JTextField(2);
		jtxtfResults = new JTextField(12);
		jtxtfResults.setEditable(false);
		
		//Set the layout of the panel
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblInstructions1);	
		jpnl1.add(jtxtaText);
		jpnl1.add(jlblInstructions2);	
		jpnl1.add(jtxtfCharacter);
		jpnl1.add(jtxtfResults);
		
		//Set Tab/Panel color
		jpnl1.setBackground(Color.orange); 
		
		//Add action listener to text field for character	
		SearchCharHandler chandler = new SearchCharHandler();
		jtxtfCharacter.addActionListener(chandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the JTextField
	 * control named jtxtfCharacter. The required method actionPerformed
	 * is created to read the input values of the letter and text
	 * and determine the number of occurrences of the letter in the text.
	 */

	class SearchCharHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Retrieve character & text and determine number of occurrences
			// of the character in text (irrespective of case)
		
			//Retrieve text and make all letters lower case for comparison
			String text = jtxtaText.getText().toLowerCase();
			
			//Retrieve character and make it lower case for comparison
			char chOrig = 'a', chLow = 'a';
			if (jtxtfCharacter.getText().length() > 0)
			{
				chOrig = jtxtfCharacter.getText().charAt(0);	
				chLow = jtxtfCharacter.getText().toLowerCase().charAt(0);				
			}

			int startAt = 0, cnt = 0;
			int ind = text.indexOf(chLow, startAt);
			while (ind > -1)
			{
				cnt++;             //Found an occurrence
				startAt = ind + 1; //Start checking after current char
				ind = text.indexOf(chLow, startAt);
			}
			
			String s = String.format("Number of %s's: %d", chOrig, cnt);
			jtxtfResults.setText(s);
		}
	}
}

