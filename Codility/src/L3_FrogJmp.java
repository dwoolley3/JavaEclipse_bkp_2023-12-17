//import java.util.*;

public class L3_FrogJmp {
	public static void main(String[] args) { 
		Solution_L3_FrogJmp obj = new Solution_L3_FrogJmp();
		System.out.println("10,50,20"); 
		System.out.println(obj.solution(10,50,20)); 
	}
}

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution_L3_FrogJmp {
    public int solution(int X, int Y, int D) {
        int dist = Y - X;
        int ans = dist / D;
        if (dist % D != 0) ans++;
        return ans;
    }
}