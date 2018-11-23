package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R338_EdR5_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R338_EdR5_A().run();
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
		char[] c1 = in.next().toCharArray();
		char[] c2 = in.next().toCharArray();

		int i = 0;
		while (i < c1.length && c1[i] == '0') i++;
		int f01 = i;
		
		i = 0;
		while (i < c2.length && c2[i] == '0') i++;
		int f02 = i;
		
		if (c1.length - f01 > c2.length - f02)
			out.println(">");
		else if (c1.length - f01 < c2.length - f02)
			out.println("<");
		else
		{
			for (i = f01; i < c1.length; i++)
				if (c1[i] > c2[f02 + i-f01])
				{
					out.println(">");
					return;
				}
				else if (c1[i] < c2[f02 + i-f01])
				{
					out.println("<");
					return;
				}		
			out.println("=");
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
