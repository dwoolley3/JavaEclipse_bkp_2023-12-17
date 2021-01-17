package topcoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM788_Div2_L1_NextOlympics2
{
	public int countDays(String today)
	{
		int y = Integer.parseInt(today.substring(0,4));
		int m = Integer.parseInt(today.substring(5,7));
		int d = Integer.parseInt(today.substring(8,10));
		int[] mo = {31,28,31,30,31,30,31,31,30,31,30,31};
		System.out.println(y+ " " + m + " " + d);
		int en = 366 + 205;
		int st = 0;
		if (y == 2021) {
			st += 366;
		}
		for (int i = 0; i < m-1; i++) {
			st += mo[i];
		}
		if (y == 2020) st++; //leap year
		st += (d+1);
		
		int days = en - st;
		
		// Alternative		
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd"); 
		LocalDate dt1 = LocalDate.parse(today, myFormatter);
		LocalDate dt2 = LocalDate.parse("2021.07.23", myFormatter);
		System.out.println(dt1 + " " + dt2);
		days = 0;
		while (!dt1.plusDays(days).isEqual(dt2)) {days++;};		

		return days;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		SRM788_Div2_L1_NextOlympics2 obj;
		int answer;
		obj = new SRM788_Div2_L1_NextOlympics2();
		long startTime = System.currentTimeMillis();
		answer = obj.countDays(p0);
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
		p0 = "2020.07.24";
		p1 = 364;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "2020.11.09";
		p1 = 256;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "2021.02.25";
		p1 = 148;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "2021.07.23";
		p1 = 0;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "2020.12.31";
		p1 = 204;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "2021.01.01";
		p1 = 203;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "2021.07.22";
		p1 = 1;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "2021.06.30";
		p1 = 23;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "2021.07.01";
		p1 = 22;
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
