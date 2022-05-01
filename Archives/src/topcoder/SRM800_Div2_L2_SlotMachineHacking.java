package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM800_Div2_L2_SlotMachineHacking
{
	public int win(String[] reels, int[] steps)
	{
		int n = reels.length;
		int[] inc = new int[n];
		for (int i = 0; i < n; i++) {
			steps[i] = steps[i] % reels[i].length();
			inc[i] = steps[i];
		}
		for (int t = 0; t < 1000000; t++) {
			boolean allc = true;
			for (int i = 0; i < n && allc; i++) {
				allc = (reels[i].charAt(steps[i]) == 'c');
			}
			if (allc) return t;
			for (int i = 0; i < n; i++) {
				steps[i] = (steps[i] + inc[i]) % reels[i].length();
			}			
		}
		return -1;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
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
		SRM800_Div2_L2_SlotMachineHacking obj;
		int answer;
		obj = new SRM800_Div2_L2_SlotMachineHacking();
		long startTime = System.currentTimeMillis();
		answer = obj.win(p0, p1);
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
		
		String[] p0;
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new String[]{"abc","acb","cab"};
		p1 = new int[]{32,31,30};
		p2 = 0;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"abc","acb","cab"};
		p1 = new int[]{30,33,300000006};
		p2 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"abc","bac","abpc"};
		p1 = new int[]{1,1,1};
		p2 = 10;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"aac","aac","aaac"};
		p1 = new int[]{1,1,1};
		p2 = 10;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"c","c","ababcbabab","c"};
		p1 = new int[]{470,4700,47002,470000};
		p2 = 1;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"ca","caba"};
		p1 = new int[]{1,2};
		p2 = 1;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"abcdefghij","abcdefghij","abcdefghij","abcdefghij","abcdefghij"};
		p1 = new int[]{4702,47003,47007,470009,474745};
		p2 = -1;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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