package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_07_C_RRFRNDS
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_07_C_RRFRNDS().run();
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
		//Set<Integer>[] hs =  new HashSet[n];		
		//for (int i = 0; i < n; i++) 
		//	hs[i] = new HashSet<Integer>();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] al = new ArrayList[n];
		for (int i = 0; i < n; i++)
			al[i] = new ArrayList<Integer>();
		
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) 
		{
			String s = in.next();
			for (int j = 0; j < n; j++)
				if (s.charAt(j) == '1') 
				{
					a[i][j] = 1;
					al[j].add(i);
					//hs[j].add(i);
				}
				else
					a[i][j] = 0;
		}
		
		int cnt = 0;
		for (int i = 0; i < n-1; i++)
			for (int j = i+1; j < n; j++)
			{
				if (a[i][j] == 1) continue;	
				//Following is quick and uses ArrayList and array
				for (int k : al[i])
					if (a[j][k] == 1)
					{
						cnt++;
						break;
					}
				//Following is quick and works, but Sets are not necessary
//				for (int k : hs[i])
//					if (hs[j].contains(k))
//					{
//						cnt++;
//						break;
//					}
				//Following is too slow to go through all k from 0 to n
//				for (int k = 0; k < n; k++)	
//					if (a[k][i] == 1 && a[k][j] == 1)
//					{
//						cnt++;
//						break;
//					}
			}
		
		out.println(cnt * 2);	
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
