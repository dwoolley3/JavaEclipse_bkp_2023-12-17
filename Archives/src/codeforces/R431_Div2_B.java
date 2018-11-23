package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R431_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R431_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[] a;
	void solve()
	{
		int n = in.nextInt();
	
		a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		boolean ok = check(0,1) || check(0,2) || check(1,2);
		
		out.println(ok ? "Yes" : "No");		
	}
	
	private boolean check(int x1, int x2) {
		boolean par = false;
		
		int dify = a[x2] - a[x1];
		int difx = x2 - x1;
		int n = a.length;
		boolean[] used = new boolean[n];
		used[x2] = true; used[x1] = true;
		int online1 = 2;
		for (int i = 0; i < n; i++)
			if (!used[i]) {
				int dify2 = a[i] - a[x1];
				int difx2 = i - x1;
				if (1L * difx * dify2 == 1L * dify * difx2)	{
					used[i] = true;
					online1++;
				}
			}
		
		int online2 = n - online1;
		if (online2 == 0)
			par = false;
		else if (online2 == 1) 
			par = true;
		else if (online2 > 1) {
			par = false;
			int i = 0;
			while (used[i]) i++;
			int i2 = i+1;
			while (used[i2]) i2++;
			int dify3 = a[i2] - a[i];
			int difx3 = i2 - i;
			
			if (1L * difx * dify3 == 1L * dify * difx3)	{
				par = true;
				for (i = i2+1; i < n && par; i++)
					if (!used[i]) {
						int dify4 = a[i] - a[i2];
						int difx4 = i - i2;
						if (1L * difx3 * dify4 != 1L * dify3 * difx4)	
							par = false;
					}
			}			
		}		
		
		return par;			
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
