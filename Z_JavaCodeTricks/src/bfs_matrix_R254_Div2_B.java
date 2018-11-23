import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class bfs_matrix_R254_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new bfs_matrix_R254_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[][] edge;
	boolean[] used;
	
	void solve()  {
		int n = in.nextInt();
		int m = in.nextInt();
		edge = new int[n+1][n+1];
		
		for (int i = 1; i <= m; i++)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			edge[u][v] = 1;
			edge[v][u] = 1;
		}
		
		//Breath First Search - BFS
		Queue<Integer> que = new LinkedList<Integer>();
		used = new boolean[n+1];
		int cnt = 0, t;
		for(int i = 1; i <= n; i++)
		{
			if(!used[i])
			{
				cnt++;
				que.add(i);
				while(!que.isEmpty())
				{
					t = que.poll();  //Retrieve and remove from head
					used[t] = true;
					for (int j = 1; j <= n; j++)
						if(edge[t][j] == 1 && !used[j])
							que.add(j);				
				}
			}			
		}
		
		out.println(1L << (n - cnt));
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
