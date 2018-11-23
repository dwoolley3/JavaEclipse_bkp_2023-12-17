package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R249_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R249_Div2_C().run();
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
	
		char[][] g = new char[2001][1001];
		for (int i = 0; i < 2001; i++)
			for (int j = 0; j < 1001; j++)
				g[i][j] = ' ';
		int a, r = 1000, c = 0, maxr = 0, minr = 2001;
		maxr = Math.max(maxr, r);
		minr = Math.min(minr, r);
		for (int i = 0; i < n; i++)
		{
			a = in.nextInt();
			if (i % 2 == 0) //up
			{
				for (int j = 0; j < a; j++)
					g[r-j][c+j] = '/';
				r -= (a - 1);
				c += a;
			}
			else //down
			{
				for (int j = 0; j < a; j++)
					g[r+j][c+j] = '\\';
				r += (a - 1);
				c += a;
			}
			maxr = Math.max(maxr, r);
			minr = Math.min(minr, r);
		}
		
		for (int i = minr; i <= maxr; i++)
		{
			for (int j = 0; j < c; j++)
				out.print(g[i][j]);
			out.println();
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
