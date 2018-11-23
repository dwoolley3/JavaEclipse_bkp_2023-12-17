package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM538_Div2_L2_EvenRoute
{
	public String isItPossible(int[] x, int[] y, int wantedParity)
	{
        int n = x.length;
        int o=0, e = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = x[i] + y[i];
            if (sum % 2 == 0) e++; else o++;
        }
        if (wantedParity == 1 && o > 0)
            return "CAN";
        else if (wantedParity == 0 && e > 0)
            return "CAN";

        return "CANNOT";
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, String p3) {
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
		System.out.print("}" + "," + p2);
		System.out.println("]");
		SRM538_Div2_L2_EvenRoute obj;
		String answer;
		obj = new SRM538_Div2_L2_EvenRoute();
		long startTime = System.currentTimeMillis();
		answer = obj.isItPossible(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p3 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p3);
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
		String p3;
		
		// ----- test 0 -----
		p0 = new int[]{-1,-1,1,1};
		p1 = new int[]{-1,1,1,-1};
		p2 = 0;
		p3 = "CAN";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{-5,-3,2};
		p1 = new int[]{2,0,3};
		p2 = 1;
		p3 = "CAN";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1001,-4000};
		p1 = new int[]{0,0};
		p2 = 1;
		p3 = "CAN";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{11,21,0};
		p1 = new int[]{-20,42,7};
		p2 = 0;
		p3 = "CANNOT";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{0,6};
		p1 = new int[]{10,-20};
		p2 = 1;
		p3 = "CANNOT";
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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