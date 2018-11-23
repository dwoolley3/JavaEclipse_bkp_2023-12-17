package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R227_Div2_B
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
		
		int[] b = new int[m];
		for (int i = 0; i < m; i++) 
			b[i] = in.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);

		int cnt = 0;
		for (int ai = n-1, bi = m-1; ai >= 0 && bi >=0; ai--)
		{
			if (a[ai] <= b[bi])
			{
				cnt++;
				bi--;
			}
		}
		
		out.println(n-cnt);		
	}
}
