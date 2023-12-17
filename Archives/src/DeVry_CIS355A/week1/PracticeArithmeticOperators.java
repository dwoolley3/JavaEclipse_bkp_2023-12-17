/***********************************************************************
Program Name:        PracticeArithmeticOperators.java
Programmer's Name:   Doug Woolley
Program Description: This program will accept two integers as input, via 
					 GUI input dialog boxes. The program outputs in tabular
					 format the sum, difference, product and quotient of 
					 the two numbers. Results are displayed to the system
					 console and in a GUI message dialog box.
***********************************************************************/ 
package week1;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;  //Use JTextArea to properly display tab in GUI dialog

public class PracticeArithmeticOperators {

	public static void main(String[] args) {
		String firstNumber;  //first string entered by the user
		String secondNumber; //second string entered by the user
		int number1;         //converted user input for number 1
		int number2;         //converted user input for number 2
		int sum;             //sum of number 1 and number 2
		int difference;      //difference of number 1 and number 2		
		int prod;			 //product of number 1 and number 2
		int quotient;	     //quotient of number 1 and number 2
		
		//read in first number as a string
		firstNumber = JOptionPane.showInputDialog("Enter first integer");
		//read in second number as a string
		secondNumber = JOptionPane.showInputDialog("Enter second integer");
		//convert numbers from String to type int
		number1 = Integer.parseInt(firstNumber);
		number2 = Integer.parseInt(secondNumber);
		
		sum = number1 + number2;         //add the numbers
		difference = number1 - number2;  //subtract the numbers
		prod = number1 * number2;        //multiply the numbers
		quotient = number1 / number2;    //divide the numbers (integer division)
			
		//Display the results to the console using a single tab between
		//the operation and result; however, if numbers are small, use two tabs.
		String tab = "\t";	
		if (firstNumber.length() + secondNumber.length() < 5)
			tab += "\t";
		System.out.println("Operation\tResult");
		System.out.println(number1 + " + " + number2 + tab + sum);
		System.out.println(number1 + " - " + number2 + tab + difference);
		System.out.println(number1 + " * " + number2 + tab + prod);
		System.out.println(number1 + " / " + number2 + tab + quotient);

		//Note: it is not necessary to also display results to a dialog, but I did.
		//Display the results in a GUI message dialog box
		//The trick to getting the tabs to work in a show Message dialog
		//is to place the strResults into a new JTextArea.
		String strResults;
		tab = "\t";
		strResults = "Operation\tResult\n" +
				number1 + " + " + number2 + tab + sum + "\n" + 
				number1 + " - " + number2 + tab + difference + "\n" + 
				number1 + " * " + number2 + tab + prod + "\n" + 
				number1 + " / " + number2 + tab + quotient;
		JOptionPane.showMessageDialog(null, new JTextArea(strResults));

		System.exit(0);   //terminate the application		
	}

}
