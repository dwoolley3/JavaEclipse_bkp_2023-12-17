package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R651_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R651_Div2_C().run();
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
		String a = "Ashishgup";
		String f = "FastestFinger";
		
		for (int tt = 0; tt < t; tt++) {
			String ans = f;
			int n = in.nextInt();
			if (n == 1) ans = f;
			else if (n == 2) ans = a;
			else if (n % 2 == 1) ans = a;
			else // even
			{
				int powOf2 = 0;
				while (n > 1 && n % 2 == 0) {
					n/= 2;
					powOf2++;
				}
				if (n==1) ans = f; //exactly pow of 2
				else if (powOf2 > 1) ans = a; // divide by all odds together
				else // powOf2 == 1
				{
					// if number of odd divisors = 1, a wins, otherwise f wins
					if (isPrime(n)) ans = f;
					else ans = a;
				}
			}
			
			out.println(ans);		
		}
	}
	
	boolean isPowerOf2(int n) {
		while (n > 1 && n % 2 == 0) {
			n/= 2;
		}
		return n == 1;
	}
	
    private static boolean isPrime(int n)
    {
      if (n <= 1) return false;
      if (n == 2) return true;
      if (n % 2 == 0) return false;
      for (int i = 3; i * i <= n; i += 2)
         if (n % i == 0) return false;
      return true;
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
