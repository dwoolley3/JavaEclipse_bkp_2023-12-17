package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R234_Div2_C //Name: Inna and Huge Candy Matrix
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R234_Div2_C().run();
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
		int m = in.nextInt();
		int x = in.nextInt(); //rotated clockwise by 90 degrees
		int y = in.nextInt(); //horizontal rotate
		int z = in.nextInt(); //rotated counterclockwise by 90 degrees
		int p = in.nextInt();
		
		x %= 4;
		y %= 2;
		z %= 4;
		
		for (int k = 0; k < p; k++)
		{
			int xk = in.nextInt();
			int yk = in.nextInt();		
			
			int nxk = xk, nyk = yk, len = m, nnew = n, mnew = m;
			if (x == 1)
			{
				nxk = yk;
				nyk = n-xk+1;
				len = n;
				nnew = m;
				mnew = n;
			}
			else if (x == 2)
			{
				nxk = n-xk+1;
				nyk = m-yk+1;
			}
			else if (x == 3)
			{
				nxk = m-yk+1;
				nyk = xk;
				len = n;
				nnew = m;
				mnew = n;
			}	
			
			if (y == 1)
				nyk = len - nyk + 1;
			
			xk = nxk; yk = nyk;
			if (z == 1)
			{
				nxk = mnew-yk+1;
				nyk = xk;
			}
			else if (z == 2)
			{
				nxk = nnew-xk+1;
				nyk = mnew-yk+1;
			}
			else if (z == 3)
			{
				nxk = yk;
				nyk = nnew-xk+1;
			}						
			
			out.println(nxk + " " + nyk);	
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
