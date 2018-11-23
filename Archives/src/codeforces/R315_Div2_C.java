package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R315_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R315_Div2_C().run();
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
		int p = in.nextInt();
		int q = in.nextInt();
		
		int maxn = 2_000_000;
		int[] pal = new int[maxn];
        int cnt = 0;
		for (int i = 1; i < maxn; i++) 
		{
			if (isPal(i)) cnt++;
			pal[i] = cnt;
		}

		int[] pri = new int[maxn];
        boolean[] prime = seive(maxn);
        cnt = 0;
        for (int i = 0; i < maxn; i++)
        {
            if (prime[i]) cnt++;
            pri[i] = cnt;
        }
        
        for (int i = maxn-1; i >= 1; i--)
        	if (q*pri[i] <= p*pal[i])
        	{
        		out.println(i);
        		return;
        	}
	}
	
	private boolean isPal(int number)
	{
        int num = number, reverse = 0, digit;
        while (num > 0)
        {
            digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return (number == reverse);
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
