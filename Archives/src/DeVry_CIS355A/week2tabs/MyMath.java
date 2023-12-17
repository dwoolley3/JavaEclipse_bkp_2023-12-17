/***********************************************************************
Program Name:        MyMath.java
Programmer's Name:   Doug Woolley
Program Description: This class retrieves two numbers from the GUI in
                     textfields and converts them to integers, so that
                     they can then be added and displayed in the GUI in
                     a third textfield.
 ***********************************************************************/
package week2tabs;

import javax.swing.JTextField;

public class MyMath
{
	// my methods	
	public static void myAdd(
		JTextField jtxfPass1, JTextField jtxfPass2, JTextField jtxfPass3) { 

		int intNum1 = Integer.parseInt(jtxfPass1.getText());

		int intNum2 = Integer.parseInt(jtxfPass2.getText());

		jtxfPass3.setText("" + (intNum1 + intNum2));

		System.out.println("The sum of " + intNum1 + " and " + intNum2 + " is "
				+ (intNum1 + intNum2));
	}
}
