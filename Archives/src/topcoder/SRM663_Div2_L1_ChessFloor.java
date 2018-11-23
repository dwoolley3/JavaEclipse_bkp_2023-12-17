package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM663_Div2_L1_ChessFloor
{
	public int minimumChanges(String[] floor)
	{
		int n = floor.length;
		int minCnt = Integer.MAX_VALUE;
		for (char c1 = 'a'; c1 <= 'z'; c1++)
			for (char c2 = 'a'; c2 <= 'z'; c2++)
			{
				if (c1 == c2) continue;
				int cnt = 0;
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++)
						if ((i+j) % 2 == 0)
						{
							if (c1 != floor[i].charAt(j)) cnt++;
						}
						else
							if (c2 != floor[i].charAt(j)) cnt++;
				minCnt = Math.min(minCnt, cnt);
			}
		return minCnt;
				
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
		SRM663_Div2_L1_ChessFloor obj;
		int answer;
		obj = new SRM663_Div2_L1_ChessFloor();
		long startTime = System.currentTimeMillis();
		answer = obj.minimumChanges(p0);
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
		p0 = new String[]{"aba","bbb","aba"};
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"wbwbwbwb","bwbwbwbw","wbwbwbwb","bwbwbwbw","wbwbwbwb","bwbwbwbw","wbwbwbwb","bwbwbwbw"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"zz","zz"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"helloand","welcomet","osingler","oundmatc","hsixhund","redandsi","xtythree","goodluck"};
		p1 = 56;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"jecjxsengslsmeijrmcx","tcfyhumjcvgkafhhffed","icmgxrlalmhnwwdhqerc","xzrhzbgjgabanfxgabed","fpcooilmwqixfagfojjq","xzrzztidmchxrvrsszii","swnwnrchxujxsknuqdkg","rnvzvcxrukeidojlakcy","kbagitjdrxawtnykrivw","towgkjctgelhpomvywyb","ucgqrhqntqvncargnhhv","mhvwsgvfqgfxktzobetn","fabxcmzbbyblxxmjcaib","wpiwnrdqdixharhjeqwt","xfgulejzvfgvkkuyngdn","kedsalkounuaudmyqggb","gvleogefcsxfkyiraabn","tssjsmhzozbcsqqbebqw","ksbfjoirwlmnoyyqpbvm","phzsdodppzfjjmzocnge"};
		p1 = 376;
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
