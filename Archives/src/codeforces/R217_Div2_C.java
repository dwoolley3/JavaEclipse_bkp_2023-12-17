package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R217_Div2_C //Name: 
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
		@SuppressWarnings("unused")
		int m = in.nextInt();
		
		int[] a = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] l = new int[n];
		int[] r = new int[n];		
		int[] rmax = new int[n];
		Arrays.sort(a);
		
		for (int i = 0; i < n; i++)
		{
			l[i] = a[i]; r[i] = l[i];
		}
		int t;
		max = -1;
		for (int i = 0; i < n; i++)
		{
			t = r[0];		
			for (int j = 0; j < n-1; j++)
				r[j] = r[j+1];
			r[n-1] = t;
			
			int cnt = 0;
			for (int j = 0; j < n; j++)
				if (l[j] != r[j]) cnt++;
			if (cnt > max)
			{
				max = cnt;
				for (int j = 0; j < n; j++)
					rmax[j] = r[j];				
			}
		}
		
		out.println(max);
		for (int i = 0; i < n; i++)
			out.println(l[i] + " " + rmax[i]);	
	}
}
