package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM813_Div2_L2_LooRollPyramid_alt2
{
	public int[] countMissing(int Q, int[] A, long[] B)
	{
		int[] ans = new int[Q];
		for (int i = 0; i < Q; i++) {
			int lo = 0, hi = A[i];
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (findVal(A[i], mid) < B[i]) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
			ans[i] = (int)(findVal(A[i], lo) - B[i]);
		}
		return ans;
	}
	
	private long findVal(int x, int y) {
		return (long) x * y - (long) y * (y-1) / 2;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, long[] p2, boolean hasAnswer, int[] p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM813_Div2_L2_LooRollPyramid_alt2 obj;
		int[] answer;
		obj = new SRM813_Div2_L2_LooRollPyramid_alt2();
		long startTime = System.currentTimeMillis();
		answer = obj.countMissing(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p3.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p3[i]);
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
			if (answer.length != p3.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p3[i]) {
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
		int[] p1;
		long[] p2;
		int[] p3;
		
		// ----- test 0 -----
		p0 = 4;
		p1 = new int[]{5,5,5,5};
		p2 = new long[]{15L,10L,5L,0L};
		p3 = new int[]{0,2,0,0};
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 5;
		p1 = new int[]{4,5,6,7,8};
		p2 = new long[]{10L,10L,10L,10L,10L};
		p3 = new int[]{0,2,1,3,5};
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 10;
		p1 = new int[]{987654321,987654321,987654321,987654321,987654321,987654321,987654321,987654321,987654321,987654321};
		p2 = new long[]{5432109876543210L,5432109876543211L,5432109876543212L,5432109876543213L,5432109876543214L,5432109876543215L,5432109876543216L,5432109876543217L,5432109876543218L,5432109876543219L};
		p3 = new int[]{735344876,735344875,735344874,735344873,735344872,735344871,735344870,735344869,735344868,735344867};
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
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
