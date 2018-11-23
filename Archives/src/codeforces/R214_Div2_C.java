package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R214_Div2_C //Name: Dima and Salad
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
		int k = in.nextInt();
		
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) 
			a[i] = in.nextInt();
		
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		for (int i = 1; i <= n; i++) 
		{
			b[i] = in.nextInt();
			c[i] = a[i] - b[i] * k;
        }
		
		final int INC = 100000;
		int[][] dp = new int[n + 1][2 * INC + 10];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        dp[0][INC] = 0;
        for (int i = 1; i <= n; ++i)
        {
            for (int j = -1*INC; j <= 10000; ++j) 
            {
                dp[i][j + INC] = dp[i - 1][j + INC];
                if (j - c[i] >= -1*INC 
                && j - c[i] <= 10000
                && dp[i - 1][j - c[i] + INC] > -1) 
                {
                    dp[i][j + INC] = Math.max(dp[i][j + INC], 
                    		dp[i - 1][j - c[i] + INC] + a[i]);
                }
            }
        }
        int ans = -1;
        if (dp[n][INC] > 0) ans = dp[n][INC];
		
		out.println(ans);		
	}
}
