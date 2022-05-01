package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM811_Div2_L2_CircularParking
{
	public long park(int N, int A, int B, int C)
	{
		int p[] = new int[N];
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i <= N; i++) ts.add(i); // Add N
		
		long y = 1L*A*0*0 + B*0 + C;
		int pi = (int)(y % N);
		p[pi] = 1;
		ts.remove(pi);
		long col2 = 0;
		
		for (int i = 1; i < N; i++) {
			y = 1L*A*i*i + 1L*B*i + C;
			pi = (int)(y % N);
			
			int free = ts.ceiling(pi);
			col2 += (free - pi);
			if (free == N) {				
				free = ts.ceiling(-1);
				col2 += free;
			} 
			ts.remove(free);
		}
		return col2;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, long p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		SRM811_Div2_L2_CircularParking obj;
		long answer;
		obj = new SRM811_Div2_L2_CircularParking();
		long startTime = System.currentTimeMillis();
		answer = obj.park(p0, p1, p2, p3);
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
		int p2;
		int p3;
		long p4;
		
		// ----- test 0 -----
		p0 = 47;
		p1 = 0;
		p2 = 1;
		p3 = 0;
		p4 = 0L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 47;
		p1 = 0;
		p2 = 0;
		p3 = 42;
		p4 = 1081L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 30;
		p1 = 1;
		p2 = 1;
		p3 = 1;
		p4 = 175L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 4;
		p1 = 1;
		p2 = 2;
		p3 = 3;
		p4 = 4L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 250000;
		p1 = 249999;
		p2 = 9999;
		p3 = 9888;
		p4 = 46625000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 250000;
		p1 = 24999;
		p2 = 9999;
		p3 = 9888;
		p4 = 46625000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 250000;
		p1 = 0;
		p2 = 0;
		p3 = 7;
		p4 = 31249875000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
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
