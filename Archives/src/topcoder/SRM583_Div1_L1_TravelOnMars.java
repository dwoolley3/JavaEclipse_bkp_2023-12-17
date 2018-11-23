package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM583_Div1_L1_TravelOnMars
{
	public int minTimes(int[] range, int startCity, int endCity)
	{
        int n = range.length;
        int i, j, k;
        int[][] g = new int[50][50];
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                if (i != j)
                    g[i][j] = 10000;

        for (i = 0; i < n; i++)
            for (j = 0; j <= range[i]; j++)
            {
                g[i][(i + j) % n] = 1;
                g[i][(i - j + 100 * n) % n] = 1;
            }
        
        // Floyd-Warshall - find shortest path
        for (k = 0; k < n; k++)
            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);

        return g[startCity][endCity];   
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1 + "," + p2);
		System.out.println("]");
		SRM583_Div1_L1_TravelOnMars obj;
		int answer;
		obj = new SRM583_Div1_L1_TravelOnMars();
		long startTime = System.currentTimeMillis();
		answer = obj.minTimes(p0, p1, p2);
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
		
		int[] p0;
		int p1;
		int p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new int[]{2,1,1,1,1,1};
		p1 = 1;
		p2 = 4;
		p3 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{2,1,1,1,1,1};
		p1 = 4;
		p2 = 1;
		p3 = 3;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{2,1,1,2,1,2,1,1};
		p1 = 2;
		p2 = 6;
		p3 = 3;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{3,2,1,1,3,1,2,2,1,1,2,2,2,2,3};
		p1 = 6;
		p2 = 13;
		p3 = 4;
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