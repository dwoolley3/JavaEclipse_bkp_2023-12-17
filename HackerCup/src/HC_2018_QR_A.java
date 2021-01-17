import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2018_QR_A
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "A_ex";
	final String PROBLEM_NAME = "A";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2018_QR_A().runWithFiles();
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
			int n = in.nextInt();
			int k = in.nextInt();
			long v = in.nextLong();
			
			String[] a = new String[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.next();
			
			int st = (int)((k * (v-1)) % n);
			int max = st + (k-1);
			if (max >= n) max = n-1;			
			
			StringBuilder s = new StringBuilder();
			for (int i = st; i <= max; i++) {				
				if (s.length() > 0) s.append(" ");
				s.append(a[i]);
			}
			
			String ans = s.toString();
			
			s = new StringBuilder();
			for (int i = 0; i < (st + (k-1) - max); i++) {
				s.append(a[i]); 
				s.append(" ");
			}
			
			ans = s.toString() + ans;
			
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
