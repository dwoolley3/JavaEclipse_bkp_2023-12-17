import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class x_R385_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new x_R385_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	boolean[] used;
	int numConnected;
	boolean containsGov;
	boolean[] isGov;
	int[][] g;
	
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		used = new boolean[n+1];
		
		isGov = new boolean[n+1];
		for (int i = 0; i < k; i++)
			isGov[in.nextInt()] = true;		
		
		g = new int[n+1][n+1];
		for (int i = 0; i < m; i++) 
		{
			int u = in.nextInt();
			int v = in.nextInt();
			g[u][v] = 1;
			g[v][u] = 1;
			used[u] = true;
			used[v] = true;
		}

		used = new boolean[n+1];
		int cnt = 0, maxConnected = 0;		
		int loose = 0;
		for(int i = 1; i <= n; i++)
		{
			if(!used[i])
			{
				containsGov = false;
				numConnected = 0;
				dfs(i);
				if (containsGov)
				{
					maxConnected = Math.max(maxConnected, numConnected);
					cnt += numConnected * (numConnected - 1) / 2;					
				}
				else
					loose += numConnected;
				//out.println(i + " " + numConnected + " " + maxConnected + " " + containsGov + " ");
			}	
		}
		
		cnt += loose * maxConnected;
		
		out.println(cnt - m);		
	}
	
	private void dfs(int v)
	{
		used[v] = true;
		if (isGov[v]) containsGov = true;
		numConnected++;
		for (int w = 1; w < g.length; w++) //: adj[v])
			if (g[v][w] == 1)
				if (!used[w])
					dfs(w);
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
