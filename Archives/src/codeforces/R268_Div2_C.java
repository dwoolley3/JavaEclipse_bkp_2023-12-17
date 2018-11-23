package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R268_Div2_C //Name: 24 Game
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R268_Div2_C().run();
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
		if (n < 4)
		{
			out.println("NO");
			return;
		}
		
		out.println("YES");
		if (n == 4)
		{
			out.println("3 * 4 = 12");
			out.println("12 * 2 = 24");
			out.println("24 * 1 = 24");
		}
		else if (n == 5)
		{
			out.println("5 * 4 = 20");
			out.println("2 - 1 = 1");
			out.println("3 + 1 = 4");
			out.println("20 + 4 = 24");
		}
		else
		{
			out.println("5 - 3 = 2");
			out.println("2 - 2 = 0");
			out.println("1 * 0 = 0");
			
			for(int i = 7; i <= n; i++)
				out.println(i + " * 0 = 0");

			out.println("4 * 6 = 24");
			out.println("24 + 0 = 24");
		}	
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
