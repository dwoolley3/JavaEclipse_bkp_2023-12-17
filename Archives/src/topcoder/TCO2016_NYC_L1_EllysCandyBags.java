package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2016_NYC_L1_EllysCandyBags
{
	public int getSize(String[] p)
	{
		int n = p.length;
		int[] a = new int[26];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < p[i].length(); j++)
				a[p[i].charAt(j)-'A']++;
		int cnt = 0;
		for (int i = 0; i < 26; i++)
			cnt += a[i] / 2;
		
		return cnt;
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
		TCO2016_NYC_L1_EllysCandyBags obj;
		int answer;
		obj = new TCO2016_NYC_L1_EllysCandyBags();
		long startTime = System.currentTimeMillis();
		answer = obj.getSize(p0);
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
		p0 = new String[]{"FOO","BAR","BAZ","TOPCODER"};
		p1 = 5;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"X"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"GIVING","CANDY","TO","CHILDREN","CANNOT","BE","CHALLENGING","RIGHT"};
		p1 = 17;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"WITHOUT","IT","IM","JUST","ESPR"};
		p1 = 5;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"PHQGHUMEAYLNLFDXFIRCVSCXGGBWKFNQDUXWFNFOZVSRTKJPRE","PGGXRPNRVYSTMWCYSYYCQPEVIKEFFMZNIMKKASVWSRENZKYCXF","XTLSGYPSFADPOOEFXZBCOEJUVPVABOYGPOEYLFPBNPLJVRVIPY","AMYEHWQNQRQPMXUJJLOOVAOWUXWHMSNCBXCOKSFZKVATXDKNLY","JYHFIXJSWNKKUFNUXXZRZBMNMGQOOKETLYHNKOAUGZQRCDDIUT","EIOJWAYYZPVSCMPSAJLFVGUBFAAOVLZYLNTRKDCPWSRTESJWHD","IZCOBZCNFWLQIJTVDWVXHRCBLDVGYLWGBUSBMBORXTLHCSMPXO","HGMGNKEUFDXOTOGBGXPEYANFETCUKEPZSHKLJUGGGEKJDQZJEN","PEVQGXIEPJSRDZJAZUJL"};
		p1 = 203;
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
