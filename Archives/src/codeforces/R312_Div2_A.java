package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R312_Div2_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R312_Div2_A().run();
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
		
		int last = 100_000 * 2 + 2;
		int[] a = new int[last];
		int neg = 0, pos = 0;
		for (int i = 0; i < n; i++) 
		{			
			int x = in.nextInt();
			a[x + 100_000] = in.nextInt();
			if (x < 0) neg++;
			else pos++;
		}
			
		int sum1 = 0, cntP = 0, cntN = 0;
		int min = Math.min(neg, pos);
		
		for (int i = 100_000; i < last; i++)
			if (a[i] != 0 && cntP < Math.min(min+1,  pos))
			{
				sum1 += a[i];
				cntP++;
			}
		for (int i = 100_000; i >= 0; i--)
			if (a[i] != 0 && cntN < min)
			{
				sum1 += a[i];
				cntN++;
			}
		
		int sum2 = 0;
		cntP = 0; cntN = 0;
		
		for (int i = 100_000; i < last; i++)
			if (a[i] != 0 && cntP < min)
			{
				sum2 += a[i];
				cntP++;
			}
		for (int i = 100_000; i >= 0; i--)
			if (a[i] != 0 && cntN < Math.min(min+1,  neg))
			{
				sum2 += a[i];
				cntN++;
			}
			
		int max = Math.max(sum1, sum2);
		
		out.println(max);		
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
