package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R286_Div2_C_qwerty787788
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R286_Div2_C_qwerty787788().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//Solution by qwerty787788
	void solve()
	{
		int n = in.nextInt();
		int d = in.nextInt();
		final int MAX_X = 30000 + 10;
		final int MAX = 333;
		int[] have = new int[MAX_X];
		int[][] dp = new int[MAX * 2][MAX_X];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < n; i++) {
			have[in.nextInt()]++;
		}
		dp[MAX][d] = have[d];
		int result = 0;
		for (int time = 0; time < MAX_X; time++) {
			for (int cur = 0; cur < dp.length; cur++) {
				int ans = dp[cur][time];
				if (ans == -1)
					continue;
				result = Math.max(result, ans);
				int realL = cur - MAX + d;
				for (int dl = -1; dl < 2; dl++) {
					if (realL + dl > 0 && cur + dl >= 0 && cur + dl < dp.length) {
						int newTime = time + realL + dl;
						if (newTime < MAX_X) {
							dp[cur + dl][newTime] = Math.max(
									dp[cur + dl][newTime], ans
											+ (have[newTime]));
						}
					}
				}
			}
		}
		out.println(result);
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
