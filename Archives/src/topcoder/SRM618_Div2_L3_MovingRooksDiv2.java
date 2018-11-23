package topcoder;


//*** Does not work in all cases

public class SRM618_Div2_L3_MovingRooksDiv2
{
	public String move(int[] Y1, int[] Y2)
	{
		String possible = "Possible", impossible = "Impossible";
		int n = Y1.length;
		
		for (int i = 0; i < n; i++)
		{
			int j = 0; 
			for (j = 0; j < n; j++) 
				if (Y1[j] == Y2[i]) break;
			if (i < j && Y1[i] > Y1[j])
			{
				for (int k = j; k >= i; k--)
					if (Y1[k] > Y1[j])
					{
//						int m = 0;
//						for (m = 0; m < n; m++) 
//							if (Y1[m] == Y2[k]) break;
//						if (m < k)
						{
							int t = Y1[k]; Y1[k] = Y1[j]; Y1[j] = t;
							j = k;
						}
					}
			}
			else if (i > j) return impossible;  //i=j continues			
		}
		return possible;
		
		//Alternative code that does not work in all cases
//		String possible = "Possible", impossible = "Impossible";
//		int n = Y1.length;
//		
//		int i = 0;
//		while (i < n && Y1[i] == Y2[i]) i++;
//		
//		if (i < n && Y1[i] < Y2[i])
//			return impossible;
//		return possible;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, String p2) {
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
		SRM618_Div2_L3_MovingRooksDiv2 obj;
		String answer;
		obj = new SRM618_Div2_L3_MovingRooksDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.move(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String p2;

		// ----- test 0 -----
		p0 = new int[]{7, 0, 4, 6, 5, 3, 1, 2};
		p1 = new int[]{4, 1, 5, 7, 2, 3, 6, 0};
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{6, 2, 4, 0, 1, 5, 7, 3};
		p1 = new int[]{1, 0, 4, 3, 2, 6, 7, 5};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{0,1,2,7,6,5,4,3};
		p1 = new int[]{0,1,2,5,7,4,3,6};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{0,1,2,7,6,5,4,3};
		p1 = new int[]{0,1,2,5,7,4,3,6};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{4,3,2,1,0};
		p1 = new int[]{2,4,1,0,3};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{4,3,2,1,0};
		p1 = new int[]{0,1,2,3,4};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{0};
		p1 = new int[]{0};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,0};
		p1 = new int[]{0,1};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{0,1};
		p1 = new int[]{1,0};
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{3,1,2,0};
		p1 = new int[]{0,2,1,3};
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{3,1,2,0};
		p1 = new int[]{3,2,0,1};
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
