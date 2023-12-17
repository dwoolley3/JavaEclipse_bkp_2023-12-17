/***********************************************************************
Program Name:        Diamond.java
Programmer's Name:   Doug Woolley
Program Description: This program will display a diamond of asterisks
					 having a given number of rows.
***********************************************************************/

package week2;

import javax.swing.JOptionPane;

public class Diamond {

	public static void main(String[] args) {
		boolean invalid = true;
		int number = 0;
		String strNumber;
		while (invalid) { 
			invalid = false;
			//Retrieve user input of a number
			strNumber = JOptionPane.showInputDialog(
					"Please enter odd number between 3 and 21");
			//Validate if entry contains an integer and not non-digits
			try {
				number = Integer.parseInt(strNumber);
				//Validate if integer entered is a odd number that is between 3 and 21
				if (number % 2 != 1 || number < 3 || number > 21)
				{
					JOptionPane.showMessageDialog(null,  
							"You must enter an odd number between 3 and 21",
							"DATA ERROR", JOptionPane.ERROR_MESSAGE);
					invalid = true;
				}	
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,  
						"Invalid number entered, try again!",
						"DATA ERROR", JOptionPane.ERROR_MESSAGE);
				invalid = true;
			}
			
		} // end while (invalid)
		diamondOfAsterisks(number);	
		System.exit(0);
	}
	
	private static void diamondOfAsterisks(int rows) {
		String msg = "";
		//Build top half of diamond, including middle row
		for (int i = 1; i <= rows; i += 2)
		{
			for (int j = 1; j <= (rows - i) / 2; j++)
				msg += " ";
			for (int j = 1; j <= i; j++)
				msg += "*";
			msg += "\n";
		}
		//Build bottom half of diamond, below middle row
		for (int i = rows-2; i > 0; i -= 2)
		{
			for (int j = 1; j <= (rows - i) / 2; j++)
				msg += " ";
			for (int j = 1; j <= i; j++)
				msg += "*";
			msg += "\n";
		}
		//The diamond displays better in console than in a showMessageDialog
		System.out.print(msg);
		JOptionPane.showMessageDialog(null, msg,
				"Diamond with " + rows + " rows", 
				JOptionPane.PLAIN_MESSAGE);
	}
}
