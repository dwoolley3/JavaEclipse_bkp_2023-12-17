package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2015_06_LT_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_06_LT_B().run();
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
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
				
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < n; j++)
					a[i][j] = in.nextInt();
			
			int[][][] row = new int[n][n][n];
			int bits = 0;
			for (int x1 = 0; x1 < n; x1++)
				for (int y1 = 0; y1 < n; y1++)
				{					
					row[x1][y1][y1] = a[x1][y1];
					for (int y2 = y1+1; y2 < n; y2++)
						row[x1][y1][y2] = row[x1][y1][y2-1] ^ a[x1][y2];
				}

			int[][][] col = new int[n][n][n];
			for (int y1 = 0; y1 < n; y1++)
				for (int x1 = 0; x1 < n; x1++)
				{					
					col[y1][x1][x1] = a[x1][y1];
					for (int x2 = x1+1; x2 < n; x2++)
						col[y1][x1][x2] = col[y1][x1][x2-1] ^ a[x2][y1];
				}
			
			int max = 0;
			for (int x1 = 0; x1 < n; x1++)
				for (int x2 = x1; x2 < n; x2++)
					for (int y1 = 0; y1 < n; y1++)
						for (int y2 = y1; y2 < n; y2++)
						{
							if (x2 - x1 <= y2 - y1)
							{
								bits = row[x1][y1][y2];						
								for (int i = x1+1; i <= x2; i++)
									bits ^= row[i][y1][y2];
							}
							else
							{
								bits = col[y1][x1][x2];						
								for (int i = y1+1; i <= y2; i++)
									bits ^= col[i][x1][x2];
							}
							max = Math.max(max,  bits);
						}
			
			out.println(max);	
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
