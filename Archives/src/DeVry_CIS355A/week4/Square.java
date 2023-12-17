/***********************************************************************
Program Name:        Square.java
Programmer's Name:   Doug Woolley
Program Description: This class inherits from class Point.
                     Square class adds a variable of sideLength and methods
                     of area() and perimeter(), while replacing toString().
 ***********************************************************************/

package week4;

public class Square extends Point
{
	private int sideLength;
	
	//Parameterized constructor to initialize x, y, and sideLength variables
	public Square(int x, int y, int sideLength)
	{
		super(x, y);
		this.sideLength = sideLength;
	}
	
	public int getLength() { return sideLength;};
	public void setLength(int len) {this.sideLength = len;};
	
	//The Square toString will first call the Point toString and then
	//concatenate to that the side length, perimeter, and area.
	public String toString()
	{
		return super.toString() 
			+ "\n length = " + sideLength
			+ "\n perimeter = " + perimeter()
			+ "\n area = " + area();		
	}
	public int perimeter() 
	{
		return sideLength * 4;
	}
	public int area()
	{
		return sideLength * sideLength;			
	}
}
