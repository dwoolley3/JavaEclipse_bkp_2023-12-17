package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_12_LT_A_FLYMODE2_v1
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_12_LT_A_FLYMODE2_v1().run();
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
			
		int[] h = new int[n];
		int lo = Integer.MAX_VALUE, hi = 1, mid;
		for (int i = 0; i < n; i++) 
		{
			h[i] = in.nextInt();
			if (h[i] > hi) hi = h[i];
			if (h[i] < lo) lo = h[i];
		}		

		int maxCnt = 0;
		for (mid = lo; mid <= hi; mid++)
		{           
			int cnt = count(mid, h);
			if (cnt > maxCnt)
				maxCnt = cnt;			
		}
		
		out.println(maxCnt);	
     		
	}
	
	static int count(int mid, int[] h)
	{
		int n = h.length;
		int cnt = 0;
		
		double midd = mid + 0.5;
		for (int i = 0; i < n-1; i++)
			if (h[i] >= midd && h[i+1] <= midd)
				cnt++;
			else if  (h[i] <= midd && h[i+1] >= midd)
				cnt++;

		return cnt;
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
