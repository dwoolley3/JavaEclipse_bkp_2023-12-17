package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R434_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R434_Div2_C().run();
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

		int firstcon = -1, lastcon = -1;
		for (int i = 0; i < n; i++)
		{
			char c = s.charAt(i);
			if (isConst(c))
			{
				if (firstcon == -1)
					firstcon = i;
				lastcon = i;
			}
			else //vowel or end
			{
				if (firstcon > -1) {
					parseCon(firstcon, lastcon, s);		
					firstcon = -1; lastcon = -1;
				}
				out.print(c);
			}
		}
		if (firstcon > -1)
			parseCon(firstcon, lastcon, s);	
		out.println();
	}
	
	void parseCon(int firstcon, int lastcon, String s)
	{
		int con = 0;
		String ns = "";
		for (int i = firstcon; i <= lastcon; i++)
		{
			char c = s.charAt(i); 
			con++;
			if (con == 3)
			{
				if (ns.charAt(0) != ns.charAt(1) || ns.charAt(1) != c)
				{
					out.print(ns + " ");
					ns = "";
					con = 1;
				}
				//else //all same
			}
			else if (con > 3)
			{
				//first 3+ are same
				if (ns.charAt(0) != c)
				{
					out.print(ns + " ");
					ns = "";
					con = 1;
				}
			}
			ns += c;
		}
		out.print(ns);
	}
	
	boolean isConst(char c) {
		if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return false;
		return true;
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
