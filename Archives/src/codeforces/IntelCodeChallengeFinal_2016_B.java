package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class IntelCodeChallengeFinal_2016_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new IntelCodeChallengeFinal_2016_B().run();
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
		int[] o = new int[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				a[i][j] = in.nextInt();
				if (a[i][j] != j+1) o[i]++;
			}
		boolean ok = true;
		for (int i = 0; i < n; i++)
			if (o[i] != 0 && o[i] != 2) ok = false;
		
		if (!ok)		
			for (int c1 = 0; c1 < m && !ok; c1++)
				for (int c2 = c1+1; c2 < m && !ok; c2++)
				{		
					//swap col c1 and c2			
					ok = true;
					for (int r = 0; r < n; r++)
					{
						if (a[r][c2] == c2 + 1) o[r]++;
						if (a[r][c1] == c1 + 1) o[r]++;
						if (a[r][c1] == c2 + 1) o[r]--;
						if (a[r][c2] == c1 + 1) o[r]--;
						if (o[r] != 0 && o[r] != 2) ok = false;
						
						if (a[r][c2] == c2 + 1) o[r]--;
						if (a[r][c1] == c1 + 1) o[r]--;
						if (a[r][c1] == c2 + 1) o[r]++;
						if (a[r][c2] == c1 + 1) o[r]++;
					}				
				}
				
		out.println(ok ? "YES" : "NO");		
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
