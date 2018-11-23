package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2015_R2D_L1_BalancedSubstrings
{
	public int countSubstrings(String s)
	{
		int n = s.length();
		System.out.println(n);
		int cnt = 0, ones = 0, val = 0;
		int[][] left = new int[n][n];
		int[][] right = new int[n][n];	
		for (int i = 0; i < n; i++)
		{
			ones = 0; val = 0;		
			for (int j = i; j < n; j++)
			{		
				int dig = s.charAt(j) - '0';
				ones += dig;
				val += ones;
				left[i][j] = val;
				if (j > 0)
					right[i][j] = right[i][j-1] + (j-i+1) * dig;
				else
					right[i][j] = (j-i+1) * dig;
			}
		}

		int l = 0, r = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
			{
				int lo=i, hi = j, k;

				while (lo <= hi)
				{
					k = (lo + hi) / 2;
					if (k == i) l = 0;
					else l = left[i][k-1];
					if (k == j) r = 0;
					else r = right[k+1][j];
				
					if (l == r)
					{
						cnt++;
						break;
					}
					else if (l < r)
						lo = k + 1;
					else
						hi = k - 1;
				}
			}

		return cnt;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		TCO2015_R2D_L1_BalancedSubstrings obj;
		int answer;
		obj = new TCO2015_R2D_L1_BalancedSubstrings();
		long startTime = System.currentTimeMillis();
		answer = obj.countSubstrings(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		
		String p0;
		int p1;
		
	
		// ----- test 0 -----
		p0 = "011";
		p1 = 4;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "10111";
		p1 = 10;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "00000";
		p1 = 15;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "0000001000000";
		p1 = 91;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "100110001001";
		p1 = 49;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011100100010111100100011011";
		p1 = 12900;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
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
