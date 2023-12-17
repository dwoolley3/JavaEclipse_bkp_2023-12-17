/***********************************************************************
Program Name:        Palindrome.java
Programmer's Name:   Doug Woolley
Program Description: This program will determine if the input five-digit integer
                     is a palindrome (same number written forward and backward)
***********************************************************************/ 

package week2;

import javax.swing.JOptionPane;

public class Palindrome {

	public static void main(String[] args) {
		int number = retrieveInput();
		Boolean isPalindrome;
		isPalindrome = check(number);
		display(number, isPalindrome);
	}
	
	private static int retrieveInput(){
		//This method prompts and retrieves the input values as a String;
		//Method will check if input is numeric and 5-digits
		boolean done = false;
		String strNumber = "";
		int number = 0;       //
		while (!done) { 
			done = true;     //Initialize to true, expecting the best
			//Retrieve user input of a number
			strNumber = JOptionPane.showInputDialog("Enter 5-digit number");
			//Validate if entry contains an integer and not non-digits
			try {
				number = Integer.parseInt(strNumber);
				//Validate if integer entered is exactly 5 digits
				if (strNumber.length() != 5)
				{
					JOptionPane.showMessageDialog(null,  
							"Number does not have 5 digits, try again!",
							"DATA ERROR", JOptionPane.ERROR_MESSAGE);
					done = false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,  
						"Invalid number entered, try again!",
						"DATA ERROR", JOptionPane.ERROR_MESSAGE);
				done = false;
			}							
		} // end while (!done)
		return number;
	}
	
	private static Boolean check(int number){
		//This method determines whether the 5-digit input is a palindrome, 
		//using numeric approach
		int num = number, reverse = 0, digit;
		while (num > 0)
		{
			digit = num % 10;
			reverse = reverse * 10 + digit;
			num /= 10;			
		}
		return (number == reverse);
	}
	
	private static Boolean check2(int number){
		//This method determines whether the 5-digit input is a palindrome, 
		//using string approach
		boolean isPalindrome = true;
		String strNumber = Integer.toString(number);
		int len = strNumber.length();
		for (int i = 0; i < len; i++)
			if (strNumber.charAt(i) != strNumber.charAt(len - i - 1))
				isPalindrome = false;
		return isPalindrome;
	}
	
	private static void display(int number, Boolean isPalindrome) {
		//This method displays the result of whether the input is a 5-digit palindrome
		String message = Integer.toString(number);
		if (isPalindrome)
			message += " is a palindrome";
		else
			message += " is NOT a palindrome";
		
		//System.out.println(message);
		JOptionPane.showMessageDialog(null, message, 
				"Is Number a Palindrome?", JOptionPane.PLAIN_MESSAGE);
	}
}
