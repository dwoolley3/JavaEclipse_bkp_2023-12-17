public class L14_MinMaxDivision {
	public static void main(String[] args) { 
		Solution_L14_MinMaxDivision obj = new Solution_L14_MinMaxDivision();
		System.out.println("3, 5, [2, 1, 5, 1, 2, 2, 2] "); 
		System.out.println(obj.solution(3,5, new int[]{2, 1, 5, 1, 2, 2, 2}));
		System.out.println(obj.solution(3,9, new int[]{0, 0, 0, 9, 0, 0, 0}));

	}	
}

class Solution_L14_MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        int lo = 0;
        int hi = sum;
        int ans = 0;
        int mid;
        
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (check(K, M, A, mid)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean check(int K, int M, int[] A, int mid) {
        int sum = 0, blocks = 1;
        for (int i = 0; i < A.length && blocks <= K; i++) {
            if (sum + A[i] > mid) {
            	if (A[i] > mid) return false;
                blocks++;
                sum = 0;
            } 
            sum += A[i];
        }
        return blocks <= K;
    }
}

