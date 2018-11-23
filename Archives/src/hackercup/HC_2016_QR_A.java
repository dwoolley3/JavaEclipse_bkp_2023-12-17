package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class HC_2016_QR_A
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "A_ex";
	final String PROBLEM_NAME = "A";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2016_QR_A().runWithFiles();
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
			
			int[] x = new int[n];
			int[] y = new int[n];
			for (int i = 0; i < n; i++)
			{
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}			
			int ans = 0;
			for (int i = 0; i < n; i++)
			{
				int ind = 0;
				long[] len = new long[n-1];			
				for (int j = 0; j < n; j++)
				{
					if (i == j) continue;
					len[ind++] = 1L * (x[i]-x[j]) * (x[i]-x[j])
						+ 1L * (y[i]-y[j]) * (y[i]-y[j]);
				}
				Arrays.sort(len);
				int cnt = 1;
				for (int j = 1; j < n-1; j++)
				{
					if (len[j-1] == len[j]) cnt++;
					else
					{
						ans += cnt * (cnt-1) / 2;
						cnt = 1;
					}						
				}
				ans += cnt * (cnt-1) / 2;
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
			//out.printf("Case #%d: %d\n", tc, ans);
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
