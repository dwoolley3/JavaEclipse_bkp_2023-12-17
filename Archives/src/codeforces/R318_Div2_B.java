package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R318_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R318_Div2_B().run();
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
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] al = new ArrayList[n+1]; 
		for (int i=1;i<=n;i++) 
			al[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int min = Math.min(a,b);
			int max = Math.max(a,b);
			al[min].add(max);
			al[max].add(min);
		}
		
		int sum = 0, minsum = Integer.MAX_VALUE;		
		for (int k = 1; k <= n; k++)
			for (int i = 0; i < al[k].size()-1; i++)
				for (int j = 1; j < al[k].size(); j++)
				{
					if (al[al[k].get(i)].contains(al[k].get(j)))
					{
						//System.out.println(k + " " + al[k].get(i) + " " + al[k].get(j));
						sum = al[k].size() + al[al[k].get(i)].size() + al[al[k].get(j)].size() - 6;
						minsum = Math.min(minsum,  sum);
					}
				}

		if (minsum == Integer.MAX_VALUE)
			out.println(-1);
		else
			out.println(minsum);		
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
