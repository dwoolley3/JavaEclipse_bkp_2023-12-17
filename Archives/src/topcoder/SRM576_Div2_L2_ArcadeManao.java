package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM576_Div2_L2_ArcadeManao
{
    int r, c;
    boolean[][] used;
    String[] l;
    
	public int shortestLadder(String[] level, int coinRow, int coinColumn)
	{
		int numLevels = level.length;
        r = coinRow - 1;
        c = coinColumn - 1;
        l = level;
        for (int i = 0; i <= 51; i++)
        {
            used = new boolean[51][51];
            if (dfs(numLevels - 1, 0, i))
                return i;
        }
        return numLevels - 1;
	}
	

    boolean dfs(int x, int y, int m)
    {
        if (used[x][y]) return false;
        used[x][y] = true;
        if (x == r && y == c) return true;
        if (y > 0 && l[x].charAt(y - 1) == 'X')
            if (dfs(x, y - 1, m)) return true;
        if (y + 1 < l[0].length() && l[x].charAt(y + 1) == 'X')
            if (dfs(x, y + 1, m)) return true;
        for (int i = 0; i < l.length; i++)
            if (l[i].charAt(y) == 'X' && Math.abs(i - x) <= m)
                if (dfs(i, y, m)) return true;
        return false;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1 + "," + p2);
		System.out.println("]");
		SRM576_Div2_L2_ArcadeManao obj;
		int answer;
		obj = new SRM576_Div2_L2_ArcadeManao();
		long startTime = System.currentTimeMillis();
		answer = obj.shortestLadder(p0, p1, p2);
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
		
		String[] p0;
		int p1;
		int p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new String[]{"XXXX....","...X.XXX","XXX..X..","......X.","XXXXXXXX"};
		p1 = 2;
		p2 = 4;
		p3 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"XXXX","...X","XXXX"};
		p1 = 1;
		p2 = 1;
		p3 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"..X..",".X.X.","X...X",".X.X.","..X..","XXXXX"};
		p1 = 1;
		p2 = 3;
		p3 = 4;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"X"};
		p1 = 1;
		p2 = 1;
		p3 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"XXXXXXXXXX","...X......","XXX.......","X.....XXXX","..XXXXX..X",".........X",".........X","XXXXXXXXXX"};
		p1 = 1;
		p2 = 1;
		p3 = 2;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
