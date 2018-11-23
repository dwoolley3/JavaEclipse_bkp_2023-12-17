package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HR_World_CodeSprint7_4
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_World_CodeSprint7_4().run();
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
		int n = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] pow2 = new int[n*2];
		pow2[0] = 1;
		int MOD = 1_000_000_007;
		for (int i = 1; i < n*2; i++)
		{
			pow2[i] = pow2[i -1] * 2;
			pow2[i] %= MOD;
		}
		
		//Not working yet
		long ans = 0;
		for (int i = 0; i < n; i++)
		{
			long sum = 0;
			for (int j = 1; j <= n; j++)
			{
				int st = i+1 - j, en = i + j - 1;
				int num1 = Math.max(0, st - 1);
				int num2 = Math.max(0, n-1 - en - 1);
				sum += pow2[num1+num2] * j;
				sum %= MOD;
			}
			long prod = sum * a[i];
			prod %= MOD;
			ans += prod;
			ans %= MOD;
		}
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
