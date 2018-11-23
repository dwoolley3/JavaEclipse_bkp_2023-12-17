import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class PartialSums_poj_1050
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new PartialSums_poj_1050().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[][] summ;
	
	void solve()
	{
		int n = in.nextInt();
		int max = Integer.MIN_VALUE;
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		
		//Compute Partial sums of all cells included in rectangle from 1,1 to i,j
		summ = new int[n+1][n+1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				summ[i][j] = summ[i-1][j] + summ[i][j-1] - summ[i-1][j-1]
						+ a[i-1][j-1];
		
		for (int c1 = 1; c1 <= n-1; c1++)
			for (int c2 = c1+1; c2 <= n; c2++)
				for (int r1 = 1; r1 <= n-1; r1++)
					for (int r2 = r1+1; r2 <= n; r2++)
					{
						max = Math.max(max,  getSum(c1, r1, c2, r2));
					}
		
		out.println(max);
	}
	
	private int getSum(int c1, int r1, int c2, int r2)
	{
		int sum = summ[r2][c2] - summ[r1-1][c2] - summ[r2][c1-1]
				+ summ[r1-1][c1-1];
		return sum;
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
