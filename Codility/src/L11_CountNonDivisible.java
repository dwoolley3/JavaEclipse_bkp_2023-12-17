//import java.util.*;

public class L11_CountNonDivisible {
	public static void main(String[] args) { 
		Solution_L11_CountNonDivisible obj = new Solution_L11_CountNonDivisible();
		System.out.println("{1, 5, 3, 4, 3, 4,1, 2, 3,4, 6, 2}"); 
		System.out.println(obj.solution(new int[] {1, 5, 3, 4, 3, 4,1, 2, 3,4, 6, 2}));
	}
}

class Solution_L11_CountNonDivisible {
    public int[] solution(int[] A) {
        int n = A.length;
        int maxA = 0;
        for (int i = 0; i < n; i++) 
        	if (A[i]>maxA) maxA=A[i];
        int[] cntA = new int[maxA+1];
        for (int i = 0; i < n; i++) 
            cntA[A[i]]++;
            
        // Count Number of Divisors for each element and subtract from total elements
        int[] cntNonDiv = new int[n];
        for (int i = 0; i < n; i++) {
            int a = A[i], divisors = 0;
            for (int j = 1; j * j <= a; j++) {
                if (a % j == 0) {
                    divisors += cntA[j];
                    if (j*j != a) {
                        divisors += cntA[a/j];
                    }
                }
            }
            cntNonDiv[i] = n - divisors;
        }
        return cntNonDiv;
    }
}