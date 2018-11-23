package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R277_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R277_Div2_B().run();
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
		int rows = in.nextInt();
		int cols = in.nextInt();
		
		int[][] b = new int[rows][cols];
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < cols; j++) 
				b[i][j] = in.nextInt();
		
		int[][] a = new int[rows][cols];
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < cols; j++) 
			{
				boolean one = false, zero = false; 
			
				for (int r = 0; r < rows; r++)
					if (b[r][j] == 1) one = true;
					else zero = true;
				for (int c = 0; c < cols; c++)
					if (b[i][c] == 1) one = true;
					else zero = true;
				
				if (one && !zero)
					a[i][j] = 1;
			}
		
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < cols; j++) 
				if (b[i][j] == 1)
				{
					boolean ok = false;
					for (int r = 0; r < rows; r++)
						if (a[r][j] == 1) ok = true;
					for (int c = 0; c < cols; c++)
						if (a[i][c] == 1) ok = true;
					if (!ok)
					{
						out.println("NO");
						return;
					}
				}
				
		out.println("YES");
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
				out.print(a[i][j] + " ");
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
