package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM153_Div2_L1_MostProfitable
{
	public String bestItem(int[] costs, int[] prices, int[] sales, String[] items)
	{
        int max = 0, maxi = -1, p = 0;
        for (int i = 0; i < costs.length; i++)
        {
            p = (prices[i] - costs[i]) * sales[i];
            if (p > max)
            {
                max = p;
                maxi = i;
            }
        }
        if (maxi == -1) return "";
        return items[maxi];                
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, String[] p3, boolean hasAnswer, String p4) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p3[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM153_Div2_L1_MostProfitable obj;
		String answer;
		obj = new SRM153_Div2_L1_MostProfitable();
		long startTime = System.currentTimeMillis();
		answer = obj.bestItem(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p4 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p4);
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
		int[] p1;
		int[] p2;
		String[] p3;
		String p4;
		
		// ----- test 0 -----
		p0 = new int[]{100,120,150,1000};
		p1 = new int[]{110,110,200,2000};
		p2 = new int[]{20,100,50,3};
		p3 = new String[]{"Video Card","256M Mem","CPU/Mobo combo","Complete machine"};
		p4 = "Complete machine";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{100};
		p1 = new int[]{100};
		p2 = new int[]{134};
		p3 = new String[]{"Service, at cost"};
		p4 = "";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{38,24};
		p1 = new int[]{37,23};
		p2 = new int[]{1000,643};
		p3 = new String[]{"Letter","Postcard"};
		p4 = "";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{10,10};
		p1 = new int[]{11,12};
		p2 = new int[]{2,1};
		p3 = new String[]{"A","B"};
		p4 = "A";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
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
