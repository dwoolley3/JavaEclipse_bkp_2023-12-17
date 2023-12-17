package codility;

//import java.util.*;

public class L10_CountFactors {
	public static void main(String[] args) { 
		Solution_L10_CountFactors obj = new Solution_L10_CountFactors();
		System.out.println("{1024}"); 
		System.out.println(obj.solution(1024)); 
		System.out.println(obj.solution(1)); 
	}
}

class Solution_L10_CountFactors {
    public int solution(int N) {
        int factor = 0;
        int i = 0;
        int sqrtN = (int)Math.sqrt(N);
        for (i = 1; i <= sqrtN; i++) {
            if (N % i == 0) {
                factor += 2;
            }
        }
        i--;
        if (i * i == N) {
            factor--;
        }
        return factor;   
    }
}