package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R372_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R372_Div2_B().run();
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
		String s = in.next();
		int n = s.length();
		
		if (n < 26)
		{
			out.println(-1);
			return;
		}
		
		int[] a = new int[26];
		int q = 0;
		for (int i = 0; i < 25; i++)
		{
			char c = s.charAt(i);
			if (c == '?') 
				q++;
			else
				a[c-'A']++;
		}
		
		for (int i = 25; i < n; i++)
		{
			char c = s.charAt(i);
			if (c == '?') 
				q++;
			else
				a[c-'A']++;
			
			boolean ok = true;
			int empty = 0;
			for (int j = 0; j < 26; j++)
				if (a[j] > 1) ok = false;
				else if (a[j] == 0) empty++;
			
			if (ok && empty == q) 
			{
				for (int j = 0; j < n; j++)
				{
					c = s.charAt(j);
					if (j < i-25 || j > i)
					{
						if (c == '?')
							out.print("A");
						else
							out.print(c);
					}
					else //for (int j = i-25; j <= i; j++)
					{
						if (c >= 'A' && c <= 'Z')
							out.print(c);
						else // (c == '?')
						{
							for (int k = 0; k < 26; k++)
								if (a[k] == 0)
								{
									out.print((char)('A'+k));
									a[k] = 1;
									break;
								}			
						}				
					}
				}
				out.println();
				return;
			}
			
			
			c = s.charAt(i-25);
			if (c == '?') 
				q--;
			else
				a[c-'A']--;
		}
		
		out.println(-1);
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
