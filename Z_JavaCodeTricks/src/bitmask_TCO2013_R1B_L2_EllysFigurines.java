//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class bitmask_TCO2013_R1B_L2_EllysFigurines
{
	int r, c;
	
	public int getMoves(String[] board, int R, int C)
	{
		r = board.length;
        c = board[0].length();

        int min = Integer.MAX_VALUE;
        for (int mask = 0; mask < 1 << r; mask++)
        {
            boolean[] exRow = new boolean[r];
            int cnt = 0, i = 0;
            for (i = 0; i < r; i++)
                if ((mask & 1 << i) > 0)
                {
                    for (int j = 0; j < R; j++)
                        if (i+j < r) exRow[i+j] = true;
                    cnt++;
                }
            i = 0;
            while (i < c)
            {
                for (int j = 0; j < r; j++)
                    if (!exRow[j])
                    {
                        if (board[j].charAt(i) == 'X')
                        {
                            cnt++;
                            i += C-1;
                            break;
                        }
                    }
                i++;
            }
            min = Math.min(min, cnt);
        }             

        return min;
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
		bitmask_TCO2013_R1B_L2_EllysFigurines obj;
		int answer;
		obj = new bitmask_TCO2013_R1B_L2_EllysFigurines();
		long startTime = System.currentTimeMillis();
		answer = obj.getMoves(p0, p1, p2);
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
		p0 = new String[]{".X.X.","XX..X",".XXX.","...X.",".X.XX"};
		p1 = 1;
		p2 = 2;
		p3 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{".X.X.","XX..X",".X.X.","...X.",".X.XX"};
		p1 = 2;
		p2 = 2;
		p3 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"XXXXXXX"};
		p1 = 2;
		p2 = 3;
		p3 = 1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"XXXXX","X....","XXX..","X....","XXXXX"};
		p1 = 1;
		p2 = 1;
		p3 = 4;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"XXX..XXX..XXX.",".X..X....X...X",".X..X....X...X",".X..X....X...X",".X...XXX..XXX.","..............","...XX...XXX...","....X......X..","....X....XXX..","....X......X..","...XXX..XXX..."};
		p1 = 1;
		p2 = 2;
		p3 = 7;
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
