package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM618_Div2_L2_LongWordsDiv2
{
	public String find(String word)
	{
		String likes = "Likes", dislikes = "Dislikes";
		int n = word.length();
		for (int i = 0; i < n-1; i++)
			if (word.charAt(i) == word.charAt(i+1)) return dislikes;
		
		if (n < 4) return likes;
		
		for (int a = 0; a < n-3; a++)
			for (int b = a+1; b < n-2; b++)
				for (int c = b+1; c < n-1; c++)
					for (int d = c+1; d < n; d++)
					{
						if (word.charAt(a) == word.charAt(c) 
						&& word.charAt(b) == word.charAt(d))
							return dislikes;
					}
		return likes;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		SRM618_Div2_L2_LongWordsDiv2 obj;
		String answer;
		obj = new SRM618_Div2_L2_LongWordsDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		
		String p0;
		String p1;
		
		// ----- test 0 -----
		p0 = "XYXY";
		p1 = "Dislikes";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "ABACADA";
		p1 = "Dislikes";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "AAA";
		p1 = "Dislikes";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "ABCBA";
		p1 = "Likes";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "ABCBAC";
		p1 = "Dislikes";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "TOPCODER";
		p1 = "Likes";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "VAMOSGIMNASIA";
		p1 = "Dislikes";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "SINGLEROUNDMATCH";
		p1 = "Likes";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = "DALELOBO";
		p1 = "Likes";
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
