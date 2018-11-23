package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R258_Div1_MemSQL_B //Names: 4-point polyline
{	
	//** Does not work for all test cases. Need to not assume the first point.
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R258_Div1_MemSQL_B().run();
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
		int m = in.nextInt();
		
		if (n == 0)
		{
			out.println("0 1");
			out.println("0 " + m);
			out.println("0 0");
			out.println("0 " + (m-1));
		}
		else if (m == 0)
		{
			out.println("1 0");
			out.println(n + " 0");
			out.println("0 0");
			out.println((n-1) + " 0");
		}
		else
		{
			out.println("0 0");
			out.println(n + " " + m);
			if (n < m)
			{
				double d1 = Math.sqrt(m*m + n*n);
				d1 += Math.sqrt(m*m + (n-n)*(n-n));
				d1 += Math.sqrt(m*m + (n-0)*(n-0));	
				
				double d2 = Math.sqrt(m*m + n*n);				
				d2 += Math.sqrt(m*m + (n-1)*(n-1));
				d2 += Math.sqrt(m*m + (n-2)*(n-2));	
				
				if (d1 > d2)
				{
					out.println(n + " 0");
					out.println("0 " + m);
				}
				else
				{
					out.println("1 0");
					out.println((n-1) + " " + m);
				}

			}
			else
			{
				double d1 = Math.sqrt(n*n + m*m);
				d1 += Math.sqrt(n*n + (m-m)*(m-m));
				d1 += Math.sqrt(n*n + (m-0)*(m-0));	
				
				double d2 = Math.sqrt(n*n + m*m);				
				d2 += Math.sqrt(n*n + (m-1)*(m-1));
				d2 += Math.sqrt(n*n + (m-2)*(m-2));	
				//out.println(d1 + " " + d2);
				if (d1 > d2)
				{
					out.println("0 " + m);
					out.println(n + " 0");
				}
				else
				{
					out.println("0 1");
					out.println(n + " " + (m-1));
				}
			}
		}
		
		double maxd = 0;
		int indi = -1, indj = -1, indk = -1;
		for (int i = 0; i <= m; i++)
			for (int j = 1; j <= m; j++)
				for (int k = 0; k <= m; k++)
				{
					if (k == i) continue;
					double d = Math.sqrt(n*n + i*i);
					d += Math.sqrt(n*n + (i-j)*(i-j));
					d += Math.sqrt(n*n + (j-k)*(j-k));	
					if (d > maxd)
					{
						maxd = d;
						indi = i;
						indj = j;
						indk = k;
					}
				}
		out.println(maxd + " " + indi + " " + indj + " " + indk);
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
