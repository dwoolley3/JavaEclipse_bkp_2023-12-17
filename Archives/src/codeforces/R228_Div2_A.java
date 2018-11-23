package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R228_Div2_A
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		while (true)
		{
			Arrays.sort(a);
			int x = a[0];
			boolean same = true;
			for (int i = 1; i < n; i++)
				if (x != a[i])
					same = false;
			
			if (same) break;
			for (int i= n-1; i >0; i--)
			{		
				if (a[i] > a[i-1])
					a[i] = a[i] - a[i-1];
			}
		}
		int sum = 0;
		for (int i : a) sum += i;
		out.println(sum);		
	}
}
