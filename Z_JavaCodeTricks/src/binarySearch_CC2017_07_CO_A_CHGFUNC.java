import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class binarySearch_CC2017_07_CO_A_CHGFUNC
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new binarySearch_CC2017_07_CO_A_CHGFUNC().run();
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
		int A = in.nextInt();	
		int B = in.nextInt();
		
		int numSq = 1_100_000;
		//TreeSet<Long> sq = new TreeSet();
		long[] a = new long[numSq];
		for (int i = 1; i < numSq; i++)
		{
			//sq.add(1L * i*i);
			a[i] = 1L * i * i;
		}
		
		int cnt = 0;
		for (int x = 1; x <= A; x++)
		{
			long fx = 1L * x * x;
			
			int ind1 = Arrays.binarySearch(a, fx); 
			int ind2 = Arrays.binarySearch(a, fx + B); 
			
			if (ind1 < 0) ind1 = -ind1; else ind1++;
			if (ind2 < 0) ind2 = -ind2 - 1; else ind2++;
			
			if (ind2 - ind1 > 0)
			{
				cnt += (ind2 - ind1);
				//out.println(fx + " " + B + " " + ind1 + " " + ind2);
			}
			
//			long first = sq.ceiling(fx);
//			long y = first - fx;
//			while (y <= B) 
//			{
//				if (y >= 1)
//				{
//					cnt++;
//					out.println(x + " " + y + " " + first);
//				}
//				first = sq.ceiling(first + 1);
//				y = first - fx;
//			}
		}
		out.println(cnt);	
			
		
//		cnt = 0;
//		for (int i = 1; i <= A; i++)
//			for (int j = 1; j <= B; j++)
//			{
//				long f = 1L * i * i + j;
//				long sqrt = (long)(Math.sqrt(f) + 0.1);
//				if (sqrt * sqrt == f)
//				{
//					//out.println(i + " " + j + " " + f);
//					cnt++;
//				}
//			}
//		
//		out.println(cnt);	
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
