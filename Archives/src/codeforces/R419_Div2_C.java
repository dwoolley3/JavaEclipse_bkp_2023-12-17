package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R419_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R419_Div2_C().run();
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
		
		int[][] g = new int[n][m];
		int[] rowMin = new int[n];
		int[] colMin = new int[m];
		Arrays.fill(rowMin, 501);
		Arrays.fill(colMin, 501);
				
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < m; j++)
			{			
				g[i][j] = in.nextInt();
				rowMin[i] = Math.min(rowMin[i], g[i][j]);
				colMin[j] = Math.min(colMin[j], g[i][j]);
			}
		
		StringBuilder sb = new StringBuilder();
		int lines = 0;
		
		if (n <= m)
		{
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < rowMin[i]; j++)
				{
					sb.append("row " + (i+1));
					sb.append("\r\n");
					lines++;
				}
				for (int col = 0; col < m; col++)
					g[i][col] -= rowMin[i];
			}
			
			for (int col = 0; col < m; col++) 
			{
				int firstItem = g[0][col];
				boolean same = true;
				for (int row = 1; row < n && same; row++)
					if (g[row][col] != firstItem) same = false;
				
				if (!same)
				{
					out.println(-1);
					return;
				}
					
				for (int j = 0; j < firstItem; j++)
				{
					sb.append("col " + (col+1));
					sb.append("\r\n");
					lines++;
				}					
			}
		}
		else // n > m
		{
			for (int col = 0; col < m; col++) 
			{
				for (int j = 0; j < colMin[col]; j++)
				{
					sb.append("col " + (col+1));
					sb.append("\r\n");
					lines++;
				}
				for (int row = 0; row < n; row++)
					g[row][col] -= colMin[col];
			}
			
			for (int row = 0; row < n; row++) 
			{
				int firstItem = g[row][0];
				boolean same = true;
				for (int col = 1; col < m && same; col++)
					if (g[row][col] != firstItem) same = false;
				
				if (!same)
				{
					out.println(-1);
					return;
				}
					
				for (int j = 0; j < firstItem; j++)
				{
					sb.append("row " + (row+1));
					sb.append("\r\n");
					lines++;
				}					
			}
		}
		
		out.println(lines);
		out.println(sb.toString());		
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
