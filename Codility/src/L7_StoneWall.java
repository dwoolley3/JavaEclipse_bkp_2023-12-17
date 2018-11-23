import java.util.*;

public class L7_StoneWall {
	public static void main(String[] args) { 
		Solution_L7_Stonewall obj = new Solution_L7_Stonewall();
		System.out.println("{8,8,5,7,9,8,7,4,8}"); 
		System.out.println(obj.solution(new int[] {8,8,5,7,9,8,7,4,8})); 
	}
}

class Solution_L7_Stonewall {
    public int solution(int[] H) {
    	int n = H.length;
    	ArrayDeque<Integer> stack = new ArrayDeque<>();
    	int blocks = 0;
    	for (int i = 0; i < n; i++) {
    		while (stack.size() > 0 && H[i] < stack.peek())
    			stack.pop();
    		
    		if (stack.size() > 0 && H[i] == stack.peek())
    			continue;
    		else {  //stack.size() == 0 || H[i] > stack.peek())
    			blocks++;
    			stack.push(H[i]);
    		}
    	}
    	return blocks;    		
    	
//        int n = H.length, head = 0;
//        int[] stack = new int[n];
//        int blocks = 0;
//        // Add heights when prior heights are smaller, inc count
//        // Remove prior heights when current height is smaller
//        // Ignore new height if same as prior, same count
//        for (int i = 0; i < n; i++) {
//        	 while (head > 0 && H[i] < stack[head - 1]) 
//                 head--;
//        	 
//        	 if (head > 0 && H[i] == stack[head - 1])
//                continue; 
//        	 else { // (head == 0 || H[i] > stack[head - 1])
//                blocks++;
//                stack[head++] = H[i];
//        	 }
//        }
//        return blocks;
    }
}