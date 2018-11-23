package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R330_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R330_Div2_B().run();
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
		int k = in.nextInt();  //n divisible by k
		long MOD = 1_000_000_007;
		
		int[] a = new int[n/k];
		for (int i = 0; i < n/k; i++) 
			a[i] = in.nextInt();
		
		int[] b = new int[n/k];
		for (int i = 0; i < n/k; i++) 
			b[i] = in.nextInt();
		
		long prod = 1;
		for (int i = 0; i < n/k; i++)
		{
			int cnt = 0;	
			int x = (int)(Math.pow(10, k) + .1);
			//int sum = 0;
			//while (sum < x)
			//{
				//String s = sum +"";
				//if (s.length() < k) s = "0" + s;
				//if (s.charAt(0)-'0' != b[i]) cnt++;
				//sum += a[i];
			//}
			if (b[i] == 0)
			{
				//cnt between x/10 and x-1
				cnt = (x-1) / a[i] + 1;  //+1 for all 0s
				cnt -= ((x/10 - 1) / a[i] + 1);
			}
			else //(b[i] > 0)
			{
				//cnt between 0 and (x/10 * b[i]) - 1
				//cnt between x/10 * (b[i]+1) - 1 and x-1
				cnt = (x/10*b[i] -1) / a[i] + 1;
				cnt += ((x-1) / a[i]) - ((x/10*(b[i]+1) - 1) / a[i]);
			}

			prod *= cnt;
			prod %= MOD;
		}
	
		out.println(prod);		
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
