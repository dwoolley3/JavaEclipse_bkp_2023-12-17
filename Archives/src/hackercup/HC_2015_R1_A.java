package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2015_R1_A
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "A_ex";
	final String PROBLEM_NAME = "A";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2015_R1_A().runWithFiles();
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
		int max = 10_000_000;
		int[] prim = getPrimacityCount(max);
		
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			int ans = 0;
			
			for (int i = a; i <= b; i++)
			{		
				if (prim[i] == k) 
					ans++;
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	private int[] getPrimacityCount(int max)
	{
		int[] prim = new int[max+1];
		for (int i = 2; i <= max; i++)
		{
			int n = i, j = 2, cnt = 0;
			while (n > 1 && j * j <= n)
			{
				if (n % j == 0)
				{
					n /= j;
					cnt++;
				}
				while (n % j == 0)
					n /= j;
				j++;
			}
			if (n > 1) cnt++;
			
			prim[i] = cnt;
		}
		return prim;
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
