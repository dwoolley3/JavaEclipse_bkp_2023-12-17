package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM558_Div2_L2b_Stamp
{
    private String s; 
    private int n, l, cost;
    private int INF = Integer.MAX_VALUE / 2;
    private int[][][] dp;
    private boolean[][][]  was;
    
	public int getMinimumCost(String desiredColor, int stampCost, int pushCost)
	{
        s = desiredColor;
        n = s.length();
        cost = pushCost;

        int best = INF;

        for (l = 1; l <= n; ++l)
        {
            was = new boolean[n][l][3];
            dp = new int[n][l][3];
            int cur = l * stampCost;

            cur += go(0, 0, 0);

            best = Math.min(best, cur);
        }

        return best;
	}
	
    boolean can(int p, int color)
    {
        if (p + l > n) return false;
        for (int i = 0; i < l; ++i)
            if (s.charAt(p + i) == '*' || s.charAt(p + i) == "RGB".charAt(color))
            { }
            else return false;
        return true;
    }
      
    int go(int p, int taken, int color)
    {
        if (p == n) return 0;
        if (was[p][taken][color]) return dp[p][taken][color];
        int res = INF;

        if (taken > 0)
        {
            res = go(p + 1, taken - 1, color);
            if (can(p, color))
            {
                res = Math.min(res, cost + go(p + 1, l - 1, color));
            }
        }
        else
        {
            for (int i = 0; i < 3; ++i)
                if (can(p, i))
                {
                    res = Math.min(res, cost + go(p + 1, l - 1, i));
                }
        }

        was[p][taken][color] = true;
        return dp[p][taken][color] = res;
    }      
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1 + "," + p2);
		System.out.println("]");
		SRM558_Div2_L2b_Stamp obj;
		int answer;
		obj = new SRM558_Div2_L2b_Stamp();
		long startTime = System.currentTimeMillis();
		answer = obj.getMinimumCost(p0, p1, p2);
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
		
		String p0;
		int p1;
		int p2;
		int p3;
		
		// ----- test 0 -----
		p0 = "RRGGBB";
		p1 = 1;
		p2 = 1;
		p3 = 5;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "R**GB*";
		p1 = 1;
		p2 = 1;
		p3 = 5;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "BRRB";
		p1 = 2;
		p2 = 7;
		p3 = 30;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "R*RR*GG";
		p1 = 10;
		p2 = 58;
		p3 = 204;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "*B**B**B*BB*G*BBB**B**B*";
		p1 = 5;
		p2 = 2;
		p3 = 33;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "*R*RG*G*GR*RGG*G*GGR***RR*GG";
		p1 = 7;
		p2 = 1;
		p3 = 30;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
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
