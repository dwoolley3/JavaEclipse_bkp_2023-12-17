package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_01_LT_B_SEALUP
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_01_LT_B_SEALUP().run();
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
				
			int x0 = in.nextInt();
			int y0 = in.nextInt();
			int prevx = x0;
			int prevy = y0;
			
			int[] len = new int[n];
			for (int i = 1; i < n; i++)
			{
				int x = in.nextInt();
				int y = in.nextInt();
				
				long d1 = x - prevx, d2 = y - prevy;			
				len[i] = (int)(Math.sqrt(d1 * d1 + d2 * d2) + 0.99999999);
				
				prevx = x; prevy = y;
			}
			long d1 = x0 - prevx, d2 = y0 - prevy;			
			len[0] = (int)(Math.sqrt(d1 * d1 + d2 * d2) + 0.999999999);
			
			int m = in.nextInt();
			int[] l = new int[m]; 
			int[] c = new int[m];
			for (int i = 0; i < m; i++)
			{
				l[i] = in.nextInt();
				c[i] = in.nextInt();
			}
			
			long minCost = 0;
			for (int i = 0; i < n; i++)
			{
				long min = Long.MAX_VALUE;
				for (int j = 0; j < m; j++)
				{
					int x = len[i] / l[j];
					if (len[i] % l[j] > 0) x++;
					long cost = 1L * x * c[j];
					min = Math.min(min, cost);
					//out.println(len[i] + " " + l[j] + " " + cost + " " + min);
				}
				//out.println(minCost);
				minCost += min;
			}
			
			out.println(minCost);	
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
