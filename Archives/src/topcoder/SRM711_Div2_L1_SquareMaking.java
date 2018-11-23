package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM711_Div2_L1_SquareMaking
{
	public int getMinimalPrice(int a, int b, int c, int d)
	{
		int min = Math.min(Math.min(Math.min(a, b),c),d);
		int max = Math.max(Math.max(Math.max(a, b),c),d);
		
		int m = Integer.MAX_VALUE;
		for (int i = min; i <= max; i++)
		{
			int sum = Math.abs(a-i);
			sum += Math.abs(b-i);
			sum += Math.abs(c-i);
			sum += Math.abs(d-i);
			m = Math.min(m, sum);
		}
		return m;			
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		SRM711_Div2_L1_SquareMaking obj;
		int answer;
		obj = new SRM711_Div2_L1_SquareMaking();
		long startTime = System.currentTimeMillis();
		answer = obj.getMinimalPrice(p0, p1, p2, p3);
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
		p0 = 5;
		p1 = 6;
		p2 = 5;
		p3 = 5;
		p4 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 4;
		p1 = 1;
		p2 = 5;
		p3 = 4;
		p4 = 4;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 2017;
		p1 = 2017;
		p2 = 2017;
		p3 = 2017;
		p4 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 705451;
		p1 = 751563;
		p2 = 608515;
		p3 = 994713;
		p4 = 432310;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
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