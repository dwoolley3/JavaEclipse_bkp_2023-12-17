//import java.util.*;

public class L9_MaxDoubleSliceSum {
	public static void main(String[] args) { 
		Solution_L9_MaxDoubleSliceSum obj = new Solution_L9_MaxDoubleSliceSum();
		System.out.println("{23171, 21011, 21123, 21366, 21013, 21367}"); 
		System.out.println(obj.solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2})); 
		System.out.println(obj.solution(new int[] {8, 9, 3, 6, 1, 2})); 
	}
}

class Solution_L9_MaxDoubleSliceSum {
    public int solution(int[] A) {
        int n = A.length;
        int[] maxXY = new int[n];
        int[] maxYZ = new int[n];
        int maxXYZ = 0;
        for (int i = 1; i < n-1; i++) {
            maxXY[i] = Math.max(maxXY[i-1] + A[i], 0);
        }

        for (int i = n-2; i > 0; i--) {
            maxYZ[i] = Math.max(maxYZ[i+1] + A[i], 0);
        }
        
        for (int i = 1; i < n-1; i++) {
            maxXYZ = Math.max(maxXYZ, maxXY[i-1] + maxYZ[i+1]);
        }
        return maxXYZ;
    }
}