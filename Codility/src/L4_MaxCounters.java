//import java.util.*;

public class L4_MaxCounters {
	public static void main(String[] args) { 
		Solution_L4_MaxCounters obj = new Solution_L4_MaxCounters();
		System.out.println("5,{3,2,2,4,2}"); 
		System.out.println(obj.solution(5, new int[] {3,2,2,4,2})); 
	}
}

class Solution_L4_MaxCounters {
    public int[] solution(int N, int[] A) {
    	int M = A.length, curMax = 0, prevMax = 0;
    	int[] cnt = new int[N];
        for (int i = 0; i < M; i++) {
        	if (A[i] == N+1) {
        		prevMax = curMax;
        	}
        	else {
	            if (cnt[A[i]-1] < prevMax) 
	            	cnt[A[i]-1] = prevMax;
	            cnt[A[i]-1]++;
	            if (cnt[A[i]-1] >= curMax)
	            	curMax = cnt[A[i]-1];
        	}
        }
        for (int i = 0; i < N; i++)
        	if (cnt[i] < prevMax)
        		cnt[i] = prevMax;
        return cnt;
    }
}