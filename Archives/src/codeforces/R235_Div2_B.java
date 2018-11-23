package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R235_Div2_B //Name: Sereja and Contests
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R235_Div2_B().run();
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
		int x = in.nextInt();
		int k = in.nextInt();
		
		int[] a = new int[4001];
		for (int i = 0; i < k; i++) 
		{
			int num = in.nextInt();
			int num2 = in.nextInt();
			a[num2] = 1;
			if (num == 1)
			{
				int num1 = in.nextInt();
				a[num1] = 1;
			}
		}
		 
		int min = 0, max = 0, cnt = 0;
		a[x] = 1;
		for (int i = 1; i <= x; i++)
		{
			if (a[i] == 0) 
			{
				max++;
				cnt++;
			}
			else 
			{
				if (cnt > 0)
				{
					min += cnt / 2; 
					if (cnt % 2 == 1) min++;
					cnt = 0;
				}
			}
		}
		
		out.println(min + " " + max);		
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
