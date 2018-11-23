package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM598_Div1_L1_BinPacking
{
	public int minBins(int[] item)
	{
		Arrays.sort(item);
		int n = item.length;
		int minCnt = Integer.MAX_VALUE;
		int n100 = 0;
		while (true)
		{
			int i = n100, j = n-1, cnt = n100 / 3;
			while (i < j)
			{
				int sum = item[i] + item[j];
				if (sum <= 300)
				{
					if (i+1 < j && sum + item[i+1] <= 300)
						i++;
					i++; 
				}
				j--;
				cnt++;
			}
			if (i == j) cnt++;
			
			minCnt = Math.min(minCnt,  cnt);
			
			if (n100 + 2 < n && item[n100] + item[n100+1] + item[n100+2] == 300)
				n100 += 3;
			else
				break;
		}
		
		return minCnt;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM598_Div1_L1_BinPacking obj;
		int answer;
		obj = new SRM598_Div1_L1_BinPacking();
		long startTime = System.currentTimeMillis();
		answer = obj.minBins(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new int[]{200, 100, 100, 100, 101};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{150,150,150,150,150};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{130,140,150,160};
		p1 = 2;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{100,100,100,100,100,100,100,100,100};
		p1 = 3;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{100,200,100,100,100,100,200,100,200};
		p1 = 4;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{157,142,167,133,135,157,143,160,141,123,162,159,165,137,138,152};
		p1 = 8;
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