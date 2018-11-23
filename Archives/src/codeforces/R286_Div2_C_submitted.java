package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R286_Div2_C_submitted
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R286_Div2_C_submitted().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//Exception in thread "main" java.lang.StackOverflowError
	//at R286_Div2_C_qwerty787788.countGems(R286_Div2_C_qwerty787788.java:58)
	static int[] a;
	static HashMap<Integer,Integer> hm;
	static int lastPos = 0;
	static int[] sum;
	void solve()
	{
		int n = in.nextInt();
		int d = in.nextInt();
		
		hm = new HashMap<Integer,Integer>();
		a = new int[30_001];		
		for (int i = 0; i < n; i++) 
		{
			int x = in.nextInt();			
			a[x]++;
			if (x > lastPos) lastPos = x;
		}
		
		sum = new int[30_001];
		for (int i = 1; i < 30_001; i++)
			sum[i] = sum[i-1] + a[i];
		
		int ans = countGems(d, 0);
		out.println(ans);		
	}
	
	public static int countGems(int cur, int prev)
	{
		if (cur > lastPos || cur <= prev)
			return 0;
		else // if (cur <= lastPos)
		{
			int l = cur - prev;
			int max = 0;
			int ind = cur * 30_001 + prev;
			if (hm.get(ind) != null)
				return hm.get(ind);
			else
			{
				if (l > 1)
					max = Math.max(max, countGems(cur + l-1, cur));
				if (l == 1)
				{
					max = sum[lastPos] - sum[cur];
				}
				else
					max = Math.max(max, countGems(cur + l, cur));
				max = Math.max(max,  countGems(cur + l+1, cur));
			}
			//System.out.println(cur + " " + prev + " " + l);
			hm.put(ind, a[cur] + max);
			return hm.get(ind);
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
