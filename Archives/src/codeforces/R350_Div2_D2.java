package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R350_Div2_D2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R350_Div2_D2().run();
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
		int k = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();	
		
		int[] b = new int[n];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) 
		{
			b[i] = in.nextInt();
			min = Math.min(min,  b[i] / a[i]);
		}
		
		//Find the highest value for which check() is ok
		int lo = min, hi = min + k + 1, mid;
		while (lo < hi)
		{
			mid = lo + (hi - lo + 1) / 2;
			if (check(mid, n, k, a, b))
				lo = mid;
			else
				hi = mid - 1;
		}
		
		out.println(lo);		
	}
	
	private boolean check(int mid, int n, int k,  int[] a, int[] b)
	{
		long need = 0;
		for (int i = 0; i < n; i++)
		{
			long x = 1L * mid * a[i];		
			need += Math.max(x - b[i], 0);
			if (need > k) break;  //Prevent overflow
		}
		return need <= k;		
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
