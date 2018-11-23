package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM648_Div2_L2_Fragile2
{	
	boolean[] used;
	int[] id;
	int cnt = 0;
	int p1 = -1, p2 = -1;
	int[] a;
	
	public int countPairs(String[] graph)
	{
		int n = graph.length;
		
		used = new boolean[n];
		id = new int[n];
		a = new int[n];
		
		for (int s = 0; s < n; s++)
			if (!used[s])
			{
				dfs(graph, s);
				cnt++;
			}
		
		for (int i = 0; i < n; i++)
			a[id[i]]++;
		
		int origCnt = cnt;
		int ans = 0;
		
		for (p1 = 0; p1 < n-1; p1++)
			for (p2 = p1+1; p2 < n; p2++)
			{
				cnt = 0;
				used = new boolean[n];
				id = new int[n];
				a = new int[n];
				
				for (int s = 0; s < n; s++)
					if (s != p1 && s != p2)
						if (!used[s])
						{
							dfs(graph, s);
							cnt++;
						}
				if (cnt > origCnt) ans++;
				
				for (int i = 0; i < n; i++)
					a[id[i]]++;					
			}
				
		return ans;		
	}
	
	private void dfs(String[] g, int v)
	{
		used[v] = true;
		id[v] = cnt;
		for (int w = 0; w < g.length; w++) //: adj[v])
			if (w != p1 && w != p2)
				if (g[v].charAt(w) == 'Y')
					if (!used[w])
						dfs(g, w);
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM648_Div2_L2_Fragile2 obj;
		int answer;
		obj = new SRM648_Div2_L2_Fragile2();
		long startTime = System.currentTimeMillis();
		answer = obj.countPairs(p0);
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
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new String[]{"NYNN","YNYN","NYNY","NNYN"};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"NYNNNN","YNYNNN","NYNNNN","NNNNYN","NNNYNY","NNNNYN"};
		p1 = 5;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"NNN","NNN","NNN"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"NYNYNNYYNN","YNNNYNYYNN","NNNNYNNNYN","YNNNYYNNNN","NYYYNNNNYN","NNNYNNNNYN","YYNNNNNNNN","YYNNNNNNYN","NNYNYYNYNY","NNNNNNNNYN"};
		p1 = 9;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"NNNYNNYNNNNNNNYYNNNY","NNNNNNNNYNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNN","YNNNNNNNNNYNNNNNNNNN","NNNNNNNYNNNNNYNNNNYN","NNNNNNNNNNNNNNNNYNNY","YNNNNNNNNNNNNYYYNYNN","NNNNYNNNNNNNNYYNNNNN","NYNNNNNNNYNNNNNNNNNN","NNNNNNNNYNNNYNNNNNYN","NNNYNNNNNNNNNNYNNNNN","NNNNNNNNNNNNNNNNNNNN","NNNNNNNNNYNNNNNNNYNN","NNNNYNYYNNNNNNNNNNNN","YNNNNNYYNNYNNNNNNNNN","YNNNNNYNNNNNNNNNYNNN","NNNNNYNNNNNNNNNYNYNN","NNNNNNYNNNNNYNNNYNNN","NNNNYNNNNYNNNNNNNNNN","YNNNNYNNNNNNNNNNNNNN"};
		p1 = 42;
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
