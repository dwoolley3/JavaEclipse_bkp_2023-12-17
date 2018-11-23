package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R368_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R368_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair
	{
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}		
	}
	
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		@SuppressWarnings("unchecked")
		ArrayList<Pair>[] al = new ArrayList[n+1];
			for (int i=1;i<=n;i++) 
				al[i] = new ArrayList<Pair>();
		
		int u,v,L;
		Pair p;
		for (int i = 0; i < m; i++)
		{
			u = in.nextInt();
			v = in.nextInt();
			L = in.nextInt();
			p = new Pair(v,L);
			al[u].add(p);
			p = new Pair(u,L);
			al[v].add(p);
		}

		int[] flour = new int[n+1];
		for (int i = 0; i < k; i++)
		{
			int a = in.nextInt();
			flour[a] = 1;		
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++)
			if (flour[i] == 0)
				for (Pair pr : al[i])
				{		
					if (flour[pr.a] == 1)
						ans = Math.min(ans, pr.b);
				}
		
		if (ans == Integer.MAX_VALUE) ans = -1;
		
		out.println(ans);		
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
