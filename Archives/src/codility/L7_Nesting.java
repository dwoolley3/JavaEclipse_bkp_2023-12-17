package codility;

//import java.util.*;

public class L7_Nesting {
	public static void main(String[] args) { 
		Solution_L7_Nesting obj = new Solution_L7_Nesting();
		System.out.println("(()(())())"); 
		System.out.println(obj.solution("(()(())())")); 
		System.out.println(obj.solution("())")); 
		System.out.println(obj.solution("")); 
	}
}

class Solution_L7_Nesting {
    public int solution(String S) {
        int n = S.length();
        int open = 0;
        for (int i = 0; i < n; i++) {
        	if (S.charAt(i)=='(') 
        		open++;
        	else {
        		open--;
        		if (open < 0) return 0;
        	}        	
        }
        return open == 0 ? 1 : 0;
        
//        int head = 0;
//        char[] c = new char[n];
//        for (int i = 0; i < n; i++) {
//            char ch = S.charAt(i);
//            if (ch=='(')
//                c[head++] = ch;
//            else {
//                head--;
//                if (head >= 0) {
//                    if (ch == ')' && c[head] == '(') continue;
//                }
//                return 0;
//            }
//        }
//        return head == 0 ? 1 : 0;
    }
}