package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R407_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R407_Div2_C().run();
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
		
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) 
			a[i] = in.nextInt();
		
		long cnt = 0, fact = 1, max = 0, cnt1, cnt2;
		cnt = Math.abs(a[1] - a[1+1]) * fact;
		max = Math.max(max, cnt);
		
		for (int i = 2; i < n-1; i+=2)
		{
			fact *= -1;
			cnt1 = Math.abs(a[i] - a[i+1]) * fact;
			fact *= -1;
			cnt2 = Math.abs(a[i+1] - a[i+2]) * fact;
			
			if (cnt1 + cnt2 >= 0)
				cnt += cnt1 + cnt2;
			else if (cnt + cnt1 + cnt2 >= cnt2)
				cnt += cnt1 + cnt2;
			else
				cnt = cnt2;
			max = Math.max(max, cnt);
		}
		
		if (n > 2)
		{
			fact = 1;
			cnt = Math.abs(a[2] - a[2+1]) * fact;
			max = Math.max(max, cnt);
			
			for (int i = 3; i < n-1; i+=2)
			{
				fact *= -1;
				cnt1 = Math.abs(a[i] - a[i+1]) * fact;
				fact *= -1;
				cnt2 = Math.abs(a[i+1] - a[i+2]) * fact;
				
				if (cnt1 + cnt2 >= 0)
					cnt += cnt1 + cnt2;
				else if (cnt + cnt1 + cnt2 >= cnt2)
					cnt += cnt1 + cnt2;
				else
					cnt = cnt2;
				max = Math.max(max, cnt);
			}
		}
		
		out.println(max);		
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
