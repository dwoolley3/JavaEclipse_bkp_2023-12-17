import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dfs_tree_R428_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dfs_tree_R428_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static ArrayList<Integer>[] g;
	static boolean[] used;
	static double totalDist;
	static int root = 1;
	
	@SuppressWarnings("unchecked")
	void solve()
	{
		int n = in.nextInt();

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
		
		//Depth First Search - DFS
		totalDist = 0;
		int v = root, level = 0, parent = -1;
		double prob = 1.0;
		dfs(v, parent, level, prob);
		
		out.println(totalDist);		
	}
	
	private void dfs(int v, int parent, int level, double prob) 
	{
		//In a tree, only need to keep track of parent instead of used[]
		int branches = g[v].size();
		if (v > root) 
			branches--;
		
		for (int y : g[v])
			if (y != parent)
				dfs(y, v, level + 1, prob / branches);
		
		if (branches == 0) // isleaf  
			totalDist += level * prob;
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
