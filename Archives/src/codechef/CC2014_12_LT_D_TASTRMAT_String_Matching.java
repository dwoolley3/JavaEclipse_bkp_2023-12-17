package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_12_LT_D_TASTRMAT_String_Matching
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_12_LT_D_TASTRMAT_String_Matching().run();
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
		long MOD = 1_000_000_007;
        String aSt = in.next();
        int k = in.nextInt();
        for (int t = 0; t < k; t++)
        {
			String bSt = in.next();
			int an = aSt.length();			
			int bn = bSt.length();
			int[] a = new int[an];
			int[] b = new int[bn];
			for (int i = 0; i < an; i++) a[i] = (aSt.charAt(i) == '1') ? 1 : 0;
			for (int i = 0; i < bn; i++) b[i] = (bSt.charAt(i) == '1') ? 1 : 0;
			long sum = 0;
			long[] dif = new long[an - bn + 1];
			
			for (int j = 0; j < bn; j++)
				dif[0] += (a[j] ^ b[j]);
			sum = dif[0] % MOD;
			
			for (int i = 1; i <= an-bn; i++) 
			{	
				for (int j = 0; j < bn; j++)
					dif[i] += (a[i+j] ^ b[j]);
				sum = (sum * 100_001 + dif[i]) % MOD;
			}
		
			out.println(sum);	
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
