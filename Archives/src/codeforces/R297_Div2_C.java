package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R297_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R297_Div2_C().run();
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
		
		int[] a = new int[1_000_001];
		int[] l = new int[n];
		for (int i = 0; i < n; i++)
		{
			l[i] = in.nextInt();		
			a[l[i]]++;
		}
		Arrays.sort(l);
		
		long area = 0;		
		for (int i = 1_000_000; i > 1; i--)
			if (a[i] % 2 == 1 && a[i-1] % 2 == 1)
			{
				a[i]--; a[i-1]++;
			}
				
		int lastj = n-1;
		for (int i = n-1; i >= 0; i--)
		{
			if (a[l[i]] >= 4)
			{
				long rec = a[l[i]] / 4;
				a[l[i]] -= (rec * 4);
				area += (rec*l[i]*l[i]);
			}
			if (a[l[i]] >= 2) 
			{
				lastj = Math.min(lastj,  i-1);
				for (int j = lastj; j >= 0 && a[l[i]] >= 2; j--)
					if (l[j] != l[i] && a[l[j]] >= 2)
					{
						long rec = Math.min(a[l[i]] / 2, a[l[j]] / 2);
						a[l[i]] -= (rec * 2);
						a[l[j]] -= (rec * 2);
						area += (rec * l[i]*l[j]);
						lastj = j;
					}	
				lastj--;
			}
		}
			
		out.println(area);		
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
