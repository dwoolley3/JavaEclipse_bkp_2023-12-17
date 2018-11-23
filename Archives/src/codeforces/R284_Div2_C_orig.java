package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R284_Div2_C_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R284_Div2_C_orig().run();
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
		long x1 = in.nextInt();
		long y1 = in.nextInt();
		
		long x2 = in.nextInt();
		long y2 = in.nextInt();
		
		int n = in.nextInt();
		double a,b,c, x3, y3, x4, y4;
		int cnt = 0;
		for (int i = 0; i < n; i++) { 
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			
			if (a == 0) {
				x3 = 1_000_001;
				y3 = -c / b;
				x4 = -1_000_001;
				y4 = y3;
			} else if (b == 0) {
				y3 = 1_000_001;
				x3 = -c / a;
				y4 = -1_000_001;
				x4 = x3;
			} else {
				x3 = 1_000_001;
				y3 = (-c - a * x3) / b;
				x4 = -1_000_001;
				y4 = (-c - a * x4) / b;
			}
			//out.println(x3 + " " + y3 + " " + x4 + " " + y4);
			if (counterclockwise(x1,y1, x3,y3, x4,y4)
			 != counterclockwise(x2,y2, x3,y3, x4,y4)
			 && counterclockwise(x1,y1, x2,y2, x3,y3)
			 != counterclockwise(x1,y1, x2,y2, x4,y4))
				cnt++;
			//out.println(cnt);
		}
	
		out.println(cnt);		
	}
	
	private boolean counterclockwise(double ax, double ay, double bx, double by, double cx, double cy)
	{
		//Given three points a, b, and c, is a --> b --> c a counterclockwise turn?
		return (cy-ay)*(bx-ax) > (by-ay)*(cx-ax);
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
