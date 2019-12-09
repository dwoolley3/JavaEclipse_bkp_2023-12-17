package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM771_Div2_L2_CollectAllCoins
{
	public int[] collect(int R, int C)
	{
		boolean swap = false;
		if (C % 2 == 0) {
			int t = R; R = C; C = t;
			swap = true;
		}
		
		int[][] a = new int[R][C];
		a[0][0] = 1;
		
		int[] ans = new int[R*C];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < C; j++) {
					if (a[i][j] == 1) {
						if (swap) {
							ans[cnt++] = i + j*R;
						}
						else {
							ans[cnt++] = i*C + j;
						}
						a[i][j] = -1;
						if (i+1 < R && a[i+1][j] != -1) {
							a[i+1][j] = 1 - a[i+1][j];
						}
						if (j+1 < C && a[i][j+1] != -1) {
							a[i][j+1] = 1 - a[i][j+1];
						}
						if (j-1 >= 0 && a[i][j-1] != -1) {
							a[i][j-1] = 1 - a[i][j-1];
						}
					}
				}
			}
		}
		
		if (cnt < R * C) return new int[] {};
		return ans;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int[] p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		SRM771_Div2_L2_CollectAllCoins obj;
		int[] answer;
		obj = new SRM771_Div2_L2_CollectAllCoins();
		long startTime = System.currentTimeMillis();
		answer = obj.collect(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p2.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p2[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p2.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p2[i]) {
						res = false;
					}
				}
			}
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
		
		// ----- test 0 -----
		p0 = 3;
		p1 = 3;
		p2 = new int[]{0,3,4,6,5,2,8,7,1};
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 7;
		p1 = 1;
		p2 = new int[]{0,1,2,3,4,5,6};
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 2;
		p1 = 3;
		p2 = new int[]{0,1,2,3,5,4};
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 14;
		p1 = 28;
		p2 = new int[]{};
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 30;
		p1 = 30;
		p2 = new int[]{};
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 3;
		p1 = 2;
		p2 = new int[]{0,2,4,1,5,3};
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1;
		p1 = 1;
		p2 = new int[]{0};
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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