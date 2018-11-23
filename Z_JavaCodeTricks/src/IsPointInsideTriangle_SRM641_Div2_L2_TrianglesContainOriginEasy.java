//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class IsPointInsideTriangle_SRM641_Div2_L2_TrianglesContainOriginEasy
{
	public int count(int[] x, int[] y)
	{
		int n = x.length, cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = i+1; j < n; j++)
				for (int k = j+1; k < n; k++)
				{
					if (isInsideTri(x[i],y[i],x[j],y[j],x[k],y[k]))
						cnt++;
				}
		return cnt;
	}
	
	private boolean isInsideTri(int ax, int ay, int bx, int by, int cx, int cy)
	{
		int pointX = 0, pointY = 0;
	    int dx = pointX - ax;
	    int dy = pointY - ay;

	    boolean bool_ab = (bx - ax) * dy - (by - ay) * dx > 0;

	    if ((cx-ax)*dy - (cy-ay)*dx > 0 == bool_ab) return false;
	    if ((cx-bx)*(0-by) - (cy-by)*(0-bx) > 0 != bool_ab) return false;
	    return true;
	}

	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		IsPointInsideTriangle_SRM641_Div2_L2_TrianglesContainOriginEasy obj;
		int answer;
		obj = new IsPointInsideTriangle_SRM641_Div2_L2_TrianglesContainOriginEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{-1,-1,1};
		p1 = new int[]{1,-1,0};
		p2 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{-1,-1,1,2};
		p1 = new int[]{1,-1,2,-1};
		p2 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{-1,-2,3,3,2,1};
		p1 = new int[]{-2,-1,1,2,3,3};
		p2 = 8;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,5,10,5,-5,7,-9,-6,-3,0,8,8,1,-4,7,-3,10,9,-6};
		p1 = new int[]{5,-6,-3,4,-2,-8,-7,2,7,4,2,0,-4,-8,7,5,-5,-2,-9};
		p2 = 256;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
