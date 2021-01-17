package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM766_Div2_L2_QueenMeetup
{
	class Queen implements Comparable<Queen> {
		int q, r, c;
		
		public Queen(int q, int r, int c) {
			this.q = q;
			this.r = r;
			this.c = c;
		}
		
	    public int compareTo(Queen queen) {
	        int d = Integer.compare(this.r, queen.r);
	        if (d != 0) {
	            return d;
	        }
	        return Integer.compare(this.c, queen.c);
	    }
	}

	
	public int[] move(int d, int[] r, int[] c)
	{
		int n = r.length;
		ArrayList<Integer> al = new ArrayList<>();
		boolean[][] occupied = new boolean[n][n];
		Queen[] queen = new Queen[n];
		for (int i = 0; i < n; i++) 
		{		
			queen[i] = new Queen(i, r[i], c[i]);
		}
		Arrays.sort(queen);
		for (int q = 0; q < n; q++) {
			int row = queen[q].r;
			int col = queen[q].c;
			int qNum = queen[q].q;			
			int last = Math.min(d,row);
			for (int i = 0; i <= last; i++) {
				if (!occupied[i][col]) {
					if (row != i) {
						row = i;
						al.add(qNum);
						al.add(row);
						al.add(col);
					}
					occupied[row][col] = true;
				}				
			}
			last = Math.min(d, col);
			for (int j = 0; j <= last; j++) {
				if (!occupied[row][j]) {
					occupied[row][col] = false;
					if (col != j) {
						col = j;
						al.add(qNum);
						al.add(row);
						al.add(col);
					}
					occupied[row][col] = true;
				}	
			}
		}
	
		int[] ans = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			ans[i] = al.get(i);
		}
		return ans;		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, int[] p2, boolean hasAnswer, int[] p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
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
		System.out.print("}");
		System.out.println("]");
		SRM766_Div2_L2_QueenMeetup obj;
		int[] answer;
		obj = new SRM766_Div2_L2_QueenMeetup();
		long startTime = System.currentTimeMillis();
		answer = obj.move(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p3.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p3[i]);
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
			if (answer.length != p3.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p3[i]) {
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
		
		int p0;
		int[] p1;
		int[] p2;
		int[] p3;
		
		// ----- test 0 -----
		p0 = 5;
		p1 = new int[]{0,1,3};
		p2 = new int[]{0,1,3};
		p3 = new int[]{0,2,0,0,2,2};
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 5;
		p1 = new int[]{0,0,4,4};
		p2 = new int[]{0,4,4,0};
		p3 = new int[]{2,1,1,3,2,0,1,0,1};
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 1000;
		p1 = new int[]{42};
		p2 = new int[]{47};
		p3 = new int[]{};
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 1234567;
		p1 = new int[]{123456,123457,123456};
		p2 = new int[]{654321,654322,654323};
		p3 = new int[]{};
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 100;
		p1 = new int[]{4,2,10,5,1,3,9,17};
		p2 = new int[]{0,1,2,3,4,5,6,7};
		p3 = new int[]{0,0,0,1,0,1,2,0,2,3,0,3,4,0,4,5,0,5,6,0,6,7,0,7};
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 6;
		p1 = new int[]{0,1,3};
		p2 = new int[]{0,1,3};
		p3 = new int[]{2,2,2};
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
