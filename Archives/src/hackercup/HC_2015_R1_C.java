package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2015_R1_C
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "C_ex";
	final String PROBLEM_NAME = "C";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2015_R1_C().runWithFiles();
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
		int MOD = 1_000_000_007;
		
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			String[] s = in.next().split("-");
			int sc1 = Integer.parseInt(s[0]);
			int sc2 = Integer.parseInt(s[1]);
			//System.out.println(sc1 + " " + sc2);
			
			// Calculate number of ways for stressful victory
			int n = sc2+2;
			int m = sc2+2;
			int[][] dp = new int[n+1][m+1];
		    for (int i = 0; i < n; i++)       
		    	dp[i][0] = 1; 

		    dp[1][0] = 1;
		    for (int i = 1; i < n; i++)
		    	for (int j = i; j < m; j++)
		    		dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
		    
		    int ans2 = dp[n-1][m-1];
		    
		    // Calculate number of ways for stress-free victory
			n = sc1;
			m = sc2;
			dp = new int[n+1][m+1];
		    for (int r = 0; r < n-m; r++) 
		    	dp[r][0] = 1;
		    for (int c = 0; c <= m; c++) 
		    	dp[0][c] = 1;
			
		    for (int r = 1; r <= n; r++)
		    	for (int c = 1; c <= m; c++)
		    		if (r < n-m + c || (r == n && c == m))
		    			dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % MOD;		    
		    
		    //p(dp);
		    int ans1 = dp[n][m];
		    if (sc2 == 0) ans1 = 1;
		    
			String ans = ans1 + " "  + ans2;
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	public void p(Object ...o) {System.out.println(Arrays.deepToString(o));}

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
