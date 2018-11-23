package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R215_Div2_A //Name: 
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
		int d = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		Arrays.sort(a);
		int m = in.nextInt();
		int min = Math.min(n, m);
		int profit = 0;
		for (int i = 0; i < min; i++) 
			profit += a[i];
		
		if (m > n)
			profit -= d*(m-n);
			
		out.println(profit);		
	}
}
