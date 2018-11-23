package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R290_Rocket_G1
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R290_Rocket_G1().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int n,k,cnt,inv;
	void solve()
	{
		n = in.nextInt();
		k = in.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		cnt = 0; inv = 0;
		perm(k-1, a);
		
		//out.println(inv + "/" + cnt);
		double ans = (double)inv / cnt;		
		out.println(ans);
	}
	
	private void perm(int level, int[] a)
	{
		if (level < 0) return;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
			{
				//reverse 
				for (int kk = 0; kk < (j-i +1)/2; kk++)
				{
					int t = a[i+kk]; a[i+kk] = a[j-kk]; a[j-kk] = t;
				}
				if (level == 0) 
				{ 
					cnt++;
					//Check for inverses
					for (int b = 0; b < n; b++)
						for (int c = b; c < n; c++)
						{
							if (a[b] > a[c]) inv++;
						}
				}
				int[] b = new int[n];
				for (int kk = 0; kk < n; kk++) b[kk] = a[kk];
				perm(level-1,b);
				//un-reverse
				for (int kk = 0; kk < (j-i +1)/2; kk++)
				{
					int t = a[i+kk]; a[i+kk] = a[j-kk]; a[j-kk] = t;
				}
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
