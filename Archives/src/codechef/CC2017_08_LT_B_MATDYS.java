package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_08_LT_B_MATDYS
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_08_LT_B_MATDYS().run();
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
			BigInteger k = in.nextBigInteger();

			//long k = in.nextLong();
//			int last = 1 << n;
//			int[] a = new int[last];
//			for (int i = 0; i < last; i++) 
//				a[i] = i;
						
//			for (int i = 0; i < n; i++)
//			{
//				int groups = 1 << i;
//				for (int j = 0; j < groups; j++)
//						reorder(a, j * (1 << n) / groups, (j+1) * (1 << n) / groups -1);
//				
//				for (int j = 0; j < last; j++) 
//					out.print(a[j] + " ");
//				out.println();
//			}
//			
//			for (int i = 0; i < 1 << n; i++)
//				if (a[i] == k)
//					out.println(i);
						
//			long pos = 0;
//			for (int i = 0; i < n; i++)
//			{
//				if (k == 0) break;
//				if (k % 2 == 1) 
//					pos += (1L << (n-1 - i));
//				k /= 2;
//			}
			
			BigInteger pos = BigInteger.ZERO;
			BigInteger two = new BigInteger("2");
			for (int i = 0; i < n; i++)
			{
				if (k.equals(BigInteger.ZERO)) break;
				if (k.mod(two).equals(BigInteger.ONE))
					pos = pos.add(two.pow(n-1 - i));
				k = k.divide(two);
			}		
				
			out.println(pos);
        }
	}
	
//	private void reorder(int[] a, int first, int last)
//	{
//		int[] b = new int[last-first+1];
//		int bind = 0;
//		for (int i = first; i <= last; i += 2)
//			b[bind++] = a[i];
//		for (int i = first+1; i <= last; i += 2)
//			b[bind++] = a[i];
//		for (int i = first; i <= last; i++)
//			a[i] = b[i-first];			
//	}

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
//	    long nextUnsignedLong() {
//	        return Long.parseUnsignedLong(next());
//	    }
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
