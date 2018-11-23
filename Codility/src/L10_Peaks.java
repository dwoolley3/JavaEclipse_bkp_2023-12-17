import java.util.*;

public class L10_Peaks {
	public static void main(String[] args) { 
		Solution_L10_Peaks obj = new Solution_L10_Peaks();
		System.out.println("{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)}"); 
		System.out.println(obj.solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2})); 
	}
}

class Solution_L10_Peaks {
    public int solution(int[] A) {
        int n = A.length;
        ArrayList<Integer> peakpos = new ArrayList<>();
        for (int i = 1; i < n-1; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                peakpos.add(i);
            }
        }
        
        for (int i = peakpos.size(); i >= 1; i--) {
            if (n % i == 0) {
            	int blocksize = n / i;
                int blockConsidered = 0;
                for (int p : peakpos) {
                	if (p / blocksize == blockConsidered) {
                		blockConsidered++;
                	}
                }
                if (blockConsidered == i) return i;
            }
        }
        
        return 0;
    }
}