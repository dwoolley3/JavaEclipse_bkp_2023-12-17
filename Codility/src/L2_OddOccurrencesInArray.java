import java.util.*;

public class L2_OddOccurrencesInArray {
	public static void main(String[] args) { 
		Solution_L2_OddOccurrencesInArray obj = new Solution_L2_OddOccurrencesInArray();
		System.out.println("{1,2,1}"); 
		System.out.println(obj.solution(new int[] {1,2,1})); 
	}
}

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution_L2_OddOccurrencesInArray {
    public int solution(int[] A) {
        HashSet<Integer> hset = new HashSet<>();
        for (int i : A)
            if (hset.contains(i))
                hset.remove(i);
            else
                hset.add(i);
        int ans = 0;
        Iterator<Integer> iter = hset.iterator();
        ans = iter.next();
        return ans;
    }
}