package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM661_Div2_L1_FallingSand
{
	public String[] simulate(String[] b)
	{
		int rows = b.length;
		int cols = b[0].length();
		char[][] c = new char[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				c[i][j] = b[i].charAt(j);
		

		for (int j = 0; j < cols; j++)
		{
			int cnto = 0, cntp = 0;
			int i = 0;
			for (i = 0; i < rows; i++)
			{
				if (c[i][j] == 'o') cnto++;
				if (c[i][j] == '.') cntp++;
				if (c[i][j] == 'x') 
				{
					for (int k = 1; k <= cnto; k++)
						c[i-k][j] = 'o';
					for (int k = 1; k <= cntp; k++)
						c[i-cnto-k][j] = '.';
					cnto = 0;
					cntp = 0;
				}
			}
			for (int k = 1; k <= cnto; k++)
				c[i-k][j] = 'o';
			for (int k = 1; k <= cntp; k++)
				c[i-cnto-k][j] = '.';
		}
		
		for (int i = 0; i < rows; i++)
			b[i] = new String(c[i]);
		
		return b;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, String[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM661_Div2_L1_FallingSand obj;
		String[] answer;
		obj = new SRM661_Div2_L1_FallingSand();
		long startTime = System.currentTimeMillis();
		answer = obj.simulate(p0);
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
				System.out.print("\"" + p1[i] + "\"");
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + answer[i] + "\"");
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (!answer[i].equals(p1[i])) {
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
		
		String[] p0;
		String[] p1;
		
		// ----- test 0 -----
		p0 = new String[]{"ooooo","..x..","o...x","....o","xxxxx"};
		p1 = new String[]{"..o..","..x.o","o...x","oo.oo","xxxxx"};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		
		// ----- test 0 -----
		p0 = new String[]{"x"};
		p1 = new String[]{"x"};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new String[]{"."};
		p1 = new String[]{"."};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new String[]{"o"};
		p1 = new String[]{"o"};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new String[]{"ooooo","..x..","....x",".....","....o"};
		p1 = new String[]{"..o..","..x.o","....x",".....","oo.oo"};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"..o..","..x.o","....x",".....","oo.oo"};
		p1 = new String[]{"..o..","..x.o","....x",".....","oo.oo"};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"ooooxooo.ooxo.oxoxoooox.....x.oo"};
		p1 = new String[]{"ooooxooo.ooxo.oxoxoooox.....x.oo"};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"o",".","o",".","o",".","."};
		p1 = new String[]{".",".",".",".","o","o","o"};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"oxxxxooo","xooooxxx","..xx.ooo","oooox.o.","..x....."};
		p1 = new String[]{"oxxxxooo","x.oo.xxx","..xxo...",".oo.x.o.","ooxo.ooo"};
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"..o..o..o..o..o..o..o..o..o..o..o","o..o..o..o..o..o..o..o..o..o..o..",".o..o..o..o..o..o..o..o..o..o..o.","...xxx...xxx...xxxxxxxxx...xxx...","...xxx...xxx...xxxxxxxxx...xxx...","...xxx...xxx......xxx......xxx...","...xxxxxxxxx......xxx......xxx...","...xxxxxxxxx......xxx......xxx...","...xxxxxxxxx......xxx......xxx...","...xxx...xxx......xxx............","...xxx...xxx...xxxxxxxxx...xxx...","...xxx...xxx...xxxxxxxxx...xxx...","..o..o..o..o..o..o..o..o..o..o..o","o..o..o..o..o..o..o..o..o..o..o..",".o..o..o..o..o..o..o..o..o..o..o."};
		p1 = new String[]{".................................",".................................","...ooo...ooo...ooooooooo...ooo...","...xxx...xxx...xxxxxxxxx...xxx...","...xxx...xxx...xxxxxxxxx...xxx...","...xxxoooxxx......xxx......xxx...","...xxxxxxxxx......xxx......xxx...","...xxxxxxxxx......xxx......xxx...","...xxxxxxxxx......xxx......xxx...","...xxx...xxx......xxx............","...xxx...xxx...xxxxxxxxx...xxx...","...xxx...xxx...xxxxxxxxx...xxx...",".................................","ooo.........ooo.........ooo...ooo","ooooooooooooooooooooooooooooooooo"};
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
