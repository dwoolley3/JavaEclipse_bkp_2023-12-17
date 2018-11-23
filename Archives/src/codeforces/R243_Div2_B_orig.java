package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R243_Div2_B_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R243_Div2_B_orig().run();
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
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = in.nextInt();
		
		int ans = n;  //if n % 2 == 1
		ArrayList<Integer> pow2 = new ArrayList<Integer>();
		pow2.add(1); pow2.add(2); pow2.add(4); pow2.add(8); pow2.add(16); pow2.add(32); pow2.add(64);
		
		int row = 0;
		for (int r = 1; r <= n; r++)
		{
			if (n % r == 0 && pow2.contains(n/r))
			{
				boolean ok = true;
				for (int i = 0; i < n / r; i++)
					for (int j = 0; j < r; j++)
						for (int k = 0; k < m; k++)
						{
							if (i%2 == 0)
								row = i*r+j;
							else
								row = (i+1)*r-1-j;

							if (a[0+j][k] != a[row][k]) ok = false;
						}
				
				if (ok) {
					ans = r;
					break;
				}		
			}
		}				
		
		out.println(ans);		
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
