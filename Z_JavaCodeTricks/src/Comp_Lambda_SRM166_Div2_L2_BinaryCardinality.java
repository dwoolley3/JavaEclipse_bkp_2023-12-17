import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class Comp_Lambda_SRM166_Div2_L2_BinaryCardinality
{
	public int[] arrange(int[] numbers)
	{
		int n = numbers.length;
		Integer[] nums = new Integer[n];
		for (int i = 0; i < n; i++) nums[i] = numbers[i];
		Arrays.sort(nums, (o1,o2) -> (Integer.bitCount(o1) - Integer.bitCount(o2) != 0) ?
				Integer.bitCount(o1) - Integer.bitCount(o2) : o1 - o2 );		
		for (int i = 0; i < n; i++) numbers[i] = nums[i];
		return numbers;
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
		Comp_Lambda_SRM166_Div2_L2_BinaryCardinality obj;
		int[] answer;
		obj = new Comp_Lambda_SRM166_Div2_L2_BinaryCardinality();
		long startTime = System.currentTimeMillis();
		answer = obj.arrange(p0);
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
		p0 = new int[]{4};
		p1 = new int[]{4};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{31,15,7,3,2};
		p1 = new int[]{2,3,7,15,31};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{10,9,8,7,6,5,4,3,2,1};
		p1 = new int[]{1,2,4,8,3,5,6,9,10,7};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{811385,340578,980086,545001,774872,855585,13848,863414,419523,190151,784903,127461};
		p1 = new int[]{13848,340578,545001,855585,419523,811385,127461,190151,774872,863414,784903,980086};
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
