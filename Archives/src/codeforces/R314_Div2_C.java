package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R314_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R314_Div2_C().run();
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
		int k = in.nextInt();
		
		HashMap<Integer,Integer> hmLeft = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> hmRight = new HashMap<Integer,Integer>();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (i >= 1)
			{
				int val = 0;			
				if (hmRight.containsKey(a[i])) val = hmRight.get(a[i]);
				hmRight.put(a[i], val + 1);
			}
		}
		
		hmLeft.put(a[0], 1);
		
		long cnt = 0;
		for (int i = 1; i < n-1; i++)
		{
			int r = hmRight.containsKey(a[i]) ? hmRight.get(a[i]) - 1 : 0;
			hmRight.put(a[i], r);
			
			long left = 0, right = 0;		
			if (a[i] % k == 0 && hmLeft.containsKey(a[i] / k))
				left = hmLeft.get(a[i] / k);
			if (Math.abs(a[i] * (long)k) <= 1e9 && hmRight.containsKey(a[i] * k))
				right = hmRight.get(a[i] * k);
			
			cnt += left * right;
			
			int l = hmLeft.containsKey(a[i]) ? hmLeft.get(a[i]) + 1 : 1;
			hmLeft.put(a[i], l);
		}
	
		out.println(cnt);		
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
