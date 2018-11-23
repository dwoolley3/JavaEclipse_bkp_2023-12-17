package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R297_Zeto_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R297_Zeto_B().run();
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
		
		int last = (int)Math.pow(2, n+1) - 1;
		int[] a = new int[last+1];
		for (int i = 2; i <= last; i++) 
			a[i] = in.nextInt();
		
		long cnt = 0;
		int maxInRow = 0;
		for (int i = n-1; i >= 0; i--)
		{
			int m = (int)Math.pow(2, i);
			for (int j = 0; j < m; j++)
			{
				if (i < n-1)
				{
					a[last-j*2] += a[(last-j*2)*2];
					a[last-j*2-1] += a[(last-j*2-1)*2];
				}
				int dif = Math.abs(a[last - j*2] - a[last - j*2 - 1]);
				int max = Math.max(a[last - j*2],  a[last - j*2 - 1]);
				cnt += dif;
				a[last - j*2] = max;
				a[last - j*2 - 1] = max;
				if (max > maxInRow) maxInRow = max;
			}
			last -= m*2;
		}
		
		out.println(cnt);		
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
