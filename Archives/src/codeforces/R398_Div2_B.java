package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R398_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R398_Div2_B().run();
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
		long ts = in.nextLong();
		long tf = in.nextLong();
		long t = in.nextLong();
		
		int n = in.nextInt();		

		long wait = 0, minWait = Long.MAX_VALUE;
		long minWaitTim = ts;

		long[] a = new long[n];
		long chk, tim = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextLong();
			//check a[i] - 1
			chk = a[i] - 1;
			if (i == 0)
			{
				if (chk >= tf)
				{
					wait = 0;
					minWait = ts;
					minWaitTim = 0;
					continue;
				}
				else if (chk >= ts)
					wait = 0;
				else
					wait = ts - chk;

				if (wait < minWait)
				{
					minWait = wait;
					minWaitTim = chk;
				}
				if (a[i] >= ts)
					tim = a[i] + t;
				else
					tim = ts + t;				
					
			}
			else
			{
				if (chk + t >= tf || tim + t >= tf)
				{
					if (tim < tf)
						tim += t;
					continue;
				}
				if (chk >= tim)
					wait = 0;
				else
					wait = tim - chk;
				if (wait < minWait)
				{
					minWait = wait;
					minWaitTim = chk;
				}
				if (a[i] >= tim)
					tim = a[i] + t;
				else
					tim = tim + t;
			}
		}
		chk = tim;
		if (tim == 0) chk = ts;
		//if no one at chk, then wait == 0
		if (chk + t <= tf)
		{
			wait = 0;
			if (wait < minWait)
			{
				minWait = wait;
				minWaitTim = chk;
			}
		}
		
		out.println(minWaitTim);		
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
