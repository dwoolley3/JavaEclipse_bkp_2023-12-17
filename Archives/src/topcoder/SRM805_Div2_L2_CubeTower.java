package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM805_Div2_L2_CubeTower
{
	public long difference(int H, int N)
	{
//		long t1 = 0, t2 = 0;
//		int mid = H/N;
//		int rem = H%N;
//		for (int i = 0; i < N; i++) {
//			int len = mid;
//			if (i < rem) len++;
//			t1 += (1L*len*len*len);
//		}
//		//System.out.println("t1="+t1);
//		
//		t2 = N-1;
//		int len = H - (N-1);
//		t2 += (1L*len*len*len);
//		//System.out.println("t2="+t2);
//		
//		return t2 - t1;
		
//		long a,b=0,h=H,n=N,d;
//		a = h-(n-1);
//		a=a*a*a+(h-a);
//		for (int i = 0; i < n; i++) {
//			d=(h/n) + ((i<h%n) ? 1 : 0);
//			b+= d*d*d;
//		}
//		return Math.abs(a-b);
		
//		long K=H/N;
//		long R=H%N;
//		long ans1 = (N-R)*K*K*K + R*(K+1)*(K+1)*(K+1);
//		long ans2 = (N-1) + (H-(N-1)) * (H-(N-1)) * (H-(N-1));
//		return ans2 - ans1;
		
		long maxV= 1L*(N-1) + 1L * ((H-(N-1)) * (H-(N-1))* (H-(N-1)));
		long minV=0;
		long div = H/N;
		long mod = H%N;
		minV += mod * (div+1) * (div+1) * (div+1);
		minV += (N-mod) * div * div * div;
		return maxV - minV;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, long p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		SRM805_Div2_L2_CubeTower obj;
		long answer;
		obj = new SRM805_Div2_L2_CubeTower();
		long startTime = System.currentTimeMillis();
		answer = obj.difference(p0, p1);
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
		
		int p0;
		int p1;
		long p2;
		
		// ----- test 0 -----
		p0 = 4;
		p1 = 2;
		p2 = 12L;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 17;
		p1 = 16;
		p2 = 0L;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 5;
		p1 = 3;
		p2 = 12L;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 9;
		p1 = 3;
		p2 = 264L;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1000000;
		p1 = 5000;
		p2 = 985077805077990000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1000000;
		p1 = 2;
		p2 = 749997000003000000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1000000;
		p1 = 999999;
		p2 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1000000;
		p1 = 999998;
		p2 = 12;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 3;
		p1 = 2;
		p2 = 0;
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
