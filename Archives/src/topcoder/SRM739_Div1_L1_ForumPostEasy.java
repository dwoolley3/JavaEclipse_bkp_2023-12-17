package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM739_Div1_L1_ForumPostEasy
{
	public String getCurrentTime(String[] exactPostTime, String[] showPostTime)
	{
		int n = exactPostTime.length;
		String smallest = "impossible";
		for (int hr = 0; hr <= 23; hr++)
			for (int min = 0; min <= 59; min++)
				for (int sec = 0; sec <= 59; sec++) {
					boolean ok = true;				
					for (int i = 0; i < n && ok; i++)
					{
						int timeDif = getTimeDif(hr,min,sec,exactPostTime[i]);
						if (showPostTime[i].equals("few seconds ago"))
						{
							if (timeDif >= 60) ok = false;
						} else if (showPostTime[i].endsWith("minutes ago")) {
							int ept_min = Integer.valueOf(
								showPostTime[i].substring(0, 2).trim());
							if (timeDif >= (ept_min + 1) * 60 
							||	timeDif <  ept_min *60)
								ok = false;
						} else if (showPostTime[i].endsWith("hours ago")) {
							int ept_hr = Integer.valueOf(
								showPostTime[i].substring(0, 2).trim());
							if (timeDif >= (ept_hr + 1) * 60 * 60
							|| timeDif < ept_hr * 60 * 60) 
								ok = false;
						}
					}
					if (ok) {
						String tim = makeTime(hr,min,sec);
						if (tim.compareTo(smallest) < 0) 
							smallest = tim;
					}
				}
		return smallest;
	}
	
	private int getTimeDif(int hr, int min, int sec, String postTime) {
		String[] pt = postTime.split(":");
		int pt_hr = Integer.valueOf(pt[0]);
		int pt_min = Integer.valueOf(pt[1]);
		int pt_sec = Integer.valueOf(pt[2]);
		
		int pt_seconds = pt_hr * 60 * 60 + pt_min * 60 + pt_sec;
		int in_seconds = hr * 60 * 60 + min * 60 + sec;
		
		if (in_seconds < pt_seconds) in_seconds += (24 * 60 * 60);
		int timeDif = in_seconds - pt_seconds;
		return timeDif;
	}
	
	private String makeTime(int hr, int min, int sec) {
		String tim = "";
		if (hr < 10) tim += "0";
		tim += hr + ":";
		if (min < 10) tim += "0";
		tim += min + ":";
		if (sec < 10) tim += "0";
		tim += sec;
		return tim;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM739_Div1_L1_ForumPostEasy obj;
		String answer;
		obj = new SRM739_Div1_L1_ForumPostEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.getCurrentTime(p0, p1);
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
		
		String[] p0;
		String[] p1;
		String p2;
		
		// ----- test 0 -----
		p0 = new String[]{"12:12:12"};
		p1 = new String[]{"few seconds ago"};
		p2 = "12:12:12";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"23:23:23","23:23:23"};
		p1 = new String[]{"59 minutes ago","59 minutes ago"};
		p2 = "00:22:23";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"00:10:10","00:10:10"};
		p1 = new String[]{"59 minutes ago","1 hours ago"};
		p2 = "impossible";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"11:59:13","11:13:23","12:25:15"};
		p1 = new String[]{"few seconds ago","46 minutes ago","23 hours ago"};
		p2 = "11:59:23";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"23:23:23","23:23:24"};
		p1 = new String[]{"59 minutes ago","59 minutes ago"};
		p2 = "00:22:24";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"00:10:10","00:10:09"};
		p1 = new String[]{"59 minutes ago","1 hours ago"};
		p2 = "01:10:09";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{};
		p1 = new String[]{};
		p2 = "00:00:00";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
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
