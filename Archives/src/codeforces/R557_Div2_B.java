package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R557_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R557_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[][] a;
	int[][] b;
	int n, m;
	
	void solve()
	{
		n = in.nextInt();
		m = in.nextInt();
		
		a = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= m; j++)
				a[i][j] = in.nextInt();
		
		b = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= m; j++) {
				b[i][j] = in.nextInt();
				if (b[i][j] < a[i][j]) {
					int x = a[i][j]; a[i][j] = b[i][j]; b[i][j] = x;
				}
			}
		
		boolean pos = true;
		for (int i = 1; i <= n && pos; i++)
			for (int j = 1; j <= m && pos; j++) {
				pos = check(i,j);
			}
		
		out.println(pos ? "Possible" : "Impossible");		
	}
	
	private boolean check(int r, int c) {
		if (a[r][c-1] < a[r][c] && a[r-1][c] < a[r][c]
		&& b[r][c-1] < b[r][c] && b[r-1][c] < b[r][c]
		&& (c == m || (a[r][c] < a[r][c+1] && b[r][c] < b[r][c+1]))
		&& (r == n || a[r][c] < a[r+1][c]  && b[r][c] < b[r+1][c]))
		return true;
		
		return false;
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
