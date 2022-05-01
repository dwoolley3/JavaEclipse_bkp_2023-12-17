package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM807_Div2_L2_ContainsItsAverage
{
	public int[] missing(int[] seq)
	{
		ArrayList<Integer> al = new ArrayList<>();
		int sum = 0;
		for (int x : seq) sum += x;
		int n = seq.length;
		for (int i = 0; i < n; i++) {
			int tot = seq[i] * (n+1);
			int ans = tot - sum;
			if (!al.contains(ans)) {
				al.add(ans);
			}
		}
		if (sum % n == 0) {
			int ans = sum / n;
			if (!al.contains(ans)) {
				al.add(ans);
			}
		}
		Collections.sort(al);
		int [] a = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			a[i] = al.get(i);
		}
		return a;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM807_Div2_L2_ContainsItsAverage obj;
		int[] answer;
		obj = new SRM807_Div2_L2_ContainsItsAverage();
		long startTime = System.currentTimeMillis();
		answer = obj.missing(p0);
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
				System.out.print(p1[i]);
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
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p1[i]) {
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
		
		int[] p0;
		int[] p1;
		
		// ----- test 0 -----
		p0 = new int[]{0,0,0};
		p1 = new int[]{0};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,10,1000,100};
		p1 = new int[]{-1106,-1061,-611,3889};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{500000,400000,200000,100000};
		p1 = new int[]{-700000,-200000,300000,800000,1300000};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
			
		// ----- test 3 -----
		p0 = new int[]{47};
		p1 = new int[]{47};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,20000000};
		p1 = new int[]{-20001176,-20001125,-20001074,-20001023,-20000972,-20000921,-20000870,-20000819,-20000768,-20000717,-20000666,-20000615,-20000564,-20000513,-20000462,-20000411,-20000360,-20000309,-20000258,-20000207,-20000156,-20000105,-20000054,-20000003,-19999952,-19999901,-19999850,-19999799,-19999748,-19999697,-19999646,-19999595,-19999544,-19999493,-19999442,-19999391,-19999340,-19999289,-19999238,-19999187,-19999136,-19999085,-19999034,-19998983,-19998932,-19998881,-19998830,-19998779,-19998728,999998824};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,20000000};
		p1 = new int[]{-20001176,-20001125,-20001074,-20001023,-20000972,-20000921,-20000870,-20000819,-20000768,-20000717,-20000666,-20000615,-20000564,-20000513,-20000462,-20000411,-20000360,-20000309,-20000258,-20000207,-20000156,-20000105,-20000054,-20000003,-19999952,-19999901,-19999850,-19999799,-19999748,-19999697,-19999646,-19999595,-19999544,-19999493,-19999442,-19999391,-19999340,-19999289,-19999238,-19999187,-19999136,-19999085,-19999034,-19998983,-19998932,-19998881,-19998830,-19998779,-19998728,999998824};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
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
