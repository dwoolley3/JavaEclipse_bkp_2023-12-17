package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2015_06_LT_C_subtask1
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_06_LT_C_subtask1().run();
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
		int q = in.nextInt();
			
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] al = new ArrayList[1001]; 
		for (int i=0;i<1001;i++) al[i] = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			al[i].add(i);
		
		int lastInd = n;
		for (int i = 0; i < q; i++) 
		{
			String w = in.next();
			int a = in.nextInt();
			int b = in.nextInt();
			//out.println(a + " " + b);
			if (w.equals("UNION")) 
			{
				lastInd++;
				for (int num : al[a])
					al[lastInd].add(num);
				for (int num : al[b])
					al[lastInd].add(num);
				al[a].clear();
				al[b].clear();
			}
			else // GET
			{
				Collections.sort(al[a]);
				out.println(al[a].get(b-1));
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
