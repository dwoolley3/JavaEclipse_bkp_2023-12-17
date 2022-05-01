package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class Rookie_SRM11_Div1_L3_ChamberCount
{
	
	boolean[][] u = new boolean[50][50];
    int cnt, r, c;
    String[] f;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
    
	public int count(String[] map) {

		int chamber = 0;	
        f = map;
        r = f.length;
        c = f[0].length();

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
            {
                if (f[i].charAt(j) == '.' && !u[i][j])
                {
                    chamber++;;
                    dfs(i, j);
                }
            }

        return chamber;
	}
	
    public void dfs(int x, int y)
    {
    	if (x < 0 || x >= r || y < 0 || y >= c || u[x][y] || f[x].charAt(y) == 'X') {
    		return;
    	}
        u[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nr = x + dx[i];
			int nc = y + dy[i];
            dfs(nr, nc);
        }
        return;
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
		Rookie_SRM11_Div1_L3_ChamberCount obj;
		int answer;
		obj = new Rookie_SRM11_Div1_L3_ChamberCount();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0);
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
		p0 = new String[]{"...","...","..."};
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"XX","XX"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{".X.","X.X",".X."};
		p1 = 5;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"X...",".XX.","...."};
		p1 = 1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"X...",".XX.","..X."};
		p1 = 2;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"XXXXX.","XXXXX.","XX..X.","X..XX.","X.X.XX","XX.X.."};
		p1 = 5;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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
