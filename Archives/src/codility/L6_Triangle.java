package codility;

import java.util.*;

public class L6_Triangle {
	public static void main(String[] args) { 
		Solution_L6_Triangle obj = new Solution_L6_Triangle();
		System.out.println("{0,1,0,1,1}"); 
		System.out.println(obj.solution(new int[] {0,1,5,13,6})); 
	}
}

class Solution_L6_Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for (int i = 0; i < n-2; i++) {
            long sum2smaller = (long)A[i] + A[i+1];
            if (sum2smaller > A[i+2])
                return 1;
        }
        return 0;
    }
}