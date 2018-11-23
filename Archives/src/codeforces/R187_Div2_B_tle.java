package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

//Time Limit exceeded in Test Case #11, due to using Scanner vs. BufferReader

public class R187_Div2_B_tle
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
		
        long[] a = new long[n+1];
        for (int i = 0; i < n; i++)
            a[i+1] = in.nextLong();

        StringBuilder sb = new StringBuilder();
        long add = 0;
        int v, x;
        for (int i = 0; i < m; i++)
        {
            int t = in.nextInt();
            if (t == 1)
            {
                v = in.nextInt();
                x = in.nextInt();
                a[v] = x - add;
            }
            else if (t == 2)
            {
                int y = in.nextInt();
                add += y;
            }
            else if (t == 3)
            {
                int q = in.nextInt();
                sb.append((a[q]+add)+"\r\n");
            }
        }
		out.print(sb);		
	}
}
