package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_06_LT_A_SQNUMBF2_gcd
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_06_LT_A_SQNUMBF2_gcd().run();
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
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
				
			long[] a = new long[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.nextLong();
			
			Map<Long,Integer> pf = getPrimeFactorization(a);
			
			//Iterate through the map set and display each prime factor x num of occurrences
			boolean found = false;
			for (Map.Entry<Long, Integer> entry : pf.entrySet())
			{
				//out.println(entry.getKey() + " x " + entry.getValue());
				if (entry.getValue() >= 2)
				{
					out.println(entry.getKey());
					found = true;
					break;
				}
			}
			
			if (!found)
			{
				long gcd = 1;
				for (int i = 0; i < n-1 && gcd == 1; i++)
					for (int j = i+1; j < n && gcd == 1; j++)
					{
						long x = a[i], y = a[j];				
						gcd = GCD(x,y);
					}
					
				out.println(gcd);
			}		

        }		
	}
	
    long GCD(long a, long b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
	
	private static TreeMap<Long, Integer> getPrimeFactorization(long[] a)
	{
		// 3000 = 2x3 * 3x1 * 5x3
		int num = a.length;		
		TreeMap<Long,Integer> pf = new TreeMap<>();
		for (int j = 0; j < num; j++)
		{
			long n = a[j];
		
			for (long i = 2; i * i <= n && i * i <= 1_000_000_000_000L; i++)
			{
				 int cnt = 0;
				 while (n % i == 0)
				 {
					 cnt++;
					 n /= i;
	//				 if (pf.get(i) != null)
	//					 pf.put(i, pf.get(i)+1);
	//				 else
	//					 pf.put(i, 1);				 
				 }
				 if (cnt > 0)
				 {
					 if (pf.containsKey(i)) 
						 cnt += pf.get(i);				 
					 pf.put(i, cnt);
				 }
			}
			if (n > 1) 
			{
				int cnt = 1;
				if (pf.containsKey(n)) 
					cnt += pf.get(n);				 
				pf.put(n, cnt);
			}
		}
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
