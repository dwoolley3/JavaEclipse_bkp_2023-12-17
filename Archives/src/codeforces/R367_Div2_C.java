package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R367_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R367_Div2_C().run();
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
		
		int[] c = new int[n];
		for (int i = 0; i < n; i++) 
			c[i] = in.nextInt();
		
		String prevS = in.next();
		String prevSrev = reverse(prevS);
		int regCost = 0, revCost = c[0];
		int prevregCost = 0, prevrevCost = c[0];
		for (int i = 1; i < n; i++) 
		{
			String s = in.next();
			String revS = reverse(s);
			if (prevS.compareTo(s) <= 0)
			{
				regCost = prevregCost;
			}
			else if (prevSrev.compareTo(s) <= 0) 
				regCost = prevrevCost;
			else
				regCost = -1;	
			
			if (prevS.compareTo(revS) <= 0)		
			{
				revCost = prevregCost + c[i];
			}
			else if (prevSrev.compareTo(revS) <= 0) 
				revCost = prevrevCost + c[i];
			else
				revCost = -1;
			
			prevrevCost = revCost;
			prevregCost = regCost;	
			prevS = s;
			prevSrev = revS;
		}
		
		if (regCost == -1 && revCost == -1)
			out.println(-1);
		else if (regCost == -1)
			out.println(revCost);
		else if (revCost == -1)
			out.println(regCost);
		else
			out.println(Math.min(regCost, revCost));		
	}
	
	String reverse(String s)
	{
		char[] c = s.toCharArray();
		int j = s.length() - 1;
		for (int i = 0; i < s.length() && i < j; i++, j--)
		{
			char t = c[i]; c[i] = c[j]; c[j] = t; 
		}
		return new String(c);
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
