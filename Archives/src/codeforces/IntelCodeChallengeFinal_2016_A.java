package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class IntelCodeChallengeFinal_2016_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new IntelCodeChallengeFinal_2016_A().run();
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
		String[] d = {"sunday", "monday", "tuesday", "wednesday",
				"thursday", "friday", "saturday"};
		//int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		String d1 = in.next();
		String d2 = in.next();
		
		int i1 = 0, i2 = 0;
		for (int i = 0; i < 7; i++)
		{
			if (d[i].equals(d1)) i1 = i;
			if (d[i].equals(d2)) i2 = i;
		}
		
		boolean ok = false;
		if ((i1 + 28) % 7 == i2) ok = true;
		if ((i1 + 30) % 7 == i2) ok = true;
		if ((i1 + 31) % 7 == i2) ok = true;
		
		out.println(ok ? "YES" : "NO");		
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
