package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2017_QR_B_small
{	
	FastReader in;
	PrintWriter out;
	final String PROBLEM_NAME = "B-ex";
//	final String PROBLEM_NAME = "B-small-attempt0";
//	final String PROBLEM_NAME = "B-small-attempt1";
//	final String PROBLEM_NAME = "B-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2017_QR_B_small().runWithFiles();
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

		for (int tc = 1; tc <= T; tc++)
		{
//			int N = in.nextInt();
//			int n = N;
//			while (n > 0)
//			{
//				String s = n + "";
//				boolean ok = true;
//				for (int i = 0; i < s.length() -1; i++)
//					if (s.charAt(i) > s.charAt(i+1)) ok = false;
//				if (ok) break;		
//				n--;
//			}
//			String ans = n + " ";
			
			
			String s = in.next();
			//String s = N + "";
			int n = s.length();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = s.charAt(i) - '0';
			
			for (int i = 0; i < n-1; i++)
			{
				if (a[i] > a[i+1])
				{
					a[i]--;
					int first = i;
					for (first = i-1; first >= 0; first--)
						if (a[first] <= a[i]) break;
					
					first++;
					if (first < i)
						a[first]--;
					for (int j = first+1; j <= n-1; j++)
						a[j] = 9;
					break;
				}
			}
			long last = a[0];
			for (int i = 1; i < n; i++)
				last = last * 10 + a[i];

			String ans = "" + last;
			
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
