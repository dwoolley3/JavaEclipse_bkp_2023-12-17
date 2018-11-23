package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R220_Div2_A
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
		int n = in.nextInt();	
		int m = in.nextInt();
		int x = in.nextInt();	
		int y = in.nextInt();
		int a = in.nextInt();	
		int b = in.nextInt();
		
		int[] dx = new int[4];
		int[] dy = new int[4];
		dx[0] = x-1; dy[0] = y-1;
		dx[1] = n-x; dy[1] = y-1;
		dx[2] = x-1; dy[2] = m-y;
		dx[3] = n-x; dy[3] = m-y;
		
		int min = Integer.MAX_VALUE;
		int cnt1, cnt2;
		for (int i = 0; i < 4; i++)
		{
			if ((dx[i] % a > 0) || (dy[i] % b > 0)) continue;
			cnt1 = dx[i] / a;
			cnt2 = dy[i] / b;
			if (cnt1 == cnt2)
				min = Math.min(min, cnt1);
			else if (cnt1 > cnt2)
			{				
				if (cnt1 % 2 == 1) dy[i] -= b;
				if (dy[i] % (2*b) == 0 && m>b) min = Math.min(min, cnt1);
			}
			else //cnt2 > cnt1
			{
				if (cnt2 % 2 == 1) dx[i] -= a;
				if (dx[i] % (2*a) == 0 && n>a) min = Math.min(min, cnt2);
			}
		}
		if (min == Integer.MAX_VALUE)
			out.println("Poor Inna and pony!");
		else		
			out.println(min);		
	}
}
