package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM788_Div2_L3_SquareCityWalking
{
	public int largestGCD(int n, int[] A)
	{
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		for (int i = 0; i < n * n; i++) {
			int r = i/n;
			int c = i%n;
			a[r][c] = A[i];
		}
		b[0][0] = a[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0) {
					b[i][j] = GCD(a[i][j],b[i-1][j]);
				}
				if (j > 0) {
					b[i][j] = Math.max(b[i][j], GCD(a[i][j],b[i][j-1]));
				}
			}
		}
		
		return b[n-1][n-1];
	}
	
    int GCD(int a, int b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM788_Div2_L3_SquareCityWalking obj;
		int answer;
		obj = new SRM788_Div2_L3_SquareCityWalking();
		long startTime = System.currentTimeMillis();
		answer = obj.largestGCD(p0, p1);
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
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = 3;
		p1 = new int[]{96,42,45,32,36,27,40,54,84};
		p2 = 6;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 3;
		p1 = new int[]{4,9,2,3,5,7,8,1,6};
		p2 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 4;
		p1 = new int[]{54,81,27,36,48,64,96,72,84,60,45,99,80,90,40,63};
		p2 = 9;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1;
		p1 = new int[]{47};
		p2 = 47;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 5;
		p1 = new int[]{100,80,64,48,36,75,10,10,10,48,50,10,10,10,64,25,10,10,10,80,5,25,50,75,100};
		p2 = 10;
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
