import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2018_QR_A
{	
	FastReader in;
	PrintWriter out;
	final String PROBLEM_NAME = "A-ex";
//	final String PROBLEM_NAME = "A-small-attempt0";
//	final String PROBLEM_NAME = "A-small-attempt1";
//	final String PROBLEM_NAME = "A-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2018_QR_A().runWithFiles();
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
			int n = in.nextInt();
			int n1 = n/2 + (n%2);
			int n2 = n/2;
			
			int[] a1 = new int[n1];
			int[] a2 = new int[n2];
			int i1 = 0, i2 = 0;
			for (int i = 0; i < n; i++)
				if (i%2 == 0)
					a1[i1++] = in.nextInt();
				else
					a2[i2++] = in.nextInt();
			
			Arrays.sort(a1);
			Arrays.sort(a2);
			int[] a = new int[n];
			for (int i = 0; i < n2; i++)
			{
				a[i*2] = a1[i];
				a[i*2+1] = a2[i];
			}
			if (n1 > n2)
				a[n-1] = a1[n1];
				
			int ind = -1;
			for (int i = 0; i < n && ind == -1; i++)
				if (a[i] > a[i+1]) ind = i;			
			
			String ans = (ind == -1) ? "OK" : ind + "";
			
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
