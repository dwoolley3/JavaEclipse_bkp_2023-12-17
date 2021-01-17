package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2020_NA_L1_EllysBlood
{
	public int getMax(int[] have, int[] need)
	{
		int ans = 0, x;
		for (int i = 0; i < 4; i++) {
			x = Math.min(need[i], have[i]);		
			ans += x;
			need[i] -= x;
			have[i] -= x;
		}

		//A to AB
		x = Math.min(have[1], need[3]);		
		ans += x;
		need[1] -= x;
		have[3] -= x;
		
		//B to AB
		x = Math.min(have[2], need[3]);		
		ans += x;
		need[2] -= x;
		have[3] -= x;
		
		//O
		for (int i = 1; i <= 3; i++) {
			x = Math.min(have[0], need[i]);		
			ans += x;
			need[i] -= x;
			have[0] -= x;
		}
		
		return ans;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		TCO2020_NA_L1_EllysBlood obj;
		int answer;
		obj = new TCO2020_NA_L1_EllysBlood();
		long startTime = System.currentTimeMillis();
		answer = obj.getMax(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		
		int[] p0;
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{9,17,12,5};
		p1 = new int[]{5,11,26,10};
		p2 = 42;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{100,0,0,0};
		p1 = new int[]{1,3,3,7};
		p2 = 14;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{0,0,0,0};
		p1 = new int[]{100,100,100,100};
		p2 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{10,20,30,40};
		p1 = new int[]{40,30,20,10};
		p2 = 60;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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