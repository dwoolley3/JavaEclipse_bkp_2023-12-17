//import java.util.*;

public class L5_PassingCars {
	public static void main(String[] args) { 
		Solution_L5_PassingCars obj = new Solution_L5_PassingCars();
		System.out.println("{0,1,0,1,1}"); 
		System.out.println(obj.solution(new int[] {0,1,0,1,1})); 
	}
}

class Solution_L5_PassingCars {
    public int solution(int[] A) {
        int sum1 = 0;
        for (int i: A) 
        	sum1 += i;
        int tot = 0;
        for (int i : A) {
        	if (i == 0) {
        		tot += sum1;
        		if (tot > 1_000_000_000)
        			return -1;
        	}
        	else
        		sum1--;
        }        		
        return tot;
    }
}