package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM772_Div1_L1_SmoothPermutations
{
	public long countPermutations(int T, int M, int MX, int seed, int[] prefN, int[] prefK, int[] prefX)
	{
		long[] a = new long[3*T];
		a[0] = seed;
		for (int i = 1; i <= 3*T-1; i++) {
			a[i] = (a[i-1] * 1103515245L + 12345) % 2147483648L;
		}
		
		long[] p = new long[200_001];
		p[0] = 1;
		for (int i = 1; i <= 200_000; i++) {
			p[i] = i * p[i-1];
			p[i] = p[i] % M;
		}
		int len = prefN.length;
		long[] n = new long[T];
		long[] k = new long[T];
		long[] x = new long[T];
		for (int i = 0; i <= len-1; i++) {
			n[i] = prefN[i];
			k[i] = prefK[i];
			x[i] = prefX[i];
		}
		
		for (int i = len; i <= T-1; i++) {
			n[i] = (a[i] % MX) + 1;
			k[i] = (a[T+i] % n[i]) + 1;
			x[i] = (a[2*T+i] % n[i]) + 1;
		}
		
		long sum = 0;
		
		for (int i = 0; i < T; i++) {
			if (x[i] < k[i]) continue;
			long perm = 1;
			for (int j = 0; j < k[i]; j++) {
				perm *= (x[i] - j);
				perm %= M;
			}
			// (n-k)!
//			for (int j = 0; j < n[i] - k[i]; j++) {
//				perm *= (n[i] - k[i] - j);				
//				perm %= M;
//			}
			perm *= p[(int)(n[i]-k[i])];
			perm %= M;

			sum += perm;
		}
				
		return sum;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, int[] p4, int[] p5, int[] p6, boolean hasAnswer, long p7) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + "{");
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p6.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p6[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM772_Div1_L1_SmoothPermutations obj;
		long answer;
		obj = new SRM772_Div1_L1_SmoothPermutations();
		long startTime = System.currentTimeMillis();
		answer = obj.countPermutations(p0, p1, p2, p3, p4, p5, p6);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p7);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p7;
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
		int[] p4;
		int[] p5;
		int[] p6;
		long p7;
		
		// ----- test 0 -----
		p0 = 3;
		p1 = 100;
		p2 = 5;
		p3 = 4;
		p4 = new int[]{5,4};
		p5 = new int[]{3,2};
		p6 = new int[]{5,2};
		p7 = 24L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 100;
		p1 = 1;
		p2 = 47;
		p3 = 47;
		p4 = new int[]{};
		p5 = new int[]{};
		p6 = new int[]{};
		p7 = 0L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 100;
		p1 = 999999937;
		p2 = 123456;
		p3 = 47;
		p4 = new int[]{};
		p5 = new int[]{};
		p6 = new int[]{};
		p7 = 24359438587L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
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