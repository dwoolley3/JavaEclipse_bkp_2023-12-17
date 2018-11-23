package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM462_Div2_L2_AgeEncoding
{
	public double getRadix(int age, String candlesLine)
	{
		//Not working for test input of 1,11. It gives a number other than -1.
        double f, ans = 0;
        for (int b = 0; b <= 100; b++)
        {
            f = func(b, candlesLine);
            if (Math.abs(f - age) < 1e-9 )
                if (ans == 0)
                    ans = b;
                else
                    return -2; //more than 1 answer
            else if (f > age)
                if (ans > 0)
                    return ans;
                else
                {
                    //Find real value between hi and lo
                    //Works for most, but gives answer for 1,11 instead of -1
                    double lo = b - 1, hi = b;
                    double m = (lo + hi) / 2.0;
                    while (Math.abs(func(m, candlesLine) - age) >= 1e-9)
                    {
                        if (func(m, candlesLine) > age)
                            hi = m;
                        else
                            lo = m;
                        m = (lo + hi) / 2.0;
                    }
                    return m;
                }
        }
        if (ans > 0)
            return ans;
        return -1;

	}

    private double func(double b, String c)
    {
        int n = c.length();
        double sum = 0;
        double pow = 1;
        int bit;
        for (int i = 0; i < n; i++)
        {
            bit = c.charAt(n-i - 1) - '0';
            sum += bit * pow;
            pow *= b;
        }
        return sum;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, String p1, boolean hasAnswer, double p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "\"" + p1 + "\"");
		System.out.println("]");
		SRM462_Div2_L2_AgeEncoding obj;
		double answer;
		obj = new SRM462_Div2_L2_AgeEncoding();
		long startTime = System.currentTimeMillis();
		answer = obj.getRadix(p0, p1);
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
			res = Math.abs(p2 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p2));
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
		String p1;
		double p2;
		
		// ----- test 0 -----
		p0 = 10;
		p1 = "00010";
		p2 = 10.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 21;
		p1 = "10101";
		p2 = 2.0D;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 6;
		p1 = "10100";
		p2 = 1.414213562373095D;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 21;
		p1 = "10111111110111101111111100111111110111111111111100";
		p2 = 0.9685012944510603D;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 16;
		p1 = "1";
		p2 = -1.0D;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = 1;
		p1 = "1";
		p2 = -2.0D;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = 1;
		p1 = "001000";
		p2 = 1.0D;
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
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
