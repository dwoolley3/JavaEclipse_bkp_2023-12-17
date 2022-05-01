package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class TCO2021_R1A_L1_EllysBalancedStrings
{
	public int getMin(String S)
	{
		int n= S.length();
		boolean[] isVowel = new boolean[n];
		String vowels = "AEIOU";
		int vowCnt = 0;
		char[] s = S.toCharArray();
		for (int i = 0; i < n; i++) {
			isVowel[i] = vowels.contains(s[i]+"");
			if (isVowel[i]) vowCnt++;
		}
		if (vowCnt == n/2) return 0;
		if (vowCnt > n/2) return vowCnt - n/2; // Constants 1 away from any vowel
		// vowCnt < n/2, so find closest vowels
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!isVowel[i]) {
				for (int j = 1; j < 26; j++) {
					char c1 = (char)(s[i] - j);
					char c2 = (char)(s[i] + j);
					if (vowels.contains(c1+"") || vowels.contains(c2+"")) {
						al.add(j); break;
					}					
				}
			}
		}
		Collections.sort(al);
		int sum = 0;
		for (int i = 0; i < n/2 - vowCnt; i++) {
			sum += al.get(i);
		}
		
		return sum;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		TCO2021_R1A_L1_EllysBalancedStrings obj;
		int answer;
		obj = new TCO2021_R1A_L1_EllysBalancedStrings();
		long startTime = System.currentTimeMillis();
		answer = obj.getMin(p0);
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
		
		String p0;
		int p1;
		
		// ----- test 0 -----
		p0 = "TOPCODER";
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "BANANA";
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "WITHOUTITIAMJUSTESPR";
		p1 = 2;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "NOZAPHODJUSTVERYVERYIMPROBABLE";
		p1 = 5;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "SYZYGY";
		p1 = 8;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		p1 = 8;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "AEIOUA";
		p1 = 3;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "ZZZZZZ";
		p1 = 15;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------	
		
		// ----- test 4 -----
		p0 = "ZZ";
		p1 = 5;
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
