package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R335_Ed3_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R335_Ed3_D().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	class Pair implements Comparable<Pair> {
		long a, b, gad;
		
		public Pair(long a, long b, long gad) {
			this.a = a;
			this.b = b;
			this.gad = gad;
		}
		
	    public int compareTo(Pair pair) {
	        int c = Long.compare(this.a, pair.a);
	        if (c != 0) {
	            return c;
	        }
	        return Long.compare(this.b, pair.b);
	    }
	}
	
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int s = in.nextInt();
		
		int bestDayDol = -1, bestDol = Integer.MAX_VALUE;
		int bestDayPnd = -1, bestPnd = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
		{
			int a = in.nextInt();
			if (a < bestDol)
			{
				bestDol = a;
				bestDayDol = i+1;
			}
		}
		for (int i = 0; i < n; i++)
		{
			int a = in.nextInt();
			if (a < bestPnd)
			{
				bestPnd = a;
				bestDayPnd = i+1;
			}
		}
		
		int[] t = new int[m];
		int[] c = new int[m];
		long price;
		Pair[] p = new Pair[m];
		int day = 0, gad = 0;
		for (int i = 0; i < m; i++) 
		{
			t[i] = in.nextInt();
			c[i] = in.nextInt();
			if (t[i] == 1)
			{
				price = 1L * bestDol * c[i];
				day = bestDayDol;
			}
			else
			{
				price = 1L * bestPnd * c[i];
				day = bestDayPnd;
			}
			gad = i+1;
			p[i] = new Pair(price, day, gad);
		}
		Arrays.sort(p);
		
		int cnt = 0, maxDay = 0;
		for (int i = 0; i < m; i++)
		{
			if (s < p[i].a) break;
			cnt++;
			s -= p[i].a;
			day = (int)p[i].b;
			maxDay = Math.max(day, maxDay);			
		}
		if (cnt < k)
			out.println(-1);
		else
		{
			out.println(maxDay);		
			for (int i = 0; i < k; i++)
				out.println(p[i].gad + " " + p[i].b);
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
