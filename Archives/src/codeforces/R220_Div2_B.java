package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R220_Div2_B
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
		char[] c = in.next().toCharArray();
		int n = c.length;
		
		long cnt = 0, tot = 1;
		for (int i = 1; i < n; i++)
			if (c[i-1] -'0' + c[i] - '0' == 9) 
				cnt++;
			else
			{
				if (cnt > 0)
				{
					if (cnt % 2 == 0) tot *= (cnt / 2 + 1);
					cnt = 0;
				}
			}
		
		if (cnt > 0)		
			if (cnt % 2 == 0) tot *= (cnt / 2 + 1);
		
		out.println(tot);		
	}
}
