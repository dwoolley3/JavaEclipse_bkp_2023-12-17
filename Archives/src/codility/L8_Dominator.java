package codility;

//import java.util.*;

public class L8_Dominator {
	public static void main(String[] args) { 
		Solution_L8_Dominator obj = new Solution_L8_Dominator();
		System.out.println("{8,8,5,7,9,8,7,4,8}"); 
		System.out.println(obj.solution(new int[] {8,8,5,7,9,8,7,4,8})); 
		System.out.println(obj.solution(new int[] {4, 3, 4, 4, 4, 2})); 
		System.out.println(obj.solution(new int[] {2, 1, 1, 1, 3})); 
	}
}

class Solution_L8_Dominator {
    public int solution(int[] A) {
        int n = A.length;
        int leader = -1, num = 0;
        
        // Find leader by pairing up values in stack; very efficient time & space
        for (int i = 0; i < n; i++) {
        	if (num == 0) {
        		leader = A[i];
        		num++;
        	} else {
        		if (leader != A[i]) {
        			num--;
        		} else {
        			num++;
        		}
        	}
        }
        
        // A good way of finding leader with HashMap
//		  int max = 0;
//        HashMap<Integer,Integer> hmap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (!hmap.containsKey(A[i])) {
//                hmap.put(A[i],0);
//            }
//            num = hmap.get(A[i]);
//            num++;
//            hmap.put(A[i], num);
//            if (num > max) {
//                max = num;
//                leader = A[i];
//            }
//        }
        
        int totLeader = 0, lastIndex = -1;
        for (int i = 0; i < n; i++) {
        	if (A[i] == leader) {
        		totLeader++;   
        		lastIndex = i;
        	}
        }
        if (totLeader <= n/2) return -1; //No real leader

        return lastIndex;
    }
}