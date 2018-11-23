package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R360_Div2_C_bipartite
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R360_Div2_C_bipartite().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static ArrayList<Integer>[] g;
	//static boolean[] used;
	
	@SuppressWarnings("unchecked")
	void solve()
	{
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
		
		//Breath First Search - BFS
		boolean bipartite = true;
		int[] color = new int[n+1];  //1 = Pari, -1 = Arya
		
		for(int i = 1; i <= n; i++)
		{
			if(color[i] == 0)
			{			
				Queue<Integer> que = new LinkedList<Integer>();
				que.add(i);				
				color[i] = -1;
				
				while(!que.isEmpty())
				{
					int t = que.poll();
					for (int j : g[t])	
						if (color[j] == 0)
						{
							color[j] = -1 * color[t];
							que.add(j);		
						}
						else if (color[j] != -1 * color[t])
						{
							bipartite = false;
						}
				}
			}			
		}
		
		if (bipartite)
		{
			int cnt = 0;
			for (int i = 1; i <= n; i++)
				if (color[i] == 1) cnt++;
			out.println(cnt);
			for (int i = 1; i <= n; i++)
				if (color[i] == 1) 
					out.print(i + " ");
			out.println();
			
			out.println(n - cnt);
			for (int i = 1; i <= n; i++)
				if (color[i] == -1) 
					out.print(i + " ");
			out.println();
		}
		else
			out.println(-1);		
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
