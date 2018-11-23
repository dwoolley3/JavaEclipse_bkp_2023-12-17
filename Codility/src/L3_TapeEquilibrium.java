//import java.util.*;

public class L3_TapeEquilibrium {
	public static void main(String[] args) { 
		Solution_L3_TapeEquilibrium obj = new Solution_L3_TapeEquilibrium();
		System.out.println("{10,50,20}"); 
		System.out.println(obj.solution(new int[] {10,50,20})); 
	}
}

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution_L3_TapeEquilibrium {
    public int solution(int[] A) {
        int n = A.length;
        int[] sum = new int[n];
        sum[0] = A[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i-1] + A[i];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
        {
            int left = sum[i-1];
            int right = sum[n-1] - left;
            int dif = Math.abs(left - right);
            if (dif < min)
                min = dif;
        }
        return min;
    }
}