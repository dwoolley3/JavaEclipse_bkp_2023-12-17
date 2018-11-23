//import java.util.*;

public class L6_CountDiv {
	public static void main(String[] args) { 
		Solution_L6_CountDiv obj = new Solution_L6_CountDiv();
		System.out.println("11,345,17"); 
		System.out.println(obj.solution(11,345,17)); //20
		System.out.println(obj.solution(11,13,2));   //1
		System.out.println(obj.solution(6,11,2));    //3
		System.out.println(obj.solution(11,14,2));   //2
		System.out.println(obj.solution(6,8,7));     //1
	}
}

class Solution_L6_CountDiv {
    public int solution(int A, int B, int K) {
    	int B2 = B / K;
    	int A2 = A / K;
    	int ans = B2 - A2;
    	if (A % K == 0) ans++;
        return ans;
    }
}