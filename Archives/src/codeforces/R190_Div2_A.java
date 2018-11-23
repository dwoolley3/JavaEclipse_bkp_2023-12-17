package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R190_Div2_A //Name: Ciel and Dancing
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
		
        int[] a = new int[n+1];
        int[] b = new int[m+1];
        out.println(n + m - 1);
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (a[i] == 0 || b[j] == 0)
                {
                    out.println(i + " " + j);
                    a[i] = 1; b[j] = 1;
                }		
	}
}
