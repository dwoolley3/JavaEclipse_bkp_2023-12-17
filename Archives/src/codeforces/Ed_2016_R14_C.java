package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2016_R14_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2016_R14_C().run();
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
		
		int st = 0;
		while (s.charAt(st) == '0') st++;
		s = s.substring(st);
		int n = s.length();
		int ind = s.indexOf('.');
		if (ind == -1)
		{
			s += ".";
			n++;
			ind = n-1;
		}		
		
		st = 0;
		while (s.charAt(st) == '0' || s.charAt(st) == '.') st++;
		s = s.substring(st);
		
		int en = s.length()-1;
		while (s.charAt(en) == '0' || s.charAt(en) == '.') en--;
		s = s.substring(0,en + 1);
		
		String s2 = s.replace(".",  "");
		out.print(s2.charAt(0));
		if (ind - 1 - st < 0) ind++;
		
		if (s2.length() > 1 || ind -1 - st  != 0)
		{
			if (s2.length() > 1)
			{
				out.print(".");
				out.print(s2.substring(1));
			}
			if (ind - 1 - st != 0)
			{
				out.print("E");
				out.print(ind -1 - st);
			}			
		}
		out.println();		
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
