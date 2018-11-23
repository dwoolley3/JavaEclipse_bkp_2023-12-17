package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2013_R1A_L2_TheFrog
{
	public double getMinimum(int D, int[] L, int[] R)
	{
        final double eps = 1e-9;
        int n = L.length;
        double res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, R[i] - L[i]);

        while (true)
        {
            boolean flg = true;
            for (int i = 0; i < n; i++)
            {
                int tmp = (int)(L[i] / res + eps) + 1;
                if (L[i] < tmp * res && tmp * res < R[i])
                {
                    double rem = R[i] - tmp * res;
                    res += rem / tmp;
                    flg = false;
                }
            }
            if (flg) break;
        }
        return res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, int[] p2, boolean hasAnswer, double p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		TCO2013_R1A_L2_TheFrog obj;
		double answer;
		obj = new TCO2013_R1A_L2_TheFrog();
		long startTime = System.currentTimeMillis();
		answer = obj.getMinimum(p0, p1, p2);
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
			res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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
		int[] p1;
		int[] p2;
		double p3;
		
		// ----- test 0 -----
		p0 = 16;
		p1 = new int[]{2};
		p2 = new int[]{7};
		p3 = 7.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 25;
		p1 = new int[]{11,3};
		p2 = new int[]{21,7};
		p3 = 10.5D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 100;
		p1 = new int[]{0};
		p2 = new int[]{100};
		p3 = 100.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 100;
		p1 = new int[]{0,50};
		p2 = new int[]{50,100};
		p3 = 50.0D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 30000;
		p1 = new int[]{17,25281,5775,2825,14040};
		p2 = new int[]{55,26000,5791,3150,14092};
		p3 = 787.8787878787879D;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
