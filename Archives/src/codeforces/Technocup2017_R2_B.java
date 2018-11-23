package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Technocup2017_R2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Technocup2017_R2_B().run();
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
		
		int[][] a = new int[n][m];
		int[][] left = new int[n][m];
		int[][] right = new int[n][m];
		int[][] up = new int[n][m];
		int[][] down = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				a[i][j] = in.nextInt();
				right[i][j] = a[i][j];
				if (j > 0) right[i][j] |= right[i][j-1];
				down[i][j] = a[i][j];
				if (i > 0) down[i][j] |= down[i-1][j];
			}
		
		for (int i = n-1; i >= 0; i--)
			for (int j = m-1; j >= 0; j--)
			{
				left[i][j] = a[i][j];
				if (j < m-1) left[i][j] |= left[i][j+1];
				up[i][j] = a[i][j];
				if (i < n-1) up[i][j] |= up[i+1][j];
			}
		
		int good = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (a[i][j] == 0)
					good += right[i][j] + left[i][j] + up[i][j] + down[i][j];
		
		out.println(good);		
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
