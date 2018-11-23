package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class AIM_Tech_R3_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new AIM_Tech_R3_Div2_B().run();
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
		int start = in.nextInt();
		
		int[] x = new int[n];
		for (int i = 0; i < n; i++)		
			x[i] = in.nextInt();
		if (n == 1)
		{
			out.println(0);
			return;
		}
		int s1 = 0, s2 = 0;
		if (n == 2)
		{
			s1 = Math.abs(x[0] - start);
			s2 = Math.abs(x[1] - start);
		}
		else
		{		
			Arrays.sort(x);

			// 1. Remove last position (n-1)
			int x1 = x[n-2] - start; 
			int x2 = start - x[0];
			if (start <= x[0]) s1 = x1;
			else if (start >= x[n-2]) s1 = x2;
			else s1 = Math.min(x1, x2) * 2 + Math.max(x1, x2);
			
			// 2. Remove first position (0)
			x1 = x[n-1] - start; 
			x2 = start - x[1];
			if (start <= x[1]) s2 = x1;
			else if (start >= x[n-1]) s2 = x2;
			else s2 = Math.min(x1, x2) * 2 + Math.max(x1, x2);
		}
		
		out.println(Math.min(s1, s2));		
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
