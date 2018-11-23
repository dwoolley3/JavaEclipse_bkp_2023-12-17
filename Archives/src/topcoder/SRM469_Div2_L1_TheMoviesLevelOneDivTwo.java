package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM469_Div2_L1_TheMoviesLevelOneDivTwo
{
	public int find(int n, int m, int[] row, int[] seat)
	{
        int sum = 0;
        boolean res = false;
        for (int i = 1; i <= n; i++)
        {
            int s = 0;
            for (int j = 1; j <= m; j++)
            {
                res = false;
                for (int x = 0; x < row.length; x++)
                    if (row[x] == i && seat[x] == j)
                        res = true;
                if (res)
                {
                    if (s >= 2)
                    {
                        sum += (s - 1);
                    }
                    s = 0;
                }
                else
                    s++;
            }
            if (s >= 2)
                sum += (s - 1);
        }

        return sum;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, int[] p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p3[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM469_Div2_L1_TheMoviesLevelOneDivTwo obj;
		int answer;
		obj = new SRM469_Div2_L1_TheMoviesLevelOneDivTwo();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0, p1, p2, p3);
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
		int[] p2;
		int[] p3;
		int p4;
		
		// ----- test 0 -----
		p0 = 2;
		p1 = 3;
		p2 = new int[]{1,2};
		p3 = new int[]{2,3};
		p4 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 3;
		p2 = new int[]{1,1,1,2,2,2};
		p3 = new int[]{1,2,3,1,2,3};
		p4 = 0;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 4;
		p1 = 7;
		p2 = new int[]{1};
		p3 = new int[]{1};
		p4 = 23;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 10;
		p1 = 8;
		p2 = new int[]{1,9,6,10,6,7,9,3,9,2};
		p3 = new int[]{7,7,3,3,7,1,5,1,6,2};
		p4 = 54;
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
