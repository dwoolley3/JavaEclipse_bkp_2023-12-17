package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R231_Div2_A //Name: Counting Sticks
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R231_Div2_A().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
		//Hacked 4 with the following: |+||=|
	}
	
	void solve()
	{
		String s = in.next();
		int n = s.length();
		String[] st = s.split("[+=]");
		int a = st[0].length();
		int b = st[1].length();
		int c = st[2].length();
		
		if (a+b == c)
			out.println(s);
		else if (a+1 + b == c-1 && c-1 > 0)
		{
			s = '|' + s;
			out.println(s.substring(0,n));
		}
		else if (a-1 + b == c+1 && a-1 > 0)
		{
			s += '|';
			out.println(s.substring(1));
		}
		else if (a + b-1 == c+1 && b-1 > 0)
		{
			st[1] = st[1].substring(1);
			st[2] += "|";
			out.println(st[0]+"+"+st[1]+"="+st[2]);
		}
		else 
			out.println("Impossible");
	
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
