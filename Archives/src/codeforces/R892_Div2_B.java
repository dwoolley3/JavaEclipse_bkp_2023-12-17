package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R892_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R892_Div2_B().run();
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
			
			int m[][] = new int[n][];
			int mlen[] = new int[n];
			for (int i = 0; i < n; i++) {
				mlen[i] = in.nextInt();
				m[i] = new int[mlen[i]];
				for (int j = 0; j < mlen[i]; j++) {
					m[i][j] = in.nextInt();
				}
				Arrays.sort(m[i]);
			}			
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < mlen[i]; j++) 
//					out.print(m[i][j] + " ");
//				out.println();
//			}
			
			// Find smallest 2nd element that has smallest 1st element 

			int min1 = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (m[i][1] < min1) {
					min1 = m[i][1];
				}
			}
			int min0 = Integer.MAX_VALUE;
			int mini = 0;
			for (int i = 0; i < n; i++) {
				if (m[i][1] == min1) {
					if (m[i][0] < min0) {
						min0 = m[i][0];
						mini = i;
					}
				}				
			}
			
			long ans = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (i != mini) {
					ans += m[i][1];
				}
				if (m[i][0] < min) {
					min = m[i][0];
				}
			}
			ans += min;
			
			out.println(ans);
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
