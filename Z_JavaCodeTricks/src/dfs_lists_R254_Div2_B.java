import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dfs_lists_R254_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dfs_lists_R254_Div2_B().run();
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
	
	@SuppressWarnings("unchecked")
	void solve()  {
		int n = in.nextInt();
		int m = in.nextInt();
		g = new ArrayList[n+1];
		for (int i = 1; i <= n; ++i) 
			g[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= m; ++i)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			g[u].add(v);
			g[v].add(u);
		}
		used = new boolean[n+1];
		int cnt = 0;
		for (int i = 1; i <= n; ++i) 
			if (!used[i]) 
			{
				cnt++;
				dfs(i);
			}
		
		out.println(1L << (n - cnt));
	}
	
	private void dfs(int v) 
	{
		used[v] = true;
		for (int i = 0; i < g[v].size(); i++)
		{
			int y = g[v].get(i);
			if (!used[y]) 
				dfs(y);			
		}
	}
	
	@SuppressWarnings("unused")
	private void dfs2(int v) 
	{
		used[v] = true;
		for (Integer y : g[v])
			if (!used[y]) 
				dfs(y);			
	}
	
	@SuppressWarnings("unused")
	private void dfs3(int v) 
	{
		if (used[v]) return;
		used[v] = true;
		for (Integer y : g[v])
			dfs(y);
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
