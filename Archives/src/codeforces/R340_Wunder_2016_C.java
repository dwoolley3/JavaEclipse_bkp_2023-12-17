package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R340_Wunder_2016_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R340_Wunder_2016_C().run();
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
		
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; i++)
		{
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		long min = Long.MAX_VALUE;
		int jInd = -1;
		for (int j = 1; j < n; j++)
		{
			long dist = (x[0]-x[j])*(x[0]-x[j])+ (y[0]-y[j])*(y[0]-y[j]);
			if (dist < min)
			{
				min = dist; jInd = j;
			}
		}
		
		//Find two closest points and then find 3rd not on line
		
		int i = 0, j = jInd;
		for (int k = 0; k < n; k++)
		{
			if (k==i || k==j) continue;
			//if i,j,k not on same line
			if (!isOnSameLine(x[i],y[i],x[j],y[j],x[k],y[k]))
			{
				boolean ok = true;
				for (int a = 0; a < n && ok; a++)
					if (a!=i && a!=j && a!=k)							
						if (isInsideTri(x[i],y[i],x[j],y[j],x[k],y[k],x[a],y[a]))
							ok = false;
				if (ok)
				{
					out.println((i+1) + " " + (j+1) + " " + (k+1));
					return;
				}
			}
		}
		
		out.println(-1);		
	}

	private boolean isOnSameLine(long ax, long ay, long bx, long by, long cx, long cy)
	{
		return ((by-ay) * (bx-cx) == (bx-ax) * (by-cy));
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
