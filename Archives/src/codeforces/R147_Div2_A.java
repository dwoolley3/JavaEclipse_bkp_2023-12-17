package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R147_Div2_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R147_Div2_A().run();
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
		int[] a = new int[24*60];
		int max = 0;
		for (int i = 0; i < n; i++)	
			max = Math.max(max, ++a[in.nextInt()*60+in.nextInt()]);
		out.println(max);	
		
//		for (int i = 0; i < n; i++)			
//		{
//			int h = in.nextInt();
//			int m = in.nextInt();
//			int ind = h*60+m;
//			a[ind]++;
//			if (a[ind] > max) max = a[ind];
//		}
//		out.println(max);	
		
//		int max = 0;
//		int cnt = 1, prevh = -1, prevm = -1;
//		for (int i = 0; i < n; i++)			
//		{
//			int h = in.nextInt();
//			int m = in.nextInt();
//			if (h == prevh && m == prevm)
//				cnt++;			
//			max = Math.max(max,cnt);
//			if (h != prevh || m != prevm)
//				cnt = 1;
//			prevh = h; prevm = m;
//		}
//		out.println(max);	
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
