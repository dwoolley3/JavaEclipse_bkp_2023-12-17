package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2017_QR_C2
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "C-ex";
	final String PROBLEM_NAME = "C-small-1-attempt0";
//	final String PROBLEM_NAME = "C-small-1-attempt1";
//	final String PROBLEM_NAME = "C-small-1-attempt2";
//	final String PROBLEM_NAME = "C-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2017_QR_C2().runWithFiles();
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
			long N = in.nextLong() + 1;			
			long K = in.nextLong();
			
			for(int step=0;;step++){
				long groups = (1l<<step);
				if(K > groups){
					K -= groups;
					continue;
				}
				
				long small = N / groups;
				long big = small + 1;
				long bigcnt = N % groups;
				//long smallcnt = groups - bigcnt;
				
				long x = big;
				if(K > bigcnt) x = small;
				
				long max = (x + 1) / 2 - 1;
				long min = x / 2 - 1;
				
				String ans = max + " " + min;
				
				System.out.println("Case #" + tc + ": " + ans);
				out.println("Case #" + tc + ": " + ans);
				break;
			}
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
