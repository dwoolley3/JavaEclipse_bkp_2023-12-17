import java.util.*;

public class L13_Ladder {
	public static void main(String[] args) { 
		Solution_L13_Ladder obj = new Solution_L13_Ladder();
		System.out.println("([4, 4, 5, 5, 1], [3, 2, 4, 3, 1]) "); 
		System.out.println(obj.solution(new int[]{4, 4, 5, 5, 1}, new int[] {3, 2, 4, 3, 1} ));
	}	
}

class Solution_L13_Ladder {
    public int[] solution(int[] A, int[] B) {
    	// Pre-compute all possible Fibs using mod of 2^30;
    	// Individual mods of smaller powers of 2 is compatible; 
        int L = A.length;
    	int maxA = L; // max of 50_000;
    	int maxB = 30;
    	ArrayList<Integer> fibs = GetFibsUpTo(maxA, maxB);
    	
        int[] ans = new int[L];
        for (int i = 0; i < L; i++) {
            ans[i] = fibs.get(A[i]) % (1 << B[i]); // means 2^B[i]
        }
        return ans;
    }
    
    private static ArrayList<Integer> GetFibsUpTo(int n, int p) {
        ArrayList<Integer> fibs = new ArrayList<>();
        // 1,1,2,3,5,8
        fibs.add(1);
        fibs.add(1);        
        for (int i = 2; i <= n; i++) {
        	int nextFib = fibs.get(fibs.size()-2) + fibs.get(fibs.size()-1);
        	fibs.add(nextFib % (1 << p));        	
        }
        return fibs;
    }
}

