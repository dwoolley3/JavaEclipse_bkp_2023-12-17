package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R272_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R272_Div2_C().run();
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
		long a = in.nextInt();
		long b = in.nextInt();
		long MOD = 1_000_000_007;
		
//		long m, d, k;
//		long sum = 0;
//		int totLines = 0;
//		for (int x = 1; x < 10000; x++)
//		{
//			m = x % b;
//			if (m > 0)
//			{
//				d = x / b;
//				if (d % m == 0)
//				{
//					k = d/ m;
//					if (k >= 1 && k <= a)
//					{
//						out.println("x=" + x + " d=" + d + " m=" + m + " k=" + k);
//						sum += x;
//						sum = sum % MOD;
//						totLines++;
//					}
//				}
//			}
//		}
//		out.println("lines = " + totLines);
//		out.println(sum);		
//		
//		long dd = 0, sum2 = 0, xx = 0;
//		for (int kk = 1; kk <= a; kk++)
//			for (int mm = 1; mm <= b-1; mm++)
//			{
//				dd = mm * kk;
//				xx = dd * b + mm;
//				sum2 += xx;
//				sum2 = sum2 % MOD;
//			}
//		out.println(sum2);	
		
		long summ = (1 + b-1) * (b-1) / (long)2;
		long sumk = (1 + a) * a / (long)2;		
		summ %= MOD;
		sumk %= MOD;		
		long sum3 = summ * sumk;
		sum3 %= MOD;
		sum3 *= b;
		sum3 %= MOD;
		long part = summ * a;
		part %= MOD;
		sum3 += part;
		sum3 %= MOD;

		out.println(sum3);
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
