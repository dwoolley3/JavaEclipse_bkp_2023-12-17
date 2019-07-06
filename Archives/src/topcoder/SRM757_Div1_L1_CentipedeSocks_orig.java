package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM757_Div1_L1_CentipedeSocks_orig
{
	public int fewestSocks(int C, int F, int[] sockCounts)
	{
		int n = sockCounts.length;
		Arrays.sort(sockCounts);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int x = Math.min(F-1, sockCounts[i]);
			sum += x;
			sockCounts[i] -= x;			
		}
		for (int i = n-1; i >= 0; i--) {
			while (sockCounts[i] >= F && C > 1) {
				sum += F;
				sockCounts[i] -= F;				
				C--;
			}
		}
		Arrays.sort(sockCounts);
		for (int i = n-1; i >= 0 && C > 0; i--) {
			if (sockCounts[i] > 0) {
				sum += 1;
				sockCounts[i]--;				
				C--;
			}
		}
		if (C > 0) return -1;		
		return sum;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM757_Div1_L1_CentipedeSocks_orig obj;
		int answer;
		obj = new SRM757_Div1_L1_CentipedeSocks_orig();
		long startTime = System.currentTimeMillis();
		answer = obj.fewestSocks(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		int p3;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 100;
		p2 = new int[]{1,1,1,1,100};
		p3 = 104;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 1;
		p1 = 100;
		p2 = new int[]{40,50,60,70};
		p3 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 3;
		p1 = 10;
		p2 = new int[]{12345};
		p3 = 30;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 2;
		p1 = 3;
		p2 = new int[]{4,4,5};
		p3 = 10;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
