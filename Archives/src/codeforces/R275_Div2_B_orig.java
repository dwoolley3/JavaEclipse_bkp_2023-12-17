package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R275_Div2_B_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R275_Div2_B_orig().run();
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
		int cnt1 = in.nextInt();
		int cnt2 = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
				
		int a1 = cnt1 / (x-1);
		int a2 = cnt2 / (y-1);
		
		int b1 = a1 * x - 1;
		int b2 = a2 * y - 1;
		int rem = cnt1 % (x-1);
		if (rem > 0)
			b1 += rem + 1;
		rem = cnt2 % (y-1);
		if (rem > 0)
			b2 += rem + 1;
		
		int cnt3 = cnt1 + cnt2;
		int a3 = cnt3 / (x*y-1);
		int b3 = a3 * x*y - 1;	
		rem = cnt3 % (x*y-1);
		if (rem > 0)
			b3 += rem + 1;
		//out.println(b1 + " " + b2 + " " + b3);		

		int ans = Math.max(b1,  Math.max(b2, b3));	
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
