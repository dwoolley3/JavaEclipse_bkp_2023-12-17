package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2017_R1B_B_small
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "B-ex";
	final String PROBLEM_NAME = "B-small-attempt0";
//	final String PROBLEM_NAME = "B-small-attempt1";
//	final String PROBLEM_NAME = "B-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2017_R1B_B_small().runWithFiles();
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
	
	@SuppressWarnings("unused")
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			
			int r = in.nextInt();
			int o = in.nextInt();  //o=r+y
			int y = in.nextInt();
			int g = in.nextInt();  //g=y+b
			int b = in.nextInt();  
			int v = in.nextInt();  //v=r+b
			
			String col = "RYB";
			int[] pos = {0,1,2};
			int[] c = {r,y,b};
			for (int i = 0; i < 3; i++)
				for (int j = i+1; j < 3; j++)
				{
					if (c[i] < c[j])
					{
						int t = c[i]; c[i] = c[j]; c[j] = t;
						t = pos[i]; pos[i] = pos[j]; pos[j] = t;
					}
				}

			String ans = "";
			if (c[0] > c[1] + c[2]) 
				ans = "IMPOSSIBLE";
			else
			{
				int first = 1, second = 2;
				while (c[0] + c[1] + c[2] > 0)
				{
					if (c[0] > 0)
					{
						ans += col.charAt(pos[0]);
						c[0]--;
					}
					if (c[first] > 0)
					{
						ans += col.charAt(pos[first]);
						c[first]--;
					}
					else if (c[second] > 0)
					{
						ans += col.charAt(pos[second]);
						c[second]--;
					}
					if (c[first] <= c[second]) 
					{
						int t = first; first = second; second = t;
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
