package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R231_Div2_C //Name: Dominoes
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R231_Div2_C().run();
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
		
		@SuppressWarnings("unused")
		int one0 = 0, one1 = 0, one2 = 0;
		String s;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				s = in.next();
				if (s.equals("00")) one0++;
				else if (s.equals("11")) one2++;
				else one1++;
			}

		String[][] st = new String[n][m];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (one2 > 0)
				{
					one2--;
					if (i%2 == 0)
						st[i][j] = "11";
					else
						st[i][m-1-j] = "11";
				}
				else if (one1 > 0)
				{
				   	if (i%2 == 0)
				   		st[i][j]="10";
				   	else
				   		st[i][m-1-j]="01";
				   	one1--;
				}
				else
					if (i%2 == 0)
						st[i][j] = "00";
					else
						st[i][m-1-j] = "00";					
			}
		}
		
		for (int i = 0; i < n; i++)	
		{
			for (int j = 0; j < m; j++)
			{
				if (j > 0) out.print(" ");			
				out.print(st[i][j]);
			}
			out.println();
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
