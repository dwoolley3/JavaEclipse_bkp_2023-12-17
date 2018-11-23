package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2016_R1A_L1_EllysTimeMachine
{
	public String getTime(String time)
	{
		int hh = Integer.parseInt(time.substring(0,2));
		int mm = Integer.parseInt(time.substring(3,5));
		
		int h = mm/5, m = hh * 5;
		if (h == 0) h = 12;
		if (m == 60) m = 0;
		
		String s = "";
		if (h < 10) s += "0";
		s += h + ":";		
		if (m < 10) s += "0";
		s += m;
		return s;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		TCO2016_R1A_L1_EllysTimeMachine obj;
		String answer;
		obj = new TCO2016_R1A_L1_EllysTimeMachine();
		long startTime = System.currentTimeMillis();
		answer = obj.getTime(p0);
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
		
		// ----- test 5 -----
		p0 = "12:05";
		p1 = "01:00";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = "11:20";
		p1 = "04:55";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "02:25";
		p1 = "05:10";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "06:30";
		p1 = "06:30";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "05:55";
		p1 = "11:25";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "03:45";
		p1 = "09:15";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "01:00";
		p1 = "12:05";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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