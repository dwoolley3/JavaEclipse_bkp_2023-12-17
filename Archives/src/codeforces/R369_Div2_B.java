package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R369_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R369_Div2_B().run();
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
		
		long[][] a = new long[n][n];
		long[] c = new long[n];
		long[] r = new long[n];
		int row = -1, col = -1;
		long maindiag = 0, secdiag = 0;
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
			{
				a[i][j] = in.nextInt();
				if (a[i][j] == 0)
				{
					row = i;
					col = j;
				}
				else
				{
					r[i] += a[i][j];
					c[j] += a[i][j];
					if (i == j) maindiag += a[i][j];
					if (i == n-1-j) secdiag += a[i][j];
				}
			}
		
		if (n == 1) // && row == 0 && col == 0) 
		{
			out.println(1);
			return;
		}
		
		//pick column for standard sum that does not contain 0
		long sum = 0;
		if (col == 0) sum = c[1]; else sum = c[0];
		long missing = sum - c[col];
		
		boolean ok = (missing > 0);		
		if (ok)
		{
			c[col] += missing;
			r[row] += missing;
			if (row == col)
				maindiag += missing;
			if (row == n-1 - col)
				secdiag += missing;			

			for (int i = 0; i < n && ok; i++) 
				if (r[i] != sum || c[i] != sum) ok = false;
			if (maindiag != sum || secdiag != sum) ok = false;
		}
		
		if (!ok) missing = -1;
		out.println(missing);		
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
