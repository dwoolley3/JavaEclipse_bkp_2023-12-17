//import java.util.*;

public class L9_MaxProfit {
	public static void main(String[] args) { 
		Solution_L9_MaxProfit obj = new Solution_L9_MaxProfit();
		System.out.println("{23171, 21011, 21123, 21366, 21013, 21367}"); 
		System.out.println(obj.solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367})); 
		System.out.println(obj.solution(new int[] {-10})); 
		System.out.println(obj.solution(new int[] {})); 
		System.out.println(obj.solution(new int[] {8, 9, 3, 6, 1, 2})); 
	}
}

class Solution_L9_MaxProfit {
    public int solution(int[] A) {
        int n = A.length;
        if (n < 2) return 0;
        int maxProfit = Integer.MIN_VALUE;
        int minThusFar = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            minThusFar = Math.min(minThusFar, A[i]);
            maxProfit = Math.max(maxProfit, A[i+1] - minThusFar);
        }
        
        return Math.max(0, maxProfit);
    }
}