package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R404_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R404_Div2_C().run();
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
		long m = in.nextLong();
		
		if (m >= n)
		{
			out.println(n);
			return;
		}
		
		long days = m;
		n -= days;  // n >= 1
		
		long lo = 1, hi = n, mid;
      	while (lo < hi)
      	{
           mid = lo + (hi - lo) / 2;
           if (!check(mid,n,m))
        	   lo = mid + 1; 
           else
               hi = mid;                           
      	}
      	days += lo;

		out.println(days);		
	}
	
	static boolean check(long mid, long n, long m)
	{
//		long barn = 0;
//		double barnD = n + m * 1.0 * mid;
//		if (barnD > 2e18) barn = (long)(2e18 + m);		
//		else barn = n + m * mid;
//		
//		long birds = 0; //m+1, m+2, ... x		
//		//for (long i = m+1; i <= m+mid; i++)
//		//	birds += i;
//		
//		double birdsD = (m+1 + m+mid) * 1.0 * mid / 2;
//		if (birdsD > 2e18) birds = (long)(2e18 + m + 1);	
//		else birds = (m+1 + m+mid) * mid / 2;
		
		// barn <= birds
		//     birdsD = (m+1 + m+mid) * mid / 2;
		//n + m*mid <= (m*mid + mid + m*mid + mid*mid) / 2
		//n*2 + 2*m*mid <= 2*m*mid + mid + mid*mid
		//n*2 <= mid + mid*mid
		
		double d = mid + 1.0*mid*mid;		
		if (d > 2e18 + 1) return true;
		
		return n * 2 <= mid + mid*mid;
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
