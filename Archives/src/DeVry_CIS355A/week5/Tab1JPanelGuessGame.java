/***********************************************************************
Program Name:        Tab1JPanelGuessGame.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for a Guess Game, 
                     whereby the program randomly selects a number between
                     1 and 1000, allowing the user to guess the number.
                     The program provides feedback about the guess:
                     1) Too High. Try a lower number
                     2) Too Low. Try a higher number
                     3) Correct. You guessed in ## tries.
                     If the guess is closer to the number than the prior guess,
                     then the textbox turns red, otherwise it turns blue.
     We can place this JPanel into an individual tab on the JFrame.
 ***********************************************************************/
package week5;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Random;  // For Random number generator

public class Tab1JPanelGuessGame extends JPanel 
{ // start class	
	static final long serialVersionUID = 54321; // assign any number

	// Global objects to be used in inner classes, if necessary.
	// Declare variables for controls needed to create GUI

	//private JFrame mainFrame;
	private JPanel jpnl1;
	private JButton btnTryTheNumber;
	private JButton btnNewGame;
	private JButton btnExit;
	private JLabel jlblInstructions1;
	private JLabel jlblInstructions2;
	private JLabel jlblGuessPhrase;
	private JTextField jtxtfGuess;
	private JTextField jtxtfMessage;
	private int number;   //Randomly generated number to be guessed
	private int tries = 0; //Number of tries made to guess random number
	private int priorGuess = -9999;  //Prior Guess made by user 
	private int maxGuessNum = 1000;  //Highest number possible for guess
	Random rn;  //Random Number to be generated 
	
	//Class constructor method
	public Tab1JPanelGuessGame()
	{
		//Define objects in constructor
		//mainFrame = new JFrame("Office Area Calculator");
		
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(260, 170));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		btnExit = new JButton("Exit");
		jlblInstructions1 = new JLabel("I have a number between 1 and 1000;");
		jlblInstructions2 = new JLabel("can you guess my number?");
		jlblGuessPhrase = new JLabel("Enter your guess:");
		jtxtfGuess = new JTextField(4);
		jtxtfMessage = new JTextField(20);
		jtxtfMessage.setEditable(false);
		
		btnTryTheNumber = new JButton("Try the number");
		btnTryTheNumber.setBackground(Color.green);
		btnExit.setBackground(Color.red);
		btnNewGame = new JButton("New Game");
		
		//Set the layout of the panel
		jpnl1.setLayout(new FlowLayout());
		
		//Add components to the container
		jpnl1.add(jlblInstructions1);	
		jpnl1.add(jlblInstructions2);	
		jpnl1.add(jlblGuessPhrase);
		jpnl1.add(jtxtfGuess);
		jpnl1.add(btnTryTheNumber);
		jpnl1.add(btnExit);
		jpnl1.add(btnNewGame);
		jpnl1.add(jtxtfMessage);
		
		//Set Tab/Panel color
		jpnl1.setBackground(Color.orange); 
		
		//Set the mnemonic for each button
		btnTryTheNumber.setMnemonic('T');
		btnExit.setMnemonic('X');
		btnNewGame.setMnemonic('N');
		
		//Add action listener to each button
		btnTryTheNumberHandler thandler = new btnTryTheNumberHandler();
		btnTryTheNumber.addActionListener(thandler);
		
		//Add action listener to each button
		btnNewGameHandler nhandler = new btnNewGameHandler();
		btnNewGame.addActionListener(nhandler);
		
		//btnExitHandler is a class that is defined below
		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
					
		//FocusHandler is a class that is defined below
		FocusHandler fhandler = new FocusHandler();
		//jtxtfLength.addFocusListener(fhandler);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
		
		//Generate random number		
		rn = new Random();
		number = rn.nextInt(maxGuessNum) + 1;  //Between 1 and 1000
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Calculate button. The required method actionPerformed
	 * is created to read the input values of the input fields
	 * and calculate the area of an office given the dimensions.
	 */

	class btnTryTheNumberHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Retrieve guess and ensure it is an integer; if not, make it 0
			int guess = 0;
			try { guess = Integer.parseInt(jtxtfGuess.getText()); }
			catch (NumberFormatException ex) { guess = 0; jtxtfGuess.setText("0"); }
			
			tries++;
			if (guess == number)
			{
				jtxtfMessage.setText("Correct. You guessed in " + tries + " tries.");
				jtxtfGuess.setEditable(false);  //No more guesses needed
				jtxtfMessage.setBackground(Color.white);
				jtxtfMessage.setForeground(Color.black);
				btnTryTheNumber.setEnabled(false);
			}
			else if (guess < number)
			{
				jtxtfMessage.setText("Too Low. Try a higher number.");
				//if user is getting warmer, display message in red;
				//if user is getting colder, display message in blue
				if (Math.abs(guess - number) < Math.abs(priorGuess - number))
				{
					jtxtfMessage.setBackground(Color.red);
					jtxtfMessage.setForeground(Color.black);
				}
				else  //colder
				{
					jtxtfMessage.setBackground(Color.blue);
					jtxtfMessage.setForeground(Color.white);
				}
			}
			else // (guess > number)
			{
				jtxtfMessage.setText("Too High. Try a lower number.");
				//if user is getting warmer, display message in red;
				//if user is getting colder, display message in blue
				if (Math.abs(guess - number) < Math.abs(priorGuess - number))
				{
					jtxtfMessage.setBackground(Color.red);
					jtxtfMessage.setForeground(Color.black);
				}
				else  //colder
				{
					jtxtfMessage.setBackground(Color.blue);
					jtxtfMessage.setForeground(Color.white);
				}
			}
			priorGuess = guess;
			jtxtfGuess.selectAll();
			jtxtfGuess.requestFocus();  //Place focus on guess textbox
		}
	}
	
	class btnNewGameHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			tries = 0;
			jtxtfMessage.setText("");
			jtxtfGuess.setText("");
			//Generate random number		
			rn = new Random();
			number = rn.nextInt(maxGuessNum) + 1;  //Between 1 and 1000
			jtxtfGuess.setEditable(true);  //Allow guessing again
			priorGuess = -9999;
			jtxtfMessage.setBackground(Color.white);
			jtxtfMessage.setForeground(Color.black);
			btnTryTheNumber.setEnabled(true);
			jtxtfGuess.requestFocus();  //Place focus on guess textbox
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
		}
		
		public void focusLost(FocusEvent e)
		{
		}
	}
}

