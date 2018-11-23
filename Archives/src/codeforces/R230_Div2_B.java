package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R230_Div2_B //Name: Three matrices
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R230_Div2_B().run();
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

		int[][] w = new int[n][n];
		double[][] a = new double[n][n];
		double[][] b = new double[n][n];
		
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++)
				w[i][j] = in.nextInt();
		
		for (int i = 0; i < n; i++) 
			for (int j = i; j < n; j++)
				if (i == j) 
					a[i][j] = w[i][j];
				else
				{
					double mid = (w[i][j] + w[j][i]) / 2.0;
					a[i][j] = mid;
					a[j][i] = mid;
					b[i][j] = w[i][j] - a[i][j];
					b[j][i] = w[j][i] - a[j][i];
				}
			
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++)
				out.print(a[i][j]+ " ");
			out.println();
		}
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++)
				out.print(b[i][j]+ " ");
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
