package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


class CC2014_03_Trinity_DJ_OPEN_A_TR004
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args) {
		new CC2014_03_Trinity_DJ_OPEN_A_TR004().run();
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
		
		String ModSt = "1000000007";
		BigInteger biMod = new BigInteger(ModSt);

		for (int i = 0; i < t; i++) 
		{
			BigInteger tl = in.nextBigInteger();
			BigInteger n = in.nextBigInteger();
			//If n == 0, then num = tl % biMod
			if (n.equals(BigInteger.ONE)) n = BigInteger.ZERO;
			BigInteger num = tl.modPow(n, biMod);
			out.println(num);					
			
//		    num = BigInteger.ONE;
//		    while (n.compareTo(BigInteger.ZERO) > 0)
//		    {
//		        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
//		            num = num.multiply(b).mod(biMod); 
//		        b = b.multiply(b).mod(biMod);
//		        n = n.divide(BigInteger.ONE.add(BigInteger.ONE));
//		        //out.println(num + " " + b + " " + n);
//		    }
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
