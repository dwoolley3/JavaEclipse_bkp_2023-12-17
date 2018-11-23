package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R323_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R323_Div2_C().run();
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
		
		int[] a = new int[n*n];
		int[] ans = new int[n];
		Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
		for (int i = 0; i < n*n; i++) 
		{
			a[i] = in.nextInt();
			int x = hm.get(a[i]) != null ? hm.get(a[i]) : 0;
			hm.put(a[i], x+1);
		}
		Arrays.sort(a);
		int ind = -1;
		for (int i = n*n-1; i >= 0; i--)
		{
			if (hm.get(a[i]) <= 0) continue;
			for (int j = 0; j <= ind; j++)
			{
				int gcd = GCD(a[i], ans[j]);
				hm.put(gcd, hm.get(gcd) - 2);				
			}		
			ans[++ind] = a[i];
			hm.put(ans[ind], hm.get(ans[ind]) - 1);
		}
		
		for (int i = 0; i < n; i++)		
			out.print(ans[i] + " ");		
	}
	
    int GCD(int a, int b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
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
