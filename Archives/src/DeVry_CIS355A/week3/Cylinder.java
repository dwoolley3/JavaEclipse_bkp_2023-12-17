/***********************************************************************
Program Name:        Cylinder.java
Programmer's Name:   Doug Woolley
Program Description: This class contains two double-precision instance
 					 variables named radius and height.
                     This class contains a constructor that initializes
                     the radius and height variables.
                     This class contains a method named volume() that 
                     computes and returns the volume of a Cylinder object,
                     given the radius and height.
 ***********************************************************************/

package week3;

import javax.swing.JTextField;

public class Cylinder

{ // start class

	// instance variables
	private double radius;
	private double height;
	
	//Parameterized constructor to initialize radius and height variables
	public Cylinder(double r, double h)
	{
		radius = r;
		height = h;
	}
	
	// class methods

	public double volume() { // start volume()
		//The volume of a cylinder is given by its 
		//radius squared times its height times Pi 
		//(radius * radius * height * Math.PI). 
		double volume = radius * radius * height * Math.PI;
		//System.out.println("volume of cylinder = " + volume);
		
		return volume;
	}
	// end volume()

} // end class
