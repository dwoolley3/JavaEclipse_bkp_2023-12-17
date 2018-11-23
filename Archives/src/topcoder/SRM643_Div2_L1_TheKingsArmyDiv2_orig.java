package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM643_Div2_L1_TheKingsArmyDiv2_orig
{
	public int getNumber(String[] state)
	{
        int[] dx = new int[] { 0, 0, 1, -1 };
        int[] dy = new int[] { 1, -1, 0, 0 };
       
		int r = state.length;
		int c = state[0].length();
		boolean one = false, two = false;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
			{
				char ch = state[i].charAt(j);
				if (ch == 'H') {
					one = true;
			        for (int k = 0; k < 4; k++)
			        {
			            int ni = i + dx[k];
			            int nj = j + dy[k];
			            if (ni < 0 || nj < 0 || ni >= r || nj >= c)
			                continue;
			            if (state[ni].charAt(nj) == 'H')
			                two = true;
			        }
				}
			}
		if (two) return 0;
		else if (one) return 1;
		return 2;
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
		SRM643_Div2_L1_TheKingsArmyDiv2_orig obj;
		int answer;
		obj = new SRM643_Div2_L1_TheKingsArmyDiv2_orig();
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
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new String[]{"SSSSS","SSHHS","SSSSS"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"SSSSS","SSHSH","HSSSS"};
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"SSS","SSS","SSS"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"HSHSHSH","SSSHSSS","SSHSHSS","SHSHSHS"};
		p1 = 1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"HHSH","HHHS","HSSS","SHSH","HHHS","HSHH","SSSH"};
		p1 = 0;
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
