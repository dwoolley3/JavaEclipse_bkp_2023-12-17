package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R390_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R390_Div2_D().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair implements Comparable<Pair> {
		int a, b, c;
		
		public Pair(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	    public int compareTo(Pair pair) {
	        return Integer.compare(this.b, pair.b);
	    }
	}
	
	//Almost solved; similar (sort of) too qwerty7897788 or VArtem
	
	void solve()
	{
		int n = in.nextInt();
		int k = in.nextInt();
		
		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) 
		{
			int l = in.nextInt();
			int r = in.nextInt();
			p[i] = new Pair(l, r, i+1);
		}
		Arrays.sort(p);
		
		TreeSet<Integer> ts = new TreeSet<>(); 
		//PriorityQueue<Integer> ts = new PriorityQueue<>();
		
		@SuppressWarnings("unused")
		int min = Integer.MIN_VALUE;
		@SuppressWarnings("unused")
		int maxRange = 0, maxRange2, maxi = 0;
		for (int i = 0; i < k; i++)
		{
			ts.add(p[i].a);
		}

		for (int i = k-1; i < n; i++) 
		{
			ts.add(p[i].a);
			int range = p[i].b - ts.last() + 1;
			if (range > maxRange)
			{
				maxRange = range;
				maxi = i;
			}
			out.println(p[i].a + " " + p[i].b + " " + p[i].c);
			ts.remove(p[i-k+1].a);
		}
		
		out.println(maxRange);
		int[] s = new int[k];
		int ind = 0;
		for (int i = maxi - k + 1; i <= maxi; i++)		
			s[ind++] = p[i].c;
		Arrays.sort(s);
		for (int i = 0; i < k; i++)
			out.print(s[i] + " ");
		out.println();
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
