package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_02_LT_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_02_LT_C().run();
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
			
		int[] rx = new int[n];
		int[] ry = new int[n];
		for (int i = 0; i < n; i++) 
		{
			rx[i] = in.nextInt();
			ry[i] = in.nextInt();
		}
		
		int[] bx = new int[m];
		int[] by = new int[m];
		for (int i = 0; i < m; i++) 
		{
			bx[i] = in.nextInt();
			by[i] = in.nextInt();
		}
		
		int cnt3 = 0;
		if (n == 3)
			for (int a = 0; a < m; a++)
				if (isInsideTri(rx[0],ry[0],rx[1],ry[1],rx[2],ry[2],bx[a],by[a]))
					cnt3++;
		
		int q = in.nextInt();
		for (int i = 0; i < q; i++) 
		{
			int k = in.nextInt();
			int[] ind = new int[k];
			for (int j = 0; j < k; j++)
			{
				ind[j] = in.nextInt() - 1;
			}
			int cnt = 0;
			if (n == 3) cnt = cnt3;
//				for (int a = 0; a < m; a++)
//					if (isInsideTri(rx[ind[0]],ry[ind[0]],rx[ind[1]],ry[ind[1]],rx[ind[2]],ry[ind[2]],bx[a],by[a]))
//						cnt++;
			out.println(cnt);
		}
		
	}
	
	private boolean isInsideTri(long ax, long ay, long bx, long by, long cx, long cy,
			long px, long py)
	{
		long ABC = Math.abs (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by));
		long ABP = Math.abs (ax * (by - py) + bx * (py - ay) + px * (ay - by));
		long APC = Math.abs (ax * (py - cy) + px * (cy - ay) + cx * (ay - py));
		long PBC = Math.abs (px * (by - cy) + bx * (cy - py) + cx * (py - by));

		boolean isInTriangle = ABP + APC + PBC == ABC;		
		
		return isInTriangle;
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
