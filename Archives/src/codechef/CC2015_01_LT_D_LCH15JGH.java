package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2015_01_LT_D_LCH15JGH
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_01_LT_D_LCH15JGH().run();
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
			
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(); 
		int a,b;
		for (int i = 0; i < n; i++)
		{
			a = in.nextInt();
			b = in.nextInt();
			hm.put(a, b);
			//c[a] = b;
		}
			
		int m = in.nextInt();
		for (int i = 0; i < m; i++)
		{
			String q = in.next();
			int amt = in.nextInt();
			if (q.equals("?"))
			{
				long sum = 0;
				for (int key : hm.keySet()) 
					sum += ((long)(amt % key) * (long)hm.get(key));
				out.println(sum);
			}
			else 
			{
				int inc = 1;
				if (q.equals("-")) inc = -1;
				if (hm.get(amt) == null && inc == 1)
					hm.put(amt, 1);
				else
					hm.put(amt, hm.get(amt) + inc);
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
