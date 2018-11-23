package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R418_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R418_Div2_B().run();
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] b = new int[n];
		for (int i = 0; i < n; i++) 
			b[i] = in.nextInt();
		
		int[] p = new int[n];
		boolean[] used = new boolean[n+1];
		ArrayList<Integer> difInd = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (a[i] == b[i])
			{
				p[i] = a[i];
				used[a[i]] = true;
			}
			else
				difInd.add(i);
		
		if (difInd.size() == 1)
		{
			int x = difInd.get(0);
			for (int i = 1; i <= n; i++)
				if (!used[i])
					p[x] = i;
		}
		else //al.size() == 2
		{
			int x = difInd.get(0);
			int y = difInd.get(1);
			boolean found = false;
			for (int i = 0; i < 2 && !found; i++)
				for (int j = 0; j < 2 && !found; j++)
				{
					int xab = (i == 0) ? a[x] : b[x];
					int yab = (j == 0) ? a[y] : b[y];
					if (xab != yab && !used[xab] && !used[yab])
					{
						p[x] = xab;
						p[y] = yab;
						found = true;
					}
				}
		}

		for (int i = 0; i < n; i++)
			out.print(p[i] + " ");
		out.println();
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
