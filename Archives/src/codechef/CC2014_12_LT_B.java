package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_12_LT_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_12_LT_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	public void p(Object ...o) {System.out.println(Arrays.deepToString(o));}
	
	void solve()
	{
		int n = 50;
		int[] sum = new int[n+1];
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		a[0] = 1;
		for (int i = 1; i <= n; i++)
		{
			b[0] = a[0];
			for (int j = 1; j < i; j++)
				b[j] = a[j-1] + a[j];
			b[i] = 1;
			for (int j = 0; j <= i; j++)
				a[j] = b[j] % 3;
			//p(a);
			
			for (int j = 0; j <= i; j++)
				sum[i] += a[j];
			sum[i] %= MOD;
			p(sum);
		}
//		for (int i = 4001; i < 5000; i++)
//			out.println(i + " " + sum[i]);
		
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			n = in.nextInt();
        
//	        for (int r = 0; r <= n; r++)
//	        {
//	            ans += (nCk(n, r) % 3);
//	            ans = ans % MOD;
//	        }
			out.println(sum[n]);
        }		
	}
	
	long MOD = 1_000_000_007;
	
    long[] fact = new long[1000001];
    void GenerateFactorials()
    {
        fact[0] = 1L;
        for (int i = 1; i < 1000001; i++)
            fact[i] = fact[i - 1] * i % MOD;
    } 
    
    long nCk(int n, int k) {
        long f = fact[n];
        long f1 = BigInteger.valueOf(fact[k]).modInverse(BigInteger.valueOf(MOD)).longValue();
        long f2 = BigInteger.valueOf(fact[n - k]).modInverse(BigInteger.valueOf(MOD)).longValue();
        long nCk = (f * f1 % MOD) * f2 % MOD ;
        return nCk;
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
