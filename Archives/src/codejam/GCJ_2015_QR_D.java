package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2015_QR_D
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "D-ex";
//	final String PROBLEM_NAME = "D-small-attempt0";
//	final String PROBLEM_NAME = "D-small-attempt1";
	final String PROBLEM_NAME = "D-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2015_QR_D().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + ".in")); //"_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + ".out")); //"_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		String gab = "GABRIEL";
		for (int tc = 1; tc <= T; tc++)
		{
			int x = in.nextInt();
			int r = in.nextInt();
			int c = in.nextInt();
			
			String ans = "RICHARD";
			//Richard wins for x >= 7 if he picks the one with a hole
			if (x < 7)
			{
				if (x == 5)
				{
					if ((r*c) % x == 0 && r > x-3 && c > x-3)
						ans = gab;
				}
				else //if (x <= 4 || x == 6)
				{
					if ((r*c) % x == 0 && r > x-2 && c > x-2)
						ans = gab;
				}
			}
			
//			if (x == 1)
//				ans = gab;
//			else if (x == 2)
//			{
//				if ((r * c) % x == 0)
//					ans = gab;
//			}
//			else if (x == 3)
//			{
//				if ((r*c) % x == 0 && r > 1 && c > 1)
//					ans = gab;
//			} 
//			else if (x == 4)
//			{
//				if ((r*c) % x == 0 && r > 2 && c > 2)
//					ans = gab;
//			}
			
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
