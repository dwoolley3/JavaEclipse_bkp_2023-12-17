//import java.util.*;

public class L7_Brackets {
	public static void main(String[] args) { 
		Solution_L7_Brackets obj = new Solution_L7_Brackets();
		System.out.println("{[()()]}"); 
		System.out.println(obj.solution("{[()()]}")); 
		System.out.println(obj.solution("([)()]")); 
		System.out.println(obj.solution("")); 
	}
}

class Solution_L7_Brackets {
    public int solution(String S) {
        int n = S.length(), head = 0;
        char[] stack = new char[n];
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            //if ("({[".contains(ch+""))  //slightly slower than...
            if (ch=='(' || ch=='{' || ch=='[')
                stack[head++] = ch;
            else {
                head--;
                if (head >= 0) {
                    if (ch == ')' && stack[head] == '(') continue;
                    if (ch == '}' && stack[head] == '{') continue;
                    if (ch == ']' && stack[head] == '[') continue;
                }
                return 0;
            }
        }
        return head == 0 ? 1 : 0;
    }
}