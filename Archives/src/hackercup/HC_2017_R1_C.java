package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2017_R1_C
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "C_ex";
	final String PROBLEM_NAME = "C";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2017_R1_C().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + "_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + "_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			int kMoves = in.nextInt();
			
			final int INF = (int)1e9;
	        int[][] graph = new int[n+1][n+1];
	        for (int i = 0; i <= n; i++)
	            for (int j = 0; j <= n; j++)
	            	if (i != j)
	            		graph[i][j] = INF;
	        
			for (int i = 0; i < m; i++) 
			{
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				int g = in.nextInt();
				graph[a][b] = g;
				graph[b][a] = g;
			}
			
			int[] s = new int[kMoves];
			int[] d = new int[kMoves];
			for (int i = 0; i < kMoves; i++)
			{
				s[i] = in.nextInt() - 1;
				d[i] = in.nextInt() - 1;
			}

	        //Get Shortest Path from i to j; initially graph[i,j] is
	        //  0 (to self), 1 (connection), or INF (no connection)
	        //Floyd Warshall algorithm
	        for (int k = 0; k < n; k++)
	            for (int i = 0; i < n; i++)
	                for (int j = 0; j < n; j++)
	                    graph[i][j] = Math.min(graph[i][j],
	                        graph[i][k] + graph[k][j]);
						
	        int totalGas = 0;
			int cur = 0;  //1 - 1
			for (int i = 0; i < kMoves; i++)
			{
				if (i == kMoves - 1)
				{
					totalGas += graph[cur][s[i]] + graph[s[i]][d[i]];
					cur = d[i];
				}
				else
				{
					//Using Greedy algorithm; hopefully not needing DP
					int p1 = graph[cur][s[i]] + graph[s[i]][s[i+1]] 
							+ graph[s[i+1]][d[i]] + graph[d[i]][d[i+1]];
					int p2 = graph[cur][s[i]] + graph[s[i]][d[i]]
							+ graph[d[i]][s[i+1]] + graph[s[i+1]][d[i+1]];
					if (p1 < p2) //pickup 2 loads and deliver 2 loads
					{
						totalGas += p1;
						cur = d[i+1];
						i++;
					}
					else  //pick up and deliver next load only
					{
						totalGas += graph[cur][s[i]] + graph[s[i]][d[i]];
						cur = d[i];
					}
				}

				if (totalGas >= INF)
				{
					totalGas = -1;
					break;
				}
				//System.out.println(totalGas);
			}
     	        
			String ans = totalGas + "";
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}

	//-----------------------------------------------------

	
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
