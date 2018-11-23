package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R345_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R345_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair implements Comparable<Pair> {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
	    public int compareTo(Pair pair) {
	        int c = Integer.compare(this.a, pair.a);
	        if (c != 0) {
	            return c;
	        }
	        return Integer.compare(this.b, pair.b);
	    }
	}
	
	void solve()
	{
		int n = in.nextInt();
		
		Pair[] xy = new Pair[n];
		Pair[] yx = new Pair[n];
		for (int i = 0; i < n; i++) 
		{
			int x = in.nextInt();
			int y = in.nextInt();
			xy[i] = new Pair(x,y);
			yx[i] = new Pair(y,x);
		}
		
		Arrays.sort(xy);
		Arrays.sort(yx);
		
		long ans = 0, cnt = 0, dups = 0, dupsAns = 0;
		for (int i = 1; i <= n; i++)
		{
			if (i < n && xy[i-1].a == xy[i].a) 
				cnt++;
			else
			{
				ans += (cnt * (cnt+1) / 2);
				cnt = 0;
			}			
			if (i < n && xy[i-1].a == xy[i].a && xy[i-1].b == xy[i].b)
				dups++;
			else
			{
				dupsAns += (dups * (dups+1) / 2);
				dups = 0;
			}
		}

		cnt = 0;
		for (int i = 1; i <= n; i++)
		{
			if (i < n && yx[i-1].a == yx[i].a) 
				cnt++;
			else
			{
				ans += (cnt * (cnt+1) / 2);
				cnt = 0;
			}				
		}
		
		out.println(ans - dupsAns);		
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
