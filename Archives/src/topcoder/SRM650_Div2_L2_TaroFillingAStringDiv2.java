package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM650_Div2_L2_TaroFillingAStringDiv2
{
	public int getNumber(String S)
	{		
		int n = S.length();
		
		String st = "";
		int j = 0;
		while (j < n && S.charAt(j) == '?') j++;
		
		char start = 'A';
		if (j > 0 && j < n)
			if (S.charAt(j) == 'A' && j %2 == 1)
				start = 'B';
			else if (S.charAt(j) == 'B' && j % 2 == 0)
				start = 'B';
		
		for (int i = 0; i < n; i++)
		{
			char c = S.charAt(i);
			if (c == '?')
				if (i == 0)
					st += start;
				else if (st.charAt(i-1) == 'B')
					st += 'A';
				else
					st += 'B';
			else
				st += c;
		}
		
		int cnt = 0, tot = 0;
		for (int i = 1; i < n; i++)
		{
			if (st.charAt(i) == st.charAt(i-1)) 
				cnt++;
			else
			{
				tot += cnt;
				cnt = 0;
			}			
		}
		tot += cnt;
		
		
		return tot;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		SRM650_Div2_L2_TaroFillingAStringDiv2 obj;
		int answer;
		obj = new SRM650_Div2_L2_TaroFillingAStringDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0);
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
		
		String p0;
		int p1;
		
		// ----- test 0 -----
		p0 = "?A";
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "???A";
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "???B";
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "ABAA";
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "??";
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "A?A";
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "A??B???AAB?A???A";
		p1 = 3;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?";
		p1 = 10;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		
		// ----- test 4 -----
		p0 = "??BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?";
		p1 = 10;
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