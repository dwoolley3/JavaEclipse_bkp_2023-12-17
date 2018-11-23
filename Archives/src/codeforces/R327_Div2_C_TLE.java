package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R327_Div2_C_TLE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R327_Div2_C_TLE().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[] a, b;
	void solve()
	{
		int n = in.nextInt();
		
		a = new int[n];
		b = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		//int max = (n-1) / 2;
			
		int rep = 0;
		rep = solve(0, n-1);
		out.println(rep);
		for (int i = 0; i < n; i++)
			out.print(a[i] + " ");
		out.println();		
	}
	
	private int solve(int start, int end)
	{
		boolean stable = true;
		for (int i = start+1; i <= end-1; i++)
		{
			int cnt = a[i-1] + a[i] + a[i+1];
			if (cnt > 1) b[i] = 1; else b[i] = 0;
			if (a[i] != b[i]) stable = false;
		}
		if (stable)
		{			
			return 0;
		}
		else
		{			
			for (int i = start+1; i <= end-1; i++)
				a[i] = b[i];
			
			int max = 0;
			int st2 = start;
			int en2 = end;
			while (st2+1 < en2)
			{
				for (int i = st2+1; i <= en2; i++)
				{
					if (a[i-1] == a[i]) continue;
					st2 = i-1;
					break;
				}
				for (int i = st2; i <= en2-1; i++)
				{
					if (a[i] != a[i+1]) continue;
					en2 = i+1;
					break;
				}
				
				int x = 1 + solve(st2, en2);
				max = Math.max(max,x);
				st2 = en2+1;
				en2 = end;
			}
			return max;
		}
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
