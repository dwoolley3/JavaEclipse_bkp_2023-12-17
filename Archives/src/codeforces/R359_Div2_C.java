package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R359_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R359_Div2_C().run();
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
		int hr = in.nextInt();
		int min = in.nextInt();
		int hrLen = 1, minLen = 1;
		int h = hr-1;
		while (h / 7 > 0) 
		{
			h/=7; hrLen++;
		}
		int m = min-1;
		while (m / 7 > 0) 
		{
			m/=7; minLen++;
		}
		//out.println(hrLen + " " + minLen);
		
		int cnt = 0;
		if (hrLen + minLen > 7)
			out.println(cnt);
		else
		{
			for (h = 0; h < hr; h++)
				for (m = 0; m < min; m++)
				{
					int[] a = new int[8];
					int num = m;
					for (int i = 0; i < minLen; i++)
					{
						int x = num % 7;
						a[x]++;
						num /= 7;
					}
					num = h;
					for (int i = 0; i < hrLen; i++)
					{
						int x = num % 7;
						a[x]++;
						num /= 7;
					}
					boolean ok = true;
					for (int i = 0; i < 8 && ok; i++)
						if (a[i] > 1) ok = false;
					if (ok) cnt++;
				}
			out.println(cnt);
		}
	
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
