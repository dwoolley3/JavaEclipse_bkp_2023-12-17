package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2014_R1B_L2_WolvesAndSheep
{
	public int getmin(String[] field)
	{
		int rows = field.length;
		int cols = field[0].length();
		int min = rows + cols;
		
		for (int mask = 0; mask < (1 << (rows-1)); mask++)
		{
			int bits = Integer.bitCount(mask);
			boolean[] hasW = new boolean[rows];
			boolean[] hasS = new boolean[rows];
			int colsNeeded = 0;
			boolean good = true;
			forc:
			for (int c = 0; c < cols; c++)
			{
				int ri = 0;
				boolean colHasW = false;
				boolean colHasS = false;
				for (int r = 0; r < rows; r++)
				{
					char ch = field[r].charAt(c);
					hasW[ri] = hasW[ri] || (ch == 'W');
					hasS[ri] = hasS[ri] || (ch == 'S');
					colHasW = colHasW || (ch == 'W');
					colHasS = colHasS || (ch == 'S');
					if (colHasW && colHasS)
					{
						good = false;					
						break forc;
					}
					if (hasW[ri] && hasS[ri])
					{
						colsNeeded++;
						for (int j = 0; j < rows; j++)
						{
							hasW[j] = false;
							hasS[j] = false;
						}
						c--;
						break;
					}
					if ((mask & (1 << r)) > 0)
					{
						ri++;
						colHasW = false;
						colHasS = false;
					}
				}
			}
			if (good)
				min = Math.min(min,  bits + colsNeeded);
		}
		
		return min;
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
		TCO2014_R1B_L2_WolvesAndSheep obj;
		int answer;
		obj = new TCO2014_R1B_L2_WolvesAndSheep();
		long startTime = System.currentTimeMillis();
		answer = obj.getmin(p0);
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
		p0 = new String[]{"W.WSS","WW.S.",".SSS.","SSS.S",".SS.S"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{".....",".....","....."};
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{".SS","...","S..","W.W"};
		p1 = 1;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"WWWSWWSSWWW","WWSWW.SSWWW","WS.WSWWWWS."};
		p1 = 10;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{".W.S.W.W","W.W.S.W.",".S.S.W.W","S.S.S.W.",".S.W.W.S","S.S.W.W.",".W.W.W.S","W.W.S.S."};
		p1 = 7;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"W.SSWWSSSW.SS",".SSSSW.SSWWWW",".WWWWS.WSSWWS","SS.WSS..W.WWS","WSSS.SSWS.W.S","WSS.WS...WWWS","S.WW.S.SWWWSW","WSSSS.SSW...S","S.WWSW.WWSWSW",".WSSS.WWSWWWS","..SSSS.WWWSSS","SSWSWWS.W.SSW","S.WSWS..WSSS.","WS....W..WSS."};
		p1 = 24;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new String[]{"WW..SS","WW..SS","......","......","SS..WW","SS..WW"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 7 -----
		p0 = new String[]{"S......W.....S..", "....S.....WS..WS", "S...W..W....S...", ".SWWWW.W...SW.W.", "W.....W..WS.WS..", "..S....W..W.....", ".WS........S..S.", ".S...W..WS.S....", "..WWSS...W.....W", "..........W.....", "W...SW.W......W.", "...W.....S.W....", "S..SSW..S...S.W.", "..SSWS.S.SS.W..."};
		p1 = 20;
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
