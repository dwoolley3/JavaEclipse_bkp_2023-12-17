package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R320_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R320_Div2_D().run();
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
		int k = in.nextInt();
		int x = in.nextInt();
		
		long[] a = new long[n];
		long maxh = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			long h = Long.highestOneBit(a[i]);
			if (h > maxh)
				maxh = h;
		}
		
		//Input: 5 1 3
		//Input: 1 5 13 8 16
		//Answer = 63, not 61		
		ArrayList<Integer> ind = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			//if (Long.highestOneBit(a[i]) == maxh || n < 6)
				ind.add(i);

		int[] bit = new int[64];
		int[] bitCopy = new int[64];
		for (int i = 0; i < n; i++)
		{
			long temp = a[i];		
			for (int j = 0; j < 64; j++)
			{
				long b = temp & 1L;
				bit[j]+= b;
				temp = temp >> 1;
			}
		}
		for (int jj = 0; jj < 64; jj++)
			bitCopy[jj] = bit[jj];
		
		long max = 0;
		for (int j = 0; j < ind.size(); j++)
		{
			for (int jj = 0; jj < 64; jj++)
				bit[jj] = bitCopy[jj];
			
			int aInd = ind.get(j);
			long temp = a[aInd];
			//subtract
			for (int jj = 0; jj < 64; jj++)
			{
				long b = temp & 1L;
				bit[jj]-= b;
				temp = temp >> 1;
			}
			temp = a[aInd];
			for (int i = 0; i < k; i++)
				temp *= x;
			
			for (int jj = 0; jj < 64; jj++)
			{
				long b = temp & 1L;
				bit[jj]+= b;
				temp = temp >> 1;
			}
			
			long bitOr = 0;	
			for (int i = 63; i >= 0; i--)
				if (bit[i] > 0)
					bitOr = bitOr * 2 + 1;
				else
					bitOr *= 2;
			
			if (bitOr > max) max = bitOr;
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
