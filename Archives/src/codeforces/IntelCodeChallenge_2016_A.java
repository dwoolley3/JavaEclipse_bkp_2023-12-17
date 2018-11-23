package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class IntelCodeChallenge_2016_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new IntelCodeChallenge_2016_A().run();
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
		int f = in.nextInt();
		String s = in.next();
		int h1 = s.charAt(0) - '0';
		int h2 = s.charAt(1) - '0';
		int m1 = s.charAt(3) - '0';
		int m2 = s.charAt(4) - '0';
				
		if (f == 12)
		{
			if (h1 == 0 && h2 == 0) h2 = 1;
			if (h1 > 1) 
				if (h2 == 0) h1 = 1; else h1 = 0;
			if (h1 == 1 && h2 > 2) h2 = 1;
			if (m1 > 5) m1 = 1;
		} else //f == 24
		{
			if (h1 > 2) h1 = 0;
			if (h1 == 2 && h2 > 3) h2 = 1;
			if (m1 > 5) m1 = 1;
		}
		
		out.println(h1 + "" + h2 + ":" + m1 + "" + m2);		
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
