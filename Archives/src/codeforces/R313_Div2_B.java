package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R313_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R313_Div2_B().run();
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
		int[] a = new int[3];
		int[] b = new int[3];
		a[0] = in.nextInt();
		b[0] = in.nextInt();
		a[1] = in.nextInt();
		b[1] = in.nextInt();
		a[2] = in.nextInt();
		b[2] = in.nextInt();
		int a0,b0,a1,b1,a2,b2;
		
		boolean ok = false;
		for (int i = 0; i < 8 && !ok; i++)
		{
			int r2 = i % 2;
			int r1 = (i % 4 < 2) ? 0 : 1;
			int r0 = (i < 4) ? 0 : 1;
			
			if (r0 == 1)
			{
				a0 = a[0]; b0 = b[0];
			}
			else
			{
				a0 = b[0]; b0 = a[0];
			}
			if (r1 == 1)
			{
				a1 = a[1]; b1 = b[1];
			}
			else
			{
				a1 = b[1]; b1 = a[1];
			}
			if (r2 == 1)
			{
				a2 = a[2]; b2 = b[2];
			}
			else
			{
				a2 = b[2]; b2 = a[2];
			}
			
			if (a1 + a2 <= a0 && Math.max(b1, b2) <= b0)
				ok = true;
			else if (b1 + b2 <= b0 && Math.max(a1,  a2) <= a0)
				ok = true;
		}
		
		if (ok)
			out.println("YES");
		else
			out.println("NO");
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
