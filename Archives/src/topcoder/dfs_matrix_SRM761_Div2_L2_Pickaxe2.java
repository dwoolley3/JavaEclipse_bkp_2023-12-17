package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;

public class dfs_matrix_SRM761_Div2_L2_Pickaxe2
{
	int r, c, z1;
	String[] m;
	boolean[][][] used;
	boolean[][][] walls;
	
	public int countWalls(String[] maze)
	{
		r = maze.length;
		c = maze[0].length();
		m = maze;
		
		used  = new boolean[2][r][c];
		walls = new boolean[2][r][c];
		z1 = 0;
		dfs(0,0);
		z1 = 1;
		dfs(r-1,c-1);
		
		int common = 0;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (walls[0][i][j] &&  walls[1][i][j])
					common++;
		return common;					
	}
		
	private void dfs(int row, int col)
	{
		if (row == r || row == -1 || col == c || col ==-1)
			return;	

		if (used[z1][row][col]) return;
		used[z1][row][col] = true;
		
		if(m[row].charAt(col) == '#') {
			walls[z1][row][col] = true;
			return;
		}
		
		dfs(row, col+1);
		dfs(row, col-1);
		dfs(row+1, col);
		dfs(row-1, col);
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
		dfs_matrix_SRM761_Div2_L2_Pickaxe2 obj;
		int answer;
		obj = new dfs_matrix_SRM761_Div2_L2_Pickaxe2();
		long startTime = System.currentTimeMillis();
		answer = obj.countWalls(p0);
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
		p0 = new String[]{"..#",".#.","#.."};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"..##..","..##..","...#..","..##.."};
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"..##..","..##..","..##..","..##.."};
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{".....#.",".###.#.",".#.#...",".###.##",".#.#.#.",".#.###.","##....."};
		p1 = 6;
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
