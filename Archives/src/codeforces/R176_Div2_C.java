package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R176_Div2_C //Name: Lucky Permutation
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
		
        if (n % 4 == 2 || n % 4 == 3)
        	out.println(-1);
        else if (n == 1)
        	out.println(1);
        else
        {
            int[] p = new int[n + 1];
            p[1] = 2;
            p[2] = n;
            p[n - 1] = 1;
            p[n] = n - 1;

            int it = n / 4 - 1;
            for (int i = 1; i <= it; i++)
            {
                p[1 + 2*i]   = p[1 +   2*(i-1)] + 2;
                p[2 + 2*i]   = p[2 +   2*(i-1)] - 2;
                p[n-1 - 2*i] = p[n-1 - 2*(i-1)] + 2;
                p[n   - 2*i] = p[n   - 2*(i-1)] - 2;
            }
            if (n % 4 == 1)
                p[n / 2 + 1] = n / 2 + 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++)
                sb.append(p[i] + " ");
		
            out.println(sb);	
        }
	}
}
