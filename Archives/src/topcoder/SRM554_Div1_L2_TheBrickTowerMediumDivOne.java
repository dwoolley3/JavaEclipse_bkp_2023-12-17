package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM554_Div1_L2_TheBrickTowerMediumDivOne
{
	public int[] find(int[] heights)
	{
        //A permutation routine does not work for extremely large numbers of n;
        //Thus, we need to know the algorithm for generating the array of 
        //numbers. 
        //The trick is to start with the first num and append non-increasing
        //numbers in order, then sort the rest in non-decreasing order, which
		//has the last number being the largest;
        //thus the order of the numbers looks like the letter V.

        int n = heights.length;
        int[] ans = new int[n];
        int[] used = new int[n];
        int min = Integer.MAX_VALUE;
        int cnt = -1;

        for (int i = 0; i < n; i++)
        {
            if (heights[i] <= min)
            {
                min = heights[i];
                cnt++;
                ans[cnt] = i;
                used[i] = 1;
            }
        }

        while (cnt < n - 1)
        {
            min = Integer.MAX_VALUE;
            int ind = -1;
            for (int i = 0; i < n; i++)
            {
                if (used[i] == 1) continue;
                if (heights[i] < min)
                {
                    min = heights[i];
                    ind = i;
                }
            }
            cnt++;
            ans[cnt] = ind;
            used[ind] = 1;
        }

        return ans;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM554_Div1_L2_TheBrickTowerMediumDivOne obj;
		int[] answer;
		obj = new SRM554_Div1_L2_TheBrickTowerMediumDivOne();
		long startTime = System.currentTimeMillis();
		answer = obj.find(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p1.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p1[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p1[i]) {
						res = false;
					}
				}
			}
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
		
		// ----- test 0 -----
		p0 = new int[]{4,7,5};
		p1 = new int[]{0,2,1};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{4,4,4,4,4,4,4};
		p1 = new int[]{0,1,2,3,4,5,6};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{2,3,3,2};
		p1 = new int[]{0,3,1,2};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{13,32,38,25,43,47,6};
		p1 = new int[]{0,6,3,1,2,4,5};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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
