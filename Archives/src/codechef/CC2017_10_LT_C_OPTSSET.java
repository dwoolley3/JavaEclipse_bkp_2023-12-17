package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_10_LT_C_OPTSSET
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_10_LT_C_OPTSSET().run();
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
			int[] x = new int[n];
			int[] y = new int[n];
			for (int i = 0; i < n; i++) { 
				x[i] = in.nextInt();
				y[i] = in.nextInt();				
			}
						
			int[] w = new int[n];
			for (int i = 0; i < n; i++)
				w[i] = in.nextInt();
			
			double maxratio = 0;
			for (int bitmask = 0; bitmask < 1<<(n-1); bitmask++) //2^n-1
			{
				int lastx = x[0];
				int lasty = y[0];
				int weightsum = 0;
				double distsum = 0;
				for (int j = 0; j < n-1; j++)
					if ((bitmask & (1 << j)) != 0) //win
					{
						weightsum += w[1+j];
						distsum += dist(lastx, lasty, x[1+j], y[1+j]);
						lastx = x[1+j];
						lasty = y[1+j];
					}

				weightsum += w[0];
				distsum += dist(lastx, lasty, x[0], y[0]);
				double ratio = distsum / weightsum;
				if (ratio > maxratio) maxratio = ratio;
			}
			
	        out.println(maxratio);
        }	
	}

    double dist(int x1, int y1, int x2, int y2) 
    {
    	long sum = 1L * (x1 - x2) * (x1 - x2);
    	sum += 1L * (y1 - y2) * (y1 - y2);
    	return Math.sqrt(sum);
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
