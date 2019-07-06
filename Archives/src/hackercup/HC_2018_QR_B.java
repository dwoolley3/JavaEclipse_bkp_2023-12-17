package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2018_QR_B
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "B_ex";
	final String PROBLEM_NAME = "B";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2018_QR_B().runWithFiles();
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
			//P0 result always = 1, since raised to 0 power
			//Only way to get total equal to 0 is for Pn result to be 0 
			//and Pn-1 result to be 1 (not 0).
			//P0 result will be 1 for x = 0;
			//P1 result will be 0 for x = 0;
			//P2 result will be 1 for x = 0;
			//P3 result will be 0 for x = 0;
			//P4 result will be 1 for x = 0;
			int[] p = new int[n+1];
			for (int i = 0; i <= n; i++) 
				p[i] = in.nextInt();
			
			int ans = n%2;
			
			System.out.println("Case #" + tc + ": " + ans);
			if (ans == 1)
				System.out.println(0.0);
			out.println("Case #" + tc + ": " + ans);
			if (ans == 1)
				out.println(0.0);
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
