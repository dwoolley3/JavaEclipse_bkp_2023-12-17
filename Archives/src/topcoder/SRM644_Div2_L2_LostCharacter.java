package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM644_Div2_L2_LostCharacter
{
	public int[] getmins(String[] str)
	{
		System.out.println('?' - 0);
		int n = str.length;
		int[] min = new int[n];
		for (int i = 0; i < n; i++)
		{
			String[] s = new String[n];
			for (int j = 0; j < n; j++)
			{
				if (j == i) 
					s[j] = str[j].replace('?', 'a');
				else
					s[j] = str[j].replace('?', 'z');				
			}
			
			for (int j = 0; j < n; j++)
				if (i != j && s[i].compareTo(s[j]) > 0)
						min[i]++;
			
			//Alternative:
			String sFind = s[i];
			Arrays.sort(s);			
			min[i] = Arrays.asList(s).indexOf(sFind);
		}
		return min;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM644_Div2_L2_LostCharacter obj;
		int[] answer;
		obj = new SRM644_Div2_L2_LostCharacter();
		long startTime = System.currentTimeMillis();
		answer = obj.getmins(p0);
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
		
		String[] p0;
		int[] p1;
		
		// ----- test 0 -----
		p0 = new String[]{"abc","bcd","cde","cdf","bbc"};
		p1 = new int[]{0,2,3,4,1};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"?ala","ara","baba"};
		p1 = new int[]{0,0,1};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"a?","a","a","ab","aa"};
		p1 = new int[]{2,0,0,3,2};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"s?nu?ke","sm??eke","?sna?ke","so?th?e","shake??"};
		p1 = new int[]{0,1,0,2,0};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"?","z?","zz?","zzz?","zzzz?","zzzzz?","zzzzzz?"};
		p1 = new int[]{0,1,2,3,4,5,6};
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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
