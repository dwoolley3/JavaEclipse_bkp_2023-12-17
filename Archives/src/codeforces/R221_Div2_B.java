package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R221_Div2_B
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
		
		int[] a = new int[m];
		int[] b = new int[m];
		int[] c = new int[m];
		int[] d = new int[n+1];
		for (int i = 0; i < m; i++) 
		{
			a[i] = in.nextInt();
			b[i] = in.nextInt();
			c[i] = in.nextInt();
			d[a[i]] += c[i];
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (b[j] == i)
					d[i] = Math.max(0,  d[i] - c[j]);				
			}
		}
		
		int tot = 0;
		for (int i = 1; i <= n; i++) tot += d[i];
		out.println(tot);		
	}
}
