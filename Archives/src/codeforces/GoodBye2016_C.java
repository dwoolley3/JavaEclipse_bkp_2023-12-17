package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GoodBye2016_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GoodBye2016_C().run();
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
		
		int[] c = new int[n];
		int[] d = new int[n];
		int sum = 0;
		int maxDiv1 = Integer.MIN_VALUE, minDiv1 = Integer.MAX_VALUE;
		int maxDiv2 = Integer.MIN_VALUE, minDiv2 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
		{
			c[i] = in.nextInt();
			d[i] = in.nextInt();
			if (d[i] == 2) 
			{
				if (sum > maxDiv2) maxDiv2 = sum;
				if (sum < minDiv2) minDiv2 = sum;
			}
			else //d[i] == 1
			{
				if (sum > maxDiv1) maxDiv1 = sum;
				if (sum < minDiv1) minDiv1 = sum;
			}
			sum += c[i];
		}
		
		if (minDiv1 <= maxDiv2)
		{
			out.println("Impossible");
			return;
		}
		else if (minDiv2 == Integer.MAX_VALUE)
		{
			out.println("Infinity");
			return;
		}

		int rating = 1899 - maxDiv2 + sum;
      	out.println(rating);
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
