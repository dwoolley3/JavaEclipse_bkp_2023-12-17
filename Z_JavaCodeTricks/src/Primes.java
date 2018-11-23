import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Primes //Name: Primes
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Primes().run();
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
		int n = in.nextInt();
        int cnt = 0;

        //Takes  16 seconds for n =  10,000,000
        //for (int i = 0; i < n; i++)
        //    if (isPrime(i)) cnt++;

        //Takes only 0.5 seconds for n =    10,000,000
        //Takes only 3   seconds for n =   100,000,000
        //Takes only 25  seconds for n = 1,000,000,000
        boolean[] prime = sieve(n);
        for (int i = 0; i < n; i++)
            if (prime[i]) cnt++;

        //Takes  4 seconds for n =  10,000,000
        //int[] primes = GetPrimesUpTo(n);
        //for (int i = 0; i < n; i++)
        //    if (primes[i] == 1) cnt++;
        
        //Takes  9 seconds for n =  10,000,000
        //ArrayList<Integer> primes = GetPrimesUpTo2(n);
        //cnt = primes.size();
        
        out.println(cnt);	
	}
	
    boolean isPrime(int n)
    {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }
    
    boolean[] sieve(int n)
    {
        //Return all primes between 0 and n using Sieve of Eratosthenes
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
    
    int[] GetPrimesUpTo(int max)
    {
        int[] primes = new int[max + 1];
        primes[0] = -1;
        primes[1] = -1;
        for (int i = 2; i < max + 1; i++)
        {
            if (primes[i] == 0)
            {
                primes[i] = 1;
            }
            int j = i + i;
            while (j < max + 1)
            {
                primes[j] = -1;
                j += i;
            }
        }
        return primes;
    }
    
    ArrayList<Integer> GetPrimesUpTo2(int max)
    {
    	ArrayList<Integer> primes = new ArrayList<Integer>();
        //if (1 <= max) primes.Add(1); //Normally not prime
        if (2 <= max) primes.add(2);
        for (int i = 3; i <= max; i += 2)
        {
            boolean prime = true;
            for (int j = 1; j < primes.size() && primes.get(j) * primes.get(j) <= i; j++)
                if (i % primes.get(j) == 0)
                {
                    prime = false;
                    break;
                }
            if (prime) primes.add(i);
        }
        return primes;
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
