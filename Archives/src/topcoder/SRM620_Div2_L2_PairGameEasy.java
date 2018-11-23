package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM620_Div2_L2_PairGameEasy
{
	
	public String able(int a, int b, int c, int d)
	{
		String able = "Able to generate";
		String na = "Not able to generate";
		
		if (able2(a,b,c,d))
			return able;
		return na;		
	}
	
	private boolean able2(int a, int b, int c, int d)
	{
		if (a == c && b == d) return true;
		if (a > c || b > d) return false;
		return able2(a,b+a,c,d) || able2(a+b,b,c,d);
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, String p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		SRM620_Div2_L2_PairGameEasy obj;
		String answer;
		obj = new SRM620_Div2_L2_PairGameEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.able(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p4 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p4);
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
		String p4;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 2;
		p2 = 3;
		p3 = 5;
		p4 = "Able to generate";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 1;
		p1 = 2;
		p2 = 2;
		p3 = 1;
		p4 = "Not able to generate";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 2;
		p1 = 2;
		p2 = 2;
		p3 = 999;
		p4 = "Not able to generate";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 2;
		p1 = 2;
		p2 = 2;
		p3 = 1000;
		p4 = "Able to generate";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 47;
		p1 = 58;
		p2 = 384;
		p3 = 221;
		p4 = "Able to generate";
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 1000;
		p1 = 1000;
		p2 = 1000;
		p3 = 1000;
		p4 = "Able to generate";
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
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
