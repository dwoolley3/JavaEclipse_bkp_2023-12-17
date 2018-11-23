package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R215_Div2_B
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] d = new int[100_001];
		int[] b = new int[n];
		int dist = 0;
		for (int i = n-1; i >= 0; i--) 
		{
			if (d[a[i]] == 0) 
				dist++;
			d[a[i]]++;
			b[i] = dist;
		}
		
		int li;
		for (int i = 0; i < m; i++)
		{
			li = in.nextInt() - 1;
			out.println(b[li]);
		}			
	}
}
