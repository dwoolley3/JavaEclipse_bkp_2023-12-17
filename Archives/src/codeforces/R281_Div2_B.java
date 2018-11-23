package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R281_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R281_Div2_B().run();
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
		int[] b = new int[n];
		int ai = -1, bi = -1, lastApos = -1, lastBpos = -1;
		long suma = 0, sumb = 0;
		for (int i = 0; i < n; i++)
		{
			int x = in.nextInt();
			if (x > 0) {
				ai++;
				a[ai] = x;
				lastApos = i;
				suma += a[ai];
			} else {
				bi++;
				b[bi] = -x;
				lastBpos = i;
				sumb += b[bi];
			}
		}
		
		boolean first = true;
		if (suma < sumb) first = false;
		else if (suma == sumb) {
			boolean dif = false;
			int min = Math.min(ai,bi);
			for (int i = 0; i <= min && !dif; i++)
				if (a[i] > b[i]) { first = true; dif = true; }
				else if (a[i] < b[i]) { first = false; dif = true; }
			
			if (!dif)
				if (ai < bi) first = false;
				else if (ai > bi) first = true;
				else if (lastApos < lastBpos) first = false;						
		}
		
		if (first)
			out.println("first");
		else 
			out.println("second");
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
