import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dfs_Ed_2017_R33_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dfs_Ed_2017_R33_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	ArrayList<Integer>[] g;
	boolean[] used;
	int min;
	int[] c;
	
	@SuppressWarnings("unchecked")
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		
		c = new int[n+1];
		for (int i = 1; i <= n; i++) 
			c[i] = in.nextInt();
		
		g = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) 
			g[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) { 
			int x = in.nextInt();
			int y = in.nextInt();
			g[x].add(y);
			g[y].add(x);
		}
		
		used = new boolean[n+1];
		long spend = 0;
		for (int i = 1; i <= n; ++i) 
			if (!used[i]) 
			{
				min = c[i];
				dfs(i);
				spend += min;
			}

		out.println(spend);	
	}
	
	private void dfs(int v) 
	{
		used[v] = true;
		min = Math.min(min, c[v]);
		for (int i = 0; i < g[v].size(); i++)
		{
			int y = g[v].get(i);
			if (!used[y]) 
				dfs(y);			
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
