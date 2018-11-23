package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HR_2014_Addepar_Easy_Upstairs
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_2014_Addepar_Easy_Upstairs().run();
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
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		
		int max = -2, maxi = -2;
		for (int i = 0; i < n-1; i++)
		{
			int sum = 0, sum2 = 0;
			if (i-1 >= 0 && a[i-1] < a[i]) sum += (a[i]-a[i-1]);
			if (a[i] < a[i+1]) sum += (a[i+1]-a[i]);
			if (i+2 < n && a[i+1] < a[i+2]) sum += (a[i+2] - a[i+1]);
			if (sum > 0)
			{
				if (i-1 >= 0 && a[i-1] < a[i+1]) sum2 += (a[i+1]-a[i-1]);
				if (a[i+1] < a[i]) sum2 += (a[i]-a[i+1]);
				if (i+2 < n && a[i] < a[i+2]) sum2 += (a[i+2] - a[i]);
				if (sum2 < sum && sum - sum2 > max)
				{
					max = sum - sum2;
					maxi = i;
				}
			}
		}	
		
		out.println(maxi + 1);	
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
