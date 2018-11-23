import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class recurse_CC2017_08_LT_C_MATTEG2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new recurse_CC2017_08_LT_C_MATTEG2().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static int maxScore = 0;
	static int[][] b;
	static int[] dx;
	static int[] dy;
	static int r, c, n, nfact;
	
	void solve()
	{
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
        	r = in.nextInt();
        	c = in.nextInt();
			n = in.nextInt();	
			int sx = in.nextInt();
			int sy = in.nextInt();
			
			dx = new int[n];
			dy = new int[n];
			for (int i = 0; i < n; i++) 
				dx[i] = in.nextInt();
			for (int i = 0; i < n; i++) 
				dy[i] = in.nextInt();
			
			b = new int[r][c];
			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++)
					b[i][j] = in.nextInt();
						
			int[] per = generateInitialPermutation(n);  //Initial = 0,1,...n-1
			nfact = per.length;
			
			maxScore = 0;
			do {
				getScore(per, 0, 0, sx, sy);

			} while (next_permutation(per));  //next in lexicographical order
			
			out.println(maxScore);	
        }		
	}
	
	private void getScore(int[] per, int ind, int score, int x, int y)
	{
		if (x < 0 || x >= r || y < 0 || y >= c) return;		
		score += b[x][y];
		maxScore = Math.max(score, maxScore);
		if (ind == nfact) return;
		
		getScore(per, ind+1, score, x + dx[per[ind]], y + dy[per[ind]]);
		getScore(per, ind+1, score, x + dx[per[ind]], y - dy[per[ind]]);
		getScore(per, ind+1, score, x - dx[per[ind]], y + dy[per[ind]]);
		getScore(per, ind+1, score, x - dx[per[ind]], y - dy[per[ind]]);		
	}
	
	public int[] generateInitialPermutation(int size)
	{
		int[] p = new int[size];
		for (int i = 0; i < size; i++) p[i] = i;
		return p;
	}
	
	public boolean next_permutation(int[] p) 
	{
		// 0,1,2 -> 0,2,1 -> 1,0,2 -> 1,2,0 -> 2,0,1 -> 2,1,0
		int t, n = p.length;
		for (int i = n - 2; i >= 0; i--)
		    if (p[i] < p[i + 1])
		    	for (int j = n - 1;; j--)
		    		if (p[j] > p[i]) 
		    		{
		    			t = p[i]; p[i] = p[j];  p[j] = t;
				        for (i++, j = n - 1; i < j; i++, j--) 
				        {
				        	t = p[i]; p[i] = p[j]; p[j] = t;
				        }
				        return true;
		    		}
		 return false;  //p is last lexicographically, e.g. -> 2, 1, 0
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
