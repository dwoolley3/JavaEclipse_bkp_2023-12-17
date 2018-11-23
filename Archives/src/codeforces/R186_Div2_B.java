package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R186_Div2_B //Name: Ilya and Queries
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
        String st = in.next();
        int n = st.length();

        int[] a = new int[n];
        int cnt = 0;
        a[0] = 0;
        for (int i = 1; i < n; i++)
        {
            if (st.charAt(i) == st.charAt(i - 1))
                cnt++;
            a[i] = cnt;
        }

        int m = in.nextInt();
        int l, r, ans;
        for (int i = 0; i < m; i++)
        {
            l = in.nextInt()-1;
            r = in.nextInt()-1;
            ans = a[r] - a[l];
            out.println(ans);
        }
	}
}
