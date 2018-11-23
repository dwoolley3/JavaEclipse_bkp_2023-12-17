package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R321_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R321_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair //implements Comparable<Pair>   //Option 1
	{
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	void solve()
	{
		int n = in.nextInt();
		int d = in.nextInt();
		
		
		Pair[] c = new Pair[n];
		for (int i = 0; i < n; i++)
		{
			int m = in.nextInt();
			int s = in.nextInt();
			c[i] = new Pair(m, s);
		}
		Arrays.sort(c, (o1, o2) -> o1.a - o2.a); 
		
		long[] sum = new long[n+1];
		long[] social = new long[n];
		sum[1] = c[0].b;
		for (int i = 1; i < n; i++)
			sum[i+1] += sum[i] + c[i].b;
					
		int ind2 = 0;
		long maxSocial = 0;
		for (int i = 0; i < n; i++)
		{
			while (ind2 < n && c[ind2].a - c[i].a < d)
				ind2++;
			social[i] = sum[ind2] - sum[i];
			maxSocial = Math.max(maxSocial, social[i]);
		}
		out.println(maxSocial);		
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
