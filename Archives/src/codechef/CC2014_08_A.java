package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_08_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_08_A().run();
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
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
			int m = in.nextInt();
				
			int[] a = new int[n];
			for (int i = 0; i < n; i++) 
			{
				a[i] = in.nextInt();
			}
			
			int l,r;
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] al = new ArrayList[n]; 
				for (int i=0;i<n;i++) al[i] = new ArrayList<Integer>();
			int num = 0;
			for (int i = 0; i < m; i++) 
			{
				l = in.nextInt();
				r = in.nextInt();
				boolean got1 = false;
				for (int j = 0; j < num; j++)
				{
					boolean hasl = al[j].contains(l);
					boolean hasr = al[j].contains(r);
	
					if (hasl && !hasr)
						al[j].add(r);
					else if (hasr && !hasl)
						al[j].add(l);
					got1 = got1 || (hasl || hasr);
				}
				if (!got1)
				{
					al[num].add(l);
					if (l != r) al[num].add(r);
					num++;
				}
			}
			
			boolean ok = true;
			for (int i = 1; i <= n && ok; i++)
			{
				ok = false;			
				for (int j = 0; j < num; j++)
					if (i == a[i-1] || (al[j].contains(i) && al[j].contains(a[i]))) ok = true;
			}
			
			if (ok) 
				out.println("Possible");
			else
				out.println("Impossible");

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
