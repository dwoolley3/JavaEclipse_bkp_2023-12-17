/***********************************************************************
Program Name:        Point.java
Programmer's Name:   Doug Woolley
Program Description: This class is a parent class to Square and Cube.
                     This class declares variables of x and y coordinates.
                     This class has a method of toString() to display a
                     point, which can be overridden in child classes.
 ***********************************************************************/
package week4;

public class Point
{
	// instance variables
	private int x_coordinate;
	private int y_coordinate;
	
	//Parameterized constructor to initialize x and y variables
	public Point(int x, int y)
	{
		this.x_coordinate = x;
		this.y_coordinate = y;
	}
	
	public int getX() { return x_coordinate;};
	public int getY() { return y_coordinate;};
	public void setX(int x) {this.x_coordinate = x;};
	public void setY(int y) {this.y_coordinate = y;};	
	
	public String toString()
	{
		return " x-coordinate = " + x_coordinate 
			+ "\n y-coordinate = " + y_coordinate;		
	}
}

