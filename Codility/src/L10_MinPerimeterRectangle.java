//import java.util.*;

public class L10_MinPerimeterRectangle {
	public static void main(String[] args) { 
		Solution_L10_MinPerimeterRectangle obj = new Solution_L10_MinPerimeterRectangle();
		System.out.println("{1024}"); 
		System.out.println(obj.solution(1024)); 
		System.out.println(obj.solution(1)); 
	}
}

class Solution_L10_MinPerimeterRectangle {
    public int solution(int N) {
    	int bestPerm = Integer.MAX_VALUE;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                bestPerm = Math.min(bestPerm, 2 * i + N / i * 2);
            }
        }
        return bestPerm;   
    }
}