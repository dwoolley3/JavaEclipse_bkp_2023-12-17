package readers;
/**
 * Created with IntelliJ IDEA.
 * User: Jovfer
 * Date: 24.11.13
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Jovfer //TaskC 
{
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Jovfer taskA = new Jovfer();
        taskA.open();
        taskA.solve();
        taskA.close();
    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    private void close() {
        try { out.close();  in.close(); } 
        catch (IOException ignore) {  }
    }
    
    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            else st = new StringTokenizer(str);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }



    int n, k;
    int[] a, b;

    private void solve() throws IOException {
        n = nextInt();
        k = nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = nextInt() * k;
        }

        int maxSumB = 100500;
        int maxSum = maxSumB + 10500 + 13;
        int[][] dp = new int[maxSum + 1][n + 1];
        for (int i = 0; i < maxSum + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[maxSumB][0] = 0;
        for (int i = 0; i < n; i++) {
            int curA = a[i], curB = b[i];
            for (int oldDiff = 0; oldDiff <= maxSum; oldDiff++) {
                if (dp[oldDiff][i] >= 0) {
                    int newDiff = oldDiff + curA - curB;
                    dp[newDiff][i + 1] = max(dp[newDiff][i + 1], dp[oldDiff][i] + curA);
                    dp[oldDiff][i + 1] = max(dp[oldDiff][i + 1], dp[oldDiff][i] + 0);
                }
            }
        }
        int answ = dp[maxSumB][n];
        out.println(answ > 0 ? answ : -1);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }


}