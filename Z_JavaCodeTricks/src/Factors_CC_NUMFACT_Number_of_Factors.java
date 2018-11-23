import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class Factors_CC_NUMFACT_Number_of_Factors
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Factors_CC_NUMFACT_Number_of_Factors().run();
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
			int[] a = new int[n];
			for (int i = 0; i < n; i++)		
				a[i] = in.nextInt();
			Map<Integer,Integer> pf = getPrimeFactorization(a);	
			long facts = 1;
			for (Map.Entry<Integer, Integer> entry : pf.entrySet())
			{
				//System.out.println(entry.getKey() + " x " + entry.getValue());
				facts *= (entry.getValue() + 1);
			}
			
			out.println(facts);	
        }		
	}
	
	private static TreeMap<Integer, Integer> getPrimeFactorization(int[] a)
	{
		// 3000 = 2x3 * 3x1 * 5x3
		TreeMap<Integer,Integer> pf = new TreeMap<Integer,Integer>();
		for (int n : a)
		{
			for (int i = 2; i * i <= n; i++)
			{
				 int cnt = 0;
				 while (n % i == 0)
				 {
					 cnt++;
					 n /= i;
				 
				 }
				 if (cnt > 0)
					 if (pf.get(i) != null)
						 pf.put(i, pf.get(i)+cnt);
					 else
						 pf.put(i, cnt);	
			}
			if (n > 1) 
				 if (pf.get(n) != null)
					 pf.put(n, pf.get(n)+1);
				 else
					 pf.put(n, 1);	
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
