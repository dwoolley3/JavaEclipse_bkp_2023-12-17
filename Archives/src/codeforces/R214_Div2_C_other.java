package codeforces;
import java.util.Scanner;
import java.io.OutputStream;
//import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class R214_Div2_C_other
{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }
}

class Task {
    final int delta = 100000;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            a[i] = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            b[i] = in.nextInt();
            b[i] = a[i] - b[i] * k;
        }
        int[][] dp = new int[n + 1][2 * delta + 10];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        dp[0][delta] = 0;
        for (int i = 1; i <= n; ++i)
            for (int j = -100000; j <= 10000; ++j) {
                dp[i][j + delta] = dp[i - 1][j + delta];
                if (j - b[i] >= -100000 && j - b[i] <= 10000 && dp[i - 1][j - b[i] + delta] > -1) {
                    dp[i][j + delta] = Math.max(dp[i][j + delta], dp[i - 1][j - b[i] + delta] + a[i]);
                    //out.println(i - 1 + " " + (j - b[i] + delta));
                }
            }
        //out.println(dp[1][6 + delta]);
        if (dp[n][delta] > 0)
            out.print(dp[n][delta]);
        else
            out.print(-1);
    }
}