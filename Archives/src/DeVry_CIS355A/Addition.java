//Program: Addition.java
//Simple addition program that uses dialog boxes for user input and output

//Java extension packages
import javax.swing.JOptionPane; 

public class Addition {

	public static void main(String[] args) {
		String firstNumber;  //first string entered by the user
		String secondNumber; //second string entered by the user
		int number1;         //converted user input for number 1
		int number2;         //converted user input for number 2
		int sum;             //sum of number 1 and number 2
		//read in first number as a string
		firstNumber = JOptionPane.showInputDialog("Enter first integer");
		//read in second number as a string
		secondNumber = JOptionPane.showInputDialog("Enter second integer");
		//convert numbers from String to type int
		number1 = Integer.parseInt(firstNumber);
		number2 = Integer.parseInt(secondNumber);
		//add the numbers
		sum = number1 + number2;
		//display the results
		JOptionPane.showMessageDialog(null, "The result of " +
				number1 + " + " + number2 + " = " + sum,
				"Results", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);   //terminate the application		
	}

}
