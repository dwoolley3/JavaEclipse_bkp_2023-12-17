//import java.util.*;

public class L4_MissingInteger {
	public static void main(String[] args) { 
		Solution_L4_MissingInteger obj = new Solution_L4_MissingInteger();
		System.out.println("5,{3,2,2,4,2}"); 
		System.out.println(obj.solution(5, new int[] {1,3,6,4,1,2})); 
	}
}

class Solution_L4_MissingInteger {
    public int solution(int N, int[] A) {
    	int max = 1_000_000;
    	boolean[] used = new boolean[max+1];
        for (int i : A) 
        	if (i > 0) 
        		used[i] = true;
        int i = 1;
        for (i = 1; i <= max; i++)
	        if (!used[i]) 
	        	break;
	    return i;
    }
}