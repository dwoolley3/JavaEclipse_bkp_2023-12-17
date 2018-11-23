package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2016_QR_D
{	
	FastReader in;
	PrintWriter out;
	final String PROBLEM_NAME = "D_ex";
	//final String PROBLEM_NAME = "D";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2016_QR_D().runWithFiles();
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
	
	static final int INF = 1_000_000_000;
	static int n;
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			n = in.nextInt();
			int kk = in.nextInt();
			
			int[][] g = new int[n+1][n+1];
			String[] s = new String[n+1];
			s[0] = "";
			for (int i = 1; i <= n; i++) 
				s[i] = in.next();
			
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= n; j++)
					if (i == j) g[i][j] = INF;
					else
					{
						int leni = s[i].length();
						int lenj = s[j].length();
						if (leni == 0)
							g[i][j] = lenj + 1; //print first word
						else if (lenj == 0)
							g[i][j] = leni;  //delete last word
						else
						{
							int common = 0;
							int min = Math.min(leni,lenj);
							while (common < min && s[i].charAt(common) == s[j].charAt(common))
								common++;
							g[i][j] = (leni - common) + (lenj - common) + 1;
						}
					}
			
			int ans = 0;
			
			for (int i = 0; i <= n; i++)
			{
				for (int j = 0; j <= n; j++)
					System.out.print(g[i][j] + " ");
				System.out.println();
			}
			
			int minSp = INF, sp;
	        //for (int u = 0; u < n; u++)
	        	//for (int v = 0; v < n; v++)
				int u = 0, v = 0;
	        	{
	        		//if (u==v) continue;
	        		if (kk >= 1) sp = shortestPath(g, u, v, kk+1);
	        		else sp = 0;
	        		//sp += s[u].length() + 1 + s[v].length();
	        		minSp = Math.min(minSp, sp);
			        System.out.println(u + " " + v + " = " + sp);
	        	}
	        
	        ans = minSp;
			
	        // Floyd-Warshall - find shortest path
//	        for (int k = 0; k < n; k++)
//	            for (int i = 0; i < n; i++)
//	                for (int j = 0; j < n; j++)
//	                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
//			
//	        System.out.println();
//			for (int i = 0; i < n; i++)
//			{
//				for (int j = 0; j < n; j++)
//					System.out.print(g[i][j] + " ");
//				System.out.println();
//			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
			//out.printf("Case #%d: %d\n", tc, ans);
		}
	}
	
    // with k edges
    static int shortestPath(int graph[][], int u, int v, int k)
    {
        // Table to be filled up using DP. The value sp[i][j][e] will store
        // weight of the shortest path from i to j with exactly k edges
        int[][][] sp = new int[n+1][n+1][k+1];
     
        // Loop for number of edges from 0 to k
        for (int e = 0; e <= k; e++)
        {
            for (int i = 0; i <= n; i++)  // for source
            {
                for (int j = 0; j <= n; j++) // for destination
                {
                    // initialize value
                    sp[i][j][e] = INF;
     
                    // from base cases
                    if (e == 0 && i == j)
                        sp[i][j][e] = 0;
                    if (e == 1 && graph[i][j] != INF)
                        sp[i][j][e] = graph[i][j];
     
                    //go to adjacent only when number of edges is more than 1
                    if (e > 1)
                    {
                        for (int a = 1; a <= n; a++)
                        {
                            // There should be an edge from i to a and a 
                            // should not be same as either i or j
                            if (graph[i][a] != INF && i != a &&
                                j!= a && sp[a][j][e-1] != INF)
                              sp[i][j][e] = Math.min(sp[i][j][e], graph[i][a] +
                            		  sp[a][j][e-1]);
                        }
                    }
               }
            }
        }
        return sp[u][v][k];
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
