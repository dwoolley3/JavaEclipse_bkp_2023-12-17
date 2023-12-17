/***********************************************************************
Program Name:        Largest.java
Programmer's Name:   Doug Woolley
Program Description: This program will accept as input a series of 10 single-digit
                     numbers and prints the largest of the numbers.
***********************************************************************/ 

package week2;

import javax.swing.JOptionPane;

public class Largest {

	public static void main(String[] args) {
		int counter;    //keeps track of number of inputs
		int number;     // the current digit input to the program
		int largest;    // The largest number found so far
		
		counter = 0;    //Initialize to 0 for first loop comparison
		largest = 0;    //Initialize to smallest digit
		number = 0;     //Initialize to 0
		String strNumber = "";  //Store user input of a number
		
		while (counter < 10) {
			//Retrieve user input of a number
			strNumber = JOptionPane.showInputDialog("Enter number #" + (counter+1) 
					+ " (any single-digit)");
			if (strNumber == null) System.exit(0);  //Exit program if user clicks "Cancel"
			
			//Validate if entry contains an integer and not non-digits
			try {
				number = Integer.parseInt(strNumber);
				//Validate if integer entered is a single digit (0 through 9)
				if (number < 0 || number > 9)
				{
					JOptionPane.showMessageDialog(null,  
							"You must enter a single digit between 0 and 9",
							"DATA ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else  //Valid entry
				{
					counter++;    //Increment number of valid inputs
					//If number is larger than any prior number, 
					//then place number in largest
					if (number > largest)
						largest = number;

				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,  
						"Invalid number entered, try again!",
						"DATA ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		//System.out.println("The largest number is " + largest);
		JOptionPane.showMessageDialog(null, 
				"The largest number is " + largest,
				"Largest Number", JOptionPane.PLAIN_MESSAGE);
	}

}
