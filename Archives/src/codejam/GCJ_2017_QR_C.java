package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2017_QR_C
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "C-ex";
//	final String PROBLEM_NAME = "C-small-1-attempt0";
//	final String PROBLEM_NAME = "C-small-1-attempt1";
	final String PROBLEM_NAME = "C-small-1-attempt2";
//	final String PROBLEM_NAME = "C-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2017_QR_C().runWithFiles();
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
			long n = in.nextLong();			
			long k = in.nextLong();
			long max = n, min = n;
			long numOfMax = 1;
			
			long pow2 = 1, sumPow2 = 0;
			while (sumPow2 + pow2 < k)
			{
				sumPow2 += pow2;
				min--;
				max--;
				
				if (min == max)
				{
					//numOfMin = pow2;
					numOfMax = pow2;
				}
				else if (min % 2 == 0)
				{
					//numOfMin = pow2 + pow2 / 2;
					numOfMax = pow2 / 2;
				}
				else if (max % 2 == 0)
				{
					numOfMax = pow2 + pow2 / 2;
					//numOfMin = pow2 / 2;
				}
							
				min = min / 2;
				max = max / 2 + (max % 2 == 1 ? 1 : 0);
				
				pow2 *= 2;
				//System.out.println(pow2 + " " + max + " " + min);
			}
			
			long need = k - sumPow2;
			long range = (need <= numOfMax) ? max : min;
			//System.out.println(pow2 + " " + max + " " + min + " " + need + " " + numOfMax + " " + range);

			if (range > 0)
				range--;
			min = range / 2;
			max = range - min;
			
			String ans = max + " " + min;
			
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
