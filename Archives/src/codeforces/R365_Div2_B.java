package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R365_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R365_Div2_B().run();
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
		int k = in.nextInt();
		

		int[] c = new int[n+1];
		long sum = 0;
		for (int i = 1; i <= n; i++)
		{
			c[i] = in.nextInt();
			sum += c[i];
		}
		
		long ans = 0;
		for (int i = 1; i < n; i++) 
			ans += c[i] * c[i+1];
		ans += c[n] * c[1];
				
		int prevCaps = 0;
		int[] capIndexes = new int[n+1];
		int[] d = new int[k];
		for (int i = 0; i < k; i++) 
		{
			d[i] = in.nextInt();
			int prev = d[i] - 1, next = d[i] + 1;
			if (prev == 0) prev = n;
			if (next == n+1) next = 1;
			int prevValue = c[prev];
			int nextValue = c[next];
			
			int sub = prevCaps;
			if (capIndexes[d[i]] == 0) sub += c[d[i]];
			if (capIndexes[prev] == 0 && prev != d[i]) sub += prevValue;
			if (capIndexes[next] == 0 && next != d[i]) sub += nextValue;
			ans += c[d[i]] * (sum - sub);
			prevCaps += c[d[i]];
			capIndexes[d[i]] = 1;
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
