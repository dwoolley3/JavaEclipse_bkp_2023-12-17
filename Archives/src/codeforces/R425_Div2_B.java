package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R425_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R425_Div2_B().run();
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
		TreeSet<Character> good = new TreeSet<>();
		for (char c = 'a'; c <= 'z'; c++)
			if (s.contains(c+""))
				good.add(c);
		
		String pat = in.next();
		int ast = pat.indexOf("*");		
		
		int n = in.nextInt();
		for (int i = 0; i < n; i++) 
		{
			s = in.next();		
			boolean ok = true;
			
			if (ast == -1)
			{
				if (pat.length() != s.length()) ok = false;
			}
			else 
				if (pat.length()-1 > s.length()) ok = false;

			if (ok)
			for (int j = 0; j < ast && ok; j++)
			{
				char c = s.charAt(j);
				char patc = pat.charAt(j);
				if (patc == '?')
					ok = good.contains(c); 
				else 
					ok = (patc == c);
			}
			
			if (ok)
			for (int j = pat.length()-1; j > ast && ok; j--)
			{
				char c = s.charAt(s.length()-1 - (pat.length()-1 - j));
				char patc = pat.charAt(j);
				if (patc == '?')
					ok = good.contains(c); 
				else 
					ok = (patc == c);
			}
			
			if (ok && ast > -1)
			{				
				int last = s.length() - (pat.length() - ast);
				for (int j = ast; j <= last && ok; j++)
				{
					char c = s.charAt(j);
					ok = !good.contains(c); 
				}
			}			
		
			out.println(ok ? "YES" : "NO");
		}
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
