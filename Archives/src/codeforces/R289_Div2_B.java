package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R289_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R289_Div2_B().run();
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
		
		int[] a = new int[n];
		int min = 101, max = 0;
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		
		if (max - min > k)
		{
			out.println("NO");
			return;
		}

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] al = new ArrayList[n]; 
		for (int i = 0; i < n; i++)
			al[i] = new ArrayList<Integer>();
		
		int c = 1;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < min; j++)
				al[i].add(c);
		
		for (c = 2; c <= k; c++)
			for (int i = 0; i < n; i++)
			{
				if (a[i] >= min-1 + c)
					al[i].add(c);
			}
		
		for (int i = 0; i < n; i++)
			if (a[i] == max && al[i].size() < a[i])
				al[i].add(1);
		
		out.println("YES");
		for (int i = 0; i < n; i++) 
		{
			for (int j : al[i])
				out.print(j + " ");
			out.println();
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
