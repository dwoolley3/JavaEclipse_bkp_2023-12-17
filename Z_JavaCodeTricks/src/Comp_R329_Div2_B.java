import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Comp_R329_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Comp_R329_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair implements Comparable<Pair> {
		long a, b;
		
		public Pair(long a, long b) {
			this.a = a;
			this.b = b;
		}
		
	    public int compareTo(Pair pair) {
	        int c = Long.compare(this.a, pair.a);
	        if (c != 0) {
	            return c;
	        }
	        return Long.compare(this.b, pair.b);
	        
	    	//Alternatively
//	        if (this.a != pair.a)
//	        	return this.a - pair.a;
//	        return this.b - pair.b;
	        
//	        int c = this.a - pair.a;
//	        if (c == 0) c = this.b - pair.b;
//	        return c;
	    }
	}
	
	void solve()
	{
		int n = in.nextInt();
		int x1 = in.nextInt();
		int x2 = in.nextInt();	
		Pair[] c = new Pair[n];
		boolean overlap = false;
		for (int i = 0; i < n; i++) 
		{
			int k = in.nextInt();
			int b = in.nextInt();
			long y1 = 1L * k * x1 + b;
			long y2 = 1L * k * x2 + b;
			
			c[i] = new Pair(y1, y2);
		}
		Arrays.sort(c);
		for (int i = 1; i < n; i++)
			if (c[i-1].b > c[i].b)
				overlap = true;		
		
		if (overlap)
			out.println("YES");
		else
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
