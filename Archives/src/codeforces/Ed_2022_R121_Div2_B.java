package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2022_R121_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2022_R121_Div2_B().run();
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
		for (int T = 0; T < t; T++) {
			// Retain sum having 2 non-zero digits, as far right as possible
			// Otherwise, sum first 2 digits
			String s = in.next();
			char[] c = s.toCharArray();
			int n = s.length();
			int d1, d2, sum, offset = 0;
			boolean good = false;
			for (int i = n-1; i > 0 && !good; i--) {
				d1 = c[i-1] - '0';
				d2 = c[i] - '0';
				sum = d1 + d2;
				if (d1 + d2 > 9) {
					d1 = 1;
					d2 = sum - 10;
					c[i-1] = (char)('0' + d1);
					c[i] = (char)('0' + d2);
					good = true;
				}
			}
			if (!good) {
				d1 = c[0] - '0';
				d2 = c[1] - '0';
				sum = d1 + d2;
				d2 = sum;
				c[1] = (char)('0' + d2);
				offset = 1;
			}
			
			int length = n - offset;
			out.println(new String(c, offset, length));
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
