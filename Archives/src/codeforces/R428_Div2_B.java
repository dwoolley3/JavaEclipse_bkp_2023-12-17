package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R428_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R428_Div2_B().run();
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
		
		int[] a = new int[k];
		for (int i = 0; i < k; i++) 
			a[i] = in.nextInt();
		
		int four = n, two = n*2;
				
		for (int i = 0; i < k; i++)
			while (a[i] >= 4 && four > 0)
			{
				a[i] -= 4;
				four--;
			}
		
		for (int i = 0; i < k; i++)
			if (a[i] == 3)
				if (four > 0)
				{
					a[i] -= 3;
					four--;
				}
				else if (two > 0)
				{
					a[i] -= 2;
					two--;
				}
		
		for (int i = 0; i < k; i++)
			while (a[i] >= 2 && two > 0)
			{
				a[i] -= 2;
				two--;
			}
		
		int[] b = new int[3];
		for (int i = 0; i < k; i++)
			b[a[i]]++;
		
		while (b[1] > 0 && b[2] > 0 && four > 0)
			{
				b[1]--;
				b[2]--;
				four--;
			}
				
		while (b[2] > 1 && four > 0)
			{
				b[2] -= 2;
				b[1]++;
				four--;
			}
		
		while (b[1] > 0 && b[2] > 0 && four > 0)
		{
			b[1]--;
			b[2]--;
			four--;
		}
		
		while (b[2] > 0 && four > 0)
			{
				b[2]--;
				four--;
			}
		
		while (b[1] >= 2 && four > 0)
			{
				b[1] -= 2;
				four--;
			}
		
		boolean ok = true;
		if (b[1] + b[2] > two + four) 
			ok = false;

		out.println(ok ? "YES" : "NO");		
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
