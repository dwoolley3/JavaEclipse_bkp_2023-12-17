package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R427_Div2_C_TLE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R427_Div2_C_TLE().run();
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
		int q = in.nextInt();
		int c = in.nextInt();  //c 1 to 10, max brightness
		
		//int[] x = new int[n];
		//int[] y = new int[n];
		//int[] s = new int[n];  //initial brightness
		int[][][] xy = new int[101][101][c+1];
		for (int i = 0; i < n; i++) 
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int s = in.nextInt();
			for (int j = 0; j <= c; j++)
				xy[x][y][j] += ((s + j) % (c+1));
		}
		
		for (int i = 0; i < q; i++)
		{
			int t = in.nextInt();
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			if (x1 > 100) x1 = 100;
			if (y1 > 100) y1 = 100;
			if (x2 > 100) x2 = 100;
			if (y2 > 100) y2 = 100;
			t = t % (c+1);
			
			int ans = 0;
			for (int x = x1; x <= x2; x++)
				for (int y = y1; y <= y2; y++)
				{
					ans += xy[x][y][t];
				}
			
			out.println(ans);
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
