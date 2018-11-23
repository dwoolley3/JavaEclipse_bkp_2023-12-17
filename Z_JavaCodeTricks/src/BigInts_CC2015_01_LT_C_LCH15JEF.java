import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class BigInts_CC2015_01_LT_C_LCH15JEF
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new BigInts_CC2015_01_LT_C_LCH15JEF().run();
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
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			long m = in.nextLong();	
			BigInteger tot = BigInteger.ONE;
			BigInteger bm = new BigInteger(m+"");
			
			String st = in.next();
			String[] s = st.split("[*]");
			int n = s.length / 3;
			
			for (int i = 0; i < n; i++)
			{
				BigInteger bx = new BigInteger(s[i*3]);
				BigInteger by = new BigInteger(s[i*3+2]);
				tot = tot.multiply(bx.modPow(by, bm)).mod(bm);
			}
	
			out.println(tot);
        }		
	}
	
	//Not used for this solution
	long getBigPowerMod(long b, long n, long m)
    {
		 //num will be b^n mod m; for n, m up to 1e10
		 //long num = 1
		 //for (int i = 0; i < n; i++)
		 //    num = (num * b) % m;
		
		 long num = 1;
		 while (n > 0)
		 {
		     if (n % 2 == 1)
		         num = (num * b) % m;
		     b = (b * b) % m;
		     n /= 2;
		     //System.out.println(num + " " + b + " " + n);
		 }
		 return num;
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
