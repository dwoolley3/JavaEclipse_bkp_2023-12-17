package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_02_CC_B_CHAIRS
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_02_CC_B_CHAIRS().run();
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
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();
			String s = in.next();
			int ones = 0, zeros = 0;
			int[] a = new int[n];
			ArrayList<Integer> z = new ArrayList<>();
			for (int i = 0; i < n; i++) 
			{
				a[i] = s.charAt(i) - '0';
				if (a[i] == 0)
					zeros++;
				else
				{
					ones++;
					z.add(zeros);
					zeros = 0;
				}
			}
			if (a[n-1] == 0)
			{
				if (a[0] == 0)
					z.add(zeros + z.get(0));
				else
					z.add(zeros);
			}
			
			int maxZeros = 0;
			for (int i = 0; i < z.size(); i++)
				maxZeros = Math.max(maxZeros, z.get(i));
			
			int ans = n - maxZeros - ones;
			
			out.println(ans);	
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
