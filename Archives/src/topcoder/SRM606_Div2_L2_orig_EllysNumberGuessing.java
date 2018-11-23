package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM606_Div2_L2_orig_EllysNumberGuessing
{
	public int getNumber(int[] guesses, int[] answers)
	{
		int n = guesses.length;	
		
		int[] g = new int[2];
		int[] g1 = new int[2];
		int[] g2 = new int[2];
		g[0] = guesses[0] - answers[0];
		g[1] = guesses[0] + answers[0];
		
		if (g[0] < 1 && g[1] > 1_000_000_000)
			return -2;
		if (n==1 && g[0] < 1) return g[1];
		if (n==1 && g[1] > 1_000_000_000) return g[0];
		if (n==1) return -1;
		
		boolean same = true;
		int dif = 1;
		for (int i = 1; i < n; i++)
			if (guesses[i] != guesses[i-1] || answers[i] != answers[i-1])
			{
				same = false;
				dif = i;
				break;
			}
		if (same && g[0] < 1) return g[1];
		if (same && g[1] > 1_000_000_000) return g[0];
		if (same) return -1;
		
		g1[0] = guesses[dif] - answers[dif];
		g1[1] = guesses[dif] + answers[dif];
		if (g1[0] < 1 && g1[1] > 1_000_000_000)
			return -2;
		
		int ans = -1;
		if (g1[0] < 1) 
		{
			if (g1[1] == g[0] || g1[1] == g[1])
				ans = g1[1];
			else
				return -2;
		}
		else if (g1[1] > 1_000_000_000) 
		{
			if (g1[0] == g[0] || g1[0] == g[1])
				ans = g1[0];
			else
				return -2;
		}
		else
		{
			if (g1[1] == g[0] || g1[1] == g[1])
				ans = g1[1];
			else if (g1[0] == g[0] || g1[0] == g[1])
				ans = g1[0];
			else 
				return -2;
		}

		for (int i = dif+1; i < n; i++)
		{
			g2[0] = guesses[i] - answers[i];
			g2[1] = guesses[i] + answers[i];
			if (g2[0] != ans && g2[1] != ans) return -2;			
		}
		
		return ans;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM606_Div2_L2_orig_EllysNumberGuessing obj;
		int answer;
		obj = new SRM606_Div2_L2_orig_EllysNumberGuessing();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1);
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
		
		int[] p0;
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{600,594};
		p1 = new int[]{6,12};
		p2 = 606;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{100,50,34,40};
		p1 = new int[]{58,8,8,2};
		p2 = 42;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{500000,600000,700000};
		p1 = new int[]{120013,220013,79987};
		p2 = -2;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{500000000};
		p1 = new int[]{133742666};
		p2 = -1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{76938260,523164588,14196746,296286419,535893832,41243148,364561227,270003278,472017422,367932361,395758413,301278456,186276934,316343129,336557549,52536121,98343562,356769915,89249181,335191879};
		p1 = new int[]{466274085,20047757,529015599,246925926,7318513,501969197,178651118,273209067,71194923,175279984,147453932,241933889,356935411,226869216,206654796,490676224,444868783,186442430,453963164,208020466};
		p2 = 543212345;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{42};
		p1 = new int[]{42};
		p2 = 84;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new int[]{999900000};
		p1 = new int[]{100001};
		p2 = 999799999;
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new int[]{999900000};
		p1 = new int[]{999900000};
		p2 = -2;
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 7 -----
		p0 = new int[]{600,12};
		p1 = new int[]{6,12};
		p2 = -2;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = new int[]{50, 50};
		p1 = new int[]{13, 13};
		p2 = -1;
		all_right = KawigiEdit_RunTest(8, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = new int[]{50, 50, 50};
		p1 = new int[]{13, 13, 13};
		p2 = -1;
		all_right = KawigiEdit_RunTest(8, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 9 -----
		p0 = new int[]{50, 50, 50, 38};
		p1 = new int[]{13, 13, 13, 1};
		p2 = 37;
		all_right = KawigiEdit_RunTest(8, p0, p1, true, p2) && all_right;
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
