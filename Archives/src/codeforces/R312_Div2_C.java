package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R312_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R312_Div2_C().run();
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
		
		int[] a = new int[n];
		int max = 0, maxi = 0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (max < a[i])
			{
				max = a[i];
				maxi = i;
			}
		}
		
		int min = Integer.MAX_VALUE;
		//for (int i = 0; i < n; i++)
		{
			int x = a[maxi];
			int cntx = 0;
			while (x >= 1)
			{
				int cnt = 0;
				boolean ok = true;
				for (int j = 0; j < n && ok; j++)
				{
					if (maxi == j) cnt += cntx;
					else
					{
						int y = a[j];	
						int cnty = 0;
						while (y > x)
						{
							cnty++;
							y /= 2;
						}
						while (y < x)
						{
							cnty++;
							y *= 2;
						}
						if (x == y)
						{
							cnt += cnty;							
						}
						else ok = false;							
					}
				}
				if (ok)
					min = Math.min(min, cnt);
				
				x = x >> 1;
				cntx++;
			}
		}
		
		out.println(min);		
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
