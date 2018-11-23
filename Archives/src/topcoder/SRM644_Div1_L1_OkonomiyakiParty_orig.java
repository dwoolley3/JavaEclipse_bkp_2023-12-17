package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
import java.math.*;


public class SRM644_Div1_L1_OkonomiyakiParty_orig
{
	public int count(int[] osize, int M, int K)
	{
		GenerateFactorials();
		Arrays.sort(osize);
		int nlen = osize.length;
		long cnt = 0;
		for (int i = 0; i < nlen; i++)
			for (int j = i + M - 1; j < nlen; j++)
				if (osize[j] - osize[i] <= K)
				{
					int n = (j-i + 1) - 2; //Start/End chosen so -2
					int k = M - 2;
					cnt += nCk(n,k);
					cnt %= MOD;				
				}
				else break;
			
		return (int)cnt;
	}
	
	long MOD = 1_000_000_007;
	
    long[] fact = new long[1000001];
    void GenerateFactorials()
    {
        fact[0] = 1L;
        for (int i = 1; i < 1000001; i++)
            fact[i] = fact[i - 1] * i % MOD;
    } 
    
    long nCk(int n, int k) {
        long f = fact[n];
        long f1 = BigInteger.valueOf(fact[k]).modInverse(BigInteger.valueOf(MOD)).longValue();
        long f2 = BigInteger.valueOf(fact[n - k]).modInverse(BigInteger.valueOf(MOD)).longValue();
        long nCk = (f * f1 % MOD) * f2 % MOD ;
        return nCk;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1 + "," + p2);
		System.out.println("]");
		SRM644_Div1_L1_OkonomiyakiParty_orig obj;
		int answer;
		obj = new SRM644_Div1_L1_OkonomiyakiParty_orig();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0, p1, p2);
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
		
		int[] p0;
		int p1;
		int p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new int[]{1,4,6,7,9};
		p1 = 2;
		p2 = 3;
		p3 = 6;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,6,2,7,4,2,6,1,5,2,4};
		p1 = 4;
		p2 = 3;
		p3 = 60;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1,4,5,7,10,11,13,16,18};
		p1 = 4;
		p2 = 5;
		p3 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{55,2,7,232,52,5,5332,623,52,6,532,5147};
		p1 = 6;
		p2 = 10000;
		p3 = 924;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{5781,8708,1754,4750,9888,3675,4810,1020,922,9834,5695,1101,1236,2496,8431,6727,1376,3373,4423,1839,7438,9407,1851,6966,8715,2905,542,535,8980,2602,2603,3117,3452,5682,7775,4356,5140,8923,9801,3729};
		p1 = 15;
		p2 = 4003;
		p3 = 114514;
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