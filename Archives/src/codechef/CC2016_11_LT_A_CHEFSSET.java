package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_11_LT_A_CHEFSSET
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_11_LT_A_CHEFSSET().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
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
	static ArrayList<Integer> primesUpTo1000;
	
	void solve()
	{
		int max = 1_000_001;
        boolean[] prim = seive(max);
		int[] primeOdd  = new int[max];  //Moved out of for loop to avoid constant re-initializing of so many elements
		int[] primeEven = new int[max];
        
        int T = in.nextInt();
		
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();
				
			HashSet<Integer> prims = new HashSet<>(); 
			for (int i = 0; i < n; i++)
			{
				int a = in.nextInt();
				if (a == 1)	continue;				
				if (prim[a]) 
				{
					int prime = a;
					prims.add(prime);
					primeOdd[prime]++;
				}
				else 
				{					
					Map<Integer,Integer> pf = getPrimeFactorization(a);
					//Iterate through the map set and display each prime factor x num of occurrences
					for (Map.Entry<Integer, Integer> entry : pf.entrySet())
					{
						int prime = entry.getKey();
						int occurs = entry.getValue();
						//System.out.println(entry.getKey() + " x " + entry.getValue());
						//if (occurs % 2 == 1)
						if ((occurs & 1) == 1)
							primeOdd[prime]++;
						else
							primeEven[prime]++;
						prims.add(prime);
					}				
				}
			}
			
			int ans = 0;
			for (int prime : prims)
			{
				//System.out.println(prime + " " + primeOdd[prime] + " " + primeEven[prime]);
				primeEven[prime] += (n - primeOdd[prime] - primeEven[prime]);  //Num of 0's
				ans += Math.min(primeOdd[prime], primeEven[prime]);
				
				primeOdd[prime] = 0;
				primeEven[prime] = 0;
			}
			
			out.println(ans);	
        }		
	}
	
	private static TreeMap<Integer, Integer> getPrimeFactorization(int n)
	{
		// 3000 = 2x3 * 3x1 * 5x3
		TreeMap<Integer,Integer> pf = new TreeMap<Integer,Integer>();
		for (int i = 2; i * i <= n; i++)
		{
			 //if (i * i > n) break;
			 int cnt = 0;
			 while (n % i == 0)
			 {
				 cnt++;
				 n /= i;		 
			 }
			 if (cnt > 0) pf.put(i, cnt);
		}
		if (n > 1) pf.put(n, 1);
		return pf;
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
