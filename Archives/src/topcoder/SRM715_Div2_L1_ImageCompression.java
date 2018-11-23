package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM715_Div2_L1_ImageCompression
{
	public String isPossible(String[] image, int k)
	{
		int rows = image.length;
		int cols = image[0].length();
		for (int i = 0; i < rows / k; i++)
			for (int j = 0; j < cols / k; j++)
			{
				int r = i*k, c = j*k;
				char ch = image[r].charAt(c);
				for (int x = 0; x < k; x++)
					for (int y = 0; y < k; y++)
					{
						if (ch != image[r+x].charAt(c+y))
							return "Impossible";
					}
			}
		return "Possible";
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		SRM715_Div2_L1_ImageCompression obj;
		String answer;
		obj = new SRM715_Div2_L1_ImageCompression();
		long startTime = System.currentTimeMillis();
		answer = obj.isPossible(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String p2;
		
		// ----- test 0 -----
		p0 = new String[]{"0011","0011","1100","1100","0000","0000"};
		p1 = 2;
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"0011","0011","1100","1100","0010","0000"};
		p1 = 2;
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"111000111","111000111","111000111"};
		p1 = 3;
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"001100","001100","110011","110011","001100","001100"};
		p1 = 6;
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"001100","001100","110011","110011","001100","001100"};
		p1 = 2;
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"11111111","11111111","11111111","11111111","11111111","11111111","11111111","11111111"};
		p1 = 4;
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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
