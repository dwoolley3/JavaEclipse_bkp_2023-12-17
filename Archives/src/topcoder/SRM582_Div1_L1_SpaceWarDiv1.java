package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM582_Div1_L1_SpaceWarDiv1
{
	public void p(Object ...o) {System.out.println(Arrays.deepToString(o));}
	
    //mgs = magicalGirlStrength; es = enemyStrength; ec = enemyCount
	public long minimalFatigue(int[] mgs, int[] es, long[] ec)
	{
        int nm = mgs.length;
        Arrays.sort(mgs);
        long[] f = new long[nm];

        int ne = es.length;
        long total_ec = 0;
        for (int i = 0; i < ne; i++)
            total_ec += ec[i];

        int ti;
        long tl;
        for (int i = 0; i < ne-1; i++)
            for (int j = i + 1; j < ne; j++)
            {
                if (es[j] < es[i])
                {
                    ti = es[i]; es[i] = es[j]; es[j] = ti;
                    tl = ec[i]; ec[i] = ec[j]; ec[j] = tl;
                }
            }

        p(es);
        int remainingM = nm;
        long maxf = 0;
        for (int i = 0; i < nm; i++)
        {
            remainingM = nm - i;
            long even = total_ec / remainingM;
            long leftToTake = even;
            long take = 0;
            for (int j = 0; j < ne; j++)
            {
                leftToTake = leftToTake - take;
                if (mgs[i] >= es[j])
                {
                    take = Math.min(leftToTake, ec[j]);
                    f[i] += take;
                    ec[j] -= take;
                }
            }
            total_ec -= f[i];
            maxf = Math.max(maxf, f[i]);
        }
        for (int i = 0; i < ne; i++)
            if (ec[i] > 0) maxf = -1;

        return maxf;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, long[] p2, boolean hasAnswer, long p3) {
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SRM582_Div1_L1_SpaceWarDiv1 obj;
		long answer;
		obj = new SRM582_Div1_L1_SpaceWarDiv1();
		long startTime = System.currentTimeMillis();
		answer = obj.minimalFatigue(p0, p1, p2);
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
		int[] p1;
		long[] p2;
		long p3;
		
		// ----- test 0 -----
		p0 = new int[]{2,3,5};
		p1 = new int[]{1,3,4};
		p2 = new long[]{2L,9L,4L};
		p3 = 7L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{2,3,5};
		p1 = new int[]{1,1,2};
		p2 = new long[]{2L,9L,4L};
		p3 = 5L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{14,6,22};
		p1 = new int[]{8,33};
		p2 = new long[]{9L,1L};
		p3 = -1L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{869,249,599,144,929,748,665,37,313,99,33,437,308,137,665,834,955,958,613,417};
		p1 = new int[]{789,57,684,741,128,794,542,367,937,739,568,872,127,261,103,763,864,360,618,307};
		p2 = new long[]{20626770196420L,45538527263992L,52807114957507L,17931716090785L,65032910980630L,88711853198687L,26353250637092L,61272534748707L,89294362230771L,52058590967576L,60568594469453L,23772707032338L,43019142889727L,39566072849912L,78870845257173L,68135668032761L,36844201017584L,10133804676521L,6275847412927L,37492167783296L};
		p3 = 75030497287405L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
