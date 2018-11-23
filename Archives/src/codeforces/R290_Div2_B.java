package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R290_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R290_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int cnt = 0;
	char[][] c;
	boolean[][] used;
	int n, m;
	void solve()
	{
		n = in.nextInt();
		m = in.nextInt();		
		c = new char[n][m];
		for (int i = 0; i < n; i++)
		{
			String s = in.next();		
			for (int j = 0; j < m; j++)
				c[i][j] = s.charAt(j);
		}
		
		for (char let = 'A'; let <= 'Z'; let++)
		{
			cnt = 0;
			used = new boolean[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (!used[i][j] && c[i][j] == let)
						if (dfs(let, i, j, -9))
						{
							out.println("Yes");
							return;
						};
		}
		
		out.println("No");		
	}
	
	private boolean dfs(char let, int row, int col, int dir)
	{
		//dir = 0-right,1-up,2-left,3-down
		if (row == n || row == -1 || col == m || col ==-1)
			return false;	

		if(c[row][col] != let) return false;
		if (used[row][col]) return true;
		used[row][col] = true;
		
		boolean found = false;
		for (int d = 0; d < 4; d++)
		{
			if (Math.abs(d - dir) == 2) continue;
			if (d==0)
				found = found || dfs(let, row, col+1, d);
			else if (d == 1)
				found = found || dfs(let, row-1, col, d);
			else if (d == 2)
				found = found || dfs(let, row, col-1, d);
			else if (d == 3)
				found = found || dfs(let, row+1, col, d);
		}
		return found;
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
