package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_06_LT_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_06_LT_B().run();
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
				
			int[] c = new int[n];
			for (int i = 0; i < n; i++) 
				c[i] = in.nextInt();
			
			int[] w = new int[n];
			long[] psum = new long[n];
			for (int i = 0; i < n; i++) 
			{
				w[i] = in.nextInt();
				if (i > 0)
					psum[i] = psum[i-1];
				psum[i] += w[i];
			}
			
			int[] ind = new int[n];
			Arrays.fill(ind, -1);
			
			long max = 0;			
			HashSet<Integer> hs = new HashSet<>();

			int starti = 0, startj = 0;
			for (int i = starti; i < n; i++)
			{
				boolean ok = true;
				for (int j = startj; j < n && ok; j++)
				{
					if (hs.contains(c[j])) 
					{
						long sum = psum[j-1];
						if (i > 0) sum -= psum[i-1];
						if (sum > max) max = sum;
						
						ok = false;
						for (int k = i; k <= ind[c[j]] - 1; k++)
						{
							hs.remove(c[k]);
							ind[c[k]] = -1;
						}
						i = ind[c[j]]; //Make +1 from i loop
						startj = j + 1;						
					}
					else 
					{
						hs.add(c[j]);						
					}
					ind[c[j]] = j;
				}
				if (ok)
				{
					long sum = psum[n-1];
					if (i > 0) sum -= psum[i-1];
					if (sum > max) max = sum;
					break;
				}
			}			
			
			out.println(max);	
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
