import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dp_MemSql_2017_R1_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dp_MemSql_2017_R1_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	int[] f, s, a;
	
	void solve()
	{
		int n = in.nextInt();
		
		a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] take = new int[n];
		int[] dont = new int[n];
		
		take[n-1] = a[n-1]; dont[n-1] = 0;
		for (int i = n-2; i >= 0; i--) {
			//take
			if (a[i] + dont[i+1] >= take[i+1]) {
				take[i] = a[i] + dont[i+1];
				dont[i] = take[i+1];
			} else {
				take[i] = take[i+1];
				dont[i] = a[i] + dont[i+1];
			}
		}
		int bob = Math.max(take[0], dont[0]);
		int al = Math.min(take[0], dont[0]);
		out.println(al + " " + bob);
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
