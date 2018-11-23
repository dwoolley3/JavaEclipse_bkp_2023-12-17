package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R177_Div2_B //Name: Polo the Penguin and Matrix
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
		int d = in.nextInt();
		
        int min = 10001, max = 0;
        int[] a = new int[n * m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                a[i * m + j] = in.nextInt();
                min = Math.min(a[i * m + j], min);
                max = Math.max(a[i * m + j], max);
            }
        }

        int minCnt = Integer.MAX_VALUE, dif, cnt;
        for (int i = min; i <= max; i += d)
        {
            cnt = 0;
            boolean ok = true;
            for (int j = 0; j < n * m; j++)
            {
                dif = (Math.abs(a[j] - i));
                if (dif % d == 0)
                    cnt += (dif / d);
                else
                {
                    ok = false;
                    break;
                }
            }
            if (ok) minCnt = Math.min(minCnt, cnt);
        }

        if (minCnt < Integer.MAX_VALUE)
            out.println(minCnt);
        else
        	out.println(-1);
	}
}
