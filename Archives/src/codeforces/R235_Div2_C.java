package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R235_Div2_C //Name: Team
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R235_Div2_C().run();
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
		int zeros = in.nextInt();
		int ones = in.nextInt();
		
		if (zeros == ones)
			for (int i = 0; i < zeros; i++)
				out.print("01");
		else if (zeros == ones + 1)
		{
			for (int i = 0; i < ones; i++)
				out.print("01");
			out.print("0");
		}		
		else if ((zeros+1)*2 >= ones && ones >= (zeros-1))
		{
			int num = ones / (zeros + 1);
			int rem = ones % (zeros + 1);
			if (num == 2 && rem == 0) rem = (zeros + 1);			
			for (int i = 0; i < zeros; i++)
				if (i < rem)
					out.print("110");
				else
					out.print("10");
			if (rem == zeros + 1)
				out.print("11");
			else
				out.print("1");
		}
		else			
			out.print(-1);
		out.println();
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
