package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class R267_Div2_C_Alt2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R267_Div2_C_Alt2().run();
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
		
        long a[] = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
		long[] cum = new long[n+1];
		for(int i = 0;i < n;i++){
			cum[i+1] = cum[i] + a[i];
		}
		
		long[] pre = new long[n+1];
		long[] cur = new long[n+1];
		pre[0] = 0;
		for(int i = 1; i <= k; i++) {
			Arrays.fill(cur, 0);
			for(int j = 0; j <= n; j++) {
				cur[j] = 0;
				if (j-1 >= 0) cur[j] = cur[j-1];
				if (i-1 >= 0 && j-m >= 0) 
					cur[j] = Math.max(cur[j], pre[j-m] + (cum[j]-cum[j-m]));
			}
			long[] dum = pre; pre = cur; cur = dum;
		}
		out.println(pre[n]);
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
