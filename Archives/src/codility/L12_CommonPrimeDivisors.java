package codility;

//import java.util.*;

public class L12_CommonPrimeDivisors {
	public static void main(String[] args) { 
		Solution_L12_CommonPrimeDivisors obj = new Solution_L12_CommonPrimeDivisors();
		System.out.println("10, 4"); 
		System.out.println(obj.solution(new int[] {15,10,9}, new int[] {75,30,5}));
	}
}

class Solution_L12_CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        int n = A.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (HasCommonPrimeDivisors(A[i], B[i])) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private static boolean HasCommonPrimeDivisors(int a, int b) {
        int gcd_ab = GCD(a, b);
        int c = GCD(a, gcd_ab);
        while (c > 1) {
            a /= c; 
            c = GCD(a, gcd_ab);
        }
        int d = GCD(b, gcd_ab);
        while (d > 1) {
            b /= d;
            d = GCD(b, gcd_ab);
        }
        return (a == 1 && b == 1);
    }
    
    private static int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a%b);
    }
}
