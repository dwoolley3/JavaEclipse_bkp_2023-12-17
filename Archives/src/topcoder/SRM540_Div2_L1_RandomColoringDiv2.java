package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM540_Div2_L1_RandomColoringDiv2
{
	public int getCount(int maxR, int maxG, int maxB, int startR, int startG, int startB, int d1, int d2)
	{
        int count = 0;
        for (int r = 0; r < maxR; r++)
            for (int g = 0; g < maxG; g++)
                for (int b = 0; b < maxB; b++)
                    if ((Math.abs(startR - r) <= d2 
                     && Math.abs(startG - g) <= d2
                     && Math.abs(startB - b) <= d2)
                     && (Math.abs(startR - r) >= d1
                     || Math.abs(startG - g) >= d1
                     || Math.abs(startB - b) >= d1))
                        count++;
        return count;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, boolean hasAnswer, int p8) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6 + "," + p7);
		System.out.println("]");
		SRM540_Div2_L1_RandomColoringDiv2 obj;
		int answer;
		obj = new SRM540_Div2_L1_RandomColoringDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getCount(p0, p1, p2, p3, p4, p5, p6, p7);
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
		int p8;
		
		// ----- test 0 -----
		p0 = 5;
		p1 = 1;
		p2 = 1;
		p3 = 2;
		p4 = 0;
		p5 = 0;
		p6 = 0;
		p7 = 1;
		p8 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 4;
		p1 = 2;
		p2 = 2;
		p3 = 0;
		p4 = 0;
		p5 = 0;
		p6 = 3;
		p7 = 3;
		p8 = 4;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 4;
		p1 = 2;
		p2 = 2;
		p3 = 0;
		p4 = 0;
		p5 = 0;
		p6 = 5;
		p7 = 5;
		p8 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 6;
		p1 = 9;
		p2 = 10;
		p3 = 1;
		p4 = 2;
		p5 = 3;
		p6 = 0;
		p7 = 10;
		p8 = 540;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 6;
		p1 = 9;
		p2 = 10;
		p3 = 1;
		p4 = 2;
		p5 = 3;
		p6 = 4;
		p7 = 10;
		p8 = 330;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 49;
		p1 = 59;
		p2 = 53;
		p3 = 12;
		p4 = 23;
		p5 = 13;
		p6 = 11;
		p7 = 22;
		p8 = 47439;
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