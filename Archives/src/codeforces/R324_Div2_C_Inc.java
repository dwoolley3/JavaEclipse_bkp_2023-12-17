package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R324_Div2_C_Inc
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R324_Div2_C_Inc().run();
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
		int t = in.nextInt();
		String s1 = in.next();
		String s2 = in.next();
		int dif = 0;
		for (int i = 0; i < n; i++)
			if (s1.charAt(i) != s2.charAt(i))
				dif++;
		
		if (t >= dif)
		{
			int cnt = 0;
			for (int i = 0; i < n; i++)
			{
				char c1 = s1.charAt(i), c2 = s2.charAt(i);
				if (c1 != c2)	
					out.print(GetDifChar(c1,c2));
				else //same char
				{
					if (cnt < t - dif)
					{
						out.print(GetDifChar(c1,c2));
						cnt++;
					}
					else
						out.print(c1);
				}
			}
			out.println();	
		}
		else if (t < dif)
		{
			@SuppressWarnings("unused")
			int cnt = 0, d1 = 0, d2 = 0;
			for (int i = 0; i < n; i++)
			{
				char c1 = s1.charAt(i), c2 = s2.charAt(i);
				if (c1 != c2)
					if (dif-t > d1)
					{
						d1++;
						out.print(c2);
					}
					else
					{
						d2++;
						out.print(c1);
					}
				else //same char
				{
					if (cnt < t - dif)
					{
						out.print(GetDifChar(c1,c2));
						cnt++;
					}
					else
						out.print(c1);
				}
			}
		}
		else
			out.println(-1);	
	
	}
	
	static char GetDifChar(char c1, char c2)
	{
		int[] a = new int[26];
		a[c1-'a'] = 1;
		a[c2-'a'] = 1;
		int i = 0;
		for (i = 0; i < 26; i++)
			if (a[i] == 0) break;
		return (char)('a' + i);		
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
