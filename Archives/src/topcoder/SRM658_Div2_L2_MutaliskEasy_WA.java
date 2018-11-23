package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM658_Div2_L2_MutaliskEasy_WA
{
	public int minimalAttacks(int[] x)
	{
		int n = x.length, ans = 0;
		if (n == 1) 
		{
			ans = x[0] / 9;
			if (x[0] % 9 > 0) ans++;
		}
		else
		{
//			int min = 100;
//			int[] p = {9,3,1};
			if (n == 2)
				for (ans = 1; ans <= 20; ans++)
					for (int i = 0; i <= ans; i++)
					{
						int j = ans - i;
						if (x[0] - 9*i - 3*j <= 0 && x[1] - 9*j - 3*i <= 0)
							return ans;
					}
			else //n == 3
			{
				//Flaw -- if i = 5, j = 4, k = 2 for 9s, the 3s could be different numbers
				//  that total to 11, such as 1, 10, 0
				for (ans = 1; ans <= 20; ans++)
					for (int i = 0; i <= ans; i++)
						for (int j = 0; j <= ans-i; j++)
						{
							int k = ans - i - j;
							if (x[0] - 9*i - 3*j - k <= 0 
							 && x[1] - 9*j - 3*k - i <= 0
							 && x[2] - 9*k - 3*i - j <= 0)
								return ans;
							if (x[0] - 9*i - 3*k - j <= 0 
							 && x[1] - 9*j - 3*i - k <= 0
							 && x[2] - 9*k - 3*j - i <= 0)
								return ans;
						}
			}			
		}
		return ans;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM658_Div2_L2_MutaliskEasy_WA obj;
		int answer;
		obj = new SRM658_Div2_L2_MutaliskEasy_WA();
		long startTime = System.currentTimeMillis();
		answer = obj.minimalAttacks(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 1 -----
		p0 = new int[]{52,49,38};
		p1 = 11;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{60,56,58};
		p1 = 14;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{54,6,18};
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{6,54,18};
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{18,54,6};
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{18,6,54};
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{6,18,54};
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{40,60};
		p1 = 9;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{4,10,12};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{4,12,10};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{12,4,10};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{10,4,12};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{10,12,4};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{12,10,4};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{54,18,6};
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{55,60,53};
		p1 = 13;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,1,1};
		p1 = 1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{60,40};
		p1 = 9;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{60};
		p1 = 7;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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