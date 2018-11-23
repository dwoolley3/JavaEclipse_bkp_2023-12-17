//import java.util.*;

public class L10_Flags {
	public static void main(String[] args) { 
		Solution_L10_Flags obj = new Solution_L10_Flags();
		System.out.println("{1, 5, 3, 4, 3, 4,1, 2, 3,4, 6, 2}"); 
		System.out.println(obj.solution(new int[] {1, 5, 3, 4, 3, 4,1, 2, 3,4, 6, 2}));
		System.out.println(obj.solution(new int[] {1}));
		System.out.println(obj.solution(new int[] {1,2})); 
		System.out.println(obj.solution(new int[] {1,2,3})); 
		System.out.println(obj.solution(new int[] {1,3,2}));
		System.out.println(obj.solution(new int[] {1,3,2,3,1})); 
	}
}

class Solution_L10_Flags {
    public int solution(int[] A) {
        int n = A.length;
        boolean[] peaks = new boolean[n];
        for (int i = 1; i < n-1; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                peaks[i] = true;
            }
        }
        
        int[] nextPeak = new int[n];
        nextPeak[n-1] = -1;
        for (int i = n-2; i >= 0; i--) {
        	if (peaks[i])
        		nextPeak[i] = i;
        	else
        		nextPeak[i] = nextPeak[i+1];        	
        }
        
        int maxK = (int)(Math.ceil(Math.sqrt(n)));
        for (int k = maxK; k > 0; k--) {
        	int pos = 0, numPeaks = 0;
            while (pos < n) {
            	pos = nextPeak[pos];
            	if (pos == -1) break;
               	numPeaks++;
                pos += k;
                if (numPeaks == k) return numPeaks;          
            }
        }
        return 0;
    }
}