package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2017_R1_D
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "D_ex";
	final String PROBLEM_NAME = "D";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2017_R1_D().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + "_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + "_out.txt"));

		solve();
		out.close();
	}
	
	int MOD = 1_000_000_007;
	
	long[] fact = new long[2001];
    void GenerateFactorials()
    {
        fact[0] = 1L;
        for (int i = 1; i < 2001; i++)
            fact[i] = fact[i - 1] * i % MOD;
    } 
	
	void solve()
	{
		//GenerateFactorials();
	    
		int T = in.nextInt();		

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			
			int[] r = new int[n];
			int sumr = 0;
			for (int i = 0; i < n; i++) 
			{
				r[i] = in.nextInt();
				sumr += r[i];
			}
								
			long cnt = 0;
			if (n == 1)
				cnt = m;
			else
			{
				HashMap<Integer,Integer> hm = new HashMap<>();
				
				for (int i = 0; i < n; i++)
					for (int j = i+1; j < n; j++)
					{	
						int span = sumr * 2 - r[i] - r[j];
						int spots = m-1 - span;
						// nCr * r! = n*(n-1)*(n-2)*...(n-r+1)
						// (spots+n)Cn * (n-2)! [Keep two ends fixed]
						// (spots+n)*(spots+n-1)*(spots+n-2)*...(spots+n-n+1)/(n*(n-1))
						if (spots >= 0)
						{							
							long p = 1;
							if (hm.containsKey(spots + n))
								p = hm.get(spots + n);
							else
							{
								int N = n, N1 = n-1; //divide by N and N1
								for (int k = spots + n; k >= spots+1; k--)
								{
									p *= k;
									if (N > 0 && p % N == 0)
									{
										p /= N;
										N = 0;
									}
									if (N1 > 0 && p % N1 == 0)
									{
										p /= N1;
										N1 = 0;
									}
									if (p >= MOD)
										p %= MOD;
								}
								hm.put(spots + n, (int)p);
								//if (N > 0 || N1 > 0)
								//	System.out.println("bad - " + N + " " + N1);
							}
							//System.out.println(p);
							cnt += p;
							cnt %= MOD;							
						}
					}
				
				//Double for i > j
				cnt *= 2;
				cnt %= MOD;
			}
			
			String ans = "" + cnt;
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}

	//-----------------------------------------------------

	
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
