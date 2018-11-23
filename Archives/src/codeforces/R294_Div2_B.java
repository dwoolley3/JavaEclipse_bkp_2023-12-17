package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R294_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R294_Div2_B().run();
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
		long sum1 = 0, sum2 = 0, sum3 = 0;
		for (int i = 0; i < n; i++) sum1 += in.nextInt();
		for (int i = 0; i < n-1; i++) sum2 += in.nextInt();
		for (int i = 0; i < n-2; i++) sum3 += in.nextInt();
		out.println(sum1 - sum2);
		out.println(sum2 - sum3);
		
		//alternativeSolution(n);
	}

	@SuppressWarnings("unused")
	private void alternativeSolution() {
		//Alternative (and original correct submission):
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		Arrays.sort(a);
		
		int[] b = new int[n-1];
		for (int i = 0; i < n-1; i++) 
			b[i] = in.nextInt();		
		Arrays.sort(b);
		
		boolean found = false;
		for (int i = 0; i < n-1; i++)
			if (a[i] != b[i])
			{
				out.println(a[i]);
				found = true;				
				break;
			}
		
		if (!found)
			out.println(a[n-1]);			
		
		int[] c = new int[n-2];
		for (int i = 0; i < n-2; i++) 
			c[i] = in.nextInt();		
		Arrays.sort(c);
		
		found = false;
		for (int i = 0; i < n-2; i++)
			if (b[i] != c[i])
			{
				out.println(b[i]);
				found = true;
				break;
			}

		if (!found)
			out.println(b[n-2]);
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
