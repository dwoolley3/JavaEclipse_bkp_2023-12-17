package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2022_QR_B_3D_Printing_Solution
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2022_QR_B_3D_Printing_Solution().run();
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
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{	
			int[] cmin = new int[4];
			int c;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					c = in.nextInt();
					if (i == 0)
						cmin[j] = c;
					else
						cmin[j] = Math.min(cmin[j], c);
				}
			}
			
			String ans = "";
			int remaining = 1_000_000;
			for (int i = 0; i < 4; i++) {
				c = Math.min(remaining, cmin[i]);
				remaining -= c;
				if (i == 0)
					ans = "" + c;
				else
					ans += (" " + c);				
			}
			if (remaining > 0) {
				ans = "IMPOSSIBLE";
			}
			
			out.println("Case #" + tc + ": " + ans);
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
