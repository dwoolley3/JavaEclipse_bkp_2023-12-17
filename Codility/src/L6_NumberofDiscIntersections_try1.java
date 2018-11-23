import java.util.*;

public class L6_NumberofDiscIntersections_try1 {
	public static void main(String[] args) { 
		Solution_L6_NumberOfDiscIntersections_try1 obj = new Solution_L6_NumberOfDiscIntersections_try1();
		System.out.println("{1, 5, 2, 1, 4, 0}"); 
		System.out.println(obj.solution(new int[] {1, 5, 2, 1, 4, 0}));
		System.out.println(obj.solution(new int[] {})); 
		System.out.println(obj.solution(new int[] {10})); 
	}
}

// For some reason (perhaps due to the system running the program)
// the Solution takes too long when using TreeSet and HashMap,
// Yet these are efficient data structures and should have been
// just as good or better than sorting all the numbers.

class Solution_L6_NumberOfDiscIntersections_try1 {
    public int solution(int[] A) {
        int n = A.length;
        TreeSet<Long> tset = new TreeSet<>();
        HashMap<Long,Integer> st = new HashMap<>(n*2);
        HashMap<Long,Integer> en = new HashMap<>(n*2);
        long stnum, ennum;
        int maxIntersect = 10_000_000;
        for (int i = 0; i < n; i++) {
            stnum = i - A[i];
            ennum = (long)i + A[i];
            if (!st.containsKey(stnum))
            	st.put(stnum, 0);
            st.put(stnum, st.get(stnum)+1);
            if (!en.containsKey(ennum))
            	en.put(ennum, 0);
            en.put(ennum, en.get(ennum)+1);
            tset.add(stnum);
            tset.add(ennum);            
        }
        int stCount = 0, intersect = 0;
        for (long i : tset) {
           	if (st.containsKey(i)) {
        		int stCount2 = stCount + st.get(i);
       			intersect += ((stCount + stCount2-1) * (stCount2 - stCount) / 2);
                if (intersect > maxIntersect)
                   return -1;
      			stCount = stCount2;
        	}

        	if (en.containsKey(i)) {
        		stCount -= en.get(i);
        	}
        }

        return intersect;
    }
}