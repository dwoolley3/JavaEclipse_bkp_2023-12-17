package codility;

public class L2_CyclicRotation {
	public static void main(String[] args) { 
		Solution_L2_CyclicRotation obj = new Solution_L2_CyclicRotation();
		System.out.println("{1,2,3}, 9"); 
		System.out.println(obj.solution(new int[] {1,2,3}, 8)); 
	}
}

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");


class Solution_L2_CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[(i+K)%n] = A[i];
        }
        return ans;
    }
}