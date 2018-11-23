package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R183_Div2_C
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
		
        if (n % 2 == 0)
        	out.println(-1);
        else
        {
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];
            StringBuilder sa = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            StringBuilder sc = new StringBuilder();
            for (int i = 0; i < n; i++)
            {
                a[i] = i;
                b[i] = (i > 0) ? (i - 1) : n - 1;
                c[i] = (a[i] + b[i]) % n;
                sa.append(a[i]);
                if (i < n - 1) sa.append(" ");
                sb.append(b[i]);
                if (i < n - 1) sb.append(" ");
                sc.append(c[i]);
                if (i < n - 1) sc.append(" ");
            }
	        out.println(sa);
	        out.println(sb);
			out.println(sc);
        }
	}
}
