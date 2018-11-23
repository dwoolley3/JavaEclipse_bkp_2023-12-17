package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R166_Div2_B //Name: Prime Matrix
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R166_Div2_B().run();
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
		final int maxN = 200000;
		boolean[] prime = seive(maxN); //Takes only 0.5 seconds for n = 10,000,000
		TreeSet<Integer> primes;
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		primes = new TreeSet<Integer>();
		Arrays.fill(prime, true);
		for (int i = 2; i < maxN; i++) {
			if (prime[i]) {
				primes.add(i);
				for (int j = 2 * i; j < maxN; j += i) {
					prime[j] = false;
				}
			}
		}
		int[][] b = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = in.nextInt();
				b[i][j] = primes.ceiling(a) - a;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += b[i][j];
			}
			min = Math.min(min, sum);
		}
		for (int j = 0; j < m; j++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += b[i][j];
			}
			min = Math.min(min, sum);
		}
		out.println(min);	
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
