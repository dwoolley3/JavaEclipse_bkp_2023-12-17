package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM793_Div1_L1_GoldMining
{
	// close but fails last test
	public long maxProfit(long goldInGround, long miningTime, long hiringCost)
	{
		long ans = Math.min(goldInGround, miningTime);
		long miners = 1;
		long haveGold = 0, possible = 0;
		for (int t = 1; t <= miningTime; t++) {
			long min = Math.min(goldInGround, miners);
			haveGold += min;
			goldInGround -= min;
			possible = haveGold + Math.min(goldInGround, miners * (miningTime - t));
			if (possible > ans) ans = possible;
			long ad = haveGold / hiringCost;
			haveGold -= ad * hiringCost;
			miners += ad;
			possible = haveGold + Math.min(goldInGround, miners * (miningTime - t));
			if (possible > ans) ans = possible;

//			while (haveGold >= hiringCost) {
//				haveGold -= hiringCost;
//				miners++;				
//				possible = haveGold + Math.min(goldInGround, miners * (miningTime - t));
//				if (possible > ans) ans = possible;
//			}
		}
		return ans;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, long p0, long p1, long p2, boolean hasAnswer, long p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		SRM793_Div1_L1_GoldMining obj;
		long answer;
		obj = new SRM793_Div1_L1_GoldMining();
		long startTime = System.currentTimeMillis();
		answer = obj.maxProfit(p0, p1, p2);
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
			res = answer == p3;
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
		
		long p0;
		long p1;
		long p2;
		long p3;
		
		// ----- test 0 -----
		p0 = 470000L;
		p1 = 1000000L;
		p2 = 50L;
		p3 = 470000L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 470000L;
		p1 = 100000L;
		p2 = 1234567890123456L;
		p3 = 100000L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 470000L;
		p1 = 100000L;
		p2 = 57000L;
		p3 = 100000L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 470000L;
		p1 = 100000L;
		p2 = 42000L;
		p3 = 116000L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 567890L;
		p1 = 4L;
		p2 = 1L;
		p3 = 8L;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 234567L;
		p1 = 47L;
		p2 = 10L;
		p3 = 215L;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = 300L;
		p1 = 47L;
		p2 = 10L;
		p3 = 190L;
		all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 7 -----
		p0 = 987654321098765432L;
		p1 = 100L;
		p2 = 3L;
		p3 = 2731288513472L;
		all_right = KawigiEdit_RunTest(7, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = 987654321098765432L;
		p1 = 1000000L;
		p2 = 1L;
		p3 = 987653221587137657L;
		all_right = KawigiEdit_RunTest(8, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = 987654321098765432L;
		p1 = 1000000L;
		p2 = 2L;
		p3 = 987652028013802142L;
		all_right = KawigiEdit_RunTest(8, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = 987654321098765432L;
		p1 = 1000000L;
		p2 = 3L;
		p3 = 987650679380747474L;
		all_right = KawigiEdit_RunTest(8, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = 1L;
		p1 = 1L;
		p2 = 1L;
		p3 = 1L;
		all_right = KawigiEdit_RunTest(8, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 8 -----
		p0 = 372361468765144L;
		p1 = 335653L;
		p2 = 796L;
		p3 = 371433369197268L;
		all_right = KawigiEdit_RunTest(8, p0, p1, p2, true, p3) && all_right;
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
