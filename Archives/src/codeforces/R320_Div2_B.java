package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R320_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R320_Div2_B().run();
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
		int[][] a = new int[2*n+1][2*n+1];
		int[] ans = new int[2*n+1];

		int max = 0, maxi = 0, maxj = 0;
		for (int i = 2; i <= n*2; i++) 
			for (int j = 1; j < i; j++)
			{
				a[i][j] = in.nextInt();
				if (a[i][j] > max)
				{
					max = a[i][j];
					maxi = i; maxj = j;
				}
			}
		ans[maxi] = maxj;
		ans[maxj] = maxi;
		
		for (int k = 1; k < n; k++)
		{
			max = 0;
			for (int i = 2; i <= n*2; i++) 
				for (int j = 1; j < n*2; j++)
				{
					if (ans[i] == 0 && ans[j] == 0 && a[i][j] > max)
					{
						max = a[i][j];
						maxi = i; maxj = j;
					}
				}
			ans[maxi] = maxj;
			ans[maxj] = maxi;
		}

		for (int i = 1; i <= n*2; i++)
			out.print(ans[i] + " ");	
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
