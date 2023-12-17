package codility;

//import java.util.*;

public class L5_GenomicRangeQuery_firstGood {
	public static void main(String[] args) { 
		Solution_L5_GenomicRangeQuery_firstGood obj = new Solution_L5_GenomicRangeQuery_firstGood();
		System.out.println("{0,1,0,1,1}"); 
		System.out.println(obj.solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}) ); 
	}
}

class Solution_L5_GenomicRangeQuery_firstGood {
    public int[] solution(String S, int[] P, int[] Q) {
        int n = S.length(), m = P.length;
        int[] a = new int[n];
        int[] c = new int[n];
        int[] g = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                a[i] = a[i-1];
                c[i] = c[i-1];
                g[i] = g[i-1];
                t[i] = t[i-1];
            }
            char ch = S.charAt(i);
            if (ch == 'A') a[i]++;
            else if (ch == 'C') c[i]++;
            else if (ch == 'G') g[i]++;
            else if (ch == 'T') t[i]++;
        }
        int[] ans = new int[m];
        int num = 0, ind = 0;
        for (int i = 0; i < m; i++) {
            num = a[Q[i]];
            if (P[i] > 0) num -= a[P[i]-1];
            if (num > 0) {
                ans[ind++] = 1;
                continue;
            }
            num = c[Q[i]];
            if (P[i] > 0) num -= c[P[i]-1];
            if (num > 0) {
                ans[ind++] = 2;
                continue;
            }
            num = g[Q[i]];
            if (P[i] > 0) num -= g[P[i]-1];
            if (num > 0) {
                ans[ind++] = 3;
                continue;
            }
            num = t[Q[i]];
            if (P[i] > 0) num -= t[P[i]-1];
            if (num > 0) {
                ans[ind++] = 4;
                continue;
            }            
        }
        return ans;
    }
}