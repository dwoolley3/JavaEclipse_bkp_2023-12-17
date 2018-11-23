//import java.util.*;

public class L11_CountSemiprimes {
	public static void main(String[] args) { 
		Solution_L11_CountSemiprimes obj = new Solution_L11_CountSemiprimes();
		System.out.println("26, [1, 4, 16], [26, 10, 20]"); 
		System.out.println(obj.solution(26, new int[]{1, 4, 16}, new int[] {26, 10, 20}));
	}
}

class Solution_L11_CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int m = P.length;
        
        // Determine the number of prime factors for each number
        // If number has 2 prime factors, then it is semi-prime
        int[] numPrimeFact = new int[N+1];
        for (int i = 2; i <= N; i++) {
            int cntPrimeFact = 0;
            int num = i;
            for (int j = 2; j * j <= num; j++) {
                while (num%j == 0) {
                    cntPrimeFact++;
                    num /= j;
                }
            }
            if (num > 1) cntPrimeFact++;
            numPrimeFact[i] = cntPrimeFact;
        }
        
        // Tally number of semi primes up to the current number        
        int[] numSemiPrime = new int[N+1];
        for (int i = 1; i <= N; i++) {
            numSemiPrime[i] = numSemiPrime[i-1];
            if (numPrimeFact[i] == 2) {
                numSemiPrime[i]++;
            }
        }
        
        // Take total number of semi primes up to current number and 
        // subtract total number of semi primes prior to the lower number
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = numSemiPrime[Q[i]] - numSemiPrime[P[i]-1];
        }
        return ans;
    }
}
