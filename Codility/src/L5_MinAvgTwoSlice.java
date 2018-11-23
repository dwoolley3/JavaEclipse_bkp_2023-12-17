//import java.util.*;

public class L5_MinAvgTwoSlice {
	public static void main(String[] args) { 
		Solution_L5_MinAvgTwoSlice obj = new Solution_L5_MinAvgTwoSlice();
		System.out.println("{4,2,2,5,1,5,8}}"); 
		System.out.println(obj.solution(new int[] {4,2,3,5,1,4,1,8}) ); 
	}
}

class Solution_L5_MinAvgTwoSlice {
    public int solution(int[] A) {
        int n = A.length;
        int[] sum = new int[n];
        double minAve = Double.MAX_VALUE;
        int mini = -1;
        sum[0] = A[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + A[i];
        }
        for (int i = 0; i < n-1; i++) {
            //for (int j = i+1; j < n; j++) {
        	// Only need to check 2 and 3 contiguous integers
        	for (int j = i+1; j <= Math.min(i+3, n-1); j++) {
                int tot = sum[j];
                if (i > 0) tot -= sum[i-1];
                double ave = 1.0 * tot / (j-i+1);
                if (ave < minAve) {
                    minAve = ave;
                    mini = i;
                }
            }
        }
        return mini;
    }
}