package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R237_Div2_B //Name: Marathon
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R237_Div2_B().run();
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
		double a = in.nextDouble();
		double d = in.nextDouble();
		int n = in.nextInt();
		
		int dir = 0;
		double x = 0, y = 0, dist = 0;
		double rem, sides;
		for (int i = 1; i <= n; i++)
		{
			dist += d;
			sides = Math.floor(dist / a);
			dir += (int)sides;
			dist -= sides * a;
			rem = dist;
			dir = dir%4;
			if (dir == 0)
			{
				x = rem; y = 0;
			}
			else if (dir == 1)
			{
				x = a; y = rem;
			}
			else if (dir == 2)
			{
				x = (a-rem); y = a;
			}
			else //if (dir == 3)
			{
				x = 0; y = (a - rem);
			}
			
			out.println(x + " " + y);
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
