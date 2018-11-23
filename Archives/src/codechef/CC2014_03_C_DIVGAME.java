package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_03_C_DIVGAME
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_03_C_DIVGAME().run();
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
		boolean [] primes = seive(10000);
		
        int T = in.nextInt();
        fort:
        for (int t = 0; t < T; t++)
        {
	        int n = in.nextInt();
			if (n == 2 || n == 17)
				out.println("Mike");
			else if (n == 16 || n == 34 || n == 289)
				out.println("Tom");
			else 
			{
				for (int p = 2; p <= 10000; p++)
				{
					if (primes[p])
					{
						if (p * p > n) break;			
						if (n % p == 0) {
							out.println("Mike");
							continue fort; 
						}
					}
				}
				out.println("Tom");
			}
        }
	}
	
    boolean[] seive(int n)
    {
        //Return all primes between 0 and n using Seive of Eratosthenes
    	boolean[] prime = new boolean[n + 1];
    	Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (prime[i])
                for (int k = i * i; k <= n; k += i)
                    prime[k] = false;
        return prime;
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
