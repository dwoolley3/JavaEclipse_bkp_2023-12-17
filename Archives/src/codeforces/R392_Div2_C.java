package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R392_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R392_Div2_C().run();
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
		long k = in.nextLong();
		int x = in.nextInt();
		int y = in.nextInt();
		
		long full,rem,max,min,ser;
		if (n == 1 || n == 2)
		{
			full = k / (n*m);		
			rem = k - full * (n*m);
			
			max = full;
			if (rem > 0) max++;
			
			min = full;		
			ser = min;
			if (rem >= (x-1)*m + y) ser++;
		}
		else // n > 2
		{			
			int mid = (n-2) * m;
			int midplus1 = mid + m;
			
			full = k / midplus1;		
			rem = k - full * midplus1;
			
			max = full;
			if (full % 2 == 1 && rem > m) max++;
			if (full % 2 == 0 && ((full == 0 && rem > 0) || (full > 0 && rem > m)))
				max++;
			
			min = full / 2;
			if (full % 2 == 1 && rem >= m) min++;	
			
			if (x == 1)
			{
				ser = full / 2;
				if (full % 2 == 0 && rem >= y) ser++;
				if (full % 2 == 1) ser++;
			}
			else if (x == n)
			{
				ser = full / 2;
				if (full % 2 == 1 && rem >= y) ser++;	
			}
			else // middle
			{
				ser = full;
				if (full % 2 == 0)
				{
					if (rem >= (x-1)*m + y) ser++;
				}
				else //full%2 == 1
				{
					if (rem >= (n-x)*m + y) ser++;
				}
			}
		}

		out.println(max + " " + min + " " + ser);		
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
