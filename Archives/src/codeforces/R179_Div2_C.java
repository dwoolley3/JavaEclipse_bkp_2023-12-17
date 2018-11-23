package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R179_Div2_C //Name: Greg and Array
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
		int high = 100001;
		
		int n = in.nextInt();	
		int m = in.nextInt();
		int k = in.nextInt();
		
		long[] a = new long[high];
		for (int i = 0; i < n; i++) 
			a[i+1] = in.nextInt();
		
        int[] l = new int[high];
        int[] r = new int[high];
        long[] d = new long[high];
        for (int i = 0; i < m; i++)
        {
            l[i+1] = in.nextInt();
            r[i+1] = in.nextInt();
            d[i+1] = in.nextLong();
        }

        int x, y;
        long[] st = new long[high];
        long[] en = new long[high];
        for (int i = 0; i < k; i++)
        {
            x = in.nextInt();
            y = in.nextInt();
            st[x]++;
            en[y]++;
        }

        long[] op = new long[high];
        long num = 0;
        for (int i = 1; i <= m; i++)
        {
            num += st[i];
            op[i] = num;
            num -= en[i];
        }

        long[] ll = new long[high];
        long[] rr = new long[high];
        for (int i = 1; i <= m; i++)
        {
            ll[l[i]] += (d[i] * op[i]);
            rr[r[i]] += (d[i] * op[i]);
        }

        num = 0;
        for (int i = 1; i <= n; i++)
        {
            num += ll[i];
            a[i] += num;
            num -= rr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n-1; i++) 
        {
            sb.append(a[i]);
            sb.append(" ");
        }
        sb.append(a[n]);	
		out.println(sb);		
	}
}
