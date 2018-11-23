package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM441_Div2_L2_PaperAndPaintEasy
{
	public long computeArea(int width, int height, int xfold, int cnt, int x1, int y1, int x2, int y2)
	{
		long xf = Math.min(xfold, width - xfold);
		long val = 0;
		long xdif = x2 - x1, ydif = y2 - y1;
		if (x1 >= 0 && x2 < xf)
		   val= xdif * ydif * ((cnt+1)*2);
		else if (x1 >= xf && x2 <= width)
		   val = xdif * ydif * (cnt + 1);
		else
		{
		   long t1 = ydif * (xf-x1) * (cnt+1) * 2;
		   long t2 = ydif * (x2-xf) * (cnt+1);
		   val = t1 + t2;
		}
		long area = (long)width * height;
		return area - val;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, boolean hasAnswer, long p8) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6 + "," + p7);
		System.out.println("]");
		SRM441_Div2_L2_PaperAndPaintEasy obj;
		long answer;
		obj = new SRM441_Div2_L2_PaperAndPaintEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.computeArea(p0, p1, p2, p3, p4, p5, p6, p7);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p8);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p8;
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
		int p5;
		int p6;
		int p7;
		long p8;
		
		// ----- test 0 -----
		p0 = 5;
		p1 = 6;
		p2 = 2;
		p3 = 2;
		p4 = 1;
		p5 = 1;
		p6 = 3;
		p7 = 2;
		p8 = 21L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 3;
		p1 = 13;
		p2 = 1;
		p3 = 0;
		p4 = 1;
		p5 = 8;
		p6 = 2;
		p7 = 12;
		p8 = 35L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 12;
		p1 = 12;
		p2 = 7;
		p3 = 3;
		p4 = 3;
		p5 = 1;
		p6 = 6;
		p7 = 2;
		p8 = 124L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 4;
		p1 = 5;
		p2 = 4;
		p3 = 0;
		p4 = 0;
		p5 = 0;
		p6 = 1;
		p7 = 1;
		p8 = 19L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 4;
		p1 = 8;
		p2 = 4;
		p3 = 3;
		p4 = 0;
		p5 = 1;
		p6 = 2;
		p7 = 2;
		p8 = 24L;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 4;
		p1 = 8;
		p2 = 3;
		p3 = 0;
		p4 = 1;
		p5 = 1;
		p6 = 3;
		p7 = 2;
		p8 = 30L;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
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
