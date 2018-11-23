package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
//Random Rudreshwar //Editorial says that dynamic programmning is needed
class CC2015_01_CO_C_wrong
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_01_CO_C_wrong().run();
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
				
			int[] b = new int[n];
			int[] m = new int[n];
			long prod = 1;
			int priorMin = 0;
			m[0] = 0;
			for (int i = 0; i < n; i++) 
			{
				b[i] = in.nextInt();
				int min = Math.min(b[i],  (i+1));
				min = Math.min(min, priorMin + 1);
				prod *= min;
				prod %= MOD;
				priorMin = min;
				m[i] = min;
				out.println("prod=" + prod);
			}
			
			//Invalids
			for (int i = 1; i < n; i++)
			{
				//int min = Math.min(b[i],  (i+1));
				int min = m[i];
				int sum = 0;
				
				//sum from i
				for (int j = 1; j <= m[i-1]; j++) //Math.min((i-1)+1, b[i-1]); j++)
				{
					if (j <= min - 2) 
						sum += (min - j - 1);
				}
				long prod2 = sum;
				for (int j = i+1; j < n; j++)
				{
					prod2 *= Math.min(m[j],  (j+1));	
					prod2 %= MOD;
				}
				out.println("prod2=" + prod2);
				
				prod -= prod2;
				if (prod < 0) prod += MOD;
			}
		
			out.println(prod);	
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
