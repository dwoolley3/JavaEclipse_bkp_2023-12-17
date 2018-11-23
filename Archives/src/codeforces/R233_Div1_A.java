package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R233_Div1_A //Name: Cards
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R233_Div1_A().run();
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
		long a = in.nextInt();
		long b = in.nextInt();
		
		long score1 = 0;
		StringBuilder sb = new StringBuilder();
		
		if (a == 0 || b <= 1)
		{
			out.println(a*a-b*b);
			for (int i = 0; i < a; i++)
				sb.append('o');
			for (int i = 0; i < b; i++)
				sb.append('x');
			out.println(sb);
		}
		else 
		{
			long min = Math.min(a, b-1);  //max # of spots for a: o
			long bestk = 0, maxScore = Long.MIN_VALUE;
			for (long k = 1; k <= min; k++)
			{
				long inc = b / (k+1);
				long rem = b % (k+1);
				score1 = (a-k+1)*(a-k+1) + (k-1) - (inc+1)*(inc+1)*rem - inc*inc*(k+1-rem);
				if (score1 > maxScore)
				{
					maxScore = score1;
					bestk = k;
				}
				score1 = 0;
			}
			out.println(maxScore);

			long inc1 = b / (bestk+1);
			long rem1 = b % (bestk+1);
			for (int j = 0; j < bestk; j++)
			{
				if (j < rem1) 
					for (int i = 0; i < inc1+1; i++) sb.append('x');
				else 
					for (int i = 0; i < inc1; i++) sb.append('x');
				sb.append('o');
			}
			for (long j = bestk; j < a; j++) sb.append('o');
			for (long j = 0; j < inc1; j++) sb.append('x');
			
			out.println(sb);
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
