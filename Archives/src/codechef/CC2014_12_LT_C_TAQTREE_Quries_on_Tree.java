package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_12_LT_C_TAQTREE_Quries_on_Tree
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_12_LT_C_TAQTREE_Quries_on_Tree().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{		
		n = in.nextInt();	
		a = new int [n+1][n+1];
		int[] u = new int[n+1];
		int[] v = new int[n+1];
		for (int i = 1; i <= n-1; i++)
		{
			u[i] = in.nextInt();
			v[i] = in.nextInt();
			int w = in.nextInt();
			a[u[i]][v[i]] = w;
			a[v[i]][u[i]] = w;
		}
		int q = in.nextInt();	
		for (int i = 0; i < q; i++)
		{
			int t = in.nextInt();
			if (t == 1)
			{
				int ind = in.nextInt();
				int w = in.nextInt();
				a[u[ind]][v[ind]] = w;
				a[v[ind]][u[ind]] = w;
			} 
			else if (t == 2) 
			{
				uu = in.nextInt();
				vv = in.nextInt();
				//Find the length of path from node uu to vv
				int dist = 0;
				used = new boolean[51][51];
				int atU = uu;
		        dfs(atU, dist);
				out.println(len);
			}
		}	
	}
	int uu, vv, n;
    boolean[][] used;
    int[][] a;
    int len = 0;
    boolean dfs(int atU, int dist)
    {
    	for (int i = 0; i < n; i++)
    		if (i != atU && a[atU][i] > 0 && !used[atU][i])
    		{
    			used[atU][i] = true;
    			used[i][atU] = true;
    			len = dist + a[atU][i];
    			if (i == vv) return true;
    			if (dfs(i, len)) return true;
    		}
        return false;
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
