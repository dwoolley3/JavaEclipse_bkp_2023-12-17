package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R506_Div3_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R506_Div3_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Pair implements Comparable<Pair>{
		int a,b;
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Pair pair) {
	        int c = Integer.compare(this.a, pair.a);
	        if (c != 0) {
	            return c;
	        }
	        return Integer.compare(pair.b, this.b);
		}
	}
		
	class Pair2 implements Comparable<Pair2>{
		int a,b;
		public Pair2(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Pair2 pair) {
	        int c = Integer.compare(pair.b, this.b);
	        if (c != 0) {
	            return c;
	        }
	        return Integer.compare(this.a, pair.a);
		}
	}
	
	void solve()
	{
		int n = in.nextInt();
		
		int[] l = new int[n];
		int[] r = new int[n];

		Pair[] p = new Pair[n];
		Pair2[] p2 = new Pair2[n];

		for (int i = 0; i < n; i++) { 
			l[i] = in.nextInt();
			r[i] = in.nextInt();
			p[i] = new Pair(l[i],r[i]);
			p2[i] = new Pair2(l[i],r[i]);
		}
		
		Arrays.sort(l);
		Arrays.sort(r);
		Arrays.sort(p);
		Arrays.sort(p2);
		
		int ans1 = (r[n-1] == p[n-1].b ? r[n-2] - l[n-2] : r[n-2] - l[n-1]);
		int ans2 = (l[n-1] == p[n-1].a ? r[n-2] - l[n-2] : r[n-1] - l[n-2]);
		int ans = Math.max(ans1, ans2);
		if (ans < 0) ans = 0;
		out.println(ans);		
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
