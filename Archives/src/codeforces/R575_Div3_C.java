package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R575_Div3_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R575_Div3_C().run();
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
		int q = in.nextInt();
		
		for (int q2 = 0; q2 < q; q2++) {
			int n = in.nextInt();
			int xmax, xmin, ymax, ymin;
			int xmax2=0, xmin2=0, ymax2=0, ymin2=0;
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int f1 = in.nextInt();
				xmin = (f1 == 1) ? -100_000 : x;
				int f2 = in.nextInt();
				ymax = (f2 == 1) ? 100_000 : y;	
				int f3 = in.nextInt();					
				xmax = (f3 == 1) ? 100_000 : x;		
				int f4 = in.nextInt();
				ymin = (f4 == 1) ? -100_000 : y;
				
				if (i > 0) {
					xmin2 = Math.max(xmin2, xmin);
					ymin2 = Math.max(ymin2, ymin);
					xmax2 = Math.min(xmax2, xmax);
					ymax2 = Math.min(ymax2, ymax);				
				} else {
					xmin2 = xmin;
					ymin2 = ymin;
					xmax2 = xmax;
					ymax2 = ymax;					
				}				
			}
			
			boolean ok = (xmin2 <= xmax2 && ymin2 <= ymax2);
			out.print(ok ? 1 : 0);
			if (ok) {
				out.print(" " +xmin2 + " " + ymin2);
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
