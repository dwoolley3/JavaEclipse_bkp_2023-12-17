import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class test
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new test().run();
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
		String[] d = {"sunday", "monday", "tuesday", "wednesday",
				"thursday", "friday", "saturday"};
		int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		String s1 = in.next();
		String s2 = in.next();
		
		for (int i = 1; i <= 7; i++)
		{
			int cur_day = i;
			for (int j = 1; j <= 12; j++)
			{
				for (int k = 1; k <= m[j-1]; k++)
				{
					if (s1.equals(d[cur_day-1]) && k == 1)
					{
						int day1 = i;
						for (int j1 = 1; j1 <= 12; j1++)
						{
							for (int k1 = 1; k1 <= m[j1-1]; k1++)
							{
								if (d[day1-1].equals(s2) && k1 == 1 && j1 == (j+1))
								{
									out.println("YES");
									return;
								}
								day1++;
								if (day1 == 8) day1 = 1;
							}
						}
					}
					cur_day++;
					if (cur_day == 8) cur_day = 1;
				}
			}
		}
		
		out.println("NO");		
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
