package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R350_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R350_Div2_C().run();
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
		int maxCnt = 0;
		for (int i = 0; i < n; i++)
		{
			int x = in.nextInt(), cnt = 1;
			if (hm.containsKey(x)) 
				cnt = hm.get(x) + 1;
			hm.put(x, cnt);
			if (cnt > maxCnt) maxCnt = cnt;
		}
		
		int m = in.nextInt();
		int[] b = new int[m];
		int[] c = new int[m];
		for (int i = 0; i < m; i++)
			b[i] = in.nextInt();
		for (int i = 0; i < m; i++)
			c[i] = in.nextInt();

		int maxx = 0, maxy = 0, maxInd = 0;
		for (int i = 0; i < m; i++)
		{
			int x = 0, y = 0;
			if (hm.containsKey(b[i]))
			{
				x = hm.get(b[i]);
			}
			if (hm.containsKey(c[i]))
			{
				y = hm.get(c[i]);
			}
			if (x > maxx || (x == maxx && y > maxy))
			{
				maxx = x;
				maxy = y;
				maxInd = i;
			}
		}
		
		out.println(maxInd + 1);		
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
