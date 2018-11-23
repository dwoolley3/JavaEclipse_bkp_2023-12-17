
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class BigInts_SPOJ_0328_BISHOPS_Bishops
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new BigInts_SPOJ_0328_BISHOPS_Bishops().run();
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
		String s = in.nextLine();
		while (s != null && !s.equals("")) {
			
			//Alternative using BigInteger is much easier
			BigInteger n = new BigInteger(s);
			BigInteger one = BigInteger.ONE;
			BigInteger two = one.add(one);
			BigInteger total = n.subtract(one).multiply(two);
			if (n.equals(one))
				out.println(1);
			else
				out.println(total);
			s = in.nextLine();
			
			//Alternative using arrays and simulating long arithmetic
//			if (s.equals("1"))
//				out.println(1);
//			else {
//				int n = s.length();
//				int[] a = new int[n+1];
//				for (int i = 0; i < n; i++)
//					a[i] = s.charAt(n-1-i) - '0';
//				//Subtract 1
//				a[0]--;
//				for (int i = 0; i < n && a[i] < 0; i++)
//				{
//					a[i] += 10;
//					a[i+1]--;
//				}
//				//Multiply by 2
//				int carry = 0;
//				for (int i = 0; i < n; i++)
//				{
//					a[i] = a[i] * 2 + carry;
//					if (a[i] > 9) {
//						a[i] -= 10;
//						carry = 1;
//					}
//					else carry = 0;
//				}
//				if (carry > 0) out.print(carry);
//				for (int i = n-1; i >= 0; i--)
//					out.print(a[i]);
//				out.println();
//			}
//			s = in.nextLine();
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
