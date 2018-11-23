package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R387_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R387_Div2_B().run();
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
		String s = in.next();
		
		int[] a = new int[26];
		for (int i = 0; i < n; i++) 
		{
			char c = s.charAt(i);
			if (c != '?')
				a[c-'A']++;
		}
		boolean ok = true;
		String dec = "";
		if (n%4 != 0)
			ok = false;
		else
		{
			String st = "ACGT";		
			for (int i = 0; i < 4; i++)
			{
				char c = st.charAt(i);
				if (a[c-'A'] > n/4) 
				{
					ok = false; break;
				}
			}
			if (ok)
			{
				int ind = 0;
				for (int i = 0; i < n; i++)
				{
					char c = s.charAt(i);
					if (c == '?')
					{
						for (int j = ind; j < 4; j++)
							if (a[st.charAt(j)-'A'] < n/4)
							{
								dec += st.charAt(j);
								a[st.charAt(j)-'A']++;
								ind = j;
								break;
							}
					}
					else
						dec += c;
				}
			}
				
		}
		
		out.println(ok ? dec : "===");		
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
