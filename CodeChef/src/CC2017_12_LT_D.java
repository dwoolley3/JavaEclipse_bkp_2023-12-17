import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_12_LT_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_12_LT_D().run();
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
	int ans = 0, sum = 0;
	int[][] m;
	int U;
	int V;
	boolean gotAnswer = false;
	int[] x;
	int[] y;
	int n;
	
	@SuppressWarnings("unchecked")
	void solve()
	{
        int T = 1;
        for (int t = 0; t < T; t++)
        {
			n = in.nextInt();	
			int q = in.nextInt();
			
			g = new ArrayList[n+1];
			for (int i = 1; i <= n; ++i) 
				g[i] = new ArrayList<Integer>();
			
			m = new int[n+1][n+1];
			for (int i = 1; i <= n-1; ++i)
			{
				int u = in.nextInt();
				int v = in.nextInt();
				int c = in.nextInt();
				m[u][v] = c;
				m[v][u] = c;
				g[u].add(v);
				g[v].add(u);
			}

			int last = 0;
			x = new int[4];
			y = new int[4];
			gotAnswer = false;
			for (int i = 0; i < q; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					x[j] = in.nextInt() + last;
					y[j] = in.nextInt() + last;
				}
				used = new boolean[n+1];
				ans = 0;
				U = x[0]; V = y[0];
				
				dfs(0,U);
				
				out.println(ans);
				last = ans;
			}
        }		
	}
	
	private void dfs(int u, int v) 
	{		
		used[v] = true;
		if (gotAnswer) return;
		
		int c = m[u][v];
		if (c == 0) c = 7; //not divisible by 2,3,5
		if (c % 2 == 0 && x[1] <= c && c <= y[1])
			sum += m[u][v];
		else if (c % 3 == 0 && x[2] <= c && c <= y[1])
			sum += m[u][v];
		else if (c % 5 == 0 && x[3] <= c && c <= y[3])
			sum += m[u][v];
		
		if (v == V) {
			gotAnswer = true;
			ans = sum;
			return;
		}
		for (int i = 0; i < g[v].size(); i++)
		{
			int y = g[v].get(i);
			if (!used[y]) 
			{
				dfs(v, y);
			}
		}
		if (!gotAnswer) {
			used[v] = false; 
			sum -= m[u][v];
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
