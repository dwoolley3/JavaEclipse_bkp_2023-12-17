package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R218_Div2_D_orig_TLE //Name: Vessels
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());
		
		String[] s = in.readLine().split(" ");
		int[] a = new int[n+1];
		int[] c = new int[n+1];
		int sum = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i+1] = Integer.parseInt(s[i]);
			sum += a[i+1];
			c[i+1] = sum;
		}
		int[] b = new int[n+1];
		
		int m = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		int t, k, p,x;
		for (int i = 0; i < m; i++) 
		{
			s = in.readLine().split(" ");
			t = Integer.parseInt(s[0]);
			if (t == 1)
			{
				p = Integer.parseInt(s[1]);
				x = Integer.parseInt(s[2]);
				
				b[p] += x;
				int j = p;
				while (j <= n && b[j] > a[j]) {
					if (j < n) b[j+1] += b[j] - a[j];  
					b[j] = a[j];
					j++;
				}
			}
			else // t== 2
			{
				k = Integer.parseInt(s[1]);
				sb.append(b[k]);
				sb.append("\n");
			}
		}
		out.print(sb);
	}

}
