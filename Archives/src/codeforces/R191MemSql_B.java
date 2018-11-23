package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R191MemSql_B //Name: Stadium and Games
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	static long t;
	public static void solve(Scanner in, PrintWriter out)
	{
		long n = in.nextLong();	
        ArrayList<Long> ans = new ArrayList<Long>();
        for (int p = 0; p < 60; p++)
        {
            long min = 1;
            long max = (long)2e9 + 10;
            for (int t = 0; t < 100; t++)
            {
                long mid = (min + max) / 2;
                if (mid % 2 == 0) mid--;
                long sum = mid * (mid - 1) / 2;
                long now = mid;
                for (int k = 0; k < p && sum <= n; k++)
                {
                    sum += now;
                    now *= 2;
                }
                if (sum == n)
                {
                    ans.add(now);
                    break;
                }
                else if (sum < n)
                {
                    min = mid;
                }
                else
                {
                    max = mid;
                }
            }
        }
        Collections.sort(ans);

        for (long item : ans)
        {
        	out.println(item);
        }
        if (ans.size() == 0) out.println(-1);
	}
}
