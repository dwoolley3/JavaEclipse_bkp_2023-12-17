
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class x_GCJ_2018_R1B_A_RoundingError
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new x_GCJ_2018_R1B_A_RoundingError().run();
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
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int N = in.nextInt();
			int L = in.nextInt();
			
			int chose = 0;
			int[] c = new int[L];
			for (int i = 0; i < L; i++) {
				c[i] = in.nextInt();
				chose += c[i];
			}
			
			TreeSet<Integer> ts = new TreeSet<>();
			for (int i = 1; i < N; i++) {
				double d = i * 1.0 / N;
				if ((int)(d * 100) != (int)(d * 100 + 0.5))
				{
					ts.add(i);
				}
			}	
			
			int more = N - chose;
			int totL = L + more;
			Pair[] p = new Pair[totL];
			for (int i = 0; i < L; i++) {
				int dif = Integer.MAX_VALUE;
				if (ts.ceiling(c[i]) != null) {
					int best = ts.ceiling(c[i]);
					if (best > c[i])
						dif = best - c[i];
				}
				p[i] = new Pair(c[i],dif);
			}
			for (int i = L; i < totL; i++) {
				int dif = Integer.MAX_VALUE;
				if (!ts.isEmpty())
					dif = ts.first();
				p[i] = new Pair(0,dif);
			}
					
			Arrays.sort(p, (o1, o2) -> o1.a - o2.a);
			//Arrays.sort(p);
			int i = 0;
			while (more > 0) {
				int min = Math.min(more, p[i].b);
				p[i].a += min;
				more -= min;	
				i++;
			}
			
			int tot = 0;
			for (i = 0; i < totL; i++)
			{
				int per = (int)(p[i].a * 1.0 / N * 100 + 0.5);
				tot += per;
			}
								
			String ans = "" + tot;
					
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	class Pair implements Comparable<Pair> {
		int a,b;
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	    public int compareTo(Pair pair) {
	        return Integer.compare(this.b, pair.b);
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
