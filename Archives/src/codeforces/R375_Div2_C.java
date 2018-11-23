package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R375_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R375_Div2_C().run();
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
		int m = in.nextInt();
		
		int[] b = new int[m+1];
		int outBounds = 0, chg = 0;
		int[] a = new int[n];
		int firstOB = -1;
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			if (a[i] <= m) 
				b[a[i]]++;
			else
			{
				outBounds++;
				if (firstOB == -1) firstOB = i;
			}
		}
		int maxOfMins = n / m;
		for (int i = 1; i <= m; i++)
		{
			while (b[i] < maxOfMins && outBounds > 0)
			{
				for (int j = firstOB; j < n; j++)
					if (a[j] > m)
					{
						a[j] = i;
						b[i]++;
						outBounds--;
						firstOB++;
						chg++;
						break;
					}
			}
		}
//		for (int i = 1; i <= m; i++)
//		{
//			while (b[i] == maxOfMins && outBounds > 0)
//			{
//				for (int j = firstOB; j < n; j++)
//					if (a[j] > m)
//					{
//						a[j] = i;
//						b[i]++;
//						outBounds--;
//						firstOB++;
//						break;
//					}
//			}
//		}
		
		if (outBounds == 0)
		for (int i = 1; i <= m; i++)
			if (b[i] < maxOfMins)
			{
				int maxInd = 0, maxNum = 0;
				for (int j = 1; j <= m; j++)
					if (b[j] > maxNum) 
					{
						maxNum = b[j];
						maxInd = j;
					}
				int x = Math.min(maxOfMins - b[i], b[maxInd] - maxOfMins);
				b[i] += x;
				b[maxInd] -= x;
				chg += x;
				for (int j = 0; j < n && x > 0; j++)
					if (a[j] == maxInd)
					{
						a[j] = i;
						x--;
					}
			}
		
		out.println(maxOfMins + " " + chg);
		
		for (int x : a)
			out.print(x + " ");
		out.println();
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
