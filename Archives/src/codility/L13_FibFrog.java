package codility;

import java.util.*;

public class L13_FibFrog {
	public static void main(String[] args) { 
		Solution_L13_FibFrog obj = new Solution_L13_FibFrog();
		System.out.println("{0,0,0,1,1,0,1,0,0,0,0}"); 
		System.out.println(obj.solution(new int[] {}));
		System.out.println(obj.solution(new int[] {1}));
		System.out.println(obj.solution(new int[] {1,1}));
		System.out.println(obj.solution(new int[] {0,0,0}));
		System.out.println(obj.solution(new int[] {0,0,0,1,1,0,1,0,0,0,0}));
	}	
}

// Can also be done with breadth first search
// Below is a dynamic programming kind of approach

class Solution_L13_FibFrog {
    public int solution(int[] A) {
        int n = A.length;
        int[] jumpsToEnd = new int[n];
        Arrays.fill(jumpsToEnd, (int)1e9);
        int bestJumps = Integer.MAX_VALUE;
        
        // for n = 100_000, there are only 24 fibs 
        ArrayList<Integer> fibs = GetFibsUpTo(n+1);
        
        for (int i = n-1; i >= 0; i--) {
            if (A[i]==0) continue;
            int fibInd = 0;
            while (fibInd < fibs.size() && i + fibs.get(fibInd) <= n) {
            	int fib = fibs.get(fibInd);
                if (i + fib == n) {
                    jumpsToEnd[i] = 1;
                } else if (A[i+fib] == 1) {
                    jumpsToEnd[i] = Math.min(jumpsToEnd[i], 
                        jumpsToEnd[i+fib] + 1);;
                }
                fibInd++;
            }
        }
        
        int fibInd = 0;
        while (fibInd < fibs.size() && fibs.get(fibInd) - 1 <= n) {
        	int fib = fibs.get(fibInd);
            if (fib - 1 == n) {
                bestJumps = 1;
            }
            else if (A[fib - 1] == 1) {
                bestJumps = Math.min(bestJumps, 
                    jumpsToEnd[fib - 1] + 1);;
            }
            fibInd++;
        }
        
        return bestJumps < (int)1e9 ? bestJumps : -1;
    }
    
    private static ArrayList<Integer> GetFibsUpTo(int n) {
        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(2);
        int nextFib = 3;
        while (nextFib <= n) {
            fibs.add(nextFib);
            nextFib += fibs.get(fibs.size()-2);
        }
        return fibs;
    }
}

