package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R241_Div2_A //Name: Guess a number!
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R241_Div2_A().run();
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
		
		int max = 2_000_000_000;
		int min = -2_000_000_000;
		for (int i = 0; i < n; i++) 
		{
			String com = in.next();
			int val = in.nextInt();
			String yn = in.next();
			if (yn.equals("N"))
			{
				if (com.equals(">=")) com = "<";
				else if (com.equals("<=")) com = ">";
				else if (com.equals(">")) com = "<=";
				else if (com.equals("<")) com = ">=";
			}
			if (com.equals(">="))
				min = Math.max(min,  val);
			if (com.equals(">"))
				min = Math.max(min,  val+1);		
			if (com.equals("<="))
				max = Math.min(max,  val);
			if (com.equals("<"))
				max = Math.min(max,  val-1);
		}

		if (min <= max)
			out.println(min);
		else
			out.println("Impossible");
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
