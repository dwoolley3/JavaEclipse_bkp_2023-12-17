package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO18_Argentina_L2_Knishop
{
	public int getShortestPath(int x1, int y1, int x2, int y2)
	{
		int sp = 0;
		if (isEqual(x1,y1,x2,y2))
			sp = 0;
		else if (isInDiagonal(x1,y1,x2,y2))
			sp = 1;
		else if (isWithinKnight(x1,y1,x2,y2))
			sp = 1;
		else
		{
			sp = 3;
			for (int i = -1; i <= 1; i+=2) 
				for (int j = -1; j <= 1; j+=2)
					for (int k = 1; k <= 2; k++)
					{
						int x3 = x1 + k*i, y3 = y1 + (3-k)*j;
						if (isEqual(x3,y3,x2,y2))
						{
							sp = 1;
							return sp;
						}
						else if (isInDiagonal(x3,y3,x2,y2))
						{
							sp = 2;
							return sp;
						}
						else if (isWithinKnight(x3,y3,x2,y2))
						{
							sp = 2;
							return sp;
						}
					}		
		}
		
		return sp;
	}
	
	private boolean isEqual(int x1, int y1, int x2, int y2)
	{
		return x1 == x2 && y1 == y2;
	}
	
	private boolean isInDiagonal(int x1, int y1, int x2, int y2)
	{
		return (Math.abs(x1 - x2) == Math.abs(y1 - y2));
	}
	
	private boolean isWithinKnight(int x1, int y1, int x2, int y2)
	{
		if (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2)
			return true;
		else if (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1)
			return true;
		return false;
	}
	
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		TCO18_Argentina_L2_Knishop obj;
		int answer;
		obj = new TCO18_Argentina_L2_Knishop();
		long startTime = System.currentTimeMillis();
		answer = obj.getShortestPath(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p4;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		int p0;
		int p1;
		int p2;
		int p3;
		int p4;
		
		// ----- test 0 -----
		p0 = 0;
		p1 = 0;
		p2 = 2;
		p3 = 3;
		p4 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 5;
		p1 = 2;
		p2 = 7;
		p3 = 0;
		p4 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 918273645;
		p1 = 987654321;
		p2 = 123456789;
		p3 = 123456798;
		p4 = 3;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 42;
		p1 = 47;
		p2 = 42;
		p3 = 47;
		p4 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 10;
		p1 = 10;
		p2 = 14;
		p3 = 8;
		p4 = 2;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
