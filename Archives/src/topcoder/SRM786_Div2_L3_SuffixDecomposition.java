package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM786_Div2_L3_SuffixDecomposition
{
	public long findTotalFun(int[] P, int A0, int X, int Y, int B0, int X1, int Y1, int N)
	{
		int[] a = new int[N];
		int[] b = new int[N];
		int MOD = 1812447359;
		a[0] = A0;
		b[0] = B0;
		for (int i = 1; i < N; i++) {
			a[i] = (int)((1L * a[i-1] * X + Y) % MOD);
			b[i] = (int)((1L * b[i-1] * X1 + Y1) % MOD);
		}
		
		int[] s = new int[N];
		for (int i = 0; i < P.length; i++) {
			s[i] = P[i];
		}
		for (int i = P.length; i < N; i++) {
			s[i] = Math.max(a[i], b[i]);
		}
		
		int sn = s.length;
		
		for (int i = 0; i < sn; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
		
		long sum = 1;
		int min = s[sn-1];
		long sub = 1;		
		for (int i = sn-2; i >= 0; i--) {	

			if (s[i] < min) {
				min = s[i];
				sub++;
			}
			else sub = 1;
			System.out.println(sub);
			sum += sub;			
		}
		
		
		return sum;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, boolean hasAnswer, long p8) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6 + "," + p7);
		System.out.println("]");
		SRM786_Div2_L3_SuffixDecomposition obj;
		long answer;
		obj = new SRM786_Div2_L3_SuffixDecomposition();
		long startTime = System.currentTimeMillis();
		answer = obj.findTotalFun(p0, p1, p2, p3, p4, p5, p6, p7);
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
		
		int[] p0;
		int p1;
		int p2;
		int p3;
		int p4;
		int p5;
		int p6;
		int p7;
		long p8;
		
		// ----- test 0 -----
		p0 = new int[]{3,9,5};
		p1 = 0;
		p2 = 0;
		p3 = 0;
		p4 = 0;
		p5 = 0;
		p6 = 0;
		p7 = 3;
		p8 = 4L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{10};
		p1 = 1;
		p2 = 2;
		p3 = 2;
		p4 = 3;
		p5 = 1;
		p6 = 2;
		p7 = 4;
		p8 = 8L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{};
		p1 = 1000001;
		p2 = 1000001;
		p3 = 1000001;
		p4 = 5000001;
		p5 = 5000001;
		p6 = 5000001;
		p7 = 4;
		p8 = 6L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{};
		p1 = 1812447358;
		p2 = 1812447358;
		p3 = 1812447358;
		p4 = 42524;
		p5 = 2565262;
		p6 = 2676642;
		p7 = 6;
		p8 = 7L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{};
		p1 = 1010;
		p2 = 2010;
		p3 = 3010;
		p4 = 900010;
		p5 = 9000;
		p6 = 76540;
		p7 = 8;
		p8 = 10L;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, p7, true, p8) && all_right;
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