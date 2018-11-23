//import java.util.*;

public class L12_ChocolatesByNumbers {
	public static void main(String[] args) { 
		Solution_L12_ChocolatesByNumbers obj = new Solution_L12_ChocolatesByNumbers();
		System.out.println("10, 4"); 
		System.out.println(obj.solution(10,4));
	}
}

class Solution_L12_ChocolatesByNumbers {
    public int solution(int N, int M) {
        long lcm = LCM(N, M);
        long eaten = lcm / M;
        return (int)eaten;
    }
    
    private static int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
    
    private static long LCM(int a, int b) {
        long ab = 1L * a * b;
        long lcm = ab / GCD(a, b);
        return lcm;
    }
}
