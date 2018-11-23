package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM685_Div2_L2_DoubleWeights2_alt
{
	
	public int minimalCost(String[] w1, String[] w2)
	{
		int n = w1.length;
		long[] c1 = new long[n];
		long[] c2 = new long[n];
		c1[0] = 0;
		c2[0] = 0;
		int INF = 100_000;
		for (int i = 1; i < n; i++)
		{
			c1[i] = INF;
			c2[i] = INF;
		}
			
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (w1[i].charAt(j) != '.' && c1[i] != INF) {				
						int w1val = w1[i].charAt(j) - '0';
						int w2val = w2[i].charAt(j) - '0';
						long newCost = (c1[i] + w1val) * (c2[i] + w2val);
						if (c1[j] == INF || newCost < c1[j] * c2[j])
						{
							c1[j] = c1[i] + w1val;
							c2[j] = c2[i] + w2val;
						}
					}
				}
			}
		}
		if (c1[1] != INF)
			return (int)(c1[1] * c2[1]);
		return -1;
	}	

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM685_Div2_L2_DoubleWeights2_alt obj;
		int answer;
		obj = new SRM685_Div2_L2_DoubleWeights2_alt();
		long startTime = System.currentTimeMillis();
		answer = obj.minimalCost(p0, p1);
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
		
		String[] p0;
		String[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new String[]{"..14","..94","19..","44.."};
		p1 = new String[]{"..94","..14","91..","44.."};
		p2 = 64;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"..14","..14","11..","44.."};
		p1 = new String[]{"..94","..94","99..","44.."};
		p2 = 36;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"..",".."};
		p1 = new String[]{"..",".."};
		p2 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{".....9","..9...",".9.9..","..9.9.","...9.9","9...9."};
		p1 = new String[]{".....9","..9...",".9.9..","..9.9.","...9.9","9...9."};
		p2 = 2025;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{".4...1","4.1...",".1.1..","..1.1.","...1.1","1...1."};
		p1 = new String[]{".4...1","4.1...",".1.1..","..1.1.","...1.1","1...1."};
		p2 = 16;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
