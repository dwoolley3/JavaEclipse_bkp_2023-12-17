package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM802_Div2_L2_TheQuestForGold2_failed
{
	int rows, cols;
	char[][] ca;
	boolean[][] vis;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	int tx = -1, ty = -1;
	
	public String explore(String[] cave)
	{
		String NO_GOLD = "no gold";
		String GOLD = "gold";
		rows = cave.length;
		cols = cave[0].length();
		ca = new char[rows][cols];
		vis = new boolean[rows+1][cols+1];
		int sx=-1,sy=-1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ca[i][j] = cave[i].charAt(j);
				if (ca[i][j] == 'T') {
					tx = i;
					ty = j;
				} else if (ca[i][j] == 'S') {
					sx = i;
					sy = j;
				}
			}
		}
		if (tx == -1) return NO_GOLD;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (ca[i][j] == 'P') {
					if (i-1 >= 0) {
						ca[i-1][j] = '*';
					}
					if (i+1 <= rows-1) {
						ca[i+1][j] = '*';
					}
					
					if (j-1 >= 0) {
						ca[i][j-1] = '*';
					}
					if (j+1 <= cols-1) {
						ca[i][j+1] = '*';
					}
				}
			}
		}
		if (ca[sx][sy] != 'S') return NO_GOLD;
		
		return dfs(sx, sy) ? GOLD : NO_GOLD;
	}
	
	boolean dfs(int r, int c) {
		if (r < 0 || r >= rows || c < 0 || c >= cols || ca[r][c] == 'P') {
			return false;
		}
		if (r == tx && c == ty) {
			return true;
		}
		if (ca[r][c] == '*') {
			return false;
		}
		if (vis[r][c]) 
			return false;
		vis[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if (dfs(nr, nc))
				return true;
		}
		return false;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM802_Div2_L2_TheQuestForGold2_failed obj;
		String answer;
		obj = new SRM802_Div2_L2_TheQuestForGold2_failed();
		long startTime = System.currentTimeMillis();
		answer = obj.explore(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		String p1;
		
		// ----- test 0 -----
		p0 = new String[]{"S....",".....","...T.","....."};
		p1 = "gold";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"S....","...P.","..PTP","...P."};
		p1 = "no gold";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"S....","..P.P",".P.T.","....."};
		p1 = "no gold";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"S....","P....","...T.","....."};
		p1 = "no gold";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"S....",".....","PPP..",".....",".....",".....","..PPP","..T.."};
		p1 = "gold";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{".......",".......","..P.P..","..PPP..","..P.P..",".......","..S...."};
		p1 = "no gold";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new String[]{".......",".......","..P.P..","..PTP..","..P.P..",".......","..S...."};
		p1 = "no gold";
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
		// ------------------
		
		p0 = new String[]{"..P..",".STP.","..P..","....."};
		p1 = "gold";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
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
