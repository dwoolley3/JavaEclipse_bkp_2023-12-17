package readers;
import java.util.*;
import java.io.*;
//import java.math.*;
//import java.awt.geom.*;

import static java.lang.Math.*;

public class R218_Div2_D_AlexanderBoshakov2 implements Runnable {

    public void solve() throws Exception {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        
        TreeSet<Integer> nonempty = new TreeSet<Integer>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            nonempty.add(i);
        }
        
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int p = sc.nextInt() - 1, x = sc.nextInt();
                while (x > 0) {
                    Integer pos = nonempty.ceiling(p);
                    if (pos == null) {
                        break;
                    }
                    int dans = min(x, a[pos] - ans[pos]);
                    ans[pos] += dans;
                    x -= dans;
                    if (ans[pos] == a[pos]) {
                        nonempty.remove(pos);
                    }
                }
            } else {
                int k = sc.nextInt() - 1;
                out.println(ans[k]);
            }
        }
    }

    static Throwable uncaught;

    BufferedReader in;
    FastScanner sc;
    PrintWriter out;

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            solve();
        } catch (Throwable uncaught) {
        	R218_Div2_D_AlexanderBoshakov2.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new R218_Div2_D_AlexanderBoshakov2(), "", (1 << 26));
        thread.start();
        thread.join();
        if (R218_Div2_D_AlexanderBoshakov2.uncaught != null) {
            throw R218_Div2_D_AlexanderBoshakov2.uncaught;
        }
    }

}

class FastScanner {

    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

}