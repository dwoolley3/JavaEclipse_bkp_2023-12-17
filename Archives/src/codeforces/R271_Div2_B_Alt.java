package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R271_Div2_B_Alt
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R271_Div2_B_Alt().run();
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
		//Alternate solution:
		int n = in.nextInt();
		int[] p = new int[1_000_001];
		int ind = 0;
		for (int i = 1; i <= n; i++)
		{
			int goal = in.nextInt();
			for (int j = 0; j < goal; j++)
				p[++ind] = i;
		}
		int m = in.nextInt();
		for (int i = 0; i < m; i++)
		{
			int q = in.nextInt();		
			out.println(p[q]);
		}
	}
	
	//Following is too slow:
//		int n = in.nextInt();
//		
//		int[] a = new int[n+1];
//		for (int i = 1; i <= n; i++) 
//			a[i] = a[i-1] + in.nextInt();
//		
//		int m = in.nextInt();
//		for (int i = 0; i < m; i++)
//		{
//			//Linear sequential search for 
//			int goal = in.nextInt();
//			int pile = 1;
//			for (pile = 1; pile <= n; pile++)
//				if (goal <= a[pile]) 
//				{
//					out.println(pile);
//					break;
//				}		
//		}
//	}

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
