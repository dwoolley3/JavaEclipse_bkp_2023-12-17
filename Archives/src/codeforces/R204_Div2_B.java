package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R204_Div2_B //Name: Jeff and Periods
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
		int max = 100001;

        boolean[] ok = new boolean[max];
        int[] lasti = new int[max];
        int[] diff = new int[max];
        int[] cnt = new int[max];
		
        int a;
        for (int i = 0; i < n; i++)
        {
            a = in.nextInt();
            if (cnt[a] <= 1)
            {
                if (cnt[a] == 0)
                    diff[a] = 0;
                else
                    diff[a] = i - lasti[a];
                ok[a] = true;
                cnt[a]++;
                lasti[a] = i;
            }
            else if (ok[a] == true)
            {
                if (i - lasti[a] != diff[a])
                    ok[a] = false;
                else
                    lasti[a] = i;
            }
        }

        int t = 0;
        for (int i = 1; i < max; i++)
            if (ok[i]) t++;

        StringBuilder sb = new StringBuilder();
        sb.append(t + "\r\n");
        for (int i = 1; i < max; i++)
            if (ok[i])
                sb.append(i + " " + diff[i] + "\r\n");
		
		out.println(sb);		
	}
}
