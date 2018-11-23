import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class dp_R267_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dp_R267_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//Java 7 solution - gets a Memory limit exceeded on test 22
	//                  Input: 5000 1 5000, thus n=5000, k=5000
	//                  Using 262,100 KB memory
	//Java 8 solution - Accepted, Using max of 204,700 KB memory
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		long[] sum = new long[n+1];
		for (int i = 0; i < n; i++) 
			sum[i+1] = sum[i] + in.nextLong();
				
		long[][] dp = new long[n+1][k+1];
		long curSum;
		
		for (int i = 1; i <= n; i++) 
		    for (int j = 0; j <= k; j++) 
		    {
		        dp[i][j] = dp[i-1][j];
		        if (j > 0 && i - m >= 0) 
		        {
		        	curSum = sum[i] - sum[i - m];
		            dp[i][j] = Math.max(dp[i][j], dp[i-m][j-1] + curSum);                    
		        }
		    }
		
		out.println(dp[n][k]);
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
