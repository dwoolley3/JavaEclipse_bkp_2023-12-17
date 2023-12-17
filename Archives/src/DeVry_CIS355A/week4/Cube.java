/***********************************************************************
Program Name:        Cube.java
Programmer's Name:   Doug Woolley
Program Description: This class inherits from class Square.
                     Cube class adds a variable of depth and methods
                     of area() and volume(), while replacing toString().
 ***********************************************************************/
package week4;

public class Cube extends Square
{
	//sideLength is length, width, and height
	private int depth;
		
	//Parameterized constructor to initialize x, y, and sideLength variables
	public Cube(int x, int y, int sideLength)
	{
		super(x, y, sideLength);
		//this.x_coordinate = x;
		//this.y_coordinate = y;
		this.depth = sideLength;
	}
	
	public int getDepth() { return depth;};
	public void setDepth(int depth) {this.depth = depth;};
	
	//The Cube toString will first call the getX and getY methods
	//in the Point class and then concatenate to that the 
	//depth, area, and volume.
	public String toString()
	{
		return " x-coordinate = " + getX()
			+ "\n y-coordinate = " + getY()
			+ "\n depth = " + depth
			+ "\n area = " + area()	
			+ "\n volume = " + volume();		
	}
	public int area()
	{
		return depth * depth * 6;			
	}
	public int volume()
	{
		return depth * depth * depth;			
	}
}