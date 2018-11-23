package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2013_R1C_L1_TheArray
{
	public int find(int n, int d, int first, int last)
	{
        for (int i = 2; i < n; i++)
        {
            if (first < last)
                first += d;
            else
                last += d;
        }
        return Math.max(first,last);
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		TCO2013_R1C_L1_TheArray obj;
		int answer;
		obj = new TCO2013_R1C_L1_TheArray();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0, p1, p2, p3);
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
		p0 = 3;
		p1 = 5;
		p2 = 2;
		p3 = 4;
		p4 = 7;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 10;
		p1 = 100;
		p2 = 999;
		p3 = 100;
		p4 = 999;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 1000000;
		p1 = 0;
		p2 = 474;
		p3 = 474;
		p4 = 474;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 97;
		p1 = 53;
		p2 = -92;
		p3 = 441;
		p4 = 2717;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 99;
		p1 = 3;
		p2 = -743;
		p3 = -619;
		p4 = -535;
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
