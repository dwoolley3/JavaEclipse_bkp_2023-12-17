package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R218_Div2_A //Name: K-Periodic Array
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
		int k = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int one = 0, cnt = 0;
		int num = n/k;
		for (int i = 0; i < k; i++)
		{
			one = 0;
			for (int j = 0; j < num; j++)
				if (a[j*k + i] == 1) one++;
			cnt += Math.min(one, num - one);
		}
		
		out.println(cnt);		
	}
}
