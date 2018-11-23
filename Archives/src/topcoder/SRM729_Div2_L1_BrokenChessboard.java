package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM729_Div2_L1_BrokenChessboard
{
	public int minimumFixes(String[] board)
	{
		int rows = board.length, cols = board[0].length();
		int chg1 = 0, chg2 = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
			{
				if ((i+j)%2 == 0 && board[i].charAt(j) != 'W') chg1++;
				if ((i+j)%2 == 1 && board[i].charAt(j) != 'B') chg1++;
				if ((i+j)%2 == 0 && board[i].charAt(j) != 'B') chg2++;
				if ((i+j)%2 == 1 && board[i].charAt(j) != 'W') chg2++;
			}
		
		return Math.min(chg1, chg2);
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM729_Div2_L1_BrokenChessboard obj;
		int answer;
		obj = new SRM729_Div2_L1_BrokenChessboard();
		long startTime = System.currentTimeMillis();
		answer = obj.minimumFixes(p0);
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
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new String[]{"BWB","BBW","BWW"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"WW","WW"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"BWB","WBW","BWB"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"B","W","B","B"};
		p1 = 1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"BWBBB","WWBBW","BBBBW","WBWBB"};
		p1 = 7;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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
