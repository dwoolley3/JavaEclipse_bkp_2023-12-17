package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R299_Div2_C_RE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R299_Div2_C_RE().run();
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
		int A = in.nextInt();
		int B = in.nextInt();
		int n = in.nextInt();
		
		long[] a = new long[100_005];
		long[] sum = new long[100_005];
		for (int i =  1; i < 100_001; i++)
		{
			a[i] = A + (i-1) * B;
			sum[i] = sum[i-1] + a[i];
		}
		
		for (int i = 0; i < n; i++) 
		{
			int leftInd = in.nextInt();
			long tBites = in.nextInt();
			long mBiteLen = in.nextInt();
			
			if (tBites < a[leftInd])
				out.println(-1);
			else
			{
				int lo = leftInd, hi = (int)(tBites - A + B) / B + 2, mid;
				
		        while (lo  + 1 < hi)
		        {
		            mid = lo + (hi - lo) / 2;
		            if (a[mid] <= tBites 
            		&& sum[mid] - sum[leftInd - 1] <= tBites * mBiteLen)
		            	lo = mid; 
		            else
		                hi = mid;                           
		        }
	        	out.println(hi - 1);
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
