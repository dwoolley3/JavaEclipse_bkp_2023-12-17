package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R620_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R620_Div2_C().run();
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
		int q = in.nextInt();
		for (int tt = 0; tt < q; tt++) {					
			int n = in.nextInt();
			int m = in.nextInt(); // initial temp
			
			int[] t = new int[n];
			int[] l = new int[n];
			int[] h = new int[n];			
			for (int i = 0; i < n; i++) {
				t[i] = in.nextInt();
				l[i] = in.nextInt();
				h[i] = in.nextInt();
			}
			
			boolean ok = true;
			int lo = m, hi = m, timeDif = t[0];
			for (int i = 0; i < n && ok; i++) {
				if (i > 0) timeDif = t[i] - t[i-1];
				lo -= timeDif;
				hi += timeDif;
				if (l[i] > hi || h[i] < lo) {
					ok = false;
				} else {
					lo = Math.max(lo, l[i]);
					hi = Math.min(hi, h[i]);
				}		
			}
			
			out.println(ok ? "YES" : "NO");
		
		}

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
