//import java.util.*;

public class L5_GenomicRangeQuery {
	public static void main(String[] args) { 
		Solution_L5_GenomicRangeQuery obj = new Solution_L5_GenomicRangeQuery();
		System.out.println("{0,1,0,1,1}"); 
		System.out.println(obj.solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}) ); 
	}
}

class Solution_L5_GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int n = S.length(), m = P.length;
        String dna = "ACGT";
        int[][] d = new int[4][n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
            	for (int j = 0; j < 3; j++)
            		d[j][i] = d[j][i-1];
            }
            int dInd = dna.indexOf(S.charAt(i));
            d[dInd][i]++;
        }
        int[] ans = new int[m];
        int num = 0, ind = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < 4; j++) {
        		num = d[j][Q[i]];
        		if (P[i] > 0) {
        			num -= d[j][P[i]-1];
        		}
                if (num > 0) {
                    ans[ind++] = j+1;
                    break;
                }
        	}        
        }
        return ans;
    }
}