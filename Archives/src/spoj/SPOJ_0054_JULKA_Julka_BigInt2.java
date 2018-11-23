package spoj;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class SPOJ_0054_JULKA_Julka_BigInt2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new SPOJ_0054_JULKA_Julka_BigInt2().run();
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
		int t = 1; 
		for (int T = 1; T <= t; T++) {	
			//n + (n + dif) = both, thus n = (both - dif) / 2;
			//Klaudia = n + dif, Natalia = n;
			String both = in.next();
			String dif = in.next();
			out.println(BigAdd(both, dif));
			
//			BigInteger both = in.nextBigInteger();
//			BigInteger dif = in.nextBigInteger();
//			BigInteger n = both.subtract(dif).divide(new BigInteger("2"));
//			BigInteger k = n.add(dif);
//			
//			out.println(k);	
//			out.println(n);
		}
	}
	
	private String BigAdd(String a, String b) {
		int na = a.length(), nb = b.length();
		int max = Math.max(na,nb);
		int[] c = new int[max+1];
		int carry = 0;
		for (int i = 0; i < max; i++)
		{
			if (na-1 >= i)
				c[i] += a.charAt(na-1-i) - '0';
			if (nb-1 >= i)
				c[i] += b.charAt(nb-1-i) - '0';
			c[i] += carry;
			carry = c[i] / 10;
			c[i] = c[i] % 10;
		}
		if (carry > 0)
			c[max++] = carry;
			
		StringBuilder s = new StringBuilder();
		for (int i = max-1; i >= 0; i--)
			s.append(c[i]);
		return s.toString();		
	}
	
//	private String BigSubtract(String a, String b) {
//		
//	}

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
