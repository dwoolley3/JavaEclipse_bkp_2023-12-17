package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2016_R1_B
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "B_ex";
	final String PROBLEM_NAME = "B";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2016_R1_B().runWithFiles();
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
			int L = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();
			int d = in.nextInt();			
			
			int[] w = new int[n];
			for (int i = 0; i < n; i++) 
				w[i] = in.nextInt();
			
			Arrays.sort(w);
			
			long lo = 1, hi = Long.MAX_VALUE, mid;
	      	while (lo < hi)
	      	{
	           mid = lo + (hi - lo) / 2;
	           if (!check(mid, w, L))
	        	   lo = mid + 1; 
	           else
	               hi = mid;                           
	      	}
	      	//lo has minimum number of minutes to wash clothes
			long ans = lo;
			//if (L <= m) 
			//	ans += d;  //Add num of min to dry clothes
			//else
			{	      	
				if (m > L) m = L;
		      	long[] loadWashedAt = new long[L];
		      	int sum = 0, ind = 0;
		      	for (int i = 0; i < n; i++)
		      	{
		      		int numOfLoadsForWasher = (int)(lo / w[i]);
		      		numOfLoadsForWasher = Math.min(numOfLoadsForWasher, L - sum );
		      		sum += numOfLoadsForWasher;
		      		for (int j = 1; j <= numOfLoadsForWasher; j++)
		      			loadWashedAt[ind++] = 1L * w[i] * j;
		      	}
		      	
		      	Arrays.sort(loadWashedAt);
		      	
		      	//System.out.println("Total mins = " + lo);
		      	int numDryers = m;
		      	long[] dryer = new long[numDryers];
		      	long dryMins = 0;
		      	ind = 0;
		      	for (int i = 0; i < L; i++)
		      	{
		      		ind = i % numDryers;
		      		dryer[ind] = Math.max(dryer[ind], loadWashedAt[i]) + d;
		      		//System.out.print(dryer[ind] + " ");
		      		dryMins = Math.max(dryMins, dryer[ind]);  		
		      	}
		      	//System.out.println();
		      	ans = dryMins;
			}
		
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	static boolean check(long mid, int[] w, int L)
	{
		//mid is number of minutes to wash all loads
		long sumLoads = 0;
		for (int i = 0; i < w.length; i++)
			sumLoads += mid / w[i];
		return sumLoads >= L;
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
