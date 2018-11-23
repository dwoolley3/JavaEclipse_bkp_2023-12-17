package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2017_R1_A
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "A_ex";
	final String PROBLEM_NAME = "A";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2017_R1_A().runWithFiles();
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
			int m = in.nextInt();
			
			int[][] c = new int[n][m];
			int[] a = new int[m];
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < m; j++)
					a[j] = in.nextInt();
				Arrays.sort(a);
				int sum = 0;
				for (int j = 0; j < m; j++)
				{
					sum += a[j];				
					c[i][j] = sum + (j+1)*(j+1);
					//System.out.print(c[i][j] + " ");
				}
				//System.out.println();
			}
			
			int minSum = 0;
			int[] start = new int[n];
			for (int i = 0; i < n; i++)
			{
				int min = Integer.MAX_VALUE;	
				int minj = -1;
				for (int j = 0; j < n; j++)
				{
					if (start[j] < m)
					{
						int increment = c[j][start[j]];
						if (start[j] > 0)
							increment -= c[j][start[j]-1];
						if (increment < min)
						{
							min = increment;
							minj = j;
						}
					}
				}
				minSum += min;
				start[minj]++;
			}

			String ans = minSum + "";
			
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
