package codility;

import java.util.*;

public class L10_Flags_ArrayList {
	public static void main(String[] args) { 
		Solution_L10_Flags_ArrayList obj = new Solution_L10_Flags_ArrayList();
		System.out.println("{1, 5, 3, 4, 3, 4,1, 2, 3,4, 6, 2}"); 
		System.out.println(obj.solution(new int[] {1, 5, 3, 4, 3, 4,1, 2, 3,4, 6, 2}));
		System.out.println(obj.solution(new int[] {1}));
		System.out.println(obj.solution(new int[] {1,2})); 
		System.out.println(obj.solution(new int[] {1,2,3})); 
		System.out.println(obj.solution(new int[] {1,3,2}));
		System.out.println(obj.solution(new int[] {1,3,2,3,1})); 
	}
}

class Solution_L10_Flags_ArrayList {
    public int solution(int[] A) {
    	// Correctness = 100%, Performance = 71%
        int n = A.length;
        ArrayList<Integer> peak = new ArrayList<>();
        for (int i = 1; i < n-1; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                peak.add(i);
            }
        }
        
        int maxK = Math.min((int)(Math.ceil(Math.sqrt(n))), peak.size());
        for (int k = maxK; k > 0; k--) {
        	int pos = peak.get(0), peaks = 0;
            for (int i = 0; i < peak.size() && pos <= peak.get(peak.size()-1); i++) {
                if (pos <= peak.get(i))  {
                    peaks++;
                    pos = peak.get(i) + k;
                    if (peaks == k) return peaks;
                }               
            }
        }
        return 0;
    }
}