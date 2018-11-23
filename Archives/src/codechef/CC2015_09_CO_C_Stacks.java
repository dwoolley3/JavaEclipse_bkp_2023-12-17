package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2015_09_CO_C_Stacks
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_09_CO_C_Stacks().run();
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
				
			ArrayList<Integer> al = new ArrayList<Integer>(); 

	      	
			for (int i = 0; i < n; i++) 
			{
				int a = in.nextInt();
				
				int lo = 0, hi = al.size()-1, mid;
		      	while (lo < hi)
		      	{
		           mid = lo + (hi - lo) / 2;
		           if (al.get(mid) <= a)
		        	   lo = mid + 1; 
		           else
		               hi = mid;                           
		      	}
		      	if (lo == al.size())
		      		al.add(a);
		      	else
		      		if (al.get(lo) <= a)
		      			al.add(a);
		      		else
		      			al.set(lo, a);

		      	//Following routine too slow, so used binary search
//				boolean ok = false;
//				for (int j = 0; j < al.size() && !ok; j++)
//					if (al.get(j) > a)
//					{
//						al.set(j, a);
//						ok = true;
//					}
//				if (!ok)
//					al.add(a);
			}
			//Already in order
			out.print(al.size());
			for (int i = 0; i < al.size(); i++)
				out.print(" " + al.get(i));
		
			out.println();	
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
