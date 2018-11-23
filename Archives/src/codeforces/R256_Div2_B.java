package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R256_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R256_Div2_B().run();
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
		String t = in.next();
		
		int ns = s.length();
		int nt = t.length();
		
		if (ns >= nt)
		{
			int ind = 0;
			boolean ok = true;
			for (int i = 0; i < nt; i++)
			{
				char c = t.charAt(i);
				boolean found = false;
				while (ind < ns)
				{
					if (s.charAt(ind) == c) {ind++; found = true; break;}
					ind++;
				}
				if (!found) {ok = false; break; }
			}
			if (ok)
			{
				out.println("automaton");
				return;
			}
		}
		
		int[] a = new int[26];
		int[] b = new int[26];
		for (int i = 0; i < nt; i++) 
			b[t.charAt(i)-'a']++;
		for (int i = 0; i < ns; i++) 
			a[s.charAt(i)-'a']++;
		
		boolean array = true;
		for (int i = 0; i < 26; i++)
			if (a[i] < b[i]) array = false;
		
		if (array && ns == nt)
			out.println("array");
		else if (array)
			out.println("both");
		else 
			out.println("need tree");
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
