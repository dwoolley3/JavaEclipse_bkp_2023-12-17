import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class bs_R399_Div2_B2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new bs_R399_Div2_B2().run();
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
		long n = in.nextLong();
		long l = in.nextLong();
		long r = in.nextLong();

		//int pow2 = (int)(Math.log(n) / Math.log(2));  //double not precise enough for really long numbers
		long pow2 = 1;
		while (pow2 <= n)
			pow2 *= 2;

		int cnt1 = 0;
		for (long i = l; i <= r; i++)
		{			
			long num = n;
			long lo = 1, hi = pow2 - 1, mid = 0;
			while (lo <= hi)
			{
				mid = (lo + hi) / 2;
				if (i == mid)
				{
					cnt1 += (num % 2);
					break;
				}
				else if (i < mid)
					hi = mid - 1;
				else // i > mid
					lo = mid + 1;
				
				num /= 2;
			}		
		}
		
		out.println(cnt1);		
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
