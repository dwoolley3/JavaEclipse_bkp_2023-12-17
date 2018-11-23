package spoj;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class SPOJ_0024_FCTRL2_Small_factorials
{
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new SPOJ_0024_FCTRL2_Small_factorials().run();
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
		int t = in.nextInt();  
		for (int T = 1; T <= t; T++) {			
			int n = in.nextInt();	
			out.println(fact(n));	
		}
	}
	
	private BigInteger fact(int n) {
		BigInteger f = BigInteger.ONE;
		for (int i = 1; i <= n; i++)
		{
			BigInteger bi = new BigInteger(i+"");		
			f = f.multiply(bi);
		}
		return f;
	}
	
	//Multiplication without using BigInteger
	@SuppressWarnings("unused")
	private String fact2(int n) {
		String s = "";
		int[] a = new int[n*3];
		a[0] = 1;
		int lastInd = 0;
		for (int i = 1; i <= n; i++)
		{
			int carry = 0;		
			for (int j = 0; j <= lastInd; j++)
			{
				a[j] = a[j] * i + carry;
				carry = a[j] / 10;
				a[j] = a[j] % 10;
			}
			while (carry > 0)
			{
				a[++lastInd] = carry % 10;
				carry /= 10;
			}
		}
		for (int i = lastInd; i >= 0; i--)
			s+= a[i];
		return s;
	}
	
	//-----------------------------------------------------

	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
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

	    int nextInt() {
	        return Integer.parseInt(next());
	    } 
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	}
}