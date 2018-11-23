package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R196_Div2_A //Name: Puzzles
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
		
		int[] a = new int[m];
		for (int i = 0; i < m; i++) 
			a[i] = in.nextInt();
		
		 Arrays.sort(a);
         int min = Integer.MAX_VALUE, cnt;
         for (int i = 0; i <= m - n; i++)
         {
             cnt = a[i + n - 1] - a[i];
             if (cnt < min) min = cnt;
         }
		
		out.println(min);		
	}
}
