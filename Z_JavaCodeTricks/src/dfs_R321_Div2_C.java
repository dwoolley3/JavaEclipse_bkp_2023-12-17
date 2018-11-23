import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dfs_R321_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dfs_R321_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[] a;
	ArrayList<Integer>[] g;
	boolean[] used;
	int[] cats;
	int res;
	int n,m,cntCats;
	
	@SuppressWarnings("unchecked")
	void solve()
	{
		n = in.nextInt();
		m = in.nextInt();
		
		a = new int[n+1];
		for (int i = 0; i < n; i++) 
			a[i+1] = in.nextInt();
		
		g = new ArrayList[n+1];
		for (int i = 1; i <= n; ++i) 
			g[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= n-1; ++i)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			g[u].add(v);
			g[v].add(u);
		}
		used = new boolean[n+1];
		cats = new int[n+1];
		res = 0;
		cntCats = 0;
		cats[1] = a[1];
		dfs(1);
		
		out.println(res);		
	}
	
	private void dfs(int v) 
	{
		used[v] = true;
		for (int i = 0; i < g[v].size(); i++)
		{
			int y = g[v].get(i);
			if (!used[y]) 
			{
				if (a[y] == 0)
					cats[y] = 0;
				else
					cats[y] = cats[v] + 1;

				if (cats[y] <= m)
					dfs(y);
			}
		}
		if (g[v].size() == 1 && v != 1) //leaf
			res++;
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
