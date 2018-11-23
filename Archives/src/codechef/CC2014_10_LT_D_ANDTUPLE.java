package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_10_LT_D_ANDTUPLE //Name: And Tuples
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_10_LT_D_ANDTUPLE().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static long MOD = 1000000009;
    static HashMap<Long,Long> hm = new  HashMap<Long,Long>();
    
	void solve()
	{

        int T = in.nextInt();

        for (int t = 0; t < T; t++)
        {
			int k = in.nextInt();	
			long n = in.nextLong();
				
			long ans;
			if (k == 3)
				ans = (n/2 + 1) % MOD;
			else
				ans = f(n);
			
			out.println(ans);
						
//			for (n = 1; n < 35; n+=1)
//			{
//			int cnt = 0;
//			for (int i = 0; i <= n; i++)
//				for (int j = 0; j <= n-i; j++)
//					for (int a = 0; a <= n-i-j; a++)
//				{
//					int d = (int)n - i - j - a;
//					if ((i & j) == j && (j & a) == a && (a & d) == d)
//					{
//						//if (d > 0)
//						{
//						//out.println(i + " " + j + " " + a + " " + d);
//						cnt++;
//						}
//					}					
//				}
//			out.println(n + " " + cnt);
//			out.println();
//			}
        }		
	}
	
	long f(long n)
	{
		long ans = 1;
		if (n == 0) 
			ans = 1;
		else if (n <= 2) 
			ans = n;
		else
		{
			if (hm.containsKey(n))
				ans = hm.get(n);
			else
			{
				ans = f(n/2) + f(n/2 - 1);
				if (n%2 == 0)
					ans += f(n/2 - 2);
				ans %= MOD;
				hm.put(n, ans);
			}
		}
		return ans;
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
