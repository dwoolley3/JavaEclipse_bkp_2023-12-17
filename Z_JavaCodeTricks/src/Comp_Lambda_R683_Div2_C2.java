import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Comp_Lambda_R683_Div2_C2
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Comp_Lambda_R683_Div2_C2().run();
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
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();
			long w = in.nextLong();
			
			int a, b;
			Pair[] p = new Pair[n];
			for (int i = 0; i < n; i++) { 
				a = in.nextInt();
				b = i+1;
				p[i] = new Pair(a,b);
			}
						
			Arrays.sort(p, (o1, o2) -> o1.a - o2.a);
			
			long sum = 0, maxsum = 0; 
			int lasti = -1;
			for (int i = n-1; i >= 0; i--) {
				if (p[i].a <= w) {
					lasti = i;
					break;
				}
			}
			for (int i = 0; i <= lasti; i++) {
				maxsum += p[i].a;
			}
			//System.out.println("lasti=" + lasti + " maxsum = "+maxsum);
			if (maxsum * 2 < w) {
				out.println(-1);
				continue;
			}
			
			ArrayList<Integer> al = new ArrayList<>();
			al.add(p[lasti].b);
			sum = p[lasti].a;
			int i = 0;
			while (sum * 2 < w) {
				sum += p[i].a;
				al.add(p[i].b);
				if (++i == lasti) break;
			}
			if (sum * 2 >= w && sum <= w) {
				out.println(al.size());
				for (int x : al) {
					out.print(x + " ");
				}
				out.println();
			}
			else {
				out.println(-1);
			}
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
