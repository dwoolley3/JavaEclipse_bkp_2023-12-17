package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R336_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R336_Div2_B().run();
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
		String sa = in.next();
		String sb = in.next();
		int na = sa.length();
		int nb = sb.length();
		int[] b1Cnt = new int[nb];
		int[] b0Cnt = new int[nb];

		long tot = 0;
		b1Cnt[0] = sb.charAt(0) - '0';
		b0Cnt[0] = '1' - sb.charAt(0);
		for (int i = 1; i < nb; i++) 
		{
			b1Cnt[i] = b1Cnt[i-1] + sb.charAt(i) - '0';
			b0Cnt[i] = b0Cnt[i-1] + '1' - sb.charAt(i);
		}
		
		for (int i = 0; i < na; i++) 
		{
			int a = sa.charAt(i) - '0';
			if (a == 0)
			{
				tot += b1Cnt[nb-na + i];
				if (i > 0) tot -= b1Cnt[i-1];
			}
			else
			{
				tot += b0Cnt[nb-na + i];
				if (i > 0) tot -= b0Cnt[i-1];
			}
		}		
		out.println(tot);		
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
