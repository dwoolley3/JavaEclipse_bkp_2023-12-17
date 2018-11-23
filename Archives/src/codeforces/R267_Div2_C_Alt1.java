package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class R267_Div2_C_Alt1
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R267_Div2_C_Alt1().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		long INF = Long.MIN_VALUE / 2;
		
        long a[] = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        long p[] = new long[n + 1];
        for (int i = 0; i < n; i++)
            p[i + 1] = p[i] + a[i];
        long cur[] = new long[n + 1];
        long old[] = new long[n + 1];
        
        for (int i = 1; i <= k; i++) {
            Arrays.fill(cur, INF);
            for (int j = m * i; j <= n; j++) {
                cur[j] = Math.max(cur[j - 1], old[j - m] + p[j] - p[j - m]);
            }
            long x[] = cur;
            cur = old; 
            old = x;
        }
        out.println(old[n]);
	}
	
    void deb(String fmt, Object... args) {
        System.out.printf(Locale.US, fmt + "%n", args);
    }
	
	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}
