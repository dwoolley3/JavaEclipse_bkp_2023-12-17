package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R342_8VC_2016_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R342_8VC_2016_B().run();
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
		
		int b = 0, g = 0, r = 0;
		for (int i = 0; i < n; i++) 
			if (s.charAt(i) == 'B') b++;
			else if (s.charAt(i) == 'G') g++;
			else if (s.charAt(i) == 'R') r++;
		
		String ans = "";
		if (b+r==0) ans = "G";
		else if (b+g==0) ans = "R";
		else if (g+r==0) ans = "B";
		else
		{
			if (n==2)
			{
				if (g==0) ans="G";
				if (r==0) ans="R";
				if (b==0) ans="B";
			}

			else if (g>=2&&r==1&&b==0) ans="BR";
			else if (g>=2&&b==1&&r==0) ans="BR";
			else if (b>=2&&r==1&&g==0) ans="GR";
			else if (b>=2&&g==1&&r==0) ans="GR";
			else if (r>=2&&b==1&&g==0) ans="BG";
			else if (r>=2&&g==1&&b==0) ans="BG";
			else // if (b>=1&&g>=1&&r>=1) or two are 2 or greater
				ans = "BGR";			
		}
		out.println(ans);

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
