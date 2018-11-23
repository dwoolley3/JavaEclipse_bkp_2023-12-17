package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2018_QR_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2018_QR_A().run();
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
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int d = in.nextInt();
			String p = in.next();
			int sc = getScore(p);	
			boolean changed = true;
			int chg = 0;
			while (sc > d && changed) {
				String np = moveS(p);
				changed = (!np.equals(p));	
				p = np;
				sc = getScore(p);
				chg++;
			}
		
			String ans = (sc <= d) ? chg + "" : "IMPOSSIBLE";
			
			System.out.println("Case #" + tc + ": " + ans);
		}
		
		
	}
	
	String moveS(String s) {
		int n = s.length();
		for (int i = n-1; i > 0; i--)
			if (s.charAt(i-1) == 'C' && s.charAt(i) == 'S') {
				return s.substring(0, i-1) + "SC" + s.substring(i+1);
			}
		return s;
	}
	
	int getScore(String s) {
		int n = s.length();
		int sc = 0, pow = 1;
		for (int i = 0; i < n; i++)
			if (s.charAt(i) == 'C') pow *= 2;
			else sc += pow;
		return sc;
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
