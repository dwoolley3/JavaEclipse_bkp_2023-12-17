import java.util.*;

public class L6_Distinct {
	public static void main(String[] args) { 
		Solution_L6_Distinct obj = new Solution_L6_Distinct();
		System.out.println("{0,1,0,1,1}"); 
		System.out.println(obj.solution(new int[] {0,1,0,1,1})); 
	}
}

class Solution_L6_Distinct {
    public int solution(int[] A) {
        Arrays.sort(A);
        int cnt = 0;
        if (A.length > 0) {
            cnt = 1;
            for (int i = 1; i < A.length; i++)
                if (A[i] != A[i-1])
                    cnt++;
        }
        return cnt;
    }
}