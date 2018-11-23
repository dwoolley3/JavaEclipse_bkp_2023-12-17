//import java.util.*;

public class L3_PermMissingElem {
	public static void main(String[] args) { 
		Solution_L3_PermMissingElem obj = new Solution_L3_PermMissingElem();
		System.out.println("{1,2,4}"); 
		System.out.println(obj.solution(new int[] {1,2,4})); 
	}
}

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution_L3_PermMissingElem {
    public int solution(int[] A) {
        int n = A.length;
        boolean[] used = new boolean[n+2];
        for (int i : A)
            used[i] = true;
        int ans = 0;
        for (int i = 1; i <= n+1; i++)
            if (!used[i]) {
                ans = i;
                break;
            }
        return ans;
    }
}