package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R345_Ed_R9_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R345_Ed_R9_B().run();
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
		
		int[] p = new int[n];
		long[] preA = new long[n];
		long[] preB = new long[n];
		long[] sufA = new long[n];
		long[] sufB = new long[n];
		for (int i = 0; i < n; i++) 
			p[i] = in.nextInt();
						
		String s = in.next();
		for (int i = 0; i < n; i++)
		{
			if (s.charAt(i) == 'A')
				preA[i] = p[i];
			else
				preB[i] = p[i];
			if (i > 0)
			{
				preA[i] += preA[i-1];
				preB[i] += preB[i-1];
			}

			if (s.charAt(n-1-i) == 'A')
				sufA[i] = p[n-1-i];
			else
				sufB[i] = p[n-1-i];
			if (i > 0)
			{
				sufA[i] += sufA[i-1];
				sufB[i] += sufB[i-1];
			}			
		}
		
		long max = preB[n-1];
		for (int i = 0; i < n; i++)
		{
			max = Math.max(max, preA[i] + ((i<n-1)?sufB[n-2-i]:0));
			max = Math.max(max, sufA[i] + ((i<n-1)?preB[n-2-i]:0));
		}
		
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
