/***********************************************************************
Program Name:        Circle.java
Programmer's Name:   Doug Woolley
Program Description: This program will accept a radius of a circle as input,
                     and then print the circle's diameter, circumference, and area.
                     Input is obtained using a GUI input dialog box,
                     and the output is displayed in a GUI message dialog box.
***********************************************************************/ 

package week1;

import javax.swing.JOptionPane;

public class Circle {

	public static void main(String[] args) {
		//Retrieve user input for radius of a circle (an integer value)
		String strRadius;
		strRadius = JOptionPane.showInputDialog("Enter radius");
		int radius = Integer.parseInt(strRadius);
		
		//Calculate diameter, circumference, and area, given circle's radius
		int diameter = 2 * radius;
		double circumference = 2 * Math.PI * radius;
		double area = Math.PI * radius * radius;
			
		//Display diameter, circumference, and area in GUI Message Dialog box
		JOptionPane.showMessageDialog(null, 
				"Diameter = " + diameter + "\n" + 
				"Circumference = " + circumference + "\n" +
				"Area = " + area, "Circle", JOptionPane.PLAIN_MESSAGE);
	}
}
