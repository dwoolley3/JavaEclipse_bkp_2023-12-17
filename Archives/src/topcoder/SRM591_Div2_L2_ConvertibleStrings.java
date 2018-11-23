package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM591_Div2_L2_ConvertibleStrings
{
	public int leastRemovals(String A, String B)
	{
		int nA = A.length();
		int n = 9;
		int[] per = generateInitialPermutation(n);
		
		int min = 51, cnt = 0;
		do {
			cnt = 0;
            for (int j = 0; j < nA; j++)
                if (per[A.charAt(j)-'A'] != (B.charAt(j) - 'A')) cnt++;
            
            min = Math.min(min, cnt);
		} while (next_permutation(per));  //next in lexicographical order
	
		return min;
	}
	
	public int[] generateInitialPermutation(int size)
	{
		int[] p = new int[size];
		for (int i = 0; i < size; i++) p[i] = i;
		return p;
	}
	
	public boolean next_permutation(int[] p) 
	{
		// 0,1,2 -> 0,2,1 -> 1,0,2 -> 1,2,0 -> 2,0,1 -> 2,1,0
		int t, n = p.length;
		for (int i = n - 2; i >= 0; i--)
		    if (p[i] < p[i + 1])
		    	for (int j = n - 1;; j--)
		    		if (p[j] > p[i]) 
		    		{
		    			t = p[i]; p[i] = p[j];  p[j] = t;
				        for (i++, j = n - 1; i < j; i++, j--) 
				        {
				        	t = p[i]; p[i] = p[j]; p[j] = t;
				        }
				        return true;
		    		}
		 return false;  //p is last lexicographically, e.g. -> 2, 1, 0
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		SRM591_Div2_L2_ConvertibleStrings obj;
		int answer;
		obj = new SRM591_Div2_L2_ConvertibleStrings();
		long startTime = System.currentTimeMillis();
		answer = obj.leastRemovals(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int p2;
		
		// ----- test 0 -----
		p0 = "DD";
		p1 = "FF";
		p2 = 0;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "AAAA";
		p1 = "ABCD";
		p2 = 3;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "AAIAIA";
		p1 = "BCDBEE";
		p2 = 3;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "ABACDCECDCDAAABBFBEHBDFDDHHD";
		p1 = "GBGCDCECDCHAAIBBFHEBBDFHHHHE";
		p2 = 9;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
