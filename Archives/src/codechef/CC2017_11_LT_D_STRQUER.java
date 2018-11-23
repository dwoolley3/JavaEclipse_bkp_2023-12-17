package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_11_LT_D_STRQUER
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_11_LT_D_STRQUER().run();
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
			int q = in.nextInt();
				
			ArrayList<Integer> al = new ArrayList<Integer>();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				al.add(a[i]);
			}

			for (int k = 0; k < q; k++) {
				int type = in.nextInt();
				int x = in.nextInt();
				if (type == 1) //add	
				{
					al.add(x);
				}
				else //type == 2 //remove
				{
					int ind = al.indexOf(x);
					al.remove(ind);
				}
				Collections.sort(al);
				long min = 0;
				if (al.size() >= 2)
					min = al.get(1) - al.get(0);
				if (al.size() >= 3)
					min += (al.get(al.size()-1) - al.get(al.size()-2));
				
				for (int i = 2; i < al.size() - 2; i++)
				{
					int opt1 = al.get(i) - al.get(i-1);
					int opt2 = al.get(i+1) - al.get(i);
					if (opt2 <= opt1) //use next i also
					{
						i++;
						min += opt2;
					}
					else if (opt2 == opt1 + 1 && i < al.size() - 3)
					{
						i++;
						min += opt2;
					}
					else
						min += opt1;
				}
				out.println(min);
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
