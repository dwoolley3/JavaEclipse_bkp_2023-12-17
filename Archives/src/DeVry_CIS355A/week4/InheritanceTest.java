package week4;

public class InheritanceTest {

	public static void main(String[] args) {
		// User enters x, y, and sideLength
		//
		//Point:
		//X-Coordinate is 5
		//Y-Coordinate is 6
		//
		//Square:
		//X-Coordinate is 5
		//Y-Coordinate is 6
		//Side length is 10
		//Perimeter is 40
		//Area is 100
		//
		//Cube:
		//X-Coordinate is 5
		//Y-Coordinate is 6
		//Depth is 10
		//Area is 600
		//Volume is 1000		
		
		int x = 5, y = 6, sideLength = 10;
		Point p = new Point(x,y);
		Square s = new Square(x,y,sideLength);
		Cube c = new Cube(x,y,sideLength);
		
		System.out.println("Point:\n" + p.toString());
		System.out.println("\nSquare:\n" + s.toString());
		System.out.println("\nCube:\n" + c.toString());
	}	
}