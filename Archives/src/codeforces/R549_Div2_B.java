package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R549_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R549_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	// Fails on test input: 389041744
	// Outputs 100442349 instead of 102036672
	// 3x7x9x9x9x9x9x9x9 instead of 3x8x8x9x9x9x9x9x9
	void solve()
	{
		int n = in.nextInt();
		String nst = n + "";
		int prod = 1;
		boolean all9 = true; //nst.length() > 2;
		for (int i = 2; i < nst.length(); i++) {
			prod *= 9;
			n /= 10;
			if (nst.charAt(i) != '9') all9 = false;
		} 
		
		if (n <= 9) {
			prod *= n;
		} else {
			if (!all9) n--;
			int u = n % 10;
			int t = n / 10;
			if (t < 1) t = 1;
			if (u < 1) u = 1;
			int max = t * u;
			if (u < 9) {
				u = 9;
				t--;
				if (t < 1) t = 1;
				max = Math.max(max, t * u);
			}
			if (max > 0) {
				prod *= max;
			}
		}
		
		out.println(prod);		
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
