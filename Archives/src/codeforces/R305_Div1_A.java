package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R305_Div1_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R305_Div1_A().run();
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
		int m = in.nextInt();
		long h1 = in.nextInt(); long a1 = in.nextInt(); //cur, goal
		long x1 = in.nextInt(); long y1 = in.nextInt();
		long h2 = in.nextInt(); long a2 = in.nextInt(); //cur, goal
		long x2 = in.nextInt(); long y2 = in.nextInt();
				
		int[] xa = new int[m+1];
		int[] ab = new int[m+1];
		
		//Flaw - cycle may not repeat at beginning: 1, 4, 6, 9, 5, 6, 9, 5, 6, 9, 5
		long ans1 = 0, ans2 = 0;
		int h = (int)h1;
		xa[h] = -1;
		int i = 1;
		for (i = 1; i <= m; i++) 
		{
			h1 = (x1 * h1 + y1) % m;
			h = (int)h1;
			if (h == a1) ans1 = i;
			if (xa[h] == 0)
			{
				xa[h] = i;
			}
			else
				break;			
		}
		long cyc1 = i;
		
		h = (int)h2;
		ab[h] = -1;
		i = 1;
		for (i = 1; i <= m; i++) 
		{
			h2 = (x2 * h2 + y2) % m;
			h = (int)h2;
			if (h == a2) ans2 = i;
			if (ab[h] == 0)
			{
				ab[h] = i;
			}
			else
				break;
		}
		long cyc2 = i;

		long ans = -1;
		if (ans1 > 0 && ans1 == ans2)
			ans = ans1;
		else if (ans1 > 0 && ans2 > 0 && (cyc1 != cyc2))
			for (int y = 0; y <= 10_000_000; y++)
			{
				if ((cyc2*y + ans2 - ans1) % cyc1 == 0)
				{
					ans = cyc2*y + ans2;
					break;
				}
			}

		out.println(ans);
		
		out.println(ans1 + " " + ans2);		
		out.println(cyc1 + " " + cyc2);	
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
