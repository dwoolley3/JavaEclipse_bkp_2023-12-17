package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R188_Div2_C //Name: Perfect Pair
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		long x = in.nextLong();	
		long y = in.nextLong();	
		long m = in.nextLong();	
		
        long x2 = x;
        long y2 = y;
        long cnt = 0, sum;
        while (x2 < m && y2 < m && (x2+y2 >0 || (x2+y2 > Math.min(x2,y2))))
        {
            long min = Math.min(x2, y2);
            long max = Math.max(x2, y2);
            if (min < 0 && Math.abs(min) > max)
            {
                long num = Math.abs(min) / max;
                cnt += num;
                min += num * max;
                x2 = min; y2 = max;
            }
            sum = x2 + y2;
            if (x2 < y2) 
                x2 = sum;
            else
                y2 = sum;
            cnt++;
        }
        if (x2 < m && y2 < m)
        	out.println(-1);
        else
        	out.println(cnt);						
	}
}
