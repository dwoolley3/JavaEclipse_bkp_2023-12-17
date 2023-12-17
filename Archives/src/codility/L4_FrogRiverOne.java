package codility;

import java.util.*;

public class L4_FrogRiverOne {
	public static void main(String[] args) { 
		Solution_L4_FrogRiverOne obj = new Solution_L4_FrogRiverOne();
		System.out.println("3,{1,3,2}"); 
		System.out.println(obj.solution(3, new int[] {1,3,2})); 
	}
}

class Solution_L4_FrogRiverOne {
    public int solution(int X, int[] A) {
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X)
                hset.add(A[i]);
            if (hset.size() == X)
                return i;
        }
        return -1;
    }
}