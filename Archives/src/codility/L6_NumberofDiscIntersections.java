package codility;

import java.util.*;

public class L6_NumberofDiscIntersections {
	public static void main(String[] args) { 
		Solution_L6_NumberOfDiscIntersections obj = new Solution_L6_NumberOfDiscIntersections();
		System.out.println("{1, 5, 2, 1, 4, 0}"); 
		System.out.println(obj.solution(new int[] {1, 5, 2, 1, 4, 0}));
		System.out.println(obj.solution(new int[] {})); 
		System.out.println(obj.solution(new int[] {10})); 
	}
}

class Solution_L6_NumberOfDiscIntersections {
    public int solution(int[] A) {
        int n = A.length;
        long[] st = new long[n];
        long[] en = new long[n];
        for (int i = 0; i < n; i++) {
            st[i] = i - A[i];
            en[i] = (long)i + A[i];
        }
        Arrays.sort(st);
        Arrays.sort(en);
        int ist = 0, ien = 0;
        int stCount = 0, intersect = 0;
        int maxIntersect = 10_000_000;
        while (ist < n && ien < n) {   	
            while (ist < n && st[ist] <= en[ien]) {
                intersect += stCount;
                if (intersect > maxIntersect)
                    return -1;
                stCount++;
                ist++;
            }

            while (ien < n && (ist == n || en[ien] < st[ist])) {
                stCount--;
                ien++;
            }
        }

        return intersect;
    }
}