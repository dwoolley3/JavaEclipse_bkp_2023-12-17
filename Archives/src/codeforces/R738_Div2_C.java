package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R738_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R738_Div2_C().run();
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
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();
			
			int[] a = new int[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.nextInt();
			
			int ans[] = new int[n+1];
			for (int i = 0; i <= n; i++) {
				ans[i] = i+1;
			}
			if (a[n-1] == 0) {
				for (int i = 0; i <= n; i++) {
					out.print(ans[i] + " ");
				}
				out.println();
			} else if (a[0] == 1) {
				out.print(ans[n] + " ");
				for (int i = 0; i < n; i++) {
					out.print(ans[i] + " ");
				}
				out.println();
			} else {
				boolean ok = false;
				for (int i = 0; i < n && !ok; i++) {
					if (a[i] == 0 && a[i+1] == 1) {
						for (int j = 0; j < n; j++) {
							if (j == i) {
								out.print(ans[j] + " ");
								out.print(ans[n] + " ");
								j++; 
							} 
							out.print(ans[j] + " ");
							
						}
						out.println();
						ok = true;
					}
				}
				if (!ok) {
					out.println(-1);
				}
			}

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
