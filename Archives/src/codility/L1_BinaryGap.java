package codility;

public class L1_BinaryGap {
	public static void main(String[] args) { 
		Solution obj = new Solution();
		System.out.println(9); 
		System.out.println(obj.solution(9)); 
	}
}

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
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
