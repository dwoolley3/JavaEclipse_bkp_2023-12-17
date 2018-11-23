package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2017_R27_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2017_R27_B().run();
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
		String s = in.next();
		
		int n = 3;
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) { 
			a[i] = s.charAt(i) - '0';
			b[i] = s.charAt(3+i) - '0';
		}		
		int asum = a[0]+a[1]+a[2];
		int bsum = b[0]+b[1]+b[2];
		if (asum > bsum) {
			int t = a[0]; a[0] = b[0]; b[0] = t;
			t = a[1]; a[1] = b[1]; b[1] = t;
			t = a[2]; a[2] = b[2]; b[2] = t;
			t = asum; asum = bsum; bsum = t;
		}		
		Arrays.sort(a);
		Arrays.sort(b);

		int chg = 0;		
		int aind = 0, bind = 2;
		while (asum < bsum)
		{
			if (9 - a[aind] > b[bind])
			{
				asum += (9 - a[aind]);
				aind++;
			}
			else
			{
				bsum -= (b[bind]);
				bind--;
			}
			chg++;
		}
		
		out.println(chg);
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
