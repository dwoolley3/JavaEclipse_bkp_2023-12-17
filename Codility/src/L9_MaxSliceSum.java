//import java.util.*;

public class L9_MaxSliceSum {
	public static void main(String[] args) { 
		Solution_L9_MaxSliceSum obj = new Solution_L9_MaxSliceSum();
		System.out.println("{3,2,-6,4,0}"); 
		System.out.println(obj.solution(new int[] {3,2,-6,4,0})); 
		System.out.println(obj.solution(new int[] {-10})); 
	}
}

class Solution_L9_MaxSliceSum {
    public int solution(int[] A) {
        int n = A.length, sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        	if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}