package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R766_Div2_B_wa
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R766_Div2_B_wa().run();
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
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();
			int m = in.nextInt();
			if (n > m) {
				int temp = n; n = m; m = temp;
			}
			// n is now <= m (longer width of m)
			
			int wi = 2 - (m % 2);
			int hi = (n > 1) ? (2 - (n % 2)) : 1;

			// hi, wi now 1 or 2
			int st = (n/2) + (m/2);
			int en = n + m - 2;
			int rep = hi * wi;
			int totPrinted = 0;
			for (int di = st; di <= en && totPrinted < n*m; di++) {				
				for (int i = 0; i < rep && totPrinted < n*m; i++) {
					out.print(di + " ");
					totPrinted++;
				}			
				rep = 0;
				if (hi < n) rep += wi*2; 
				if (n > 1 && di > st) rep += 4;
				if (wi < m) rep += hi*2;
				
				if (hi < n) hi += 2;
				if (wi < m) wi += 2;		
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
