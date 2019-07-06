package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM762_Div2_L2_Restrictions
{
	public int[] exist(int n, int m, int[] type, int[] l, int[] r, int[] val)
	{
		int[] a = new int[n];
		int[] min = new int[n];
		int[] max = new int[n];
		for (int i = 0; i < n; i++) min[i] = 1;
		for (int i = 0; i < n; i++) max[i] = 1_000_000;

		for (int i = 0; i < m; i++) {
			if (type[i] == 1) {
				for (int j = l[i]; j <= r[i]; j++) {					
					min[j] = Math.max(val[i], min[j]);	
				}
			} 
			else // type[i] == 2
			{
				for (int j = l[i]; j <= r[i]; j++) {
					max[j] = Math.min(val[i], max[j]);	
				}
			}
		}
		
		boolean ok = true;
		for (int i = 0; i < n && ok; i++) {
			if (min[i] <= max[i]) {
				a[i] = min[i];
			} else {
				ok = false;
			}
		}
		if (!ok) 
			return new int[] {-1};
		return a;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, int[] p3, int[] p4, int[] p5, boolean hasAnswer, int[] p6) {
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p4.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p4[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p5.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p5[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM762_Div2_L2_Restrictions obj;
		int[] answer;
		obj = new SRM762_Div2_L2_Restrictions();
		long startTime = System.currentTimeMillis();
		answer = obj.exist(p0, p1, p2, p3, p4, p5);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p6.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p6[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p6.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p6[i]) {
						res = false;
					}
				}
			}
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
		int[] p4;
		int[] p5;
		int[] p6;
		
		// ----- test 0 -----
		p0 = 6;
		p1 = 5;
		p2 = new int[]{1,1,2,2,2};
		p3 = new int[]{0,1,2,1,2};
		p4 = new int[]{5,3,3,4,2};
		p5 = new int[]{10,18,25,26,16};
		p6 = new int[]{-1};
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 3;
		p2 = new int[]{1,2,2};
		p3 = new int[]{0,1,0};
		p4 = new int[]{1,1,0};
		p5 = new int[]{3,4,4};
		p6 = new int[]{3,3};
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 0;
		p2 = new int[]{};
		p3 = new int[]{};
		p4 = new int[]{};
		p5 = new int[]{};
		p6 = new int[]{1,1};
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 1;
		p2 = new int[]{2};
		p3 = new int[]{0};
		p4 = new int[]{0};
		p5 = new int[]{1000000};
		p6 = new int[]{1,1};
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, true, p6) && all_right;
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
