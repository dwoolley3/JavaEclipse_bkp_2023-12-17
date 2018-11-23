package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R268_Div2_B //Name: Chat Online
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R268_Div2_B().run();
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
		int p = in.nextInt();
		int q = in.nextInt();
		int l = in.nextInt();
		int r = in.nextInt();
		
		int[] a = new int[p];
		int[] b = new int[p];
		for (int i = 0; i < p; i++) 
		{
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
		
		int[] c = new int[q];
		int[] d = new int[q];
		for (int i = 0; i < q; i++) 
		{
			c[i] = in.nextInt();
			d[i] = in.nextInt();
		}
		
		int cnt = 0;
		for (int t = l; t <= r; t++)
		{
			boolean good = false;
			for (int i = 0; i < p && !good; i++)
				for (int j = 0; j < q && !good; j++)
					if (overlap (a[i],b[i], c[j]+t, d[j]+t))
							good = true;
			if (good) cnt++;
		}
		
		out.println(cnt);		
	}
	
	boolean overlap(int a, int b, int c, int d)
	{
		if (a >= c && a <= d) return true;
		if (b >= c && b <= d) return true;
		if (c >= a && c <= b) return true;
		if (d >= a && d <= b) return true;
		return false;
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
