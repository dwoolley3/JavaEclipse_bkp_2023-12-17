package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R226_Div2_A //Name: Bear and Raspberry
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
		int c = in.nextInt();
		
		int[] a = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (i>0)
				max = Math.max(max, a[i-1]-a[i]);
		}
		
		max -= c;
		if (max < 0) max = 0;
		out.println(max);		
	}
}
