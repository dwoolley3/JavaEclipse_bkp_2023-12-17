package codility;

//import java.util.*;

public class L4_PermCheck {
	public static void main(String[] args) { 
		Solution_L4_PermCheck obj = new Solution_L4_PermCheck();
		System.out.println("{1,3,2}"); 
		System.out.println(obj.solution(new int[] {1,3,2})); 
	}
}

class Solution_L4_PermCheck {
    public int solution(int[] A) {
        int n = A.length;
        boolean[] used = new boolean[n+1];
        for (int i = 0; i < n; i++)
            if (A[i] > n || used[A[i]])
                return 0;
            else
                used[A[i]] = true;
        return 1;
    }
}