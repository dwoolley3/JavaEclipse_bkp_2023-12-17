package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R596_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R596_Div2_C().run();
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
		int p = in.nextInt();
		
		for (int i = 1; i < 32; i++) {
			int n2 = n - (p * i);
			if (n2 < 1) break;			
			if (foundPowersOf2(i, n2)) {
				out.println(i);
				return;
			}
		}
		out.println(-1);

	}
	
	// Return true of there are numPowOf2 that sum to n
	boolean foundPowersOf2(int numPowOf2, int n) {
		int bc = Integer.bitCount(n);
		if (bc == numPowOf2) return true;  // unique powers of 2
		if (bc < numPowOf2) return true;   // make some duplicate
		
		return false;
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
