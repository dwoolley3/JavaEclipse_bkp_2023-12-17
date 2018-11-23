package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R178_Div2_A //Name: Shaass and Oskols
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
		
		int m = in.nextInt();	
        for (int i = 0; i < m; i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x - 1 > 0)                
                a[x-1 - 1] += y - 1;
            if (x + 1 <= n)
                a[x + 1 - 1] += a[x-1] - y;
            a[x-1] = 0;
        }

        for (int i = 0; i < n; i++)
            out.println(a[i]);
	
	}
}
