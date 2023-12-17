package codility;

import java.util.*;

public class L7_Fish {
	public static void main(String[] args) { 
		Solution_L7_Fish obj = new Solution_L7_Fish();
		System.out.println("([4, 3, 2, 1, 5], [0, 1, 0, 0, 0])"); 
		System.out.println(obj.solution(new int[] {4, 3, 2, 1, 5}, new int[] {0, 1, 0, 0, 0})); 
	}
}

class Solution_L7_Fish {
    public int solution(int[] A, int[] B) {
        int n = A.length, fish = n;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (B[i] == 1) {
                stack.push(A[i]);
            }
            else if (B[i] == 0) {
                while (stack.size() > 0 && stack.peek() < A[i]) {
                    fish--;
                    stack.pop();
                }
                if (stack.size() > 0 && stack.peek() > A[i]) {
                    fish--;
                }
            }
        }
        return fish;
    }
}