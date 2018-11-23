package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM148_Div2_L2_CeyKaps
{
	public String decipher(String typed, String[] switches)
	{
        String s = typed;
        for (int i = 0; i < switches.length; i++)
        {
            typed = "";
            for (int j = 0; j < s.length(); j++)
                if (s.charAt(j) == switches[i].charAt(0))
                    typed += switches[i].charAt(2);
                else if (s.charAt(j) == switches[i].charAt(2))
                    typed += switches[i].charAt(0);
                else
                    typed += s.charAt(j);
            s = typed;  
        }
        return s;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String[] p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM148_Div2_L2_CeyKaps obj;
		String answer;
		obj = new SRM148_Div2_L2_CeyKaps();
		long startTime = System.currentTimeMillis();
		answer = obj.decipher(p0, p1);
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
		
		String p0;
		String[] p1;
		String p2;
		
		// ----- test 0 -----
		p0 = "AAAAA";
		p1 = new String[]{"A:B","B:C","A:D"};
		p2 = "CCCCC";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "ABCDE";
		p1 = new String[]{"A:B","B:C","C:D","D:E","E:A"};
		p2 = "AEBCD";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "IHWSIOTCHEDMYKEYCAPSARWUND";
		p1 = new String[]{"W:O","W:I"};
		p2 = "WHOSWITCHEDMYKEYCAPSAROUND";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
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
