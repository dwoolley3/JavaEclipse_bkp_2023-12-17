package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter
//import java.util.Arrays;

public class R223_Div2_B //Name: 
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
		int m = Integer.parseInt(in.readLine());
		
		String[] s = in.readLine().split(" ");
		int[] a = new int[5001];
		for (int i = 0; i < m; i++) 
			a[Integer.parseInt(s[i])]++;
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0, max = 0;
		for (int i = 1; i <= 5000; i++)
			if (a[i] > 0) 
				{
					sb.append(i + " ");
					cnt++;
					max = i;
				}
		
		for (int i = --max; i >= 1; i--)
			if (a[i] > 1) 
				{
					sb.append(i + " ");
					cnt++;
				}
		
		out.println(cnt);
		out.println(sb);		
	}
}
