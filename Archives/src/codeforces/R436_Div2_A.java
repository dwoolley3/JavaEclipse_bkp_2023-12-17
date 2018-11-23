package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R436_Div2_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R436_Div2_A().run();
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
		
		int[] c = new int[101];
		for (int i = 0; i < n; i++) 
			c[in.nextInt()]++;
		
		int a1 = -1, a2 = -1;
		for (int i = 1; i <= 100; i++)
		{
			if (c[i] * 2 == n)
			{
				if (a1 == -1) a1 = i;
				else a2 = i;
			}
		}
		out.println(a2 != -1 ? "YES" : "NO");	
		if (a2 != -1)
			out.println(a1 + " " + a2);		
		
		//Alternate
//		int[] a = new int[n];
//		for (int i = 0; i < n; i++) 
//			a[i] = in.nextInt();
//		
//		Arrays.sort(a);
//		boolean ok = true;
//		for (int i = 1; i < n/2; i++)
//			if (a[0] != a[i]) ok = false;
//		
//		for (int i = n/2; i < n-1; i++)
//			if (a[n-1] != a[i]) ok = false;
//	
//		if (a[0] == a[n-1]) ok = false;
//		out.println(ok ? "YES" : "NO");	
//		if (ok) 
//			out.println(a[0] + " " + a[n-1]);
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
