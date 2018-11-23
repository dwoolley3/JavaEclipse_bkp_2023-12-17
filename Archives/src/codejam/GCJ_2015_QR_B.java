package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2015_QR_B
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "B-ex2";
//	final String PROBLEM_NAME = "B-small-attempt0";
//	final String PROBLEM_NAME = "B-small-attempt1";
//	final String PROBLEM_NAME = "B-small-attempt2";
	final String PROBLEM_NAME = "B-small-attempt3";
//	final String PROBLEM_NAME = "B-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2015_QR_B().runWithFiles();
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
			int d = in.nextInt();

			int[] a = new int[1001];
			int max = 0;
			for (int i = 0; i < d; i++)
			{
				int p = in.nextInt();			
				a[p]++;
				if (p > max) max = p;
			}
			
			int min = max, splits = 0, num1, num2;
			int[] sq = {3*3, 5*5, 9*9, 17*17};
			while (max > 1)
			{				
				boolean isSquare = false;
				for (int s : sq) 
					if (s == max) isSquare = true;

				num1 = (int)(Math.sqrt(max)+0.01);
				if (isSquare && a[max] == 1 && 
				  (getMax(a,max-1) <= num1
				|| getMax(a,max-1) == num1*2 && a[num1*2] <= num1-2))
				{
					//num1 = (int)(Math.sqrt(max)+0.01);
					num2 = max - num1;
				}
				else
				{
					num1 = max/2;
					num2 = max - num1;
				}
				
				splits += a[max];
				a[num1] += a[max];
				a[num2] += a[max];
				a[max] = 0;
				max = getMax(a, max);
				min = Math.min(min, max + splits);				
			}
			
			String ans = min + "";
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	int getMax(int[] a, int lastInd)
	{
		for (int i = lastInd; i > 0; i--)
			if (a[i] > 0) return i;
		return 0;
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
