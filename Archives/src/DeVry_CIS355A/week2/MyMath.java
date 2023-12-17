package week2;

//File 3

//CIS355A Jul 2013
//Senior Prof B. Stryk
//Week 2 program

import javax.swing.JTextField;

public class MyMath

{ // start class

	// my methods

	public static void myAdd(JTextField jtxfPass1, JTextField jtxfPass2,
			JTextField jtxfPass3) { // start MyAdd()

		int intNum1 = Integer.parseInt(jtxfPass1.getText());

		int intNum2 = Integer.parseInt(jtxfPass2.getText());

		jtxfPass3.setText("" + (intNum1 + intNum2));

		System.out.println("The sum of " + intNum1 + " and " + intNum2 + " is "
				+ (intNum1 + intNum2));

	}

	// end MyAdd()

} // end class
