package codeforces;

//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R215_Div2_B_br_pw //Name: Sereja and Suffixes
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		//Reading 100,000 numbers on a line takes 3 times longer with Scanner
		//Scanner = 436ms; BufferedReader w/split = 186ms; w/o split = 124ms
		//For 200,000 numbers on a line: Scanner = 810ms; BR w/split = 280ms.
		//Thus, use BufferedReader instead of Scanner if time is critical.
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		String[] s = in.readLine().split("\\s+");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		s = in.readLine().split("\\s+");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(s[i]);
		
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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++)
		{
			li = Integer.parseInt(in.readLine()) - 1;
			sb.append(b[li] + "\r\n");
		}
		
		out.print(sb);			
	}
}

