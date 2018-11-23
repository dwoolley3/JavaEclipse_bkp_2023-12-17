package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R322_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R322_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair {
		int a,b;
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
	
	void solve()
	{
		int n = in.nextInt();
		int k = in.nextInt();
		
		Pair[] p = new Pair[n];
		int a,b;
		for (int i = 0; i < n; i++) 
		{
			a = in.nextInt();
			b = a - (a / 10) * 10;
			if (b > 0) b = 10 - b;
			p[i] = new Pair(a,b);
		}
		
		Arrays.sort(p, (o1, o2) -> o1.b - o2.b);
		
		int sum = 0, difFrom100 = 0;
		for (int i = 0; i < n; i++)
		{
			if (p[i].b > 0)
			{
				int d = Math.min(p[i].b, k);
				p[i].a += d;
				k -= d;
			}
			sum += (p[i].a / 10);
			difFrom100 += (100 - p[i].a);
		}
		sum += (Math.min(difFrom100, k) / 10);
		
		out.println(sum);		
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
