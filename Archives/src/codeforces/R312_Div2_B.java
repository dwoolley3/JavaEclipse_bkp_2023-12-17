package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R312_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R312_Div2_B().run();
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
		
		int[] a = new int[n];
		int[] b = new int[1_000_001];
		int[] c = new int[1_000_001];
		int[] first = new int[1_000_001];
		int[] last = new int[1_000_001];
		int max = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			b[a[i]]++;
			if (b[a[i]] > max) 
			{
				max = b[a[i]];
			}
			if (b[a[i]] == 1)
				first[a[i]] = i;
		}
		
		for (int i = n-1; i >= 0; i--) 
		{
			if (c[a[i]] == 0)
				last[a[i]] = i;
			c[a[i]] = 1;
		}
		
		int minRange = 1_000_001, bestNum = 0;
		for (int i = 1; i < 1_000_001; i++)
		{
			if (b[i] == max)
			{
				if (last[i] - first[i] < minRange)
				{
					minRange = last[i] - first[i];
					bestNum = i;
				}
			}
		}
		
		out.println((first[bestNum]+1) + " " + (last[bestNum]+1));
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
