package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_10_LT_C_CSS2 //Name: Cascading Style Sheets
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_10_LT_C_CSS2().run();
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
		int n = in.nextInt();	
		int m = in.nextInt();
			
		//int[][] v = new int[1001][1001];
		//int[][] p = new int[1001][1001];
		HashMap<Long,Integer> v = new HashMap<Long,Integer>(); 
		HashMap<Long,Integer> p = new HashMap<Long,Integer>(); 
		int id, attr, val, priority;
		long ind;
		for (int i = 0; i < n; i++) 
		{
			id = in.nextInt();
			attr = in.nextInt();
			val = in.nextInt();
			priority = in.nextInt();
			ind = id * 1_000_001L + attr;
			if (p.get(ind) == null || priority >= p.get(ind))
			{
				p.put(ind, priority);
				v.put(ind, val);
			}
//			if (priority >= p[id][attr])			
//			{
//				p[id][attr] = priority;
//				v[id][attr] = val;
//			}			
		}

		for (int i = 0; i < m; i++)
		{
			id = in.nextInt();
			attr = in.nextInt();
			ind = id * 1_000_001L + attr;
			out.println(v.get(ind));
			//out.println(v[id][attr]);
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
