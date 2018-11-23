import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dp_rectangle_R427_Div2_C2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dp_rectangle_R427_Div2_C2().run();
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
		
		int[][][] xy = new int[101][101][c+1];
		for (int i = 0; i < n; i++) 
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int s = in.nextInt();
			for (int j = 0; j <= c; j++)
				xy[x][y][j] += ((s + j) % (c+1));
		}
		
		int[][][] ans2 = new int[101][101][c+1];
		for (int x = 1; x <= 100; x++)
			for (int y = 1; y <= 100; y++)
				for (int t = 0; t <= c; t++)
				{
					ans2[x][y][t] = ans2[x][y-1][t] + ans2[x-1][y][t]
								  - ans2[x-1][y-1][t] + xy[x][y][t];
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
			
			int ans = ans2[x2][y2][t] - ans2[x1-1][y2][t] - ans2[x2][y1-1][t] + ans2[x1-1][y1-1][t];
			
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
