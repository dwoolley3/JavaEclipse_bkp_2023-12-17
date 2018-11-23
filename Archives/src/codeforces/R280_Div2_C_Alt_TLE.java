package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class R280_Div2_C_Alt_TLE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R280_Div2_C_Alt_TLE().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//TLE - Time Limit Exceeded, but bubble sort is a good alternative 
	//      if number of elements to sort is small.
	void solve()
	{
		int n = in.nextInt();
		int r = in.nextInt();
		long avg = in.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			b[i] = in.nextInt();
			sum += a[i];
		}
		//Customized sort is easy to produce, but sort takes too long O(n^2)
		for (int i = 0; i < n; i++)
			for (int j = i+1; j < n; j++)
				if (b[j] < b[i]) {
					int t = b[j]; b[j] = b[i]; b[i] = t;
					t = a[j]; a[j] = a[i]; a[i] = t;
				}
        
		long sumNeeded = avg * n;
		long dif = sumNeeded - sum;
		long essays = 0;
		int i = 0;
		while (sumNeeded > sum && i < n)
		{	
			dif = sumNeeded - sum;
			long min = Math.min(dif, r - a[i]);
			essays += (min * b[i]);
			sum += min;
			i++;
		}
	
		out.println(essays);		
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

