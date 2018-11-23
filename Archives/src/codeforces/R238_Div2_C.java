package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R238_Div2_C //Name: Unusual Product
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R238_Div2_C().run();
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
		
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		
		int p = 0;
		for (int i = 0; i < n; i++)			
			for (int j = 0; j < n; j++)
				p += a[i][j] * a[j][i];
		p %= 2;
		
		int m = in.nextInt();
		@SuppressWarnings("unused")
		int q, rc;
		for (int t = 0; t < m; t++)
		{
			q = in.nextInt();
			if (q <= 2)
			{
				rc = in.nextInt() - 1;
				p = 1-p;
			}
			else //q== 3
				out.print(p);
		}
		
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
