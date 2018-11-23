package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Manthan_Codefest_17_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Manthan_Codefest_17_B().run();
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
		long p = in.nextInt();
		long q = in.nextInt();
		long r = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
		}
		
		long[] rm = new long[n];
		rm[n-1] = a[n-1] * r;
		for (int i = n-2; i >= 0; i--)
			rm[i] = Math.max(rm[i+1], r * a[i]);
		
		long[] qm = new long[n];
		qm[n-1] = a[n-1] * q + rm[n-1];
		for (int i = n-2; i >= 0; i--)
			qm[i] = Math.max(qm[i+1], q * a[i] + rm[i]);
		
		long[] pm = new long[n];
		pm[n-1] = a[n-1] * p + qm[n-1];
		for (int i = n-2; i >= 0; i--)
			pm[i] = Math.max(pm[i+1], p * a[i] + qm[i]);
				
		out.println(pm[0]);		
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
