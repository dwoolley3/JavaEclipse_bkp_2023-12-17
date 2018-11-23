package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R407_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R407_Div2_B().run();
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
		int b1 = in.nextInt();
		int q = in.nextInt();
		int l = in.nextInt();
		int m = in.nextInt();
		
		TreeSet<Integer> ts = new TreeSet<Integer>(); 
		int[] a = new int[m];
		for (int i = 0; i < m; i++) 
		{
			a[i] = in.nextInt();
			ts.add(a[i]);
		}		
		
		if (Math.abs(b1) > l)
			out.println(0);
		else if (q == 1)
		{
			if (ts.contains(b1))
				out.println(0);
			else
				out.println("inf");
		}
		else if (q == -1)
		{
			if (ts.contains(b1) && ts.contains(-b1))
				out.println(0);
			else
				out.println("inf");
		}
		else if (q == 0)
		{
			if (ts.contains(0))
			{
				if (b1 == 0)
					out.println(0);
				else if (ts.contains(b1))
					out.println(0);
				else
					out.println(1);
			}					
			else
				out.println("inf");
		}
		else if (b1 == 0)
		{
			if (ts.contains(0))
				out.println(0);		
			else
				out.println("inf");
		}
		else
		{
			int cnt = 0;
			long b = b1;
			while (Math.abs(b) <= l)
			{
				if (!ts.contains((int)b)) cnt++;
				b *= q;
			}
			out.println(cnt);
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
