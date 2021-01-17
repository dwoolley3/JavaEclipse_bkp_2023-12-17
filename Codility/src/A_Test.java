
public class A_Test {
	public static void main(String[] args) { 
		Solution2 obj = new Solution2();
		System.out.println(9); 
		System.out.println(obj.solution(9)); 
		
		System.out.println(obj.getCurrentTime());
		System.out.println(obj.getCurrentTimeAndReformat());		
	}
}

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution2 {
	public String getCurrentTime() {
		return "2020-04-10T12:34:56.123Z";
	}
	
	public String getCurrentTimeAndReformat() {
		String utcDT = getCurrentTime();
		if (utcDT != null && utcDT.indexOf('.') > -1) {
			utcDT = utcDT.replace('-', '/').replace('T',  ' ');
			utcDT = utcDT.substring(0, utcDT.indexOf('.'));
		}
		return utcDT;
	}
	
 public int solution(int N) {
     // write your code in Java SE 8
     int cnt0 = 0, max0 = 0;
     boolean found1 = false;
     while (N > 0) {
         int bit = N % 2;
         N /= 2;
         if (bit == 1) {
             if (cnt0 > max0)
                 max0 = cnt0;
             cnt0 = 0;
             found1 = true;
         } else {
             if (found1)
                 cnt0++;
         }
     }
     return max0;
 }
}
