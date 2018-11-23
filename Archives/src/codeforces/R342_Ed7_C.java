package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R342_Ed7_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R342_Ed7_C().run();
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
		
		int[] a = new int[n+1];
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i <= n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] != a[i-1]) al.add(i);
		}
		int[] ar = new int[al.size()];
		for (int i = 0; i < al.size(); i++) ar[i] = al.get(i);
		
		for (int i = 0; i < m; i++) 
		{
			int l = in.nextInt();
			int r = in.nextInt();
			int x = in.nextInt();
			
			if (a[l] != x)
				out.println(l);
			else
			{
				//Binary search not needed if another array stores prior change index
				int ind = Arrays.binarySearch(ar, l+1);
				if (ind < 0) ind = -ind - 1;
				if (ind < ar.length && ar[ind] <= r && a[ar[ind]] != x)
					out.println(ar[ind]);
				else
					out.println(-1);
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
