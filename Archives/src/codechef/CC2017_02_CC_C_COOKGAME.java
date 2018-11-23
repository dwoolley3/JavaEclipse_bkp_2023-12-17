package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_02_CC_C_COOKGAME
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_02_CC_C_COOKGAME().run();
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
		int MOD = 1_000_000_007;
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
				
			int[] a = new int[n];
			boolean valid = true;
			int neg1 = 0, posPrev = 0;
			int ans = 1;
			for (int i = 0; i < n; i++) 
			{
				a[i] = in.nextInt();
				if (i == 0)
				{
					if (a[i] == -1)
						a[i] = 1;
					else if (a[i] > 1)
						valid = false;
					posPrev = 1;
				}
				else if (a[i] == -1)
				{
					neg1++;
				}
				else //if (a[i] != -1)
				{
					if (a[i] != 1)		
					{
						if (neg1 < a[i] - 1 && posPrev + 1 + neg1 != a[i])
							valid = false;
					}
					if (valid && neg1 > 0)
					{
						if (neg1 < a[i] - 1)
							neg1 = 0;
						else
							neg1 -= (a[i] - 1);
						while (neg1 > 0)
						{
							ans *= 2;
							ans %= MOD;
							neg1--;
						}									
						
					}
					posPrev = a[i];
				}
			}
			if (valid)
				while (neg1 > 0)
				{
					ans *= 2;
					ans %= MOD;
					neg1--;
				}									

			if (!valid) ans = 0;		
			out.println(ans);	
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
