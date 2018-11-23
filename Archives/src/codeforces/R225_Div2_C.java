package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R225_Div2_C //Name: Milking cows
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
		int[] a = new int[n];
		long cnt0 = 0, cnt1 = 0;
		long cur0 = 0, cur1 = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = Integer.parseInt(s[i]);
			if (a[i] == 0)
				cnt1 += cur1;
			else
				cur1++;
		}	
		
		for (int i = n-1; i >= 0; i--)
			if (a[i] == 1)
				cnt0 += cur0;
			else
				cur0++;
		
		long cnt = Math.min(cnt0,  cnt1);
		out.println(cnt);		
	}
}
