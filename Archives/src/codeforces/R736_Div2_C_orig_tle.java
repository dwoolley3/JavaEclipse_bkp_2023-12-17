package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R736_Div2_C_orig_tle
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R736_Div2_C_orig_tle().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//static ArrayList<Integer>[] g;
	static PriorityQueue<Integer>[] pq; 
	static boolean[] killed;
	
	@SuppressWarnings("unchecked")
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		//g = new ArrayList[n+1];
		pq = new PriorityQueue[n+1];
		PriorityQueue<Integer>[] pqStore = new PriorityQueue[n+1];
		killed = new boolean[n+1];
		for (int i = 1; i <= n; ++i)  
			//g[i] = new ArrayList<Integer>();
			pq[i] = new PriorityQueue<Integer>();
		
		TreeSet<Integer> groups = new TreeSet<>();
		for (int i = 1; i <= m; ++i)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			//g[u].add(v);
			//g[v].add(u);
			pq[u].add(v);
			pq[v].add(u);
			groups.add(v); 
			groups.add(u);
		}
		
		for (int i = 1; i <= n; i++) {
			pqStore[i] = pq[i];		// Does not work as intended
		}				

		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int f = in.nextInt();
			if (f == 1) {
				int u = in.nextInt();
				int v = in.nextInt();
				pq[u].add(v);
				pq[v].add(u);
				groups.add(v); 
				groups.add(u);
			} else if (f == 2) {
				int u = in.nextInt();
				int v = in.nextInt();
				pq[u].remove(v);
				pq[v].remove(u);
				if (pq[u].size() == 0) {
					groups.remove(u); 
				}
				if (pq[v].size() == 0) {
					groups.remove(v); 
				}
			} else { // f==3
				while (groups.size() > 0) {
					ArrayList<Integer> toBeKilled = new ArrayList<>();
					for (int j = 1; j <= n; j++) {
						if (!killed[j]) {
							if (pq[j].size() > 0 && pq[j].peek() > j) {
								toBeKilled.add(j);
							}
						}
					}
					for (int j : toBeKilled) {
						killed[j] = true;
						while (pq[j].size() > 0) {
							int x = pq[j].poll();
							if (pq[j].contains(x))
								pq[j].remove(x);
							if (pq[x].contains(j))
								pq[x].remove(j);
							if (pq[x].size() == 0) {
								groups.remove(x);
							}
						}
						groups.remove(j);
					}
				} // end while
				
				int alive = 0;
				for (int j = 1; j <= n; j++) {
					if (!killed[j]) alive++;
				}
				out.println(alive);
				
				groups = new TreeSet<>();
				for (int j = 1; j <= n; j++) {
					pq[j] = pqStore[j];		// does not work as intended
					if (pq[j].size() > 0) groups.add(j);
				}
			}
		}
		
		//Breath First Search - BFS
//		Queue<Integer> que = new LinkedList<Integer>();
//		used = new boolean[n+1];
//		int cnt = 0, t;
//		for(int i = 1; i <= n; i++)
//		{
//			if(!used[i])
//			{
//				cnt++;
//				que.add(i);
//				while(!que.isEmpty())
//				{
//					t = que.poll();
//					used[t] = true;
//					for (int j = 1; j <= n; j++)
//						if(g[t].contains(j) && !used[j])
//							que.add(j);				
//				}
//			}			
//		}
//		
//		out.println(1L << (n - cnt));
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
