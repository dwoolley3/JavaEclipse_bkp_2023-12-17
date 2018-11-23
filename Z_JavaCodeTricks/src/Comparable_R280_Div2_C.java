
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class Comparable_R280_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Comparable_R280_Div2_C().run();
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
	        return Integer.compare(this.b, pair.b);
	    }
	}
	
	void solve()
	{
		int n = in.nextInt();
		int r = in.nextInt();
		long avg = in.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		long sum = 0;
		Pair[] c = new Pair[n];
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			b[i] = in.nextInt();
			c[i] = new Pair(a[i], b[i] );
			sum += a[i];
		}
		Arrays.sort(c);
//        Arrays.sort(c, new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o1.b - o2.b;
//            }
//        });
        
		long sumNeeded = avg * n;
		long dif = sumNeeded - sum;
		long essays = 0;
		int i = 0;
		while (sumNeeded > sum && i < n)
		{
			dif = sumNeeded - sum;
			long min = Math.min(dif, r - c[i].a);
			essays += (min * c[i].b);
			sum += min;
			i++;
		}
	
		out.println(essays);		
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

