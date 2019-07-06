package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2018_QR_C
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "C_ex";
	final String PROBLEM_NAME = "C";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2018_QR_C().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + "_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + "_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			String s = in.next();
			int n = s.length();
			
			String ans = "Impossible";
			boolean ok = false;
			for (int i = 1; i < n; i++)
				if (s.charAt(0) != s.charAt(i)) ok = true;
			
			if (ok) {
			for (int i = 1; i < n-1; i++) {
				if (s.charAt(i) == s.charAt(0)) {
					if (!s.substring(i+1).startsWith(s.substring(1,i+1))) {
						ans = s.substring(0, i) + s;
						break;
					}

				}
			}
			}

			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
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
