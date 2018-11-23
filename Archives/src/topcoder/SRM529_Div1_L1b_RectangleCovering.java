package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM529_Div1_L1b_RectangleCovering
{
	public int minimumNumber(int holeH, int holeW, int[] boardH, int[] boardW)
	{
		int min1 = solve(holeH, holeW, boardH, boardW);
		int min2 = solve(holeW, holeH, boardH, boardW);
		int min = Math.min(min1, min2);
		if (min == 1000) return -1;
		return min;
	}
	
	public int solve(int holeH, int holeW, int[] bH, int[] bW)
	{
		int n = bH.length;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (holeH < bH[i] && holeH < bW[i])
				a.add(Math.max(bH[i], bW[i]));
			else if (holeH < bH[i])
				a.add(bW[i]);
			else if (holeH < bW[i])
				a.add(bH[i]);
		
		Collections.sort(a);
		int sum = 0;
		for (int i = a.size() - 1; i >= 0; i--)
		{
			sum += a.get(i);
			if (sum >= holeW) return a.size() - i;
		}
		return 1000;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, int[] p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p3[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM529_Div1_L1b_RectangleCovering obj;
		int answer;
		obj = new SRM529_Div1_L1b_RectangleCovering();
		long startTime = System.currentTimeMillis();
		answer = obj.minimumNumber(p0, p1, p2, p3);
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
		int[] p2;
		int[] p3;
		int p4;
		
		// ----- test 4 -----
		p0 = 10000;
		p1 = 5000;
		p2 = new int[]{12345,12343,12323,12424,1515,6666,6789,1424,11111,25};
		p3 = new int[]{1442,2448,42,1818,3535,3333,3456,7890,1,52};
		p4 = 3;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = 5;
		p1 = 5;
		p2 = new int[]{8,8,8};
		p3 = new int[]{2,3,4};
		p4 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 10;
		p1 = 10;
		p2 = new int[]{6,6,6,6};
		p3 = new int[]{6,6,6,6};
		p4 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 5;
		p1 = 5;
		p2 = new int[]{5};
		p3 = new int[]{5};
		p4 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 3;
		p1 = 5;
		p2 = new int[]{6};
		p3 = new int[]{4};
		p4 = 1;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 10000;
		p1 = 5000;
		p2 = new int[]{12345,12343,12323,12424,1515,6666,6789,1424,11111,25};
		p3 = new int[]{1442,2448,42,1818,3535,3333,3456,7890,1,52};
		p4 = 3;
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
